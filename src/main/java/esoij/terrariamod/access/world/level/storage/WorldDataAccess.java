package esoij.terrariamod.access.world.level.storage;

import esoij.terrariamod.world.level.WorldType;

public interface WorldDataAccess {
    WorldType getWorldType();
    void setWorldType(WorldType worldType);
}
