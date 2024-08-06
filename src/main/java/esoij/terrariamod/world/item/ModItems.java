package esoij.terrariamod.world.item;

import com.google.common.collect.ImmutableList;
import com.mojang.logging.LogUtils;
import esoij.terrariamod.resources.ResourceLocationHelper;
import esoij.terrariamod.world.effect.ModMobEffects;
import esoij.terrariamod.world.entity.ModEntityType;
import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.component.ItemContainerContents;
import org.slf4j.Logger;

import java.util.Optional;

import static esoij.terrariamod.ModSharedConstants.IDE;

//IDs 1-234:   1.0.0
//ID  235:     1.0.2
//IDs 236-238: 1.0.3
public class ModItems extends Items {
    public static final Logger LOGGER = LogUtils.getLogger();
    private static final ImmutableList.Builder<FoodProperties.PossibleEffect> effects = ImmutableList.builder();
    public static final Item UTIL_FAST_EAT_FOOD = registerItem("fast_eat_food", new Item(new Properties().food(new FoodProperties(1, 0, true, .05F, Optional.empty(), effects.build()))));
    public static final Item UTIL_HIGH_VALUE_FAST_EAT_FOOD = registerItem("high_value_fast_eat_food", new Item(new Properties().food(new FoodProperties(50, 50, true, .05F, Optional.empty(), effects.build()))));
    public static final Item WEAPONS = registerItem(                           -1,    "creativemodetabiconweapons",         new Item(                                                     new Properties()));
    public static final Item ARMOR = registerItem(                             -1,    "creativemodetabiconarmor",           new Item(                                                     new Properties()));
    public static final Item VANITY = registerItem(                            -1,    "creativemodetabiconvanity",          new Item(                                                     new Properties()));
    public static final Item BLOCKS = registerItem(                            -1,    "creativemodetabiconblocks",          new Item(                                                     new Properties()));
    public static final Item FURNITURE = registerItem(                         -1,    "creativemodetabiconfurniture",       new Item(                                                     new Properties()));
    public static final Item ACCESSORIES = registerItem(                       -1,    "creativemodetabiconaccessories",     new Item(                                                     new Properties()));
    public static final Item EQUIPMENT = registerItem(                         -1,    "creativemodetabiconequipment",       new Item(                                                     new Properties()));
    public static final Item CONSUMABLES = registerItem(                       -1,    "creativemodetabiconconsumables",     new Item(                                                     new Properties()));
    public static final Item TOOLS = registerItem(                             -1,    "creativemodetabicontools",           new Item(                                                     new Properties()));
    public static final Item MATERIALS = registerItem(                         -1,    "creativemodetabiconmaterials",       new Item(                                                     new Properties()));
    public static final Item MISC = registerItem(                              -1,    "creativemodetabiconmisc",            new Item(                                                     new Properties()));
    public static final Item COLLECTOR = registerItem(                         -1,    "advancementcategorycollector",       new Item(                                                     new Properties()));
    public static final Item TIMBER = registerItem(                            -1,    "advancementicontimber",              new Item(                                                     new Properties()));
    public static final Item OBTAIN_HAMMER = registerItem(                     -1,    "advancementiconobtainhammer",        new Item(                                                     new Properties()));
    public static final Item GRASS_BLOCK = registerItem(                       -1,    "grass_block",                        new ItemNameBlockItem(ModBlocks.GRASS,                        new Properties()));
    public static final Item BEACH_GRASS_BLOCK = registerItem(                 -1,    "beach_grass_block",                  new ItemNameBlockItem(ModBlocks.BEACH_GRASS,                  new Properties()));
    public static final Item CORRUPT_GRASS_BLOCK = registerItem(               -1,    "corrupt_grass_block",                new ItemNameBlockItem(ModBlocks.CORRUPT_GRASS,                new Properties()));
    public static final Item JUNGLE_GRASS_BLOCK = registerItem(                -1,    "jungle_grass_block",                 new ItemNameBlockItem(ModBlocks.JUNGLE_GRASS,                 new Properties()));
    public static final Item CORRUPT_PLANTS_BLOCK = registerItem(              -1,    "corrupt_plants_block",               new ItemNameBlockItem(ModBlocks.CORRUPT_PLANTS,               new Properties()));
    public static final Item MUSHROOM_GRASS_BLOCK = registerItem(              -1,    "mushroom_grass_block",               new ItemNameBlockItem(ModBlocks.MUSHROOM_GRASS,               new Properties()));
    public static final Item TREE_LOG_BLOCK = registerItem(                    -1,    "tree_log_block",                     new ItemNameBlockItem(ModBlocks.TREE_LOG,                     new Properties()));
    public static final Item TREE_LEAVES_BLOCK = registerItem(                 -1,    "tree_leaves_block",                  new ItemNameBlockItem(ModBlocks.TREE_LEAVES,                  new Properties()));
    public static final Item GLOWING_MUSHROOM_TREE_LOG_BLOCK = registerItem(   -1,    "glowing_mushroom_tree_log_block",    new ItemNameBlockItem(ModBlocks.GLOWING_MUSHROOM_TREE_LOG,    new Properties()));
    public static final Item GLOWING_MUSHROOM_TREE_LEAVES_BLOCK = registerItem(-1,    "glowing_mushroom_tree_leaves_block", new ItemNameBlockItem(ModBlocks.GLOWING_MUSHROOM_TREE_LEAVES, new Properties()));
    public static final Item MUSHROOM_PLANTS_BLOCK = registerItem(             -1,    "mushroom_plants_block",              new ItemNameBlockItem(ModBlocks.MUSHROOM_PLANTS,              new Properties()));
    public static final Item TERRARIA_CRAFTER = registerItem(                  -1,    "terraria_crafter",                   new ItemNameBlockItem(ModBlocks.TERRARIA_CRAFTER,             new Properties()));
    public static final Item PALM_TREE_LOG_BLOCK = registerItem(               -1,    "palm_tree_log_block",                new ItemNameBlockItem(ModBlocks.PALM_TREE_LOG,                new Properties()));
    public static final Item PALM_TREE_LEAVES_BLOCK = registerItem(            -1,    "palm_tree_leaves_block",             new ItemNameBlockItem(ModBlocks.PALM_TREE_LEAVES,             new Properties()));
    public static final Item JUNGLE_TREE_LOG_BLOCK = registerItem(             -1,    "jungle_tree_log_block",              new ItemNameBlockItem(ModBlocks.JUNGLE_TREE_LOG,              new Properties()));
    public static final Item JUNGLE_TREE_LEAVES_BLOCK = registerItem(          -1,    "jungle_tree_leaves_block",           new ItemNameBlockItem(ModBlocks.JUNGLE_TREE_LEAVES,           new Properties()));
    public static final Item BOREAL_TREE_LOG_BLOCK = registerItem(             -1,    "boreal_tree_log_block",              new ItemNameBlockItem(ModBlocks.BOREAL_TREE_LOG,              new Properties()));
    public static final Item BOREAL_TREE_LEAVES_BLOCK = registerItem(          -1,    "boreal_tree_leaves_block",           new ItemNameBlockItem(ModBlocks.BOREAL_TREE_LEAVES,           new Properties()));
    public static final Item ASH_GRASS_BLOCK = registerItem(                   -1,    "ash_grass_block",                    new ItemNameBlockItem(ModBlocks.ASH_GRASS,                    new Properties()));
    public static final Item TREE_ASH_LOG_BLOCK = registerItem(                -1,    "tree_ash_log_block",                 new ItemNameBlockItem(ModBlocks.TREE_ASH_LOG,                 new Properties()));
    public static final Item TREE_ASH_LEAVES_BLOCK = registerItem(             -1,    "tree_ash_leaves_block",              new ItemNameBlockItem(ModBlocks.TREE_ASH_LEAVES,              new Properties()));
    public static final Item BLUE_SLIME_SPAWN_EGG = registerItem(              -1,    "blue_slime_spawn_egg",               new TerrariaSpawnEggItem(                                     new Properties(), ModEntityType.BLUE_SLIME, 0x1a49ac, 0x4074e2));
    public static final Item GREEN_SLIME_SPAWN_EGG = registerItem(             -1,    "green_slime_spawn_egg",              new TerrariaSpawnEggItem(                                     new Properties(), ModEntityType.GREEN_SLIME, 0x2f9842, 0x3abb52));
    public static final Item COPPER_LEGGINGS = registerItem(                   -1,    "copper_leggings",                    new TerrariaArmorItem(                                        new Properties().stacksTo(1), ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, TerrariaArmorSets.COPPER));
    public static final Item DUNGEON_SLIME_SPAWN_EGG = registerItem(           -1,    "dungeon_slime_spawn_egg",            new TerrariaSpawnEggItem(                                     new Properties(), ModEntityType.DUNGEON_SLIME, 0x383265, 0x676292));
    public static final Item PINKY_SPAWN_EGG = registerItem(                   -1,    "pinky_spawn_egg",                    new TerrariaSpawnEggItem(                                     new Properties(), ModEntityType.PINKY, 0xff4b83, 0xff5da1));
    public static final Item ANGRY_BONES_SPAWN_EGG = registerItem(             -1,    "angry_bones_spawn_egg",              new TerrariaSpawnEggItem(                                     new Properties(), ModEntityType.ANGRY_BONES, 0x6b2e29, 0xb2b289));
    public static final Item LOCKED_GOLD_CHEST = registerItem(                 -1,    "locked_gold_chest",                  new ItemNameBlockItem(ModBlocks.LOCKED_GOLD_CHEST,            new Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));

    public static final Item IRON_PICKAXE = registerItem(                       1,    "iron_pickaxe",                       new TerrariaPickaxeItem(ModTiers.IRON,                        new Properties().attributes(TerrariaPickaxeItem.createAttributes(5, -1.1428572F)).stacksTo(1)));
    public static final Item DIRT_BLOCK = registerItem(                         2,    "dirt_block",                         new ItemNameBlockItem(ModBlocks.DIRT,                         new Properties()));
    public static final Item STONE_BLOCK = registerItem(                        3,    "stone_block",                        new ItemNameBlockItem(ModBlocks.STONE,                        new Properties()));
    public static final Item IRON_BROADSWORD = registerItem(                    4,    "iron_broadsword",                    new TerrariaSwordItem(ModTiers.IRON,                          new Properties().attributes(TerrariaSwordItem.createAttributes(12, -1.1428572F)).stacksTo(1)));
    public static final Item MUSHROOM = registerItem(                           5,    "mushroom",                           new MushroomItem(ModBlocks.MUSHROOM,                          new Properties()));
    public static final Item IRON_SHORTSWORD = registerItem(                    6,    "iron_shortsword",                    new TerrariaSwordItem(ModTiers.IRON,                          new Properties().attributes(TerrariaSwordItem.createAttributes(8, 1)).stacksTo(1)));
    public static final Item IRON_HAMMER = registerItem(                        7,    "iron_hammer",                        new HammerItem(ModTiers.IRON,                                 new Properties().attributes(HammerItem.createAttributes(7, -2)).stacksTo(1)));
    public static final Item TORCH = registerItem(                              8,    "torch",                              new ItemNameBlockItem(ModBlocks.TORCH,                        new Properties()));
    public static final Item WOOD = registerItem(                               9,    "wood",                               new ItemNameBlockItem(ModBlocks.WOOD_BLOCK,                   new Properties()));
    public static final Item IRON_AXE = registerItem(                           10,   "iron_axe",                           new TerrariaAxeItem(ModTiers.IRON,                            new Properties().attributes(TerrariaAxeItem.createAttributes(5, -1.7777778F)).stacksTo(1)));
    public static final Item IRON_ORE = registerItem(                           11,   "iron_ore",                           new ItemNameBlockItem(ModBlocks.IRON,                         new Properties()));
    public static final Item COPPER_ORE = registerItem(                         12,   "copper_ore",                         new ItemNameBlockItem(ModBlocks.COPPER,                       new Properties()));
    public static final Item GOLD_ORE = registerItem(                           13,   "gold_ore",                           new ItemNameBlockItem(ModBlocks.GOLD,                         new Properties()));
    public static final Item SILVER_ORE = registerItem(                         14,   "silver_ore",                         new ItemNameBlockItem(ModBlocks.SILVER,                       new Properties()));
    public static final Item COPPER_WATCH = registerItem(                       15,   "copper_watch",                       new Item(                                                     new Properties()));
    public static final Item SILVER_WATCH = registerItem(                       16,   "silver_watch",                       new Item(                                                     new Properties()));
    public static final Item GOLD_WATCH = registerItem(                         17,   "gold_watch",                         new Item(                                                     new Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item DEPTH_METER = registerItem(                        18,   "depth_meter",                        new Item(                                                     new Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item GOLD_BAR = registerItem(                           19,   "gold_bar",                           new ItemNameBlockItem(ModBlocks.GOLD_BAR,                     new Properties()));
    public static final Item COPPER_BAR = registerItem(                         20,   "copper_bar",                         new ItemNameBlockItem(ModBlocks.COPPER_BAR,                   new Properties()));
    public static final Item SILVER_BAR = registerItem(                         21,   "silver_bar",                         new ItemNameBlockItem(ModBlocks.SILVER_BAR,                   new Properties()));
    public static final Item IRON_BAR = registerItem(                           22,   "iron_bar",                           new ItemNameBlockItem(ModBlocks.IRON_BAR,                     new Properties()));
    public static final Item GEL = registerItem(                                23,   "gel",                                new Item(                                                     new Properties()));
    public static final Item WOODEN_SWORD = registerItem(                       24,   "wooden_sword",                       new TerrariaSwordItem(ModTiers.WOOD,                          new Properties().attributes(TerrariaSwordItem.createAttributes(7, -1)).stacksTo(1)));
    public static final Item WOODEN_DOOR = registerItem(                        25,   "wooden_door",                        new DoubleHighBlockItem(ModBlocks.WOODEN_DOOR,                new Properties()));

    public static final Item ACORN = registerItem(                              27,   "acorn",                              new ItemNameBlockItem(ModBlocks.FOREST_SAPLING,               new Properties()));
    public static final Item LESSER_HEALING_POTION = registerItem(              28,   "lesser_healing_potion",              new HealingItem(                                              new Properties(), 17, 50, 60));
    public static final Item LIFE_CRYSTAL = registerItem(                       29,   "life_crystal",                       new LifeCrystalItem(                                          new Properties().rarity(Rarity.UNCOMMON).fireResistant(), 20, 400));

    public static final Item BOTTLE = registerItem(                             31,   "bottle",                             new ItemNameBlockItem(ModBlocks.BOTTLE,                       new Properties()));

    public static final Item FURNACE = registerItem(                            33,   "furnace",                            new WorkstationItem(ModBlocks.FURNACE,                        new Properties()));

    public static final Item WORK_BENCH = registerItem(                         36,   "work_bench",                         new WorkstationItem(ModBlocks.WORK_BENCH,                     new Properties()));

    public static final Item CHEST = registerItem(                              48,   "chest",                              new ItemNameBlockItem(ModBlocks.CHEST,                        new Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));

    public static final Item DEMONITE_ORE = registerItem(                       56,   "demonite_ore",                       new ItemNameBlockItem(ModBlocks.DEMONITE,                     new Properties().rarity(Rarity.UNCOMMON).fireResistant()));

    public static final Item VILE_MUSHROOM = registerItem(                      60,   "vile_mushroom",                      new ItemNameBlockItem(ModBlocks.VILE_MUSHROOM,                new Properties()));
    public static final Item EBONSTONE_BLOCK = registerItem(                    61,   "ebonstone_block",                    new ItemNameBlockItem(ModBlocks.EBONSTONE,                    new Properties()));

    public static final Item COPPER_COIN = registerItem(                        71,   "copper_coin",                        new CopperCoinItem(ModBlocks.COPPER_COIN_PILE,                new Properties().stacksTo(100)));
    public static final Item SILVER_COIN = registerItem(                        72,   "silver_coin",                        new SilverCoinItem(ModBlocks.SILVER_COIN_PILE,                new Properties().stacksTo(100)));
    public static final Item GOLD_COIN = registerItem(                          73,   "gold_coin",                          new GoldCoinItem(ModBlocks.GOLD_COIN_PILE,                    new Properties().stacksTo(100)));

    public static final Item FALLEN_STAR = registerItem(                        75,   "fallen_star",                        new Item(                                                     new Properties()));
    public static final Item COPPER_GREAVES = registerItem(                     76,   "copper_greaves",                     new TerrariaArmorItem(                                        new Properties().stacksTo(1), ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, TerrariaArmorSets.COPPER));

    public static final Item COPPER_CHAINMAIL = registerItem(                   80,   "copper_chainmail",                   new TerrariaArmorItem(                                        new Properties().stacksTo(1), ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, TerrariaArmorSets.COPPER));

    public static final Item COPPER_HELMET = registerItem(                      80,   "copper_helmet",                      new TerrariaArmorItem(                                        new Properties().stacksTo(1), ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, TerrariaArmorSets.COPPER));

    public static final Item METEORITE = registerItem(                          116,  "meteorite",                          new ItemNameBlockItem(ModBlocks.METEORITE,                    new Properties()));

    public static final Item FIERY_GREATSWORD = registerItem(                   121,  "fiery_greatsword",                   new VolcanoItem(ModTiers.HELLSTONE,                           new Properties().stacksTo(1).attributes(VolcanoItem.createAttributes(40, -2.5f))));

    public static final Item GRAY_BRICK = registerItem(                         129,  "gray_brick",                         new ItemNameBlockItem(ModBlocks.GRAY_BRICK,                   new Properties()));

    public static final Item RED_BRICK = registerItem(                          131,  "red_brick",                          new ItemNameBlockItem(ModBlocks.RED_BRICK,                    new Properties()));

    public static final Item CLAY_BLOCK = registerItem(                         133,  "clay_block",                         new ItemNameBlockItem(ModBlocks.CLAY_BLOCK,                   new Properties()));
    public static final Item BLUE_BRICK = registerItem(                         134,  "blue_brick",                         new ItemNameBlockItem(ModBlocks.BLUE_DUNGEON_BRICK,           new Properties()));

    public static final Item GREEN_BRICK = registerItem(                        137,  "green_brick",                        new ItemNameBlockItem(ModBlocks.GREEN_DUNGEON_BRICK,          new Properties()));

    public static final Item PINK_BRICK = registerItem(                         139,  "pink_brick",                         new ItemNameBlockItem(ModBlocks.PINK_DUNGEON_BRICK,           new Properties()));

    public static final Item GOLD_BRICK = registerItem(                         141,  "gold_brick",                         new ItemNameBlockItem(ModBlocks.GOLD_BRICK,                   new Properties()));

    public static final Item SILVER_BRICK = registerItem(                       143,  "silver_brick",                       new ItemNameBlockItem(ModBlocks.SILVER_BRICK,                 new Properties()));

    public static final Item COPPER_BRICK = registerItem(                       145,  "copper_brick",                       new ItemNameBlockItem(ModBlocks.COPPER_BRICK,                 new Properties()));

    public static final Item SPIKE = registerItem(                              147,  "spike",                              new ItemNameBlockItem(ModBlocks.SPIKES,                       new Properties()));

    public static final Item SAND_BLOCK = registerItem(                         169,  "sand_block",                         new ItemNameBlockItem(ModBlocks.SAND,                         new Properties()));

    public static final Item ASH_BLOCK = registerItem(                          172,  "ash_block",                          new ItemNameBlockItem(ModBlocks.ASH,                          new Properties()));

    public static final Item HELLSTONE = registerItem(                          174,  "hellstone",                          new ItemNameBlockItem(ModBlocks.HELLSTONE,                    new Properties().rarity(Rarity.UNCOMMON).fireResistant()));

    public static final Item MUD_BLOCK = registerItem(                          176,  "mud_block",                          new ItemNameBlockItem(ModBlocks.MUD,                          new Properties()));

    public static final Item EMERALD = registerItem(                            179,  "emerald",                            new ItemNameBlockItem(ModBlocks.EMERALD_GEM,                  new Properties()));

    public static final Item AMETHYST = registerItem(                           181,  "amethyst",                           new ItemNameBlockItem(ModBlocks.AMETHYST_GEM,                 new Properties()));
    public static final Item DIAMOND  = registerItem(                           182,  "diamond",                            new ItemNameBlockItem(ModBlocks.DIAMOND_GEM ,                 new Properties()));
    public static final Item GLOWING_MUSHROOM = registerItem(                   183,  "glowing_mushroom",                   new ItemNameBlockItem(ModBlocks.MUSHROOM_BLOCK,               new Properties()));

    public static final Item HEALING_POTION = registerItem(                     188,  "healing_potion",                     new HealingItem(                                              new Properties().rarity(Rarity.UNCOMMON).fireResistant(), 17, 100, 60));

    public static final Item OBSIDIAN_SKIN_POTION = registerItem(               288,  "obsidian_skin_potion",               new TerrariaPotionItem(                                       new Properties().rarity(Rarity.UNCOMMON).fireResistant(), ModMobEffects.OBSIDIAN_SKIN, 60*6));
    public static final Item REGENERATION_POTION = registerItem(                289,  "regeneration_potion",                new TerrariaPotionItem(                                       new Properties().rarity(Rarity.UNCOMMON).fireResistant(), ModMobEffects.REGENERATION, 60*8));
    public static final Item SWIFTNESS_POTION = registerItem(                   290,  "swiftness_potion",                   new TerrariaPotionItem(                                       new Properties().rarity(Rarity.UNCOMMON).fireResistant(), ModMobEffects.SWIFTNESS, 60*8));
    public static final Item GILLS_POTION = registerItem(                       291,  "gills_potion",                       new TerrariaPotionItem(                                       new Properties().rarity(Rarity.UNCOMMON).fireResistant(), ModMobEffects.GILLS, 60*4));
    public static final Item IRONSKIN_POTION = registerItem(                    292,  "ironskin_potion",                    new TerrariaPotionItem(                                       new Properties().rarity(Rarity.UNCOMMON).fireResistant(), ModMobEffects.IRONSKIN, 60*8));

    public static final Item FEATHERFALL_POTION = registerItem(                 295,  "featherfall_potion",                 new TerrariaPotionItem(                                       new Properties().rarity(Rarity.UNCOMMON).fireResistant(), ModMobEffects.FEATHERFALL, 60*10));

    public static final Item GOLD_CHEST = registerItem(                         306,  "gold_chest",                         new ItemNameBlockItem(ModBlocks.GOLD_CHEST,                   new Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)));

    public static final Item GOLDEN_KEY = registerItem(                         327,  "golden_key",                         new Item(                                                     new Properties()));

    public static final Item SILT_BLOCK = registerItem(                         424,  "silt_block",                         new ItemNameBlockItem(ModBlocks.SILT,                         new Properties()));

    public static final Item GREATER_HEALING_POTION = registerItem(             499,  "greater_healing_potion",             new HealingItem(                                              new Properties().rarity(Rarity.UNCOMMON).fireResistant(), 17, 150, 60));

    public static final Item SNOW_BLOCK = registerItem(                         593,  "snow_block",                         new ItemNameBlockItem(ModBlocks.SNOW_BLOCK,                   new Properties()));

    public static final Item RED_STUCCO = registerItem(                         611,  "red_stucco",                         new ItemNameBlockItem(ModBlocks.RED_STUCCO,                   new Properties()));
    public static final Item YELLOW_STUCCO = registerItem(                      612,  "yellow_stucco",                      new ItemNameBlockItem(ModBlocks.YELLOW_STUCCO,                new Properties()));

    public static final Item GRAY_STUCCO = registerItem(                        614,  "gray_stucco",                        new ItemNameBlockItem(ModBlocks.GRAY_STUCCO,                  new Properties()));

    public static final Item RICH_MAHOGANY = registerItem(                      620,  "rich_mahogany",                      new ItemNameBlockItem(ModBlocks.RICH_MAHOGANY,                new Properties()));

    public static final Item ICE_BLOCK = registerItem(                          664,  "ice_block",                          new ItemNameBlockItem(ModBlocks.ICE_BLOCK,                    new Properties()));

    public static final Item SLUSH_BLOCK = registerItem(                        1103, "slush_block",                        new ItemNameBlockItem(ModBlocks.SLUSH,                        new Properties()));

    public static final Item CRIMSAND_BLOCK = registerItem(                     1246, "crimsand_block",                     new ItemNameBlockItem(ModBlocks.CRIMSAND,                     new Properties()));

    public static final Item LIFE_FRUIT = registerItem(                         1291, "life_fruit",                         new LifeCrystalItem(                                          new Properties().rarity(Rarity.RARE).fireResistant(), 5, 500));

    public static final Item SLIME_BANNER = registerItem(                       1683, "slime_banner",                       new ItemNameBlockItem(ModBlocks.BLUE_SLIME_BANNER,            new Properties().rarity(Rarity.UNCOMMON).fireResistant()));

    public static final Item BOREAL_WOOD = registerItem(                        2503, "boreal_wood",                        new ItemNameBlockItem(ModBlocks.BOREAL_WOOD,                  new Properties()));
    public static final Item PALM_WOOD = registerItem(                          2504, "palm_wood",                          new ItemNameBlockItem(ModBlocks.PALM_WOOD,                    new Properties()));

    public static final Item DUNGEON_SLIME_BANNER = registerItem(               2916, "dungeon_slime_banner",               new ItemNameBlockItem(ModBlocks.DUNGEON_SLIME_BANNER,         new Properties().rarity(Rarity.UNCOMMON).fireResistant()));

    public static final Item GREEN_SLIME_BANNER = registerItem(                 2928, "green_slime_banner",                 new ItemNameBlockItem(ModBlocks.GREEN_SLIME_BANNER,           new Properties().rarity(Rarity.UNCOMMON).fireResistant()));

    public static final Item PINKY_BANNER = registerItem(                       2960, "pinky_banner",                       new ItemNameBlockItem(ModBlocks.PINKY_BANNER,                 new Properties().rarity(Rarity.UNCOMMON).fireResistant()));

    public static final Item MARBLE = registerItem(                             3081, "marble",                             new ItemNameBlockItem(ModBlocks.MARBLE,                       new Properties()));

    public static final Item GRANITE = registerItem(                            3086, "granite",                            new ItemNameBlockItem(ModBlocks.GRANITE,                      new Properties()));

    public static final Item PINK_GEL = registerItem(                           3111, "pink_gel",                           new Item(                                                     new Properties()));

    public static final Item PINK_SLIME_BLOCK = registerItem(                   3113, "pink_slime_block",                   new ItemNameBlockItem(ModBlocks.PINK_SLIME_BLOCK,             new Properties()));

    public static final Item SANDSTONE = registerItem(                          3271, "sandstone",                          new ItemNameBlockItem(ModBlocks.SANDSTONE,                    new Properties()));

    public static final Item CRIMSON_SANDSTONE = registerItem(                  3277, "crimson_sandstone",                  new ItemNameBlockItem(ModBlocks.CRIMSON_SANDSTONE,            new Properties()));

    public static final Item ANGRY_BONES_BANNER = registerItem(                 3451, "angry_bones_banner",                 new ItemNameBlockItem(ModBlocks.ANGRY_BONES_BANNER,           new Properties().rarity(Rarity.UNCOMMON).fireResistant()));

    public static final Item SUPER_HEALING_POTION = registerItem(               3544, "super_healing_potion",               new HealingItem(                                              new Properties().rarity(Rarity.RARE).fireResistant(), 17, 200, 60));

    public static final Item FLOWER_PACKET_TALL_GRASS = registerItem(           4048, "flower_packet_tall_grass",           new ItemNameBlockItem(ModBlocks.TALL_GRASS,                   new Properties()));

    public static final Item AMETHYST_STONE_BLOCK = registerItem(               4640, "amethyst_stone_block",               new ItemNameBlockItem(ModBlocks.AMETHYST,                     new Properties()));

    public static final Item EMERALD_STONE_BLOCK = registerItem(                4643, "emerald_stone_block",                new ItemNameBlockItem(ModBlocks.EMERALD,                      new Properties()));

    public static final Item DIAMOND_STONE_BLOCK = registerItem(                4645, "diamond_stone_block",                new ItemNameBlockItem(ModBlocks.DIAMOND,                      new Properties()));

    public static final Item ASH_WOOD = registerItem(                           5215, "ash_wood",                           new ItemNameBlockItem(ModBlocks.ASH_WOOD,                     new Properties()));

    public static final Item AEGIS_FRUIT = registerItem(                        5338, "aegis_fruit",                        new AegisFruitItem(                                           new Properties().rarity(Rarity.RARE).fireResistant(), 4, 4));

    public static final Item AMBROSIA = registerItem(                           5342, "ambrosia",                           new AmbrosiaItem(                                             new Properties().rarity(Rarity.RARE).fireResistant(), 5, 5));

    public static Item registerItem(long terrariaItemID, String key, Item item) {
        if (IDE) LOGGER.info("Registered {}, ID: {}, Item: {}", key, terrariaItemID, item);
        return registerItem(ResourceLocationHelper.parse(key), item);
    }
    public static void init() {
        if (IDE) LOGGER.info("Initializing Mod Items...");
    }
}
