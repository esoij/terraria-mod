package esoij.terrariamod.world.item;

import esoij.terrariamod.resources.ResourceLocationHelper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;

import static esoij.terrariamod.world.item.ModItems.*;

public class ModCreativeModeTabs extends CreativeModeTabs {
    public static final ResourceKey<CreativeModeTab> WEAPONS = createKey("weapons");
    public static final ResourceKey<CreativeModeTab> ARMOR = createKey("armor");
    public static final ResourceKey<CreativeModeTab> VANITY = createKey("vanity");
    public static final ResourceKey<CreativeModeTab> BLOCKS = createKey("blocks");
    public static final ResourceKey<CreativeModeTab> FURNITURE = createKey("furniture");
    public static final ResourceKey<CreativeModeTab> ACCESSORIES = createKey("accessories");
    public static final ResourceKey<CreativeModeTab> EQUIPMENT = createKey("equipment");
    public static final ResourceKey<CreativeModeTab> CONSUMABLES = createKey("consumables");
    public static final ResourceKey<CreativeModeTab> TOOLS = createKey("tools");
    public static final ResourceKey<CreativeModeTab> MATERIALS = createKey("materials");
    public static final ResourceKey<CreativeModeTab> MISC = createKey("misc");
    public static final ResourceKey<CreativeModeTab> NONVANILLA = createKey("nonvanilla");
    private static ResourceKey<CreativeModeTab> createKey(String name) {
        return ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocationHelper.parse(name));
    }
    public static void init() {
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                WEAPONS,
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.weapons"))
                        .icon(() -> new ItemStack(ModItems.WEAPONS))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(GOLD_COIN);
                            output.accept(SILVER_COIN);
                            output.accept(COPPER_COIN);
                            output.accept(IRON_PICKAXE);
                            output.accept(IRON_AXE);
                            output.accept(IRON_HAMMER);
                            output.accept(FIERY_GREATSWORD);
                            output.accept(IRON_BROADSWORD);
                            output.accept(IRON_SHORTSWORD);
                            output.accept(WOODEN_SWORD);
                        }).build());
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                ARMOR,
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.armor"))
                        .icon(() -> new ItemStack(ModItems.ARMOR))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(COPPER_HELMET);
                            output.accept(COPPER_CHAINMAIL);
                            output.accept(COPPER_GREAVES);
                        }).build());
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                VANITY,
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.vanity"))
                        .icon(() -> new ItemStack(ModItems.VANITY))
                        .displayItems((itemDisplayParameters, output) -> {
                        }).build());
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                BLOCKS,
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.blocks"))
                        .icon(() -> new ItemStack(ModItems.BLOCKS))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(GOLD_COIN);
                            output.accept(SILVER_COIN);
                            output.accept(COPPER_COIN);
                            output.accept(WOOD);
                            output.accept(ASH_WOOD);
                            output.accept(BOREAL_WOOD);
                            output.accept(PALM_WOOD);
                            output.accept(RICH_MAHOGANY);
                            output.accept(DIRT_BLOCK);
                            output.accept(STONE_BLOCK);
                            output.accept(CLAY_BLOCK);
                            output.accept(SILT_BLOCK);
                            output.accept(SLUSH_BLOCK);
                            output.accept(SAND_BLOCK);
                            output.accept(MUD_BLOCK);
                            output.accept(AMETHYST_STONE_BLOCK);
                            output.accept(ASH_BLOCK);
                            output.accept(BLUE_BRICK);
                            output.accept(COPPER_BRICK);
                            output.accept(COPPER_ORE);
                            output.accept(CRIMSAND_BLOCK);
                            output.accept(CRIMSON_SANDSTONE);
                            output.accept(DEMONITE_ORE);
                            output.accept(DIAMOND_STONE_BLOCK);
                            output.accept(EBONSTONE_BLOCK);
                            output.accept(EMERALD_STONE_BLOCK);
                            output.accept(GLOWING_MUSHROOM);
                            output.accept(GOLD_BRICK);
                            output.accept(GOLD_ORE);
                            output.accept(GRANITE);
                            output.accept(GRAY_BRICK);
                            output.accept(GRAY_STUCCO);
                            output.accept(GREEN_BRICK);
                            output.accept(HELLSTONE);
                            output.accept(ICE_BLOCK);
                            output.accept(IRON_ORE);
                            output.accept(MARBLE);
                            output.accept(METEORITE);
                            output.accept(PINK_BRICK);
                            output.accept(PINK_SLIME_BLOCK);
                            output.accept(RED_BRICK);
                            output.accept(RED_STUCCO);
                            output.accept(SANDSTONE);
                            output.accept(SILVER_BRICK);
                            output.accept(SILVER_ORE);
                            output.accept(SNOW_BLOCK);
                            output.accept(SPIKE);
                            output.accept(YELLOW_STUCCO);
                        }).build());
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                FURNITURE,
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.furniture"))
                        .icon(() -> new ItemStack(ModItems.FURNITURE))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(TORCH);
                            output.accept(AMETHYST);
                            output.accept(DIAMOND);
                            output.accept(EMERALD);
                            output.accept(COPPER_BAR);
                            output.accept(GOLD_BAR);
                            output.accept(IRON_BAR);
                            output.accept(SILVER_BAR);
                            output.accept(ACORN);
                            output.accept(WORK_BENCH);
                            output.accept(WOODEN_DOOR);
                            output.accept(CHEST);
                            output.accept(GOLD_CHEST);
                            output.accept(FLOWER_PACKET_TALL_GRASS);
                            output.accept(BOTTLE);
                            output.accept(ANGRY_BONES_BANNER);
                            output.accept(SLIME_BANNER);
                            output.accept(DUNGEON_SLIME_BANNER);
                            output.accept(GREEN_SLIME_BANNER);
                            output.accept(PINKY_BANNER);
                        }).build());
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                ACCESSORIES,
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.accessories"))
                        .icon(() -> new ItemStack(ModItems.ACCESSORIES))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(DEPTH_METER);
                            output.accept(GOLD_WATCH);
                            output.accept(COPPER_WATCH);
                            output.accept(SILVER_WATCH);
                        }).build());
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                EQUIPMENT,
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.equipment"))
                        .icon(() -> new ItemStack(ModItems.EQUIPMENT))
                        .displayItems((itemDisplayParameters, output) -> {
                        }).build());
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                CONSUMABLES,
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.consumables"))
                        .icon(() -> new ItemStack(ModItems.CONSUMABLES))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(SUPER_HEALING_POTION);
                            output.accept(GREATER_HEALING_POTION);
                            output.accept(HEALING_POTION);
                            output.accept(LESSER_HEALING_POTION);
                            output.accept(MUSHROOM);
                            output.accept(FEATHERFALL_POTION);
                            output.accept(GILLS_POTION);
                            output.accept(IRONSKIN_POTION);
                            output.accept(OBSIDIAN_SKIN_POTION);
                            output.accept(REGENERATION_POTION);
                            output.accept(SWIFTNESS_POTION);
                            output.accept(AEGIS_FRUIT);
                            output.accept(AMBROSIA);
                            output.accept(FALLEN_STAR);
                            output.accept(GEL);
                            output.accept(LIFE_CRYSTAL);
                            output.accept(LIFE_FRUIT);
                        }).build());
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                TOOLS,
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.toools"))
                        .icon(() -> new ItemStack(ModItems.TOOLS))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(IRON_PICKAXE);
                            output.accept(IRON_AXE);
                            output.accept(IRON_HAMMER);
                        }).build());
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                MATERIALS,
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.materials"))
                        .icon(() -> new ItemStack(ModItems.MATERIALS))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(TORCH);
                            output.accept(WOOD);
                            output.accept(ASH_WOOD);
                            output.accept(BOREAL_WOOD);
                            output.accept(PALM_WOOD);
                            output.accept(RICH_MAHOGANY);
                            output.accept(GREATER_HEALING_POTION);
                            output.accept(LESSER_HEALING_POTION);
                            output.accept(MUSHROOM);
                            output.accept(FALLEN_STAR);
                            output.accept(GEL);
                            output.accept(LIFE_CRYSTAL);
                            output.accept(AMETHYST);
                            output.accept(DIAMOND);
                            output.accept(EMERALD);
                            output.accept(COPPER_BAR);
                            output.accept(GOLD_BAR);
                            output.accept(IRON_BAR);
                            output.accept(SILVER_BAR);
                            output.accept(ACORN);
                            output.accept(CHEST);
                            output.accept(GOLD_CHEST);
                            output.accept(BOTTLE);
                            output.accept(DIRT_BLOCK);
                            output.accept(STONE_BLOCK);
                            output.accept(CLAY_BLOCK);
                            output.accept(SILT_BLOCK);
                            output.accept(SAND_BLOCK);
                            output.accept(MUD_BLOCK);
                            output.accept(AMETHYST_STONE_BLOCK);
                            output.accept(ASH_BLOCK);
                            output.accept(BLUE_BRICK);
                            output.accept(COPPER_BRICK);
                            output.accept(COPPER_ORE);
                            output.accept(CRIMSAND_BLOCK);
                            output.accept(CRIMSON_SANDSTONE);
                            output.accept(DEMONITE_ORE);
                            output.accept(DIAMOND_STONE_BLOCK);
                            output.accept(EBONSTONE_BLOCK);
                            output.accept(EMERALD_STONE_BLOCK);
                            output.accept(GLOWING_MUSHROOM);
                            output.accept(GOLD_BRICK);
                            output.accept(GOLD_ORE);
                            output.accept(GRANITE);
                            output.accept(GRAY_BRICK);
                            output.accept(GRAY_STUCCO);
                            output.accept(GREEN_BRICK);
                            output.accept(HELLSTONE);
                            output.accept(ICE_BLOCK);
                            output.accept(IRON_ORE);
                            output.accept(MARBLE);
                            output.accept(METEORITE);
                            output.accept(PINK_BRICK);
                            output.accept(RED_BRICK);
                            output.accept(RED_STUCCO);
                            output.accept(SANDSTONE);
                            output.accept(SILVER_BRICK);
                            output.accept(SILVER_ORE);
                            output.accept(SNOW_BLOCK);
                            output.accept(YELLOW_STUCCO);
                            output.accept(FIERY_GREATSWORD);
                            output.accept(DEPTH_METER);
                            output.accept(GOLD_WATCH);
                            output.accept(COPPER_WATCH);
                            output.accept(SILVER_WATCH);
                            output.accept(PINK_GEL);
                            output.accept(VILE_MUSHROOM);
                        }).build());
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                MISC,
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.misc"))
                        .icon(() -> new ItemStack(ModItems.MISC))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(GOLDEN_KEY);
                        }).build());
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                NONVANILLA,
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.nonvanilla"))
                        .icon(() -> new ItemStack(GRASS_BLOCK))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(ModItems.WEAPONS);
                            output.accept(ModItems.ARMOR);
                            output.accept(ModItems.VANITY);
                            output.accept(ModItems.BLOCKS);
                            output.accept(ModItems.FURNITURE);
                            output.accept(ModItems.ACCESSORIES);
                            output.accept(ModItems.EQUIPMENT);
                            output.accept(ModItems.CONSUMABLES);
                            output.accept(ModItems.TOOLS);
                            output.accept(ModItems.MATERIALS);
                            output.accept(ModItems.MISC);
                            output.accept(ModItems.COLLECTOR);
                            output.accept(ModItems.TIMBER);
                            output.accept(ModItems.OBTAIN_HAMMER);
                            output.accept(GRASS_BLOCK);
                            output.accept(BEACH_GRASS_BLOCK);
                            output.accept(CORRUPT_GRASS_BLOCK);
                            output.accept(JUNGLE_GRASS_BLOCK);
                            output.accept(CORRUPT_PLANTS_BLOCK);
                            output.accept(MUSHROOM_GRASS_BLOCK);
                            output.accept(TREE_LOG_BLOCK);
                            output.accept(TREE_LEAVES_BLOCK);
                            output.accept(GLOWING_MUSHROOM_TREE_LOG_BLOCK);
                            output.accept(GLOWING_MUSHROOM_TREE_LEAVES_BLOCK);
                            output.accept(MUSHROOM_PLANTS_BLOCK);
                            output.accept(PALM_TREE_LOG_BLOCK);
                            output.accept(PALM_TREE_LEAVES_BLOCK);
                            output.accept(JUNGLE_TREE_LOG_BLOCK);
                            output.accept(JUNGLE_TREE_LEAVES_BLOCK);
                            output.accept(BOREAL_TREE_LOG_BLOCK);
                            output.accept(BOREAL_TREE_LEAVES_BLOCK);
                            output.accept(ASH_GRASS_BLOCK);
                            output.accept(TREE_ASH_LOG_BLOCK);
                            output.accept(TREE_ASH_LEAVES_BLOCK);
                            output.accept(BLUE_SLIME_SPAWN_EGG);
                            output.accept(GREEN_SLIME_SPAWN_EGG);
                            output.accept(COPPER_LEGGINGS);
                            output.accept(DUNGEON_SLIME_SPAWN_EGG);
                            output.accept(PINKY_SPAWN_EGG);
                            output.accept(ANGRY_BONES_SPAWN_EGG);
                            output.accept(LOCKED_GOLD_CHEST);
                        }).build());
    }
}
