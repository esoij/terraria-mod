package esoij.terrariamod.world.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BurningMobEffect extends TerrariaMobEffect {
    protected BurningMobEffect(MobEffectCategory mobEffectCategory, int i) {
        super(mobEffectCategory, i);
    }
    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        amplifier = amplifier == 0 ? 1 : amplifier;
        if (!livingEntity.hasEffect(ModMobEffects.OBSIDIAN_SKIN)) livingEntity.hurt(livingEntity.damageSources().hotFloor(), 5 * amplifier);
        return true;
    }
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 2 == 0;
    }
}
