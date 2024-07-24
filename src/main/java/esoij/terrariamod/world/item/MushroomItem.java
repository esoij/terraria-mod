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
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;

public class MushroomItem extends ItemNameBlockItem {
    public MushroomItem(Block block, Properties properties) {
        super(block, properties);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
        if (!player.hasEffect(ModMobEffects.POTION_SICKNESS)) {
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
            }

            if (!level.isClientSide) {
                player.heal(15);
                livingEntity.addEffect(new MobEffectInstance(ModMobEffects.POTION_SICKNESS, 600));
            }

            if (player != null) {
                player.awardStat(Stats.ITEM_USED.get(this));
                stack.consume(1, player);
            }

            livingEntity.gameEvent(GameEvent.EAT);
        }
        return stack;
    }
    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return entity.hasEffect(ModMobEffects.POTION_SICKNESS) ? 0 : 5;
    }
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }
    @Override
    public SoundEvent getEatingSound() {
        return ModSoundEvents.EAT;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        return player.hasEffect(ModMobEffects.POTION_SICKNESS) ? super.use(level, player, usedHand) : ItemUtils.startUsingInstantly(level, player, usedHand);
    }
}
