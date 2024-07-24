package esoij.terrariamod.client.renderer;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

public class HealthAndArmourOverlay {
    public static void renderOverlay(GuiGraphics graphics, DeltaTracker tracker) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player != null) {
            String text = player.getHealth() + "/" + player.getMaxHealth();
            int width = graphics.guiWidth();
            int textWidth = minecraft.font.width(text);
            int x = width - textWidth - 10;
            graphics.drawString(minecraft.font, "", x, 15, 0xffffff);
            String text2 = "" + player.getArmorValue();
            int textWidth2 = minecraft.font.width(text2);
            int x2 = width - textWidth2 - 10;
            graphics.drawString(minecraft.font, "", x2, 15, 0xffffff);
        }
    }
}
