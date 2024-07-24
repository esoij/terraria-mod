package esoij.terrariamod.data.worldgen.features;

import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModOreFeatures extends OreFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_COPPPER_SMALL = ModFeatureUtils.createKey("ore_copper_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_BURIED = ModFeatureUtils.createKey("ore_diamond_buried");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_LARGE = ModFeatureUtils.createKey("ore_diamond_large");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_MEDIUM = ModFeatureUtils.createKey("ore_diamond_medium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_SMALL = ModFeatureUtils.createKey("ore_diamond_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DIRT = ModFeatureUtils.createKey("ore_dirt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_EMERALD = ModFeatureUtils.createKey("ore_emerald");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GOLD_BURIED = ModFeatureUtils.createKey("ore_gold_buried");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_HELLSTONE = ModFeatureUtils.createKey("ore_hellstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_IRON = ModFeatureUtils.createKey("ore_iron");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_IRON_SMALL = ModFeatureUtils.createKey("ore_iron_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SILT = ModFeatureUtils.createKey("ore_silt");
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest ruleTest = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);
        RuleTest ruleTest2 = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest ruleTest4 = new BlockMatchTest(ModBlocks.ASH);
        List<OreConfiguration.TargetBlockState> list = List.of(OreConfiguration.target(ruleTest2, ModBlocks.IRON.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> list2 = List.of(OreConfiguration.target(ruleTest2, ModBlocks.GOLD.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> list3 = List.of(OreConfiguration.target(ruleTest2, ModBlocks.DIAMOND.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> list5 = List.of(OreConfiguration.target(ruleTest2, ModBlocks.COPPER.defaultBlockState()));
        ModFeatureUtils.register(context, ORE_COPPPER_SMALL, Feature.ORE, new OreConfiguration(list5, 10));
        ModFeatureUtils.register(context, ORE_DIAMOND_BURIED, Feature.ORE, new OreConfiguration(list3, 8, 1.0F));
        ModFeatureUtils.register(context, ORE_DIAMOND_LARGE, Feature.ORE, new OreConfiguration(list3, 12, 0.7F));
        ModFeatureUtils.register(context, ORE_DIAMOND_MEDIUM, Feature.ORE, new OreConfiguration(list3, 8, 0.5F));
        ModFeatureUtils.register(context, ORE_DIAMOND_SMALL, Feature.ORE, new OreConfiguration(list3, 4, 0.5F));
        ModFeatureUtils.register(context, ORE_DIRT, Feature.ORE, new OreConfiguration(ruleTest, ModBlocks.DIRT.defaultBlockState(), 33));
        ModFeatureUtils.register(context, ORE_EMERALD, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(ruleTest2, ModBlocks.EMERALD.defaultBlockState())), 3));
        ModFeatureUtils.register(context, ORE_GOLD_BURIED, Feature.ORE, new OreConfiguration(list2, 9, 0.5F));
        ModFeatureUtils.register(context, ORE_HELLSTONE, Feature.ORE, new OreConfiguration(ruleTest4, ModBlocks.HELLSTONE.defaultBlockState(), 33));
        ModFeatureUtils.register(context, ORE_IRON, Feature.ORE, new OreConfiguration(list, 9));
        ModFeatureUtils.register(context, ORE_IRON_SMALL, Feature.ORE, new OreConfiguration(list, 4));
        ModFeatureUtils.register(context, ORE_SILT, Feature.ORE, new OreConfiguration(ruleTest, ModBlocks.SILT.defaultBlockState(), 33));
    }
}
