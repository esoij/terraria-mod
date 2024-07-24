package esoij.terrariamod.world.item;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class CopperCoinItem extends ItemNameBlockItem {
    public CopperCoinItem(Block block, Properties properties) {
        super(block, properties);
    }
    /**
     * Called each tick as long the item is in a player's inventory. Used by maps to check if it's in a player's hand and update its contents.
     */
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (stack.getCount() == 100 && entity instanceof ServerPlayer player) {
            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                if (player.getInventory().getItem(i).is(ModItems.SILVER_COIN)) {
                    player.getInventory().getItem(i).grow(1);
                    entity.getSlot(slotId).get().shrink(100);
                    break;
                }
            }
        }
    }
}