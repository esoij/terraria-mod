package esoij.terrariamod.world.inventory;

import com.mojang.logging.LogUtils;
import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.slf4j.Logger;

import static esoij.terrariamod.ModSharedConstants.IDE;

public class ModMenuType<T extends AbstractContainerMenu> extends MenuType<T> {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final MenuType<TerrariaCrafterMenu> TERRARIA_CRAFTER = register("terraria_crafter", TerrariaCrafterMenu::new);
    private static <T extends AbstractContainerMenu> MenuType<T> register(String key, MenuType.MenuSupplier<T> factory) {
        if (IDE) LOGGER.info("Registering {}, factory: {}", key, factory);
        return Registry.register(BuiltInRegistries.MENU, ResourceLocationHelper.parse(key), new MenuType<>(factory, FeatureFlags.VANILLA_SET));
    }
    public ModMenuType(MenuSupplier<T> constructor, FeatureFlagSet requiredFeatures) {
        super(constructor, requiredFeatures);
    }
    public static void init() {
        if (IDE) LOGGER.info("Initialized Mod Menu Types!");
    }
}
