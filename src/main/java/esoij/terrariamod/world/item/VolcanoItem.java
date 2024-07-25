package esoij.terrariamod.world.item;

import esoij.terrariamod.sounds.ModSoundEvents;
import esoij.terrariamod.world.level.WeaponExplosion;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class VolcanoItem extends TerrariaSwordItem {
    public VolcanoItem(Tier tier, Properties properties) {
        super(tier, properties);
    }
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        float radius = Math.max(target.getType().getHeight() + 3, target.getType().getWidth() + 3);
        target.level().explode(attacker,
                //Explosion.getDefaultDamageSource(attacker.level(), attacker),
                attacker.damageSources().source(DamageTypes.PLAYER_ATTACK, attacker, target),
                new WeaponExplosion(40, attacker),
                target.getX() - attacker.getRandom().nextIntBetweenInclusive(-1, 1),
                target.getY() - attacker.getRandom().nextIntBetweenInclusive(-1, 1),
                target.getZ() - attacker.getRandom().nextIntBetweenInclusive(-1, 1),
                radius,
                false,
                Level.ExplosionInteraction.TNT,
                ParticleTypes.EXPLOSION,
                ParticleTypes.EXPLOSION_EMITTER,
                ModSoundEvents.DD2_EXPLOSIVE_TRAP_EXPLODE);
        return true;
    }
}
