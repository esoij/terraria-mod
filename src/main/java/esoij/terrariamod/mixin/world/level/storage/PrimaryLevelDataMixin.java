package esoij.terrariamod.mixin.world.level.storage;

import esoij.terrariamod.access.world.level.storage.WorldDataAccess;
import esoij.terrariamod.world.level.WorldType;
import net.minecraft.world.level.storage.PrimaryLevelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(PrimaryLevelData.class)
public class PrimaryLevelDataMixin implements WorldDataAccess {
    private WorldType worldType;
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
