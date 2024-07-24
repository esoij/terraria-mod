package esoij.terrariamod.world.level;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.block.state.BlockState;

public class WeaponExplosion extends ExplosionDamageCalculator {
    public final float attackDamage;
    public final LivingEntity attacker;
    public WeaponExplosion(float attackDamage, LivingEntity attacker) {
        this.attackDamage = attackDamage;
        this.attacker = attacker;
    }
    @Override
    public boolean shouldDamageEntity(Explosion explosion, Entity entity) {
        return entity != attacker;
    }
    @Override
    public float getKnockbackMultiplier(Entity entity) {
        return 0.0F;
    }
    @Override
    public boolean shouldBlockExplode(Explosion explosion, BlockGetter reader, BlockPos pos, BlockState state, float power) {
        return false;
    }
    @Override
    public float getEntityDamageAmount(Explosion explosion, Entity entity) {
        return this.attackDamage * 0.75f;
    }
}
