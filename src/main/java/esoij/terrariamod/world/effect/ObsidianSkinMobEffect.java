package esoij.terrariamod.world.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ObsidianSkinMobEffect extends TerrariaMobEffect {
    protected ObsidianSkinMobEffect(MobEffectCategory mobEffectCategory, int i) {
        super(mobEffectCategory, i);
    }
    @Override
    public void onMobHurt(LivingEntity livingEntity, int amplifier, DamageSource damageSource, float amount) {
        if (damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.CAMPFIRE) || damageSource.is(DamageTypes.ON_FIRE) || damageSource.is(DamageTypes.LAVA) || damageSource.is(DamageTypes.HOT_FLOOR) || damageSource.is(DamageTypes.FIREBALL) || damageSource.is(DamageTypes.UNATTRIBUTED_FIREBALL)) {
            if (damageSource.is(DamageTypes.LAVA)) livingEntity.heal(amount - .12F);
            else livingEntity.heal(amount);
        }
    }
}
