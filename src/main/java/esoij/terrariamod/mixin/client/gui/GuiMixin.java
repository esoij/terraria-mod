package esoij.terrariamod.mixin.client.gui;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import static esoij.terrariamod.ModSharedConstants.IDE;

@Mixin(Gui.class)
public class GuiMixin {
    @Unique
    private boolean removed = false;
    @Unique
    private static final Logger LOGGER = LogUtils.getLogger();
    /**
     * @author
     * esoij
     * @reason
     * remove food
     */
    @Overwrite
    private void renderFood(GuiGraphics guiGraphics, Player player, int y, int x) {
        if (IDE && !removed) {
            LOGGER.info("Removed hunger bar!");
            removed = true;
        }
    }
}
