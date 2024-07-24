package esoij.terrariamod.mixin.world;

import net.minecraft.world.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Container.class)
public interface ContainerMixin {
    /**
     * @author
     * esoij
     * @reason
     * max stack size -> 9999
     */
    @Overwrite
    default int getMaxStackSize() {
        return 9999;
    }
}
