package esoij.terrariamod.access.server;

import esoij.terrariamod.world.level.WorldType;

public interface MinecraftServerAccess {
    void setWorldType(WorldType worldType, boolean forced);
}
