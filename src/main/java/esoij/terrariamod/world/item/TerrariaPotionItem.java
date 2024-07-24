package esoij.terrariamod.world.item;

import esoij.terrariamod.sounds.ModSoundEvents;
import esoij.terrariamod.world.effect.ModMobEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class TerrariaPotionItem extends Item {
    public final Holder<MobEffect> effect;
    public final int duration;
    public TerrariaPotionItem(Properties properties, Holder<MobEffect> effect, int duration) {
        super(properties);
        this.effect = effect;
        this.duration = duration * 20;
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
        }
        if (!level.isClientSide) {
            livingEntity.addEffect(new MobEffectInstance(effect, duration));
        }
        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            stack.consume(1, player);
        }
        livingEntity.gameEvent(GameEvent.DRINK);
        return stack;
    }
    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 17 / 3;
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
        return ItemUtils.startUsingInstantly(level, player, usedHand);
    }
}
