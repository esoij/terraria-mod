package esoij.terrariamod.data.worldgen.features;

import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SpringConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

@SuppressWarnings("deprecation")
public class UnderworldFeatures extends NetherFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_FIRE = ModFeatureUtils.createKey("patch_fire");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRING_UNDERWORLD_CLOSED = ModFeatureUtils.createKey("spring_underworld_closed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRING_UNDERWORLD_OPEN = FeatureUtils.createKey("spring_underworld_open");
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        ModFeatureUtils.register(context, PATCH_FIRE, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.FIRE)), List.of(ModBlocks.ASH)));
        ModFeatureUtils.register(context, SPRING_UNDERWORLD_CLOSED, Feature.SPRING, new SpringConfiguration(Fluids.LAVA.defaultFluidState(), false, 5, 0, HolderSet.direct(Block::builtInRegistryHolder, ModBlocks.ASH)));
        ModFeatureUtils.register(context, SPRING_UNDERWORLD_OPEN, Feature.SPRING, new SpringConfiguration(Fluids.LAVA.defaultFluidState(), false, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, ModBlocks.ASH)));
    }
}
