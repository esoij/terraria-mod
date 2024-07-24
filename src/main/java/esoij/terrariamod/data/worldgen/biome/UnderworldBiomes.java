package esoij.terrariamod.data.worldgen.biome;

import esoij.terrariamod.data.worldgen.placement.*;
import esoij.terrariamod.world.entity.ModEntityType;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.biome.NetherBiomes;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class UnderworldBiomes extends NetherBiomes {
    public static Biome underworld(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder builder = new MobSpawnSettings.Builder();
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntityType.BLUE_SLIME, 100, 4, 4));
        net.minecraft.world.level.biome.BiomeGenerationSettings.Builder builder2 = new net.minecraft.world.level.biome.BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        builder2.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        builder2.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, UnderworldPlacements.SPRING_OPEN);
        builder2.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, UnderworldPlacements.PATCH_FIRE);
        builder2.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, ModOrePlacements.ORE_HELLSTONE);
        builder2.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, UnderworldPlacements.SPRING_CLOSED);
        builder2.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, MiscOverworldPlacements.FREEZE_TOP_LAYER);
        net.minecraft.world.level.biome.BiomeSpecialEffects.Builder builder3 = new net.minecraft.world.level.biome.BiomeSpecialEffects.Builder().waterColor(6823707).waterFogColor(6823707).fogColor(6823707).skyColor(1970457).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_NETHER_WASTES)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111)).ambientLoopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP);
        return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(2.0F).downfall(0.0F).specialEffects(builder3.build()).mobSpawnSettings(builder.build()).generationSettings(builder2.build()).build();
    }
    public static Biome underworldForest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder builder = new MobSpawnSettings.Builder();
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntityType.BLUE_SLIME, 100, 4, 4));
        net.minecraft.world.level.biome.BiomeGenerationSettings.Builder builder2 = new net.minecraft.world.level.biome.BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        builder2.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        builder2.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, UnderworldPlacements.SPRING_OPEN);
        builder2.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, UnderworldPlacements.PATCH_FIRE);
        builder2.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, ModOrePlacements.ORE_HELLSTONE);
        builder2.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, UnderworldPlacements.SPRING_CLOSED);
        builder2.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModMiscOverworldPlacements.SPRING_LAVA);
        builder2.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModTreePlacements.TREE_ASH);
        net.minecraft.world.level.biome.BiomeSpecialEffects.Builder builder3 = new net.minecraft.world.level.biome.BiomeSpecialEffects.Builder().waterColor(6823707).waterFogColor(6823707).fogColor(6823707).skyColor(1970457).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_NETHER_WASTES)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111)).ambientLoopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP);
        return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(2.0F).downfall(0.0F).specialEffects(builder3.build()).mobSpawnSettings(builder.build()).generationSettings(builder2.build()).build();
    }
}
