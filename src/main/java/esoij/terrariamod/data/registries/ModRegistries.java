package esoij.terrariamod.data.registries;

import esoij.terrariamod.data.worldgen.biome.ModBiomeData;
import esoij.terrariamod.data.worldgen.features.ModFeatureUtils;
import esoij.terrariamod.data.worldgen.placement.ModPlacementUtils;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;

public class ModRegistries extends VanillaRegistries {
    public static void init(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, ModFeatureUtils::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, ModPlacementUtils::bootstrap);
        registryBuilder.add(Registries.BIOME, ModBiomeData::bootstrap);
        //RegistryAccess.Frozen frozen = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
        //registryBuilder.build(frozen);
    }
}
