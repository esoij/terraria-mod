package esoij.terrariamod.world.level.biome;

import com.mojang.logging.LogUtils;
import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import org.slf4j.Logger;

import static esoij.terrariamod.ModSharedConstants.IDE;

public class ModBiomes extends Biomes {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final ResourceKey<Biome> BEACH = register("beach");
    public static final ResourceKey<Biome> DESERT = register("desert");
    public static final ResourceKey<Biome> FOREST = register("forest");
    public static final ResourceKey<Biome> FOREST_RIVER = register("forest_river");
    public static final ResourceKey<Biome> GLOWING_MUSHROOM = register("glowing_mushroom");
    public static final ResourceKey<Biome> GRANITE = register("granite");
    public static final ResourceKey<Biome> JUNGLE = register("jungle");
    public static final ResourceKey<Biome> MARBLE = register("marble");
    public static final ResourceKey<Biome> OCEAN = register("ocean");
    public static final ResourceKey<Biome> SNOW = register("snow");
    public static final ResourceKey<Biome> SNOW_RIVER = register("snow_river");
    public static final ResourceKey<Biome> SPARSE_FOREST = register("sparse_forest");
    public static final ResourceKey<Biome> UNDERWORLD = register("underworld");
    public static final ResourceKey<Biome> UNDERWORLD_FOREST = register("underworld_forest");
    private static ResourceKey<Biome> register(String key) {
        if (IDE) LOGGER.info("Registering {}...", key);
        return ResourceKey.create(Registries.BIOME, ResourceLocationHelper.parse(key));
    }
    public static void init() {
        if (IDE) LOGGER.info("Initializing Mod Biomes...");
    }
}
