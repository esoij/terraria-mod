package esoij.terrariamod.world.level.block;

import esoij.terrariamod.world.effect.ModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("deprecation")
public class TerrariaBannerBlock extends Block {
    private static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
    public final EntityType entityToGrantBonusTo;
    public TerrariaBannerBlock(EntityType entityToGrantBonusTo, Properties properties) {
        super(properties);
        this.entityToGrantBonusTo = entityToGrantBonusTo;
    }
    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.above()).isSolid();
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.UP && !state.canSurvive(level, pos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }
    @Override
    public boolean isPossibleToRespawnInThis(BlockState state) {
        return true;
    }
    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        for (LivingEntity entity : level.getEntitiesOfClass(Player.class, new AABB(pos.getX() - 85, pos.getY() - 62.5, pos.getZ() - 85, pos.getX() + 85, pos.getY() + 62.5, pos.getZ() + 85))) {
            entity.addEffect(new MobEffectInstance(ModMobEffects.MONSTER_BANNER, 10, 1));
        }
    }
}
