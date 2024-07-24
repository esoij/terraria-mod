package esoij.terrariamod.data.worldgen.placement;

import esoij.terrariamod.data.worldgen.features.UnderworldFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class UnderworldPlacements extends NetherPlacements {
    public static final ResourceKey<PlacedFeature> PATCH_FIRE = ModPlacementUtils.createKey("patch_fire");
    public static final ResourceKey<PlacedFeature> SPRING_CLOSED = ModPlacementUtils.createKey("spring_closed");
    public static final ResourceKey<PlacedFeature> SPRING_OPEN = ModPlacementUtils.createKey("spring_open");
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> holder15 = holderGetter.getOrThrow(UnderworldFeatures.SPRING_UNDERWORLD_CLOSED);
        Holder<ConfiguredFeature<?, ?>> holder16 = holderGetter.getOrThrow(UnderworldFeatures.SPRING_UNDERWORLD_OPEN);
        Holder<ConfiguredFeature<?, ?>> holder18 = holderGetter.getOrThrow(UnderworldFeatures.PATCH_FIRE);
        List<PlacementModifier> list = List.of(CountPlacement.of(UniformInt.of(0, 5)), InSquarePlacement.spread(), PlacementUtils.RANGE_4_4, BiomeFilter.biome());
        ModPlacementUtils.register(context, PATCH_FIRE, holder18, list);
        ModPlacementUtils.register(context, SPRING_CLOSED, holder15, CountPlacement.of(16), InSquarePlacement.spread(), PlacementUtils.RANGE_10_10, BiomeFilter.biome());
        ModPlacementUtils.register(context, SPRING_OPEN, holder16, CountPlacement.of(8), InSquarePlacement.spread(), PlacementUtils.RANGE_4_4, BiomeFilter.biome());
    }
}
