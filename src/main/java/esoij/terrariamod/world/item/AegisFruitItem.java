package esoij.terrariamod.world.item;

import esoij.terrariamod.sounds.ModSoundEvents;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class AegisFruitItem extends Item {
    public final double defense;
    public final double maxDefense;
    public AegisFruitItem(Properties properties, double defense, double maxDefense) {
        super(properties);
        this.defense = defense;
        this.maxDefense = maxDefense;
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
        double currentMaxDefense = player.getAttributes().getInstance(Attributes.ARMOR).getBaseValue();
        if (!(currentMaxDefense >= maxDefense)) {
            if (player instanceof ServerPlayer) CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
            if (!level.isClientSide) player.getAttributes().getInstance(Attributes.ARMOR).setBaseValue(currentMaxDefense + defense);
            if (player != null) {
                player.awardStat(Stats.ITEM_USED.get(this));
                stack.consume(1, player);
            }
            livingEntity.gameEvent(GameEvent.ENTITY_ACTION);
        }
        return stack;
    }
    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return entity.getAttributeBaseValue(Attributes.ARMOR) >= maxDefense ? 0 : 45 / 3;
    }
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }
    @Override
    public SoundEvent getEatingSound() {
        return ModSoundEvents.CONSUME_SHIMMER;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        return player.getAttributes().getInstance(Attributes.ARMOR).getBaseValue() >= maxDefense ? super.use(level, player, usedHand) : ItemUtils.startUsingInstantly(level, player, usedHand);
    }
}
