package esoij.terrariamod.world.item.crafting;

import com.mojang.logging.LogUtils;
import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import org.slf4j.Logger;

import static esoij.terrariamod.ModSharedConstants.IDE;

public interface ModRecipeType<T extends Recipe<?>> extends RecipeType<T> {
    Logger LOGGER = LogUtils.getLogger();
    RecipeType<TerrariaRecipe> TERRARIA_CRAFTING = register("terraria_crafting");
    static <T extends Recipe<?>> RecipeType<T> register(String identifier) {
        if (IDE) LOGGER.info("Registering {}", identifier);
        return Registry.register(BuiltInRegistries.RECIPE_TYPE, ResourceLocationHelper.parse(identifier), new RecipeType<T>() {
            @Override
            public String toString() {
                return identifier;
            }
        });
    }
    static void init() {
        if (IDE) LOGGER.info("Initialized Mod Recipe Types!");
    }
}
