package esoij.terrariamod.data.worldgen.placement;

import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacementUtils extends PlacementUtils {
    public static ResourceKey<PlacedFeature> createKey(String key) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocationHelper.parse(key));
    }
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        ModCavePlacements.bootstrap(context);
        ModMiscOverworldPlacements.bootstrap(context);
        UnderworldPlacements.bootstrap(context);
        ModOrePlacements.bootstrap(context);
        ModTreePlacements.bootstrap(context);
        ModVegetationPlacements.bootstrap(context);
    }
}
