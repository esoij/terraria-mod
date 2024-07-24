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

public class LifeCrystalItem extends Item {
    public final double life;
    public final double maxLife;
    public LifeCrystalItem(Properties properties, double life, double maxLife) {
        super(properties);
        this.life = life;
        this.maxLife = maxLife;
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
        double currentMaxHealth = player.getAttributes().getInstance(Attributes.MAX_HEALTH).getBaseValue();
        if (!(currentMaxHealth >= maxLife)) {
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
            }
            if (!level.isClientSide) {
                player.getAttributes().getInstance(Attributes.MAX_HEALTH).setBaseValue(currentMaxHealth + life);
            }
            if (player != null) {
                player.awardStat(Stats.ITEM_USED.get(this));
                stack.consume(1, player);
            }
            livingEntity.gameEvent(GameEvent.ENTITY_ACTION);
        }
        player.heal((float)life);
        return stack;
    }
    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return entity.getAttributeBaseValue(Attributes.MAX_HEALTH) >= maxLife ? 0 : 30 / 3;
    }
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }
    @Override
    public SoundEvent getEatingSound() {
        return ModSoundEvents.CRYSTAL;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        return player.getAttributes().getInstance(Attributes.MAX_HEALTH).getBaseValue() >= maxLife ? super.use(level, player, usedHand) : ItemUtils.startUsingInstantly(level, player, usedHand);
    }
}
