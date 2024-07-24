package esoij.terrariamod.data.recipes.packs;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

import static esoij.terrariamod.world.item.ModItems.*;
import static esoij.terrariamod.world.level.block.ModBlocks.COPPER;
import static esoij.terrariamod.world.level.block.ModBlocks.VILE_MUSHROOM;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    public void buildRecipes(RecipeOutput exporter) {
        oreSmelting(exporter, ImmutableList.of(IRON_ORE),   RecipeCategory.MISC,  IRON_BAR,   0.7F, 0, "iron_bar");
        oreBlasting(exporter, ImmutableList.of(IRON_ORE),   RecipeCategory.MISC,  IRON_BAR,   0.7F, 0, "iron_bar");
        oreSmelting(exporter, ImmutableList.of(COPPER_ORE), RecipeCategory.MISC,  COPPER_BAR, 0.7F, 0, "copper_bar");
        oreBlasting(exporter, ImmutableList.of(COPPER_ORE), RecipeCategory.MISC,  COPPER_BAR, 0.7F, 0, "copper_bar");
        oreSmelting(exporter, ImmutableList.of(GOLD_ORE),   RecipeCategory.MISC,  GOLD_BAR,   0.7F, 0, "gold_bar");
        oreBlasting(exporter, ImmutableList.of(GOLD_ORE),   RecipeCategory.MISC,  GOLD_BAR,   0.7F, 0, "gold_bar");
        oreSmelting(exporter, ImmutableList.of(SILVER_ORE), RecipeCategory.MISC,  SILVER_BAR, 0.7F, 0, "silver_bar");
        oreBlasting(exporter, ImmutableList.of(SILVER_ORE), RecipeCategory.MISC,  SILVER_BAR, 0.7F, 0, "silver_bar");
        pickaxe(    exporter, IRON_PICKAXE,                 RecipeCategory.TOOLS, IRON_BAR);
    }
    public static void pickaxe(RecipeOutput exporter, Item output, RecipeCategory category, Item input) {
        ShapedRecipeBuilder.shaped(category, output).define('#', WOOD).define('X', input).pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy(getHasName(input), has(input)).save(exporter);
    }
}
