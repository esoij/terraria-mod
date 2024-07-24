package esoij.terrariamod.tags;

import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> ASH_GRASS_CAN_SPREAD_TO = create("ash_grass_can_spread_to");
    public static final TagKey<Block> GRASS_CAN_SPREAD_TO = create("grass_can_spread_to");
    public static final TagKey<Block> JUNGLE_GRASS_CAN_SPREAD_TO = create("jungle_grass_can_spread_to");
    public static final TagKey<Block> MINEABLE_WITH_HAMMER = create("mineable/hammer");
    public static final TagKey<Block> MINEABLE_WITH_PICKAXE = create("mineable/pickaxe");
    private static TagKey<Block> create(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocationHelper.parse(name));
    }
}
