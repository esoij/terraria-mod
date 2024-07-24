package esoij.terrariamod.client.renderer.accessories;

import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import esoij.terrariamod.world.item.ModItems;

public class AccessoryRenderers {
    public static void init() {
        TrinketRendererRegistry.registerRenderer(ModItems.COPPER_WATCH, new CopperWatchRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.SILVER_WATCH, new SilverWatchRenderer());
        TrinketRendererRegistry.registerRenderer(ModItems.GOLD_WATCH, new GoldWatchRenderer());
    }
}
