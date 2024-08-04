package esoij.terrariamod.mixin.world.damagesource;

import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(CombatRules.class)
public class CombatRulesMixin {
    /**
     * @author
     * esoij
     * @reason
     * rewrite armour damage absorption code
     */
    @Overwrite
    public static float getDamageAfterAbsorb(LivingEntity entity, float damage, DamageSource damageSource, float armorValue, float armorToughness) {
        float armour;
        if (entity instanceof Player) {
            float f = switch (entity.level().getDifficulty()) {
                case PEACEFUL, EASY -> 0.5f;
                case NORMAL -> 0.75f;
                case HARD -> 1f;
            };
            armour = damage - armorValue * f;// <= 0 ? 1 : (damage - (armorValue * f));
        } else armour = damage - armorValue * 0.5f;// <= 0 ? 1 : damage - armorValue * 0.5f;
        int damage1 = Math.round(armour * (1 - armorToughness / 100));
        return entity instanceof Player ? damage1 : damage1 <= 0 ? 1 : damage1;
    }
}
