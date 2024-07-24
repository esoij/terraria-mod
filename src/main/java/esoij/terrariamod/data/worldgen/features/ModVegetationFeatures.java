package esoij.terrariamod.data.worldgen.features;

import esoij.terrariamod.data.worldgen.placement.ModPlacementUtils;
import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomBooleanFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ModVegetationFeatures extends VegetationFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BAMBOO_NO_PODZOL = ModFeatureUtils.createKey("bamboo_no_podzol");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWING_MUSHROOM_VEGETATION = ModFeatureUtils.createKey("glowing_mushroom_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GLOWING_MUSHROOM = ModFeatureUtils.createKey("patch_glowing_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GRASS = ModFeatureUtils.createKey("patch_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_FOREST = ModFeatureUtils.createKey("trees_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_JUNGLE = ModFeatureUtils.createKey("trees_jungle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_OCEAN = ModFeatureUtils.createKey("trees_ocean");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SPARSE_FOREST = ModFeatureUtils.createKey("trees_sparse_forest");
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> holder = holderGetter.getOrThrow(ModTreeFeatures.HUGE_GLOWING_MUSHROOM);
        Holder<ConfiguredFeature<?, ?>> holder2 = holderGetter.getOrThrow(ModTreeFeatures.HUGE_GLOWING_MUSHROOM);
        Holder<ConfiguredFeature<?, ?>> holder3 = holderGetter.getOrThrow(ModTreeFeatures.FANCY_FOREST);
        Holder<ConfiguredFeature<?, ?>> holder4 = holderGetter.getOrThrow(ModTreeFeatures.FOREST);
        Holder<ConfiguredFeature<?, ?>> holder8 = holderGetter.getOrThrow(ModTreeFeatures.FANCY_OCEAN);
        Holder<ConfiguredFeature<?, ?>> holder22 = holderGetter.getOrThrow(ModTreeFeatures.MEGA_JUNGLE_TREE);
        Holder<ConfiguredFeature<?, ?>> holder24 = holderGetter.getOrThrow(ModTreeFeatures.OCEAN);
        Holder<ConfiguredFeature<?, ?>> holder29 = holderGetter.getOrThrow(ModTreeFeatures.JUNGLE_TREE);
        ModFeatureUtils.register(context, BAMBOO_NO_PODZOL, Feature.BAMBOO, new ProbabilityFeatureConfiguration(0.0F));
        ModFeatureUtils.register(context, GLOWING_MUSHROOM_VEGETATION, Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfiguration(PlacementUtils.inlinePlaced(holder2), PlacementUtils.inlinePlaced(holder)));
        ModFeatureUtils.register(context, PATCH_GLOWING_MUSHROOM, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MUSHROOM_PLANTS))));
        ModFeatureUtils.register(context, PATCH_GRASS, Feature.RANDOM_PATCH, FeatureUtils.simpleRandomPatchConfiguration(32, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TALL_GRASS)))));
        ModFeatureUtils.register(context, TREES_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(holder3), 0.2F)), PlacementUtils.inlinePlaced(holder4)));
        ModFeatureUtils.register(context, TREES_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(holder22), 0.33333334F)), PlacementUtils.inlinePlaced(holder29)));
        ModFeatureUtils.register(context, TREES_OCEAN, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(holder8), 0.1F)), PlacementUtils.inlinePlaced(holder24)));
        ModFeatureUtils.register(context, TREES_SPARSE_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(holder3), 0.2F)), PlacementUtils.inlinePlaced(holder4)));
    }
}
