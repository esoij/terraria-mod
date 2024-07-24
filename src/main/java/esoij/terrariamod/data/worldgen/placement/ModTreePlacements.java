package esoij.terrariamod.data.worldgen.placement;

import esoij.terrariamod.data.worldgen.features.ModTreeFeatures;
import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

@SuppressWarnings("deprecation")
public class ModTreePlacements extends TreePlacements {
    public static final ResourceKey<PlacedFeature> BOREAL = ModPlacementUtils.createKey("boreal");
    public static final ResourceKey<PlacedFeature> FANCY_BOREAL = ModPlacementUtils.createKey("fancy_boreal");
    public static final ResourceKey<PlacedFeature> FANCY_FOREST_CHECKED = ModPlacementUtils.createKey("fancy_forest_checked");
    public static final ResourceKey<PlacedFeature> FANCY_OCEAN_CHECKED = ModPlacementUtils.createKey("fancy_ocean_checked");
    public static final ResourceKey<PlacedFeature> FOREST = ModPlacementUtils.createKey("forest");
    public static final ResourceKey<PlacedFeature> FOREST_CHECKED = ModPlacementUtils.createKey("forest_checked");
    public static final ResourceKey<PlacedFeature> JUNGLE_TREE = ModPlacementUtils.createKey("jungle_tree");
    public static final ResourceKey<PlacedFeature> MEGA_BOREAL_CHECKED = ModPlacementUtils.createKey("mega_boreal_checked");
    public static final ResourceKey<PlacedFeature> MEGA_FANCY_BOREAL_CHECKED = ModPlacementUtils.createKey("mega_fancy_boreal_checked");
    public static final ResourceKey<PlacedFeature> MEGA_JUNGLE_TREE_CHECKED = ModPlacementUtils.createKey("mega_jungle_tree_checked");
    public static final ResourceKey<PlacedFeature> OCEAN_CHECKED = ModPlacementUtils.createKey("ocean_checked");
    public static final ResourceKey<PlacedFeature> TREE_ASH = ModPlacementUtils.createKey("tree_ash");
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> holder = holderGetter.getOrThrow(ModTreeFeatures.TREE_ASH);
        Holder<ConfiguredFeature<?, ?>> holder3 = holderGetter.getOrThrow(ModTreeFeatures.FOREST);
        Holder<ConfiguredFeature<?, ?>> holder7 = holderGetter.getOrThrow(ModTreeFeatures.BOREAL);
        Holder<ConfiguredFeature<?, ?>> holder10 = holderGetter.getOrThrow(ModTreeFeatures.FANCY_BOREAL);
        Holder<ConfiguredFeature<?, ?>> holder11 = holderGetter.getOrThrow(ModTreeFeatures.JUNGLE_TREE);
        Holder<ConfiguredFeature<?, ?>> holder12 = holderGetter.getOrThrow(ModTreeFeatures.FANCY_FOREST);
        Holder<ConfiguredFeature<?, ?>> holder13 = holderGetter.getOrThrow(ModTreeFeatures.MEGA_JUNGLE_TREE);
        Holder<ConfiguredFeature<?, ?>> holder14 = holderGetter.getOrThrow(ModTreeFeatures.MEGA_BOREAL);
        Holder<ConfiguredFeature<?, ?>> holder15 = holderGetter.getOrThrow(ModTreeFeatures.MEGA_FANCY_BOREAL);
        Holder<ConfiguredFeature<?, ?>> holder28 = holderGetter.getOrThrow(ModTreeFeatures.FANCY_OCEAN);
        Holder<ConfiguredFeature<?, ?>> holder29 = holderGetter.getOrThrow(ModTreeFeatures.OCEAN);
        ModPlacementUtils.register(context, BOREAL, holder7, PlacementUtils.filteredByBlockSurvival(ModBlocks.BOREAL_SAPLING));
        ModPlacementUtils.register(context, FANCY_BOREAL, holder10, PlacementUtils.filteredByBlockSurvival(ModBlocks.BOREAL_SAPLING));
        ModPlacementUtils.register(context, FANCY_FOREST_CHECKED, holder12, PlacementUtils.filteredByBlockSurvival(ModBlocks.FOREST_SAPLING));
        ModPlacementUtils.register(context, FANCY_OCEAN_CHECKED, holder28, PlacementUtils.filteredByBlockSurvival(ModBlocks.FOREST_SAPLING));
        ModPlacementUtils.register(context, FOREST, holder3, PlacementUtils.filteredByBlockSurvival(ModBlocks.FOREST_SAPLING));
        ModPlacementUtils.register(context, FOREST_CHECKED, holder3, PlacementUtils.filteredByBlockSurvival(ModBlocks.FOREST_SAPLING));
        ModPlacementUtils.register(context, JUNGLE_TREE, holder11, PlacementUtils.filteredByBlockSurvival(ModBlocks.FOREST_SAPLING));
        ModPlacementUtils.register(context, MEGA_BOREAL_CHECKED, holder14, PlacementUtils.filteredByBlockSurvival(ModBlocks.BOREAL_SAPLING));
        ModPlacementUtils.register(context, MEGA_FANCY_BOREAL_CHECKED, holder15, PlacementUtils.filteredByBlockSurvival(ModBlocks.BOREAL_SAPLING));
        ModPlacementUtils.register(context, MEGA_JUNGLE_TREE_CHECKED, holder13, PlacementUtils.filteredByBlockSurvival(ModBlocks.FOREST_SAPLING));
        ModPlacementUtils.register(context, OCEAN_CHECKED, holder29, PlacementUtils.filteredByBlockSurvival(ModBlocks.FOREST_SAPLING));
        ModPlacementUtils.register(context, TREE_ASH, holder, CountOnEveryLayerPlacement.of(8), BiomeFilter.biome());
    }
}
