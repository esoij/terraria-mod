package esoij.terrariamod.client;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class ModOptions {
    public static final KeyMapping keyBuff = KeyBindingHelper.registerKeyBinding(new KeyMapping("key.buff", GLFW.GLFW_KEY_B, "key.categories.terraria"));
    public static void init() {
    }
}
