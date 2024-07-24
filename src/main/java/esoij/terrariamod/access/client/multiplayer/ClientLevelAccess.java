package esoij.terrariamod.access.client.multiplayer;

import esoij.terrariamod.world.level.WorldType;

public interface ClientLevelAccess {
    WorldType getWorldType();
    void setWorldType(WorldType worldType);
}
