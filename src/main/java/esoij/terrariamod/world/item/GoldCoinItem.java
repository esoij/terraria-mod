package esoij.terrariamod.world.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class GoldCoinItem extends ItemNameBlockItem {
    public GoldCoinItem(Block block, Properties properties) {
        super(block, properties);
    }
    /**
     * Called each tick as long the item is in a player's inventory. Used by maps to check if it's in a player's hand and update its contents.
     */
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        //todo;if (stack.getCount() == 100) entity.getSlot(slotId).set(stack.transmuteCopy(ModItems.GOLD_COIN, 1));
    }
}
