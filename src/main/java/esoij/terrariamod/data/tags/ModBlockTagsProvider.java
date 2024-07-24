package esoij.terrariamod.data.tags;

import esoij.terrariamod.tags.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

import static esoij.terrariamod.world.level.block.ModBlocks.*;

public class ModBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE).add(BOREAL_TREE_LEAVES, BOREAL_TREE_LOG, CORRUPT_PLANTS, GLOWING_MUSHROOM_TREE_LEAVES, GLOWING_MUSHROOM_TREE_LOG,
                JUNGLE_TREE_LEAVES, JUNGLE_TREE_LOG, MUSHROOM, MUSHROOM_PLANTS, PALM_TREE_LEAVES, PALM_TREE_LOG, TALL_GRASS, TREE_ASH_LEAVES, TREE_ASH_LOG, TREE_LEAVES, TREE_LOG,
                VILE_MUSHROOM);
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(AMETHYST, ASH, ASH_GRASS, ASH_WOOD, BEACH_GRASS, BLUE_DUNGEON_BRICK, BOREAL_WOOD, CHEST, CLAY_BLOCK, COPPER, COPPER_BAR,
                COPPER_BRICK, COPPER_COIN_PILE, CORRUPT_GRASS, CRIMSAND, CRIMSON_SANDSTONE, DEMONITE, DIAMOND, DIRT, EBONSTONE, EMERALD, GOLD, GOLD_BAR, GOLD_BRICK, GOLD_CHEST,
                GOLD_COIN_PILE, GRASS, GRANITE, GRAY_BRICK, GRAY_STUCCO, GREEN_DUNGEON_BRICK, HELLSTONE, ICE_BLOCK, IRON, IRON_BAR, JUNGLE_GRASS, LOCKED_GOLD_CHEST, MARBLE,
                METEORITE, MUD, MUSHROOM_BLOCK, MUSHROOM_GRASS, PALM_WOOD, PINK_DUNGEON_BRICK, PINK_SLIME_BLOCK, RED_BRICK, RED_STUCCO, RICH_MAHOGANY, SAND, SANDSTONE, SILT, SILVER,
                SILVER_BAR, SILVER_BRICK, SILVER_COIN_PILE, SNOW_BLOCK, SPIKES, STONE, WOOD_BLOCK, WORK_BENCH, YELLOW_STUCCO);
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_SHOVEL).add(ASH_GRASS, BEACH_GRASS, CLAY_BLOCK, CORRUPT_GRASS, CRIMSAND, DIRT, GRASS, JUNGLE_GRASS, MUD, MUSHROOM_GRASS, SAND,
                SILT, SLUSH, SNOW_BLOCK);
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_HOE).add(BOREAL_TREE_LEAVES, GLOWING_MUSHROOM_TREE_LEAVES, JUNGLE_TREE_LEAVES, PALM_TREE_LEAVES, TREE_ASH_LEAVES, TREE_LEAVES);
        getOrCreateTagBuilder(BlockTags.ANIMALS_SPAWNABLE_ON).add(BEACH_GRASS, GRASS, JUNGLE_GRASS);
        getOrCreateTagBuilder(BlockTags.ARMADILLO_SPAWNABLE_ON).add(CRIMSAND);
        getOrCreateTagBuilder(BlockTags.AXOLOTLS_SPAWNABLE_ON).add(CLAY_BLOCK);
        getOrCreateTagBuilder(BlockTags.AZALEA_GROWS_ON).add(SLUSH, SNOW_BLOCK);
        getOrCreateTagBuilder(BlockTags.AZALEA_ROOT_REPLACEABLE).add(CLAY_BLOCK, CRIMSAND, SAND, SILT, SLUSH, SNOW_BLOCK);
        getOrCreateTagBuilder(BlockTags.BADLANDS_TERRACOTTA).add(GRAY_STUCCO, RED_STUCCO, YELLOW_STUCCO);
        getOrCreateTagBuilder(BlockTags.BAMBOO_PLANTABLE_ON).add(SILT);
        getOrCreateTagBuilder(BlockTags.BANNERS).add(ANGRY_BONES_BANNER, BLUE_SLIME_BANNER, DUNGEON_SLIME_BANNER, GREEN_SLIME_BANNER, PINKY_BANNER);
        getOrCreateTagBuilder(BlockTags.BASE_STONE_NETHER).add(ASH);
        getOrCreateTagBuilder(BlockTags.BASE_STONE_OVERWORLD).add(GRANITE, MARBLE, STONE);
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(COPPER_BAR, COPPER_BRICK, GOLD_BAR, GOLD_BRICK, IRON_BAR, SILVER_BAR, SILVER_BRICK);
        getOrCreateTagBuilder(BlockTags.COPPER_ORES).add(COPPER);
        getOrCreateTagBuilder(BlockTags.DEEPSLATE_ORE_REPLACEABLES).add(GRANITE, MARBLE, STONE);
        getOrCreateTagBuilder(BlockTags.DIRT).add(BARRIER, BEACH_GRASS, CORRUPT_GRASS, GRASS, JUNGLE_GRASS, MUD, MUSHROOM_GRASS);
        getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE).add(ASH_GRASS, CLAY_BLOCK, CRIMSAND, MUSHROOM, SAND, SILT);
        getOrCreateTagBuilder(BlockTags.FEATURES_CANNOT_REPLACE).add(CHEST, GOLD_CHEST, LOCKED_GOLD_CHEST);
        getOrCreateTagBuilder(BlockTags.FOXES_SPAWNABLE_ON).add(BEACH_GRASS, GRASS, JUNGLE_GRASS, SLUSH, SNOW_BLOCK);
        getOrCreateTagBuilder(BlockTags.FROGS_SPAWNABLE_ON).add(BEACH_GRASS, GRASS, JUNGLE_GRASS, MUD);
        getOrCreateTagBuilder(BlockTags.GEODE_INVALID_BLOCKS).add(ICE_BLOCK, WATER);
        getOrCreateTagBuilder(BlockTags.GOATS_SPAWNABLE_ON).add(GRANITE, MARBLE, SILT, SLUSH, SNOW_BLOCK, STONE);
        getOrCreateTagBuilder(BlockTags.GOLD_ORES).add(GOLD);
        getOrCreateTagBuilder(BlockTags.GUARDED_BY_PIGLINS).add(CHEST, GOLD, GOLD_BAR, GOLD_BRICK, GOLD_CHEST, GOLD_COIN_PILE, LOCKED_GOLD_CHEST);
        getOrCreateTagBuilder(BlockTags.ICE).add(ICE_BLOCK);
        getOrCreateTagBuilder(BlockTags.INFINIBURN_OVERWORLD).add(ASH, HELLSTONE, METEORITE);
        getOrCreateTagBuilder(BlockTags.IRON_ORES).add(IRON);
        getOrCreateTagBuilder(BlockTags.LEAVES).add(BOREAL_TREE_LEAVES, GLOWING_MUSHROOM_TREE_LEAVES, JUNGLE_TREE_LEAVES, PALM_TREE_LEAVES, TREE_ASH_LEAVES, TREE_LEAVES);
        getOrCreateTagBuilder(BlockTags.LOGS).add(TREE_ASH_LOG);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(BOREAL_TREE_LOG, GLOWING_MUSHROOM_TREE_LOG, JUNGLE_TREE_LOG, PALM_TREE_LOG, TREE_LOG);
        getOrCreateTagBuilder(BlockTags.LUSH_GROUND_REPLACEABLE).add(CLAY_BLOCK, SAND, SILT);
        getOrCreateTagBuilder(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH).add(MUD);
        getOrCreateTagBuilder(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH).add(MUD);
        getOrCreateTagBuilder(BlockTags.MOOSHROOMS_SPAWNABLE_ON).add(MUSHROOM_GRASS);
        getOrCreateTagBuilder(BlockTags.MUSHROOM_GROW_BLOCK).add(MUSHROOM_GRASS);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(COPPER_BRICK, DEMONITE, EBONSTONE, GOLD, GOLD_BRICK, SILVER, SILVER_BRICK);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(COPPER, IRON);
        getOrCreateTagBuilder(BlockTags.OVERWORLD_CARVER_REPLACEABLES).add(CRIMSON_SANDSTONE, SANDSTONE, SILT, WATER);
        getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS).add(BOREAL_TREE_LOG, GLOWING_MUSHROOM_TREE_LOG, JUNGLE_TREE_LOG, PALM_TREE_LOG, TREE_LOG);
        getOrCreateTagBuilder(BlockTags.PARROTS_SPAWNABLE_ON).add(BEACH_GRASS, GRASS, JUNGLE_GRASS);
        getOrCreateTagBuilder(BlockTags.PLANKS).add(ASH_WOOD, BOREAL_WOOD, PALM_WOOD, RICH_MAHOGANY, WOOD_BLOCK);
        getOrCreateTagBuilder(BlockTags.POLAR_BEARS_SPAWNABLE_ON_ALTERNATE).add(ICE_BLOCK);
        getOrCreateTagBuilder(BlockTags.RABBITS_SPAWNABLE_ON).add(BEACH_GRASS, GRASS, JUNGLE_GRASS, SAND, SLUSH, SNOW_BLOCK);
        getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_TREES).add(BOREAL_SAPLING, CORRUPT_PLANTS, FOREST_SAPLING, MUSHROOM_PLANTS, TALL_GRASS, VILE_MUSHROOM, WATER);
        getOrCreateTagBuilder(BlockTags.SAND).add(CRIMSAND, SAND);
        getOrCreateTagBuilder(BlockTags.SAPLINGS).add(BOREAL_SAPLING, FOREST_SAPLING);
        getOrCreateTagBuilder(BlockTags.SCULK_REPLACEABLE).add(CLAY_BLOCK, CRIMSAND, CRIMSON_SANDSTONE, SAND, SANDSTONE, SILT);
        getOrCreateTagBuilder(BlockTags.SMALL_DRIPLEAF_PLACEABLE).add(CLAY_BLOCK);
        getOrCreateTagBuilder(BlockTags.SMELTS_TO_GLASS).add(CRIMSAND, SAND);
        getOrCreateTagBuilder(BlockTags.SNAPS_GOAT_HORN).add(COPPER, EBONSTONE, GRANITE, IRON, MARBLE, STONE);
        getOrCreateTagBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(ASH_GRASS, BEACH_GRASS, CORRUPT_GRASS, DIRT, GRASS, JUNGLE_GRASS, MUD);
        getOrCreateTagBuilder(BlockTags.SNOW).add(SLUSH, SNOW_BLOCK);
        getOrCreateTagBuilder(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON).add(MUD);
        getOrCreateTagBuilder(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON).add(ICE_BLOCK);
        getOrCreateTagBuilder(BlockTags.STONE_BRICKS).add(GRAY_BRICK);
        getOrCreateTagBuilder(BlockTags.STONE_ORE_REPLACEABLES).add(GRANITE, MARBLE, STONE);
        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT).add(CORRUPT_PLANTS, MUSHROOM, MUSHROOM_PLANTS, TALL_GRASS, VILE_MUSHROOM);
        getOrCreateTagBuilder(BlockTags.TERRACOTTA).add(GRAY_STUCCO, RED_STUCCO, YELLOW_STUCCO);
        getOrCreateTagBuilder(BlockTags.TRAIL_RUINS_REPLACEABLE).add(SILT);
        getOrCreateTagBuilder(BlockTags.VALID_SPAWN).add(ASH_GRASS, BEACH_GRASS, GRASS, JUNGLE_GRASS);
        getOrCreateTagBuilder(BlockTags.WALL_POST_OVERRIDE).add(TORCH);
        getOrCreateTagBuilder(BlockTags.WOLVES_SPAWNABLE_ON).add(BEACH_GRASS, GRASS, JUNGLE_GRASS, SLUSH, SNOW_BLOCK);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(WOODEN_DOOR);
        getOrCreateTagBuilder(ModBlockTags.ASH_GRASS_CAN_SPREAD_TO).add(ASH);
        getOrCreateTagBuilder(ModBlockTags.GRASS_CAN_SPREAD_TO).add(DIRT);
        getOrCreateTagBuilder(ModBlockTags.JUNGLE_GRASS_CAN_SPREAD_TO).add(MUD);
        getOrCreateTagBuilder(ModBlockTags.MINEABLE_WITH_PICKAXE).addTag(BlockTags.MINEABLE_WITH_PICKAXE);
        getOrCreateTagBuilder(ModBlockTags.MINEABLE_WITH_PICKAXE).addTag(BlockTags.MINEABLE_WITH_SHOVEL);
        getOrCreateTagBuilder(ModBlockTags.MINEABLE_WITH_PICKAXE).addTag(BlockTags.MINEABLE_WITH_HOE);
    }
}
