package esoij.terrariamod.data.worldgen.placement;

import com.google.common.collect.ImmutableList;
import esoij.terrariamod.data.worldgen.features.ModTreeFeatures;
import esoij.terrariamod.data.worldgen.features.ModVegetationFeatures;
import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModVegetationPlacements extends VegetationPlacements {
    public static final ResourceKey<PlacedFeature> BAMBOO_LIGHT = ModPlacementUtils.createKey("bamboo_light");
    public static final ResourceKey<PlacedFeature> GLOWING_MUSHROOM_PLANTS = ModPlacementUtils.createKey("glowing_mushroom_plants");
    public static final ResourceKey<PlacedFeature> GLOWING_MUSHROOM_VEGETATION = ModPlacementUtils.createKey("glowing_mushroom_vegetation");
    public static final ResourceKey<PlacedFeature> PATCH_GRASS_FOREST = ModPlacementUtils.createKey("patch_grass_forest");
    public static final ResourceKey<PlacedFeature> TREES_FOREST = ModPlacementUtils.createKey("trees_forest");
    public static final ResourceKey<PlacedFeature> TREES_JUNGLE = ModPlacementUtils.createKey("trees_jungle");
    public static final ResourceKey<PlacedFeature> TREES_OCEAN = ModPlacementUtils.createKey("trees_ocean");
    public static final ResourceKey<PlacedFeature> TREES_SNOWY = ModPlacementUtils.createKey("trees_snowy");
    public static final ResourceKey<PlacedFeature> TREES_SPARSE_FOREST = ModPlacementUtils.createKey("trees_sparse_forest");
    private static List<PlacementModifier> getMushroomPlacement(int rarity, @Nullable PlacementModifier placement) {
        ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
        if (placement != null) {
            builder.add(placement);
        }

        if (rarity != 0) {
            builder.add(RarityFilter.onAverageOnceEvery(rarity));
        }

        builder.add(InSquarePlacement.spread());
        builder.add(PlacementUtils.HEIGHTMAP);
        builder.add(BiomeFilter.biome());
        return builder.build();
    }
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> holder = holderGetter.getOrThrow(ModVegetationFeatures.BAMBOO_NO_PODZOL);
        Holder<ConfiguredFeature<?, ?>> holder6 = holderGetter.getOrThrow(ModVegetationFeatures.PATCH_GRASS);
        Holder<ConfiguredFeature<?, ?>> holder19 = holderGetter.getOrThrow(ModVegetationFeatures.PATCH_GLOWING_MUSHROOM);
        Holder<ConfiguredFeature<?, ?>> holder26 = holderGetter.getOrThrow(ModVegetationFeatures.TREES_SPARSE_FOREST);
        Holder<ConfiguredFeature<?, ?>> holder34 = holderGetter.getOrThrow(ModTreeFeatures.BOREAL);
        Holder<ConfiguredFeature<?, ?>> holder41 = holderGetter.getOrThrow(ModVegetationFeatures.TREES_OCEAN);
        Holder<ConfiguredFeature<?, ?>> holder42 = holderGetter.getOrThrow(ModVegetationFeatures.TREES_FOREST);
        Holder<ConfiguredFeature<?, ?>> holder46 = holderGetter.getOrThrow(ModVegetationFeatures.TREES_JUNGLE);
        Holder<ConfiguredFeature<?, ?>> holder48 = holderGetter.getOrThrow(ModVegetationFeatures.GLOWING_MUSHROOM_VEGETATION);
        PlacementModifier placementModifier = SurfaceWaterDepthFilter.forMaxDepth(0);
        ModPlacementUtils.register(context, BAMBOO_LIGHT, holder, RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        ModPlacementUtils.register(context, GLOWING_MUSHROOM_PLANTS, holder19, getMushroomPlacement(512, null));
        ModPlacementUtils.register(context, GLOWING_MUSHROOM_VEGETATION, holder48, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        ModPlacementUtils.register(context, PATCH_GRASS_FOREST, holder6, worldSurfaceSquaredWithCount(2));
        ModPlacementUtils.register(context, TREES_FOREST, holder42, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
        ModPlacementUtils.register(context, TREES_JUNGLE, holder46, treePlacement(PlacementUtils.countExtra(50, 0.1F, 1)));
        ModPlacementUtils.register(context, TREES_OCEAN, holder41, treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
        ModPlacementUtils.register(context, TREES_SNOWY, holder34, treePlacement(PlacementUtils.countExtra(5, 0.1F, 1), ModBlocks.BOREAL_SAPLING));
        ModPlacementUtils.register(context, TREES_SPARSE_FOREST, holder26, PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), placementModifier, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(ModBlocks.FOREST_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
    }
}
