package esoij.terrariamod.world.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ModRegenerationMobEffect extends TerrariaMobEffect {
    protected ModRegenerationMobEffect(MobEffectCategory mobEffectCategory, int i) {
        super(mobEffectCategory, i);
    }
    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        amplifier = amplifier == 0 ? 1 : amplifier;
        if (livingEntity.getHealth() < livingEntity.getMaxHealth()) {
            livingEntity.heal(amplifier);
        }
        return true;
    }
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 10 == 0;
    }
}
