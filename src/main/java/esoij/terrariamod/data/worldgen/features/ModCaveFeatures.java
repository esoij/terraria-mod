package esoij.terrariamod.data.worldgen.features;

import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class ModCaveFeatures extends CaveFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETHYST_GEODE = ModFeatureUtils.createKey("amethyst_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MONSTER_ROOM = ModFeatureUtils.createKey("monster_room");
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, AMETHYST_GEODE, Feature.GEODE, new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR), BlockStateProvider.simple(ModBlocks.AMETHYST), BlockStateProvider.simple(ModBlocks.AMETHYST), BlockStateProvider.simple(ModBlocks.STONE), BlockStateProvider.simple(ModBlocks.STONE), List.of(ModBlocks.AMETHYST_GEM.defaultBlockState(), ModBlocks.AMETHYST_GEM.defaultBlockState(), ModBlocks.AMETHYST_GEM.defaultBlockState(), ModBlocks.AMETHYST_GEM.defaultBlockState()), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7, 2.2, 3.2, 4.2), new GeodeCrackSettings(0.95, 2.0, 2), 0.35, 0.083, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05, 1));
        ModFeatureUtils.register(context, MONSTER_ROOM, Feature.MONSTER_ROOM);
    }
}
