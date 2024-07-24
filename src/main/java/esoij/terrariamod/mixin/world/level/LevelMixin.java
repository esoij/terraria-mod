package esoij.terrariamod.mixin.world.level;

import esoij.terrariamod.access.world.level.LevelAccess;
import esoij.terrariamod.world.level.WorldType;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Level.class)
public class LevelMixin implements LevelAccess {
    @Unique
    public WorldType worldType = WorldType.PRE_HARDMODE;
    @Override
    @Unique
    public WorldType getWorldType() {
        return this.worldType;
    }
    @Override
    @Unique
    public void setWorldType(WorldType worldType) {
        this.worldType = worldType;
    }
}
