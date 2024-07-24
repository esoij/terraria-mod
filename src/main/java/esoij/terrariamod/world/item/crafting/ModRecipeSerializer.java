package esoij.terrariamod.world.item.crafting;

import com.mojang.logging.LogUtils;
import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.slf4j.Logger;

import static esoij.terrariamod.ModSharedConstants.IDE;

public interface ModRecipeSerializer<T extends Recipe<?>> extends RecipeSerializer<T> {
    Logger LOGGER = LogUtils.getLogger();
    RecipeSerializer<TerrariaRecipe> TERRARIA_CRAFTER = register("terraria_crafting", new TerrariaRecipe.Serializer());
    static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String key, S recipeSerializer) {
        if (IDE) LOGGER.info("Registering {}, Recipe Serializer: {}", key, recipeSerializer);
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ResourceLocationHelper.parse(key), recipeSerializer);
    }
    static void init() {
        if (IDE) LOGGER.info("Initializing Mod Recipe Serializers...");
    }
}
