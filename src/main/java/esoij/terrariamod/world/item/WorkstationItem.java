package esoij.terrariamod.world.item;

import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;

public class WorkstationItem extends ItemNameBlockItem {
    public WorkstationItem(Block block, Properties properties) {
        super(block, properties);
        this.craftingRemainingItem = this;
    }
}
