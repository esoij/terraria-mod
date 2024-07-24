package esoij.terrariamod.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.BambooFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

public abstract class ModFeature<FC extends FeatureConfiguration> extends Feature<FC> {
    public static final Feature<ProbabilityFeatureConfiguration> TERRARIA_BAMBOO = register("bamboo", new TerrariaBambooFeature(ProbabilityFeatureConfiguration.CODEC));
    public ModFeature(Codec<FC> codec) {
        super(codec);
    }
    private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String key, F value) {
        return (F) Registry.register(BuiltInRegistries.FEATURE, ResourceLocationHelper.parse(key), value);
    }
}
