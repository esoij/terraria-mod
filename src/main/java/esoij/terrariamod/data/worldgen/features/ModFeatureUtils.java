package esoij.terrariamod.data.worldgen.features;

import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ModFeatureUtils extends FeatureUtils {
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        ModCaveFeatures.bootstrap(context);
        ModMiscOverworldFeatures.bootstrap(context);
        UnderworldFeatures.bootstrap(context);
        ModOreFeatures.bootstrap(context);
        ModTreeFeatures.bootstrap(context);
        ModVegetationFeatures.bootstrap(context);
    }
    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocationHelper.parse(name));
    }
}
