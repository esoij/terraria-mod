package esoij.terrariamod.world.item;

import net.minecraft.server.level.ServerPlayer;
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
        //todo;boolean bl = false;
        //todo;if (stack.getCount() == 100 && entity instanceof ServerPlayer player) for (int i = 0; i < player.getInventory().getContainerSize(); i++) if (player.getInventory().getItem(i).is(ModItems.a)) {
        //todo;    player.getInventory().getItem(i).grow(1);
        //todo;    entity.getSlot(slotId).get().shrink(100);
        //todo;    bl = true;
        //todo;    break;
        //todo;}
        //todo;if (stack.getCount() == 100 && entity instanceof ServerPlayer player && !bl) for (int i = 0; i < player.getInventory().getContainerSize(); i++) if (player.getInventory().getItem(i).is(ModItems.AIR) || i == slotId) {
        //todo;    player.getInventory().setItem(i, new ItemStack(ModItems.a, 1));
        //todo;    entity.getSlot(slotId).get().shrink(100);
        //todo;    bl = true;
        //todo;    break;
        //todo;}
    }
}
