package esoij.terrariamod.world.level.levelgen;

import esoij.terrariamod.data.worldgen.ModSurfaceRuleData;
import esoij.terrariamod.resources.ResourceLocationHelper;
import esoij.terrariamod.world.level.biome.ModOverworldBiomeBuilder;
import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class ModNoiseGeneratorSettings {
    public static final ResourceKey<NoiseGeneratorSettings> TERRARIA = ResourceKey.create(
            Registries.NOISE_SETTINGS, ResourceLocationHelper.parse("overworld")
    );
    public static void bootstrap(BootstrapContext<NoiseGeneratorSettings> context) {
        context.register(TERRARIA, terraria(context, false, false));
    }
    private static NoiseGeneratorSettings terraria(BootstrapContext<?> context, boolean large, boolean amplified) {
        return new NoiseGeneratorSettings(
                ModNoiseSettings.TERRARIA_NOISE_SETTINGS,
                ModBlocks.STONE.defaultBlockState(),
                Blocks.WATER.defaultBlockState(),
                ModNoiseRouterData.terraria(context.lookup(Registries.DENSITY_FUNCTION), context.lookup(Registries.NOISE), amplified, large),
                ModSurfaceRuleData.overworld(),
                new ModOverworldBiomeBuilder().spawnTarget(),
                63,
                false,
                true,
                true,
                false
        );
    }
}
