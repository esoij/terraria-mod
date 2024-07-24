package esoij.terrariamod.world.level.levelgen.presets;

import esoij.terrariamod.resources.ResourceLocationHelper;
import esoij.terrariamod.world.level.levelgen.ModNoiseGeneratorSettings;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.DebugLevelSource;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorSettings;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.minecraft.world.level.levelgen.presets.WorldPresets;
import net.minecraft.world.level.levelgen.structure.StructureSet;

import java.util.Map;

public class ModWorldPresets extends WorldPresets {
    public static final ResourceKey<WorldPreset> TERRARIA = register("terraria");
    public static void bootstrap(BootstrapContext<WorldPreset> context) {
        new ModWorldPresets.Bootstrap(context).bootstrap();
    }
    private static ResourceKey<WorldPreset> register(String name) {
        return ResourceKey.create(Registries.WORLD_PRESET, ResourceLocationHelper.parse(name));
    }
    static class Bootstrap {
        private final BootstrapContext<WorldPreset> context;
        private final HolderGetter<NoiseGeneratorSettings> noiseSettings;
        private final HolderGetter<MultiNoiseBiomeSourceParameterList> multiNoiseBiomeSourceParameterLists;
        private final Holder<DimensionType> overworldDimensionType;
        private final LevelStem netherStem;
        private final LevelStem endStem;
        Bootstrap(BootstrapContext<WorldPreset> context) {
            this.context = context;
            HolderGetter<DimensionType> holderGetter = context.lookup(Registries.DIMENSION_TYPE);
            this.noiseSettings = context.lookup(Registries.NOISE_SETTINGS);
            HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
            HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
            HolderGetter<StructureSet> structureSets = context.lookup(Registries.STRUCTURE_SET);
            this.multiNoiseBiomeSourceParameterLists = context.lookup(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST);
            this.overworldDimensionType = holderGetter.getOrThrow(BuiltinDimensionTypes.OVERWORLD);
            Holder<DimensionType> holder = holderGetter.getOrThrow(BuiltinDimensionTypes.NETHER);
            Holder<NoiseGeneratorSettings> holder2 = this.noiseSettings.getOrThrow(NoiseGeneratorSettings.NETHER);
            Holder.Reference<MultiNoiseBiomeSourceParameterList> reference = this.multiNoiseBiomeSourceParameterLists
                    .getOrThrow(MultiNoiseBiomeSourceParameterLists.NETHER);
            this.netherStem = new LevelStem(holder, new NoiseBasedChunkGenerator(MultiNoiseBiomeSource.createFromPreset(reference), holder2));
            Holder<DimensionType> holder3 = holderGetter.getOrThrow(BuiltinDimensionTypes.END);
            Holder<NoiseGeneratorSettings> holder4 = this.noiseSettings.getOrThrow(NoiseGeneratorSettings.END);
            this.endStem = new LevelStem(holder3, new NoiseBasedChunkGenerator(TheEndBiomeSource.create(biomes), holder4));
        }
        private LevelStem makeOverworld(ChunkGenerator generator) {
            return new LevelStem(this.overworldDimensionType, generator);
        }
        private LevelStem makeNoiseBasedOverworld(BiomeSource biomeSource, Holder<NoiseGeneratorSettings> settings) {
            return this.makeOverworld(new NoiseBasedChunkGenerator(biomeSource, settings));
        }
        private WorldPreset createPresetWithCustomOverworld(LevelStem overworldStem) {
            return new WorldPreset(Map.of(LevelStem.OVERWORLD, overworldStem, LevelStem.NETHER, this.netherStem, LevelStem.END, this.endStem));
        }
        private void registerCustomOverworldPreset(ResourceKey<WorldPreset> dimensionKey, LevelStem levelStem) {
            this.context.register(dimensionKey, this.createPresetWithCustomOverworld(levelStem));
        }
        private void registerTerraria(BiomeSource biomeSource) {
            Holder<NoiseGeneratorSettings> holder = this.noiseSettings.getOrThrow(ModNoiseGeneratorSettings.TERRARIA);
            this.registerCustomOverworldPreset(ModWorldPresets.TERRARIA, this.makeNoiseBasedOverworld(biomeSource, holder));
        }
        public void bootstrap() {
            Holder.Reference<MultiNoiseBiomeSourceParameterList> reference = this.multiNoiseBiomeSourceParameterLists
                    .getOrThrow(MultiNoiseBiomeSourceParameterLists.OVERWORLD);
            this.registerTerraria(MultiNoiseBiomeSource.createFromPreset(reference));
        }
    }
}
