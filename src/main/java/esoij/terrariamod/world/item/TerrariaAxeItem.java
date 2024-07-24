package esoij.terrariamod.world.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class TerrariaAxeItem extends TerrariaDiggerItem {
    public TerrariaAxeItem(Tier tier, Item.Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_AXE, properties);
    }
}
