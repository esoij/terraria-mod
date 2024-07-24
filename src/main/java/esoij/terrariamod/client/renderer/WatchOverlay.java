package esoij.terrariamod.client.renderer;

import dev.emi.trinkets.api.TrinketsApi;
import esoij.terrariamod.tags.ModItemTags;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.player.Inventory;

import java.util.concurrent.atomic.AtomicBoolean;

public class WatchOverlay {
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
                if (inventory.getItem(i).is(ModItemTags.DISPLAYS_TIME)) shouldShowOverlay.set(true);
            }
            if (shouldShowOverlay.get()) {
                String text = getString(minecraft);
                int width = graphics.guiWidth();
                int textWidth = minecraft.font.width(text);
                int x = width - textWidth - 10;
                graphics.drawString(minecraft.font, text, x, 5, 0xffffff);
            }
        }
    }

    private static String getString(Minecraft minecraft) {
        ClientLevel level = minecraft.level;
        final long rawTime = level == null ? -1 : level.getDayTime() % 24000;
        long timeL = rawTime == -1 ? -1 : (int)(30000 + rawTime) % 24000;
        int seconds = (int) timeL / 20;
        int hours = seconds / 50;
        int minutes = (int) Math.floor((timeL % 1000) / 16.66D);
        String timeSuffix = timeL < 12000 ? "AM" : "PM";
        return String.format("%02d:%02d %s", hours % 12, minutes == 60 ? 59 : minutes, timeSuffix);
    }
}
