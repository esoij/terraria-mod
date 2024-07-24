package esoij.terrariamod.data.worldgen.biome;

import esoij.terrariamod.world.level.biome.ModBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.biome.BiomeData;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModBiomeData extends BiomeData {
    public static void bootstrap(BootstrapContext<Biome> context) {
        HolderGetter<PlacedFeature> holderGetter = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> holderGetter2 = context.lookup(Registries.CONFIGURED_CARVER);
        context.register(ModBiomes.BEACH, ModOverworldBiomes.beach(holderGetter, holderGetter2));
        context.register(ModBiomes.DESERT, ModOverworldBiomes.desert(holderGetter, holderGetter2));
        context.register(ModBiomes.FOREST, ModOverworldBiomes.forest(holderGetter, holderGetter2));
        context.register(ModBiomes.FOREST_RIVER, ModOverworldBiomes.forestRiver(holderGetter, holderGetter2));
        context.register(ModBiomes.GLOWING_MUSHROOM, ModOverworldBiomes.glowingMushroom(holderGetter, holderGetter2));
        context.register(ModBiomes.GRANITE, ModOverworldBiomes.granite(holderGetter, holderGetter2));
        context.register(ModBiomes.JUNGLE, ModOverworldBiomes.jungle(holderGetter, holderGetter2));
        context.register(ModBiomes.MARBLE, ModOverworldBiomes.marble(holderGetter, holderGetter2));
        context.register(ModBiomes.OCEAN, ModOverworldBiomes.ocean(holderGetter, holderGetter2));
        context.register(ModBiomes.SNOW, ModOverworldBiomes.snow(holderGetter, holderGetter2));
        context.register(ModBiomes.SNOW_RIVER, ModOverworldBiomes.snowRiver(holderGetter, holderGetter2));
        context.register(ModBiomes.SPARSE_FOREST, ModOverworldBiomes.sparseForest(holderGetter, holderGetter2));
        context.register(ModBiomes.UNDERWORLD, UnderworldBiomes.underworld(holderGetter, holderGetter2));
        context.register(ModBiomes.UNDERWORLD_FOREST, UnderworldBiomes.underworldForest(holderGetter, holderGetter2));
    }
}
