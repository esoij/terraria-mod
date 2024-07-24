package esoij.terrariamod.mixin.client.multiplayer;

import esoij.terrariamod.access.client.multiplayer.ClientLevelAccess;
import esoij.terrariamod.access.world.level.LevelAccess;
import esoij.terrariamod.world.level.WorldType;
import org.spongepowered.asm.mixin.Unique;

public class ClientLevelMixin implements ClientLevelAccess {
    @Override
    @Unique
    public WorldType getWorldType() {
        return ((LevelAccess)this).getWorldType();
    }
    @Override
    @Unique
    public void setWorldType(WorldType worldType) {
        ((LevelAccess)this).setWorldType(worldType);
    }
}
