package esoij.terrariamod.world.item;

import esoij.terrariamod.tags.ModBlockTags;
import net.minecraft.world.item.Tier;

public class HammerItem extends TerrariaDiggerItem {
    public HammerItem(Tier tier, Properties properties) {
        super(tier, ModBlockTags.MINEABLE_WITH_HAMMER, properties);
    }
}
