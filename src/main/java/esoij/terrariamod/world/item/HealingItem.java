package esoij.terrariamod.world.item;

import esoij.terrariamod.sounds.ModSoundEvents;
import esoij.terrariamod.world.effect.ModMobEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class HealingItem extends Item {
    /**
     * use time
     */
    public final int time;
    public final float heal;
    /**
     * duration of potion sickness
     */
    public final int duration;
    public HealingItem(Properties properties, int time, float heal, int duration) {
        super(properties);
        this.time = time / 3;
        this.heal = heal;
        this.duration = duration * 20;
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
        if (!player.hasEffect(ModMobEffects.POTION_SICKNESS)) {
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
            }

            if (!level.isClientSide) {
                player.heal(heal);
                livingEntity.addEffect(new MobEffectInstance(ModMobEffects.POTION_SICKNESS, duration));
            }

            if (player != null) {
                player.awardStat(Stats.ITEM_USED.get(this));
                stack.consume(1, player);
            }

            livingEntity.gameEvent(GameEvent.DRINK);
        }
        return stack;
    }
    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return entity.hasEffect(ModMobEffects.POTION_SICKNESS) ? 0 : time;
    }
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
    @Override
    public SoundEvent getEatingSound() {
        return ModSoundEvents.DRINK;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        return player.hasEffect(ModMobEffects.POTION_SICKNESS) ? super.use(level, player, usedHand) : ItemUtils.startUsingInstantly(level, player, usedHand);
    }
}
