package esoij.terrariamod.world.level.block;

import esoij.terrariamod.resources.ResourceLocationHelper;
import esoij.terrariamod.tags.ModBlockTags;

import esoij.terrariamod.world.entity.ModEntityType;
import esoij.terrariamod.world.level.block.grower.ModTreeGrower;
import esoij.terrariamod.world.level.block.state.properties.ModBlockSetType;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.OffsetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.of;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy;

public class ModBlocks extends Blocks {
    static final double[] tallGrass = {3.0, 3.1, 3.2, 3.3, 3.4, 3.5};
    static final double[] corruptPlants = {24.0, 24.1, 24.2, 24.3, 24.4, 24.5, 24.6, 24.7, 24.9, 24.10, 24.11, 24.12, 24.13, 24.14, 24.15, 24.16, 24.17, 24.18, 24.19, 24.20, 24.21, 24.22};
    static final double[] woodenDoor = {10.0, 11.0};

    public static final Block TREE_LEAVES = register(        -1, "tree_leaves", leaves(ModSoundType.GRASS, 0));
    public static final Block GLOWING_MUSHROOM_TREE_LEAVES = register(-1, "glowing_mushroom_tree_leaves", leaves(ModSoundType.DIG, 8));
    public static final Block TERRARIA_CRAFTER = register(   -1, "terraria_crafter", new TerrariaCrafterBlock(of()));
    public static final Block PALM_TREE_LEAVES = register(   -1, "palm_tree_leaves", leaves(ModSoundType.GRASS, 0));
    public static final Block JUNGLE_TREE_LEAVES = register( -1, "jungle_tree_leaves", leaves(ModSoundType.GRASS, 0));
    public static final Block BOREAL_TREE_LEAVES = register( -1, "boreal_tree_leaves", leaves(ModSoundType.GRASS, 0));
    public static final Block TREE_ASH_LEAVES = register(    -1, "tree_ash_leaves", leaves(ModSoundType.GRASS, 0));
    public static final Block DIRT = register(               0.0, "dirt", new Block(of().mapColor(MapColor.DIRT).strength(0.5F).sound(ModSoundType.DIG)));
    public static final Block STONE = register(              1.0, "stone", new Block(of().mapColor(MapColor.STONE).strength(1.5F, 6.0F).sound(ModSoundType.TINK).requiresCorrectToolForDrops()));
    public static final Block GRASS = register(              2.0, "grass", new TerrariaGrassBlock(ModBlockTags.GRASS_CAN_SPREAD_TO, of().mapColor(MapColor.GRASS).randomTicks().strength(0.6F).sound(ModSoundType.DIG)));
    public static final Block BEACH_GRASS = register(        2.1, "beach_grass", new TerrariaGrassBlock(ModBlockTags.GRASS_CAN_SPREAD_TO, of().mapColor(MapColor.GRASS).randomTicks().strength(0.6F).sound(ModSoundType.DIG)));
    public static final Block TALL_GRASS = register(         tallGrass, "tall_grass", new TerrariaTallGrassBlock(of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(ModSoundType.GRASS).offsetType(OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));

    public static final Block MUSHROOM = register(           3.8, "mushroom", new TerrariaTallGrassBlock(ofFullCopy(TALL_GRASS)));

    public static final Block TORCH = register(              4.0, "torch", new TerrariaTorchBlock(of().noCollission().instabreak().lightLevel(blockStatex -> blockStatex.hasProperty(TerrariaTorchBlock.LIT) ? 15 : 0).sound(ModSoundType.DIG).pushReaction(PushReaction.DESTROY)));

    public static final Block TREE_LOG = register(           5.0, "tree_log", log(MapColor.WOOD, MapColor.WOOD, 0));

    public static final Block JUNGLE_TREE_LOG = register(    5.2, "jungle_tree_log", log(MapColor.WOOD, MapColor.WOOD, 0));

    public static final Block BOREAL_TREE_LOG = register(    5.4, "boreal_tree_log", log(MapColor.WOOD, MapColor.WOOD, 0));

    public static final Block GLOWING_MUSHROOM_TREE_LOG = register(5.7, "glowing_mushroom_tree_log", log(MapColor.COLOR_BLUE, MapColor.COLOR_BLUE, 8));

    public static final Block IRON = register(               6.0, "iron", new Block(of().mapColor(MapColor.RAW_IRON).requiresCorrectToolForDrops().strength(3.0F).sound(ModSoundType.TINK)));
    public static final Block COPPER = register(             7.0, "copper", new Block(of().mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(3.0F).sound(ModSoundType.TINK)));
    public static final Block GOLD = register(               8.0, "gold", new Block(of().mapColor(MapColor.GOLD).requiresCorrectToolForDrops().strength(3.0F).sound(ModSoundType.TINK)));
    public static final Block SILVER = register(             9.0, "silver", new Block(of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.0F).sound(ModSoundType.TINK)));
    public static final Block WOODEN_DOOR = register(        woodenDoor, "wooden_door", new DoorBlock(ModBlockSetType.WOOD, of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(ModSoundType.DIG).ignitedByLava()));

    public static final Block BOTTLE = register(             13.0, "bottle", new Block(of().strength(1).sound(ModSoundType.GLASS)));

    public static final Block FURNACE = register(            17.0, "furnace", new Block(of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3.0F).sound(ModSoundType.DIG)));
    public static final Block WORK_BENCH = register(         18.0, "work_bench", new Block(of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(ModSoundType.WOOD).ignitedByLava()));

    public static final Block FOREST_SAPLING = register(     20.0, "forest_sapling", new TerrariaSaplingBlock(ModTreeGrower.FOREST, of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(ModSoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final Block BOREAL_SAPLING = register(     20.1, "boreal_sapling", new TerrariaSaplingBlock(ModTreeGrower.BOREAL, ofFullCopy(FOREST_SAPLING)));

    public static final Block CHEST = register(              21.0, "chest", new TerrariaChestBlock(of().strength(2.5F).sound(ModSoundType.DIG)));
    public static final Block GOLD_CHEST = register(         21.1, "gold_chest", new TerrariaChestBlock(of().strength(2.5F).sound(ModSoundType.DIG)));
    public static final Block LOCKED_GOLD_CHEST = register(  21.2, "locked_gold_chest", new LockedChestBlock(of().strength(2.5F).sound(ModSoundType.DIG)));

    public static final Block DEMONITE = register(           22.0, "demonite", new Block(of().mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops().strength(3.0F).sound(ModSoundType.TINK).lightLevel(blockStatex -> 1)));
    public static final Block CORRUPT_GRASS = register(      23.0, "corrupt_grass", new CorruptSpreadingGrassBlock(of().mapColor(MapColor.COLOR_PURPLE).randomTicks().strength(0.6F).sound(ModSoundType.DIG)));
    public static final Block CORRUPT_PLANTS = register(     corruptPlants, "corrupt_plants", new CorruptSpreadingTallGrassBlock(of().mapColor(MapColor.COLOR_PURPLE).replaceable().noCollission().instabreak().sound(ModSoundType.GRASS).offsetType(OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final Block VILE_MUSHROOM = register(      24.8, "vile_mushroom", new CorruptSpreadingTallGrassBlock(ofFullCopy(CORRUPT_PLANTS)));

    public static final Block EBONSTONE = register(          25.0, "ebonstone", new CorruptSpreadingBlock(of().mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops().strength(3.0F, 12.0F).sound(ModSoundType.TINK).randomTicks()));

    public static final Block WOOD_BLOCK = register(         30.0, "wood_block", new Block(of().mapColor(MapColor.WOOD).strength(2.0F, 3.0F).sound(ModSoundType.DIG)));

    public static final Block METEORITE = register(          37.0, "meteorite", new Block(of().mapColor(MapColor.NETHER).requiresCorrectToolForDrops().lightLevel(blockStatex -> 3).strength(1.4F).isValidSpawn((blockStatex, blockGetter, blockPos, entityType) -> entityType.fireImmune()).hasPostProcess(Blocks::always).emissiveRendering(Blocks::always)));
    public static final Block GRAY_BRICK = register(         38.0, "gray_brick", new Block(of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(ModSoundType.DIG)));
    public static final Block RED_BRICK = register(          39.0, "red_brick", new Block(of().mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(ModSoundType.DIG)));
    public static final Block CLAY_BLOCK = register(         40.0, "clay_block", new Block(of().mapColor(MapColor.COLOR_RED).strength(0.6F).sound(ModSoundType.DIG)));
    public static final Block BLUE_DUNGEON_BRICK = register( 41.0, "blue_dungeon_brick", new Block(of().mapColor(MapColor.COLOR_BLUE).strength(4.0F, 16.0F).sound(ModSoundType.TINK).requiresCorrectToolForDrops()));

    public static final Block GREEN_DUNGEON_BRICK = register(43.0, "green_dungeon_brick", new Block(of().mapColor(MapColor.COLOR_GREEN).strength(4.0F, 16.0F).sound(ModSoundType.TINK).requiresCorrectToolForDrops()));
    public static final Block PINK_DUNGEON_BRICK = register( 44.0, "pink_dungeon_brick", new Block(of().mapColor(MapColor.COLOR_PINK).strength(4.0F, 16.0F).sound(ModSoundType.TINK).requiresCorrectToolForDrops()));
    public static final Block GOLD_BRICK = register(         45.0, "gold_brick", new Block(of().mapColor(MapColor.GOLD).strength(3.0F, 6.0F).sound(ModSoundType.TINK).requiresCorrectToolForDrops()));
    public static final Block SILVER_BRICK = register(       46.0, "silver_brick", new Block(of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ModSoundType.TINK)));
    public static final Block COPPER_BRICK = register(       47.0, "copper_brick", new Block(of().mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ModSoundType.TINK)));
    public static final Block SPIKES = register(             48.0, "spikes", new SpikesBlock(of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ModSoundType.TINK)));

    public static final Block SAND = register(               53.0, "sand", new ColoredFallingBlock(new ColorRGBA(0xbaa854), of().mapColor(MapColor.SAND).sound(ModSoundType.DIG).strength(0.5F)));

    public static final Block ASH = register(                57.0, "ash", new Block(of().mapColor(MapColor.COLOR_GRAY).sound(ModSoundType.DIG).strength(0.5F)));
    public static final Block HELLSTONE = register(          58.0, "hellstone", new HellstoneBlock(of().mapColor(MapColor.COLOR_ORANGE).sound(ModSoundType.TINK).strength(2.0F).requiresCorrectToolForDrops()));
    public static final Block MUD = register(                59.0, "mud", new Block(of().mapColor(MapColor.TERRACOTTA_CYAN).sound(ModSoundType.DIG).strength(0.5F)));
    public static final Block JUNGLE_GRASS = register(       60.0, "jungle_grass", new TerrariaGrassBlock(ModBlockTags.JUNGLE_GRASS_CAN_SPREAD_TO, of().mapColor(MapColor.GRASS).randomTicks().sound(ModSoundType.DIG).strength(0.6F)));

    public static final Block EMERALD = register(            65.0, "emerald", new Block(ofFullCopy(STONE)));

    public static final Block AMETHYST = register(           67.0, "amethyst", new Block(ofFullCopy(STONE)));
    public static final Block DIAMOND = register(            68.0, "diamond", new Block(ofFullCopy(STONE)));

    public static final Block MUSHROOM_GRASS = register(     70.0, "mushroom_grass", new MushroomSpreadingGrassBlock(of().mapColor(MapColor.COLOR_BLUE).randomTicks().strength(0.6F).sound(ModSoundType.DIG).lightLevel(blockStatex -> 8)));
    public static final Block MUSHROOM_PLANTS = register(    71.0, "mushroom_plants", new TerrariaTallGrassBlock(ofFullCopy(TALL_GRASS).lightLevel(blockStatex -> 8).mapColor(MapColor.COLOR_BLUE)));

    public static final Block BLUE_SLIME_BANNER = register(  91.90, "blue_slime_banner", new TerrariaBannerBlock(ModEntityType.BLUE_SLIME, of().forceSolidOn().noCollission()));

    public static final Block DUNGEON_SLIME_BANNER = register(91.128, "dungeon_slime_banner", new TerrariaBannerBlock(ModEntityType.DUNGEON_SLIME, of().forceSolidOn().noCollission()));

    public static final Block GREEN_SLIME_BANNER = register( 91.140, "green_slime_banner", new TerrariaBannerBlock(ModEntityType.GREEN_SLIME, of().forceSolidOn().noCollission()));

    public static final Block PINKY_BANNER = register(       91.172, "pinky_banner", new TerrariaBannerBlock(ModEntityType.PINKY, of().forceSolidOn().noCollission()));

    public static final Block ANGRY_BONES_BANNER = register( 91.268, "angry_bones_banner", new TerrariaBannerBlock(ModEntityType.ANGRY_BONES, of().forceSolidOn().noCollission()));

    public static final Block SILT = register(               123.0, "silt", new ColoredFallingBlock(new ColorRGBA(0x595353), of().mapColor(MapColor.STONE).sound(ModSoundType.DIG).strength(0.6F)));

    public static final Block SNOW_BLOCK = register(         147.0, "snow_block", new Block(of().mapColor(MapColor.SNOW).sound(ModSoundType.SNOW).strength(0.2F)));

    public static final Block RED_STUCCO = register(         153.0, "red_stucco", new Block(of().mapColor(MapColor.TERRACOTTA_RED).sound(ModSoundType.TINK).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final Block YELLOW_STUCCO = register(      154.0, "yellow_stucco", new Block(of().mapColor(MapColor.TERRACOTTA_YELLOW).sound(ModSoundType.TINK).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));

    public static final Block GRAY_STUCCO = register(        156.0, "gray_stucco", new Block(of().mapColor(MapColor.TERRACOTTA_WHITE).sound(ModSoundType.TINK).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));

    public static final Block RICH_MAHOGANY = register(      158.0, "rich_mahogany", new Block(ofFullCopy(WOOD_BLOCK)));

    public static final Block ICE_BLOCK = register(          161.0, "ice_block", new Block(of().mapColor(MapColor.ICE).friction(0.98F).randomTicks().strength(0.5F).sound(ModSoundType.ICE).isValidSpawn((blockStatex, blockGetter, blockPos, entityType) -> entityType == EntityType.POLAR_BEAR)));

    public static final Block AMETHYST_GEM = register(       178.0, "amethyst_gem", new AmethystClusterBlock(7.0F, 3.0F, ofFullCopy(AMETHYST_CLUSTER).sound(ModSoundType.DIG)));

    public static final Block EMERALD_GEM = register(        178.3, "emerald_gem", new AmethystClusterBlock(7.0F, 3.0F, ofFullCopy(AMETHYST_GEM)));

    public static final Block DIAMOND_GEM = register(        178.5, "diamond_gem", new AmethystClusterBlock(7.0F, 3.0F, ofFullCopy(AMETHYST_GEM)));

    public static final Block MUSHROOM_BLOCK = register(     190.0, "mushroom_block", new Block(of().mapColor(MapColor.COLOR_BLUE).strength(1.0F).sound(ModSoundType.DIG).lightLevel(blockStatex -> 8)));

    public static final Block SLUSH = register(              224.0, "slush", new ColoredFallingBlock(new ColorRGBA(0x9eb8bd), of().mapColor(MapColor.SNOW).sound(ModSoundType.SNOW).strength(0.6F)));

    public static final Block CRIMSAND = register(           234.0, "crimsand", new CrimsonSpreadingColoredFallingBlock(of().mapColor(MapColor.TERRACOTTA_CYAN).sound(ModSoundType.DIG).strength(0.5F)));

    public static final Block COPPER_BAR = register(         239.0, "copper_bar", new Block(ofFullCopy(COPPER_BRICK).sound(ModSoundType.DIG)));

    public static final Block IRON_BAR = register(           239.2, "iron_bar", new Block(ofFullCopy(IRON).sound(ModSoundType.DIG)));

    public static final Block SILVER_BAR = register(         239.4, "silver_bar", new Block(ofFullCopy(SILVER_BRICK).sound(ModSoundType.DIG)));

    public static final Block GOLD_BAR = register(           239.6, "gold_bar", new Block(ofFullCopy(GOLD_BRICK).sound(ModSoundType.DIG)));

    public static final Block BOREAL_WOOD = register(        321.0, "boreal_wood", new Block(ofFullCopy(WOOD_BLOCK)));
    public static final Block PALM_WOOD = register(          322.0, "palm_wood", new Block(ofFullCopy(WOOD_BLOCK)));
    public static final Block PALM_TREE_LOG = register(      323.0, "palm_tree_log", log(MapColor.WOOD, MapColor.WOOD, 0));

    public static final Block COPPER_COIN_PILE = register(   330.0, "copper_coin_pile", new ColoredFallingBlock(new ColorRGBA(0xe2764c), ofFullCopy(COPPER_BAR)));
    public static final Block SILVER_COIN_PILE = register(   331.0, "silver_coin_pile", new ColoredFallingBlock(new ColorRGBA(0xe2764c), ofFullCopy(SILVER_BAR)));
    public static final Block GOLD_COIN_PILE = register(     332.0, "gold_coin_pile", new ColoredFallingBlock(new ColorRGBA(0xe2764c), ofFullCopy(GOLD_BAR)));

    public static final Block MARBLE = register(             367.0, "marble", new Block(ofFullCopy(STONE)));
    public static final Block GRANITE = register(            368.0, "granite", new Block(ofFullCopy(STONE)));

    public static final Block PINK_SLIME_BLOCK = register(   371.0, "pink_slime_block", new SlimeBlock(of().sound(ModSoundType.DIG)));

    public static final Block SANDSTONE = register(          396.0, "sandstone", new Block(of().mapColor(MapColor.SAND).requiresCorrectToolForDrops().strength(0.8F).sound(ModSoundType.DIG)));

    public static final Block CRIMSON_SANDSTONE = register(  401.0, "crimson_sandstone", new CrimsonSpreadingBlock(of().mapColor(MapColor.TERRACOTTA_CYAN).requiresCorrectToolForDrops().strength(1.0F).sound(ModSoundType.DIG)));

    public static final Block ASH_GRASS = register(          633.0, "ash_grass", new TerrariaGrassBlock(ModBlockTags.ASH_GRASS_CAN_SPREAD_TO, ofFullCopy(GRASS).mapColor(MapColor.COLOR_ORANGE)));
    public static final Block TREE_ASH_LOG = register(       634.0, "tree_ash_log", log(MapColor.COLOR_GRAY, MapColor.COLOR_GRAY));
    public static final Block ASH_WOOD = register(           635.0, "ash_wood", new Block(ofFullCopy(WOOD_BLOCK)));
    public static Block leaves(SoundType soundType, int lightLevel) {
        return new LeavesBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.PLANT)
                        .strength(0.2F)
                        .randomTicks()
                        .sound(soundType)
                        .noOcclusion()
                        .isValidSpawn(Blocks::ocelotOrParrot)
                        .isSuffocating(Blocks::never)
                        .isViewBlocking(Blocks::never)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
                        .isRedstoneConductor(Blocks::never).lightLevel(blockStatex -> lightLevel)
        );
    }
    public static Block log(MapColor topMapColor, MapColor sideMapColor, int lightLevel) {
        return new RotatedPillarBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(blockState -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sound(ModSoundType.DIG)
                        .ignitedByLava().lightLevel(blockStatex -> lightLevel)
        );
    }
    public static Block register(double terrariaTileID, String key, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocationHelper.parse(key), block);
    }
    public static Block register(double[] terrariaTileID, String key, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocationHelper.parse(key), block);
    }
}
