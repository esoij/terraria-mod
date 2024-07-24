package esoij.terrariamod.client.renderer;

import dev.emi.trinkets.api.TrinketsApi;
import esoij.terrariamod.tags.ModItemTags;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.Level;

import java.util.concurrent.atomic.AtomicBoolean;

public class DepthMeterOverlay {
    public static void renderOverlay(GuiGraphics graphics, DeltaTracker tracker) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.options.hideGui || minecraft.gui.getDebugOverlay().showDebugScreen()) return;
        AtomicBoolean shouldShowOverlay = new AtomicBoolean(false);
        if (minecraft.player != null) {
            Inventory inventory = minecraft.player.getInventory();
            if (TrinketsApi.getTrinketComponent(minecraft.player).isPresent()) {
                TrinketsApi.getTrinketComponent(minecraft.player).get().forEach((slotReference, itemStack) -> {
                    if (itemStack.is(ModItemTags.DISPLAYS_TIME)) shouldShowOverlay.set(true);
                });
            }
            if (!shouldShowOverlay.get() && !inventory.isEmpty()) for (int i = 0; i < inventory.getContainerSize(); i++) {
                if (inventory.getItem(i).isEmpty()) continue;
                if (inventory.getItem(i).is(ModItemTags.DISPLAYS_DEPTH)) shouldShowOverlay.set(true);
            }
            if (shouldShowOverlay.get()) {
                int y = (int)minecraft.player.getY();
                String text;
                if (minecraft.player.level().dimension() == Level.END) text = y + "` Space";
                else if (minecraft.player.level().dimension() == Level.NETHER) text = y + "` Underworld";
                else {
                    if (y > 320) text = y + "` Space";
                    else if (y > 30) text = y + "` Surface";
                    else if (y == 0) text = "Level Underground";
                    else if (y < -64) text = y + "` Underworld";
                    else if (y < -0) text = y + "` Caverns";
                    else text = y + "` Underground";
                }
                int width = graphics.guiWidth();
                int textWidth = minecraft.font.width(text);
                int x = width - textWidth - 10;
                graphics.drawString(minecraft.font, text, x, 15, 0xffffff);
            }
        }
    }
}
