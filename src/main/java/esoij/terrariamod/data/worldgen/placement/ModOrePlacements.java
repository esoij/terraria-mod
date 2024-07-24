package esoij.terrariamod.data.worldgen.placement;

import esoij.terrariamod.data.worldgen.features.ModOreFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacements extends OrePlacements {
    public static final ResourceKey<PlacedFeature> ORE_COPPER = ModPlacementUtils.createKey("ore_copper");
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND = ModPlacementUtils.createKey("ore_diamond");
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND_BURIED = ModPlacementUtils.createKey("ore_diamond_buried");
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND_LARGE = ModPlacementUtils.createKey("ore_diamond_large");
    public static final ResourceKey<PlacedFeature> ORE_DIAMOND_MEDIUM = ModPlacementUtils.createKey("ore_diamond_medium");
    public static final ResourceKey<PlacedFeature> ORE_DIRT = ModPlacementUtils.createKey("ore_dirt");
    public static final ResourceKey<PlacedFeature> ORE_EMERALD = ModPlacementUtils.createKey("ore_emerald");
    public static final ResourceKey<PlacedFeature> ORE_GOLD = ModPlacementUtils.createKey("ore_gold");
    public static final ResourceKey<PlacedFeature> ORE_GOLD_LOWER = ModPlacementUtils.createKey("ore_gold_lower");
    public static final ResourceKey<PlacedFeature> ORE_HELLSTONE = ModPlacementUtils.createKey("ore_hellstone");
    public static final ResourceKey<PlacedFeature> ORE_IRON_MIDDLE = ModPlacementUtils.createKey("ore_iron_middle");
    public static final ResourceKey<PlacedFeature> ORE_IRON_SMALL = ModPlacementUtils.createKey("ore_iron_small");
    public static final ResourceKey<PlacedFeature> ORE_IRON_UPPER = ModPlacementUtils.createKey("ore_iron_upper");
    public static final ResourceKey<PlacedFeature> ORE_SILT = ModPlacementUtils.createKey("ore_silt");
    private static List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier heightRange) {
        return List.of(countPlacement, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }
    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return orePlacement(CountPlacement.of(count), heightRange);
    }
    private static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), heightRange);
    }
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> holder = holderGetter.getOrThrow(ModOreFeatures.ORE_HELLSTONE);
        Holder<ConfiguredFeature<?, ?>> holder7 = holderGetter.getOrThrow(ModOreFeatures.ORE_DIRT);
        Holder<ConfiguredFeature<?, ?>> holder8 = holderGetter.getOrThrow(ModOreFeatures.ORE_SILT);
        Holder<ConfiguredFeature<?, ?>> holder15 = holderGetter.getOrThrow(ModOreFeatures.ORE_IRON);
        Holder<ConfiguredFeature<?, ?>> holder16 = holderGetter.getOrThrow(ModOreFeatures.ORE_IRON_SMALL);
        Holder<ConfiguredFeature<?, ?>> holder18 = holderGetter.getOrThrow(ModOreFeatures.ORE_GOLD_BURIED);
        Holder<ConfiguredFeature<?, ?>> holder20 = holderGetter.getOrThrow(ModOreFeatures.ORE_DIAMOND_SMALL);
        Holder<ConfiguredFeature<?, ?>> holder21 = holderGetter.getOrThrow(ModOreFeatures.ORE_DIAMOND_MEDIUM);
        Holder<ConfiguredFeature<?, ?>> holder22 = holderGetter.getOrThrow(ModOreFeatures.ORE_DIAMOND_LARGE);
        Holder<ConfiguredFeature<?, ?>> holder23 = holderGetter.getOrThrow(ModOreFeatures.ORE_DIAMOND_BURIED);
        Holder<ConfiguredFeature<?, ?>> holder27 = holderGetter.getOrThrow(ModOreFeatures.ORE_EMERALD);
        Holder<ConfiguredFeature<?, ?>> holder30 = holderGetter.getOrThrow(ModOreFeatures.ORE_COPPPER_SMALL);
        ModPlacementUtils.register(context, ORE_COPPER, holder30, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
        ModPlacementUtils.register(context, ORE_DIAMOND, holder20, commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        ModPlacementUtils.register(context, ORE_DIAMOND_BURIED, holder23, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        ModPlacementUtils.register(context, ORE_DIAMOND_LARGE, holder22, rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        ModPlacementUtils.register(context, ORE_DIAMOND_MEDIUM, holder21, commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-4))));
        ModPlacementUtils.register(context, ORE_DIRT, holder7, commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));
        ModPlacementUtils.register(context, ORE_EMERALD, holder27, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
        ModPlacementUtils.register(context, ORE_GOLD, holder18, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
        ModPlacementUtils.register(context, ORE_GOLD_LOWER, holder18, orePlacement(CountPlacement.of(UniformInt.of(0, 1)), HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48))));
        ModPlacementUtils.register(context, ORE_HELLSTONE, holder, commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(27), VerticalAnchor.absolute(36))));
        ModPlacementUtils.register(context, ORE_IRON_MIDDLE, holder15, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
        ModPlacementUtils.register(context, ORE_IRON_SMALL, holder16, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72))));
        ModPlacementUtils.register(context, ORE_IRON_UPPER, holder15, commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));
        ModPlacementUtils.register(context, ORE_SILT, holder8, commonOrePlacement(14, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
    }
}
