package esoij.terrariamod.world.level.block;

import com.mojang.serialization.MapCodec;
import esoij.terrariamod.world.effect.ModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SpikesBlock extends Block {
    public static final MapCodec<? extends SpikesBlock> CODEC = simpleCodec(SpikesBlock::new);
    protected static final VoxelShape SHAPE = Block.box(0.1, 0.1, 0.1, 15.9, 15.9, 15.9);
    @Override
    public MapCodec<? extends SpikesBlock> codec() {
        return CODEC;
    }
    public SpikesBlock(Properties properties) {
        super(properties);
    }
    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(ModMobEffects.BLEEDING, 10 * 20, 0, false, true, true, new MobEffectInstance(ModMobEffects.BURNING, 1, 0, true, false, false)));
        }
    }
}
