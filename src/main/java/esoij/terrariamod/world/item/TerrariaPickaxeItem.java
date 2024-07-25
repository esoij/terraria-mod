package esoij.terrariamod.world.item;

import esoij.terrariamod.tags.ModBlockTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class TerrariaPickaxeItem extends TerrariaDiggerItem {
    public TerrariaPickaxeItem(Tier tier, Item.Properties properties) {
        super(tier, ModBlockTags.MINEABLE_WITH_PICKAXE, properties);
    }
}
