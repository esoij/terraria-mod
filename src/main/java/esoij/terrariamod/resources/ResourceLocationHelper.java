package esoij.terrariamod.resources;

import net.minecraft.resources.ResourceLocation;

public class ResourceLocationHelper {
    public static ResourceLocation parse(String path) {
        return ResourceLocation.fromNamespaceAndPath("terraria", path);
    }
}
