package esoij.terrariamod.world.level.block;

import com.mojang.serialization.MapCodec;
import esoij.terrariamod.world.effect.ModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BubbleColumnBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class MeteoriteBlock extends Block {
    public static final MapCodec<? extends MeteoriteBlock> CODEC = simpleCodec(MeteoriteBlock::new);
    private static final int BUBBLE_COLUMN_CHECK_DELAY = 20;
    @Override
    public MapCodec<? extends MeteoriteBlock> codec() {
        return CODEC;
    }
    public MeteoriteBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        LivingEntity livingEntity = entity instanceof LivingEntity ? (LivingEntity) entity : null;
        if (livingEntity != null && !entity.isSteppingCarefully() && !livingEntity.hasEffect(ModMobEffects.OBSIDIAN_SKIN)) livingEntity.addEffect(new MobEffectInstance(ModMobEffects.BURNING, 10));
        super.stepOn(level, pos, state, entity);
    }
    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BubbleColumnBlock.updateColumn(level, pos.above(), state);
    }
    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.UP && neighborState.is(Blocks.WATER)) {
            level.scheduleTick(pos, this, BUBBLE_COLUMN_CHECK_DELAY);
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }
    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        level.scheduleTick(pos, this, BUBBLE_COLUMN_CHECK_DELAY);
    }
}
