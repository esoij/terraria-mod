package esoij.terrariamod.data.recipes;

import esoij.terrariamod.world.item.crafting.TerrariaRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class TerrariaRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final Item result;
    private final int count;
    private final NonNullList<Ingredient> ingredients = NonNullList.create();
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap();
    @Nullable
    private String group;
    public TerrariaRecipeBuilder(RecipeCategory category, ItemLike result, int count) {
        this.category = category;
        this.result = result.asItem();
        this.count = count;
    }
    /**
     * Creates a new builder for a shapeless recipe.
     */
    public static TerrariaRecipeBuilder crafting(RecipeCategory category, ItemLike result) {
        return new TerrariaRecipeBuilder(category, result, 1);
    }
    /**
     * Creates a new builder for a shapeless recipe.
     */
    public static TerrariaRecipeBuilder crafting(RecipeCategory category, ItemLike result, int count) {
        return new TerrariaRecipeBuilder(category, result, count);
    }
    /**
     * Adds an ingredient that can be any item in the given tag.
     */
    public TerrariaRecipeBuilder requires(TagKey<Item> tag) {
        return this.requires(Ingredient.of(tag));
    }
    /**
     * Adds an ingredient of the given item.
     */
    public TerrariaRecipeBuilder requires(ItemLike item) {
        return this.requires(item, 1);
    }
    /**
     * Adds the given ingredient multiple times.
     */
    public TerrariaRecipeBuilder requires(ItemLike item, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.requires(Ingredient.of(item));
        }

        return this;
    }
    /**
     * Adds an ingredient.
     */
    public TerrariaRecipeBuilder requires(Ingredient ingredient) {
        return this.requires(ingredient, 1);
    }
    /**
     * Adds an ingredient multiple times.
     */
    public TerrariaRecipeBuilder requires(Ingredient ingredient, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.ingredients.add(ingredient);
        }

        return this;
    }
    @Override
    public TerrariaRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }
    @Override
    public TerrariaRecipeBuilder group(@Nullable String groupName) {
        this.group = groupName;
        return this;
    }
    @Override
    public Item getResult() {
        return this.result;
    }
    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        this.ensureValid(id);
        Advancement.Builder builder = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(builder::addCriterion);
        TerrariaRecipe terrariaRecipe = new TerrariaRecipe(
                (String) Objects.requireNonNullElse(this.group, ""),
                RecipeBuilder.determineBookCategory(this.category),
                new ItemStack(this.result, this.count),
                this.ingredients
        );
        recipeOutput.accept(id, terrariaRecipe, builder.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }
    /**
     * Makes sure that this recipe is valid and obtainable.
     */
    private void ensureValid(ResourceLocation id) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }
}
