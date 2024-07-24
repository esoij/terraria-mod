package esoij.terrariamod.data.worldgen.features;

import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SpringConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

@SuppressWarnings("deprecation")
public class ModMiscOverworldFeatures extends MiscOverworldFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_CLAY = ModFeatureUtils.createKey("disk_clay");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_SAND = ModFeatureUtils.createKey("disk_sand");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_SILT = ModFeatureUtils.createKey("disk_silt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAKE_LAVA = ModFeatureUtils.createKey("lake_lava");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRING_LAVA_FROZEN = ModFeatureUtils.createKey("spring_lava_frozen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRING_LAVA_OVERWORLD = ModFeatureUtils.createKey("spring_lava_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRING_WATER = ModFeatureUtils.createKey("spring_water");
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        ModFeatureUtils.register(context, DISK_CLAY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.CLAY_BLOCK), BlockPredicate.matchesBlocks(List.of(ModBlocks.DIRT, ModBlocks.CLAY)), UniformInt.of(2, 3), 1));
        ModFeatureUtils.register(context, DISK_SAND, Feature.DISK, new DiskConfiguration(new RuleBasedBlockStateProvider(BlockStateProvider.simple(ModBlocks.SAND), List.of(new RuleBasedBlockStateProvider.Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR), BlockStateProvider.simple(ModBlocks.SANDSTONE)))), BlockPredicate.matchesBlocks(List.of(ModBlocks.DIRT, ModBlocks.GRASS)), UniformInt.of(2, 6), 2));
        ModFeatureUtils.register(context, DISK_SILT, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.SILT), BlockPredicate.matchesBlocks(List.of(ModBlocks.DIRT, ModBlocks.GRASS)), UniformInt.of(2, 5), 2));
        ModFeatureUtils.register(context, LAKE_LAVA, Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(Blocks.LAVA.defaultBlockState()), BlockStateProvider.simple(ModBlocks.STONE.defaultBlockState())));
        ModFeatureUtils.register(context, SPRING_LAVA_FROZEN, Feature.SPRING, new SpringConfiguration(Fluids.LAVA.defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, ModBlocks.SNOW_BLOCK, ModBlocks.SLUSH, ModBlocks.ICE_BLOCK)));
        ModFeatureUtils.register(context, SPRING_LAVA_OVERWORLD, Feature.SPRING, new SpringConfiguration(Fluids.LAVA.defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, ModBlocks.STONE, ModBlocks.DIRT)));
        ModFeatureUtils.register(context, SPRING_WATER, Feature.SPRING, new SpringConfiguration(Fluids.WATER.defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, ModBlocks.STONE, ModBlocks.DIRT, ModBlocks.SNOW_BLOCK, ModBlocks.SLUSH, ModBlocks.ICE_BLOCK)));
    }
}
