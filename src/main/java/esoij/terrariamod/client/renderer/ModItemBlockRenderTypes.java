package esoij.terrariamod.client.renderer;

import esoij.terrariamod.world.level.block.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

public class ModItemBlockRenderTypes {
    public static void init() {
        cutout(ModBlocks.TALL_GRASS);
        cutout(ModBlocks.CORRUPT_PLANTS);
        cutout(ModBlocks.MUSHROOM);
        cutout(ModBlocks.TORCH);
        cutout(ModBlocks.FOREST_SAPLING);
        cutout(ModBlocks.AMETHYST_GEM);
        cutout(ModBlocks.DIAMOND_GEM);
        cutout(ModBlocks.MUSHROOM_PLANTS);
        cutout(ModBlocks.VILE_MUSHROOM);
        cutout(ModBlocks.EMERALD_GEM);
        cutout(ModBlocks.BOREAL_SAPLING);
        cutout(ModBlocks.WOODEN_DOOR);
        cutout(ModBlocks.SPIKES);
        cutout(ModBlocks.BOTTLE);
    }
    public static void cutout(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
    }
}
