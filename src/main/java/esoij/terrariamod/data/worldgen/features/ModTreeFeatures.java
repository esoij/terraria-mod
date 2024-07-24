package esoij.terrariamod.data.worldgen.features;

import com.google.common.collect.ImmutableList;
import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.OptionalInt;

public class ModTreeFeatures extends TreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BOREAL = ModFeatureUtils.createKey("boreal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_BOREAL = ModFeatureUtils.createKey("fancy_boreal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_FOREST = ModFeatureUtils.createKey("fancy_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_OCEAN = ModFeatureUtils.createKey("fancy_ocean");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOREST = ModFeatureUtils.createKey("forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_GLOWING_MUSHROOM = ModFeatureUtils.createKey("huge_glowing_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_TREE = ModFeatureUtils.createKey("jungle_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_BOREAL = ModFeatureUtils.createKey("mega_boreal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_FANCY_BOREAL = ModFeatureUtils.createKey("mega_fancy_boreal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_JUNGLE_TREE = ModFeatureUtils.createKey("mega_jungle_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OCEAN = ModFeatureUtils.createKey("ocean");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_ASH = ModFeatureUtils.createKey("tree_ash");
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        ModFeatureUtils.register(context, BOREAL,                Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.BOREAL_TREE_LOG),           new StraightTrunkPlacer(5, 2, 1),                       BlockStateProvider.simple(ModBlocks.BOREAL_TREE_LEAVES),           new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)),             new TwoLayersFeatureSize(2, 0, 2))                         .ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.SNOW_BLOCK)).build());
        ModFeatureUtils.register(context, FANCY_BOREAL,          Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.BOREAL_TREE_LOG),           new StraightTrunkPlacer(6, 4, 0),                       BlockStateProvider.simple(ModBlocks.BOREAL_TREE_LEAVES),           new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)),        new TwoLayersFeatureSize(2, 0, 2))                        .ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.SNOW_BLOCK)).build());
        ModFeatureUtils.register(context, FANCY_FOREST,          Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.TREE_LOG),                  new FancyTrunkPlacer(3, 11, 0),  BlockStateProvider.simple(ModBlocks.TREE_LEAVES),                  new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),                      new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.GRASS)).build());
        ModFeatureUtils.register(context, FANCY_OCEAN,           Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.PALM_TREE_LOG),             new FancyTrunkPlacer(3, 11, 0),  BlockStateProvider.simple(ModBlocks.PALM_TREE_LEAVES),             new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),                      new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.SAND)).build());
        ModFeatureUtils.register(context, FOREST,                Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.TREE_LOG),                  new StraightTrunkPlacer(6, 8, 0),                       BlockStateProvider.simple(ModBlocks.TREE_LEAVES),                  new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),                   new TwoLayersFeatureSize(1, 0, 1))                         .ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.GRASS)).build());
        ModFeatureUtils.register(context, HUGE_GLOWING_MUSHROOM, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.GLOWING_MUSHROOM_TREE_LOG), new StraightTrunkPlacer(6, 8, 0),                       BlockStateProvider.simple(ModBlocks.GLOWING_MUSHROOM_TREE_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),                   new TwoLayersFeatureSize(1, 0, 1))                         .ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.MUSHROOM_GRASS)).build());
        ModFeatureUtils.register(context, JUNGLE_TREE,           Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.JUNGLE_TREE_LOG),           new StraightTrunkPlacer(4, 8, 0),                       BlockStateProvider.simple(ModBlocks.JUNGLE_TREE_LEAVES),           new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),                   new TwoLayersFeatureSize(1, 0, 1))                         .ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.JUNGLE_GRASS)).build());
        ModFeatureUtils.register(context, MEGA_BOREAL,           Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.BOREAL_TREE_LOG),           new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(ModBlocks.BOREAL_TREE_LEAVES),           new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2))                         .ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.SNOW_BLOCK)).build());
        ModFeatureUtils.register(context, MEGA_FANCY_BOREAL,     Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.BOREAL_TREE_LOG),           new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(ModBlocks.BOREAL_TREE_LEAVES),           new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(3, 7)),   new TwoLayersFeatureSize(1, 1, 2))                         .ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.SNOW_BLOCK)).build());
        ModFeatureUtils.register(context, MEGA_JUNGLE_TREE,      Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.JUNGLE_TREE_LOG),           new MegaJungleTrunkPlacer(10, 2, 19),                   BlockStateProvider.simple(ModBlocks.JUNGLE_TREE_LEAVES),           new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),             new TwoLayersFeatureSize(1, 1, 2))                         .ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.JUNGLE_GRASS)).build());
        ModFeatureUtils.register(context, OCEAN,                 Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.PALM_TREE_LOG),             new StraightTrunkPlacer(6, 8, 0),                       BlockStateProvider.simple(ModBlocks.PALM_TREE_LEAVES),             new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),                   new TwoLayersFeatureSize(1, 0, 1))                         .ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.SAND)).build());
        ModFeatureUtils.register(context, TREE_ASH,              Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.TREE_ASH_LOG),              new StraightTrunkPlacer(6, 8, 0),                       BlockStateProvider.simple(ModBlocks.TREE_ASH_LEAVES),              new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),                   new TwoLayersFeatureSize(1, 0, 1))                         .ignoreVines().dirt(BlockStateProvider.simple(ModBlocks.ASH_GRASS)).build());
    }
}
