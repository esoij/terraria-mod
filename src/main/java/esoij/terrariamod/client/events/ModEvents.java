package esoij.terrariamod.client.events;

import esoij.terrariamod.client.renderer.DepthMeterOverlay;
import esoij.terrariamod.client.renderer.HealthAndArmourOverlay;
import esoij.terrariamod.client.renderer.WatchOverlay;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class ModEvents {
    public static void init() {
        HudRenderCallback.EVENT.register(WatchOverlay::renderOverlay);
        HudRenderCallback.EVENT.register(DepthMeterOverlay::renderOverlay);
        HudRenderCallback.EVENT.register(HealthAndArmourOverlay::renderOverlay);
    }
}
