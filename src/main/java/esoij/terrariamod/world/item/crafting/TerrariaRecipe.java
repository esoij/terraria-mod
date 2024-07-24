package esoij.terrariamod.world.item.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class TerrariaRecipe implements Recipe<TerrariaInput> {
    final String group;
    final CraftingBookCategory category;
    final ItemStack result;
    final NonNullList<Ingredient> ingredients;
    public TerrariaRecipe(String group, CraftingBookCategory category, ItemStack result, NonNullList<Ingredient> ingredients) {
        this.group = group;
        this.category = category;
        this.result = result;
        this.ingredients = ingredients;
    }
    @Override
    public RecipeType<?> getType() {
        return ModRecipeType.TERRARIA_CRAFTING;
    }
    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializer.TERRARIA_CRAFTER;
    }
    @Override
    public String getGroup() {
        return this.group;
    }
    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.result;
    }
    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }
    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.TERRARIA_CRAFTER);
    }
    @Override
    public boolean matches(TerrariaInput input, Level level) {
        if (input.ingredientCount() != this.ingredients.size()) {
            return false;
        } else {
            return input.size() == 1 && this.ingredients.size() == 1
                    ? this.ingredients.get(0).test(input.getItem(0))
                    : input.stackedContents().canCraft(this, null);
        }
    }
    @Override
    public ItemStack assemble(TerrariaInput input, HolderLookup.Provider registries) {
        return this.result.copy();
    }
    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.ingredients.size();
    }
    public static class Serializer implements RecipeSerializer<TerrariaRecipe> {
        private static final MapCodec<TerrariaRecipe> CODEC = RecordCodecBuilder.mapCodec(
                instance -> instance.group(
                                Codec.STRING.optionalFieldOf("group", "").forGetter(shapelessRecipe -> shapelessRecipe.group),
                                CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(shapelessRecipe -> shapelessRecipe.category),
                                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(shapelessRecipe -> shapelessRecipe.result),
                                Ingredient.CODEC_NONEMPTY
                                        .listOf()
                                        .fieldOf("ingredients")
                                        .flatXmap(
                                                list -> {
                                                    Ingredient[] ingredients = (Ingredient[])list.stream().filter(ingredient -> !ingredient.isEmpty()).toArray(i -> new Ingredient[i]);
                                                    if (ingredients.length == 0) {
                                                        return DataResult.error(() -> "No ingredients for shapeless recipe");
                                                    } else {
                                                        return ingredients.length > 9
                                                                ? DataResult.error(() -> "Too many ingredients for shapeless recipe")
                                                                : DataResult.success(NonNullList.of(Ingredient.EMPTY, ingredients));
                                                    }
                                                },
                                                DataResult::success
                                        )
                                        .forGetter(shapelessRecipe -> shapelessRecipe.ingredients)
                        )
                        .apply(instance, TerrariaRecipe::new)
        );
        public static final StreamCodec<RegistryFriendlyByteBuf, TerrariaRecipe> STREAM_CODEC = StreamCodec.of(
                TerrariaRecipe.Serializer::toNetwork, TerrariaRecipe.Serializer::fromNetwork
        );
        public MapCodec<TerrariaRecipe> codec() {
            return CODEC;
        }
        public StreamCodec<RegistryFriendlyByteBuf, TerrariaRecipe> streamCodec() {
            return STREAM_CODEC;
        }
        private static TerrariaRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            String string = buffer.readUtf();
            CraftingBookCategory craftingBookCategory = (CraftingBookCategory)buffer.readEnum(CraftingBookCategory.class);
            int i = buffer.readVarInt();
            NonNullList<Ingredient> nonNullList = NonNullList.withSize(i, Ingredient.EMPTY);
            nonNullList.replaceAll(ingredient -> (Ingredient)Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
            ItemStack itemStack = (ItemStack)ItemStack.STREAM_CODEC.decode(buffer);
            return new TerrariaRecipe(string, craftingBookCategory, itemStack, nonNullList);
        }
        private static void toNetwork(RegistryFriendlyByteBuf buffer, TerrariaRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            buffer.writeVarInt(recipe.ingredients.size());

            for(Ingredient ingredient : recipe.ingredients) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
            }

            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
        }
    }
}
