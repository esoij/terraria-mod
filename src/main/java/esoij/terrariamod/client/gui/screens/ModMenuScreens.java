package esoij.terrariamod.client.gui.screens;

import esoij.terrariamod.client.gui.screens.inventory.TerrariaCrafterScreen;
import esoij.terrariamod.world.inventory.ModMenuType;
import net.minecraft.client.gui.screens.MenuScreens;

public class ModMenuScreens extends MenuScreens {
    public static void init() {
        register(ModMenuType.TERRARIA_CRAFTER, TerrariaCrafterScreen::new);
    }
}
