package esoij.terrariamod.mixin.world.level.storage;

import esoij.terrariamod.access.world.level.storage.WorldDataAccess;
import esoij.terrariamod.world.level.WorldType;
import net.minecraft.world.level.storage.WorldData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(WorldData.class)
public interface WorldDataMixin extends WorldDataAccess {
    @Override
    @Unique
    WorldType getWorldType();
    @Override
    @Unique
    void setWorldType(WorldType worldType);
}
