package esoij.terrariamod.data.models;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;

import static esoij.terrariamod.world.item.ModItems.*;
import static net.minecraft.data.models.model.ModelTemplates.FLAT_HANDHELD_ITEM;

public class ModItemModelGenerators extends FabricModelProvider {
    public ModItemModelGenerators(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockModelGenerators thiz) {
        //DO NOT USE THIS
    }
    @Override
    public void generateItemModels(ItemModelGenerators thiz) {
        thiz.generateFlatItem(ACCESSORIES, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(ACORN, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(AEGIS_FRUIT, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(AMBROSIA, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(AMETHYST, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(AMETHYST_STONE_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(ANGRY_BONES_BANNER, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(ARMOR, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(ASH_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(ASH_WOOD, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(BLOCKS, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(BLUE_BRICK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(BOREAL_WOOD, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(CHEST, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(CLAY_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(COLLECTOR, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(CONSUMABLES, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(COPPER_BAR, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(COPPER_BRICK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(COPPER_CHAINMAIL, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(COPPER_COIN, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(COPPER_GREAVES, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(COPPER_HELMET, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(COPPER_LEGGINGS, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(COPPER_ORE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(COPPER_WATCH, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(CRIMSAND_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(CRIMSON_SANDSTONE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(DEMONITE_ORE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(DEPTH_METER, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(DIAMOND, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(DIAMOND_STONE_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(DIRT_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(DUNGEON_SLIME_BANNER, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(EBONSTONE_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(EMERALD, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(EMERALD_STONE_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(EQUIPMENT, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(FALLEN_STAR, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(FEATHERFALL_POTION, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(FIERY_GREATSWORD, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(FLOWER_PACKET_TALL_GRASS, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(FURNITURE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GEL, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GILLS_POTION, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GLOWING_MUSHROOM, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GOLDEN_KEY, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GOLD_BAR, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GOLD_BRICK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GOLD_CHEST, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GOLD_COIN, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GOLD_ORE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GOLD_WATCH, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GRANITE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GRAY_BRICK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GRAY_STUCCO, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GREATER_HEALING_POTION, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GREEN_BRICK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(GREEN_SLIME_BANNER, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(HEALING_POTION, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(HELLSTONE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(ICE_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(IRON_AXE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(IRON_BAR, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(IRON_BROADSWORD, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(IRON_HAMMER, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(IRON_ORE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(IRON_PICKAXE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(IRON_SHORTSWORD, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(IRONSKIN_POTION, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(LESSER_HEALING_POTION, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(LIFE_CRYSTAL, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(LIFE_FRUIT, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(LOCKED_GOLD_CHEST, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(MARBLE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(MATERIALS, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(METEORITE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(MISC, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(MUD_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(MUSHROOM, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(OBSIDIAN_SKIN_POTION, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(OBTAIN_HAMMER, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(PALM_WOOD, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(PINK_BRICK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(PINK_GEL, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(PINK_SLIME_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(PINKY_BANNER, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(RED_BRICK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(RED_STUCCO, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(REGENERATION_POTION, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(RICH_MAHOGANY, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SAND_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SANDSTONE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SILT_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SILVER_BAR, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SILVER_BRICK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SILVER_COIN, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SILVER_ORE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SILVER_WATCH, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SLIME_BANNER, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SLUSH_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SNOW_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SPIKE, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(STONE_BLOCK, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SUPER_HEALING_POTION, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(SWIFTNESS_POTION, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(TIMBER, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(TOOLS, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(TORCH, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(VANITY, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(VILE_MUSHROOM, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(WEAPONS, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(WOOD, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(WOODEN_DOOR, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(WOODEN_SWORD, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(WORK_BENCH, FLAT_HANDHELD_ITEM);
        thiz.generateFlatItem(YELLOW_STUCCO, FLAT_HANDHELD_ITEM);
    }
}
