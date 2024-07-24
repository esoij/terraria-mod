package esoij.terrariamod.mixin.world.food;

import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import static esoij.terrariamod.ModSharedConstants.IDE;

@Mixin(FoodData.class)
public class FoodDataMixin {
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
    public void tick(Player player) {
        if (IDE && !removed) {
            LOGGER.info("Removed Hunger!");
            removed = true;
        }
    }
}
