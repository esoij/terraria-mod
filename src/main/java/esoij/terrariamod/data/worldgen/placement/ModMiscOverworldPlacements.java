package esoij.terrariamod.data.worldgen.placement;

import esoij.terrariamod.data.worldgen.features.ModMiscOverworldFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.heightproviders.VeryBiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;

public class ModMiscOverworldPlacements extends MiscOverworldPlacements {
    public static final ResourceKey<PlacedFeature> DISK_CLAY = ModPlacementUtils.createKey("disk_clay");
    public static final ResourceKey<PlacedFeature> DISK_SAND = ModPlacementUtils.createKey("disk_sand");
    public static final ResourceKey<PlacedFeature> DISK_SILT = ModPlacementUtils.createKey("disk_silt");
    public static final ResourceKey<PlacedFeature> LAKE_LAVA_SURFACE = ModPlacementUtils.createKey("lake_lava_surface");
    public static final ResourceKey<PlacedFeature> LAKE_LAVA_UNDERGROUND = ModPlacementUtils.createKey("lake_lava_underground");
    public static final ResourceKey<PlacedFeature> SPRING_LAVA = ModPlacementUtils.createKey("spring_lava");
    public static final ResourceKey<PlacedFeature> SPRING_LAVA_FROZEN = ModPlacementUtils.createKey("spring_lava_frozen");
    public static final ResourceKey<PlacedFeature> SPRING_WATER = ModPlacementUtils.createKey("spring_water");
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> holder7 = holderGetter.getOrThrow(ModMiscOverworldFeatures.LAKE_LAVA);
        Holder<ConfiguredFeature<?, ?>> holder8 = holderGetter.getOrThrow(ModMiscOverworldFeatures.DISK_CLAY);
        Holder<ConfiguredFeature<?, ?>> holder9 = holderGetter.getOrThrow(ModMiscOverworldFeatures.DISK_SILT);
        Holder<ConfiguredFeature<?, ?>> holder10 = holderGetter.getOrThrow(ModMiscOverworldFeatures.DISK_SAND);
        Holder<ConfiguredFeature<?, ?>> holder15 = holderGetter.getOrThrow(ModMiscOverworldFeatures.SPRING_LAVA_OVERWORLD);
        Holder<ConfiguredFeature<?, ?>> holder16 = holderGetter.getOrThrow(ModMiscOverworldFeatures.SPRING_LAVA_FROZEN);
        Holder<ConfiguredFeature<?, ?>> holder17 = holderGetter.getOrThrow(ModMiscOverworldFeatures.SPRING_WATER);
        ModPlacementUtils.register(context, DISK_CLAY, holder8, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)), BiomeFilter.biome());
        ModPlacementUtils.register(context, DISK_SAND, holder10, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)), BiomeFilter.biome());
        ModPlacementUtils.register(context, DISK_SILT, holder9, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)), BiomeFilter.biome());
        ModPlacementUtils.register(context, LAKE_LAVA_SURFACE, holder7, RarityFilter.onAverageOnceEvery(200), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        ModPlacementUtils.register(context, LAKE_LAVA_UNDERGROUND, holder7, RarityFilter.onAverageOnceEvery(9), InSquarePlacement.spread(), HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.top())), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.allOf(BlockPredicate.not(BlockPredicate.ONLY_IN_AIR_PREDICATE), BlockPredicate.insideWorld(new BlockPos(0, -5, 0))), 32), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -5), BiomeFilter.biome());
        ModPlacementUtils.register(context, SPRING_LAVA, holder15, CountPlacement.of(20), InSquarePlacement.spread(), HeightRangePlacement.of(VeryBiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(8), 8)), BiomeFilter.biome());
        ModPlacementUtils.register(context, SPRING_LAVA_FROZEN, holder16, CountPlacement.of(20), InSquarePlacement.spread(), HeightRangePlacement.of(VeryBiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(8), 8)), BiomeFilter.biome());
        ModPlacementUtils.register(context, SPRING_WATER, holder17, CountPlacement.of(25), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(192)), BiomeFilter.biome());
    }
}
