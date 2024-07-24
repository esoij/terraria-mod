package esoij.terrariamod.data.worldgen.placement;

import esoij.terrariamod.data.worldgen.features.ModCaveFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

public class ModCavePlacements extends CavePlacements {
    public static final ResourceKey<PlacedFeature> AMETHYST_GEODE = ModPlacementUtils.createKey("amethyst_geode");
    public static final ResourceKey<PlacedFeature> MONSTER_ROOM = ModPlacementUtils.createKey("monster_room");
    public static final ResourceKey<PlacedFeature> MONSTER_ROOM_DEEP = ModPlacementUtils.createKey("monster_room_deep");
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> holder = holderGetter.getOrThrow(ModCaveFeatures.MONSTER_ROOM);
        Holder<ConfiguredFeature<?, ?>> holder16 = holderGetter.getOrThrow(ModCaveFeatures.AMETHYST_GEODE);
        ModPlacementUtils.register(context, AMETHYST_GEODE, holder16, RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(30)), BiomeFilter.biome());
        ModPlacementUtils.register(context, MONSTER_ROOM, holder, CountPlacement.of(10), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()), BiomeFilter.biome());
        ModPlacementUtils.register(context, MONSTER_ROOM_DEEP, holder, CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(-1)), BiomeFilter.biome());
    }
}
