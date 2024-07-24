package esoij.terrariamod.access.world.level;

import esoij.terrariamod.world.level.WorldType;

public interface LevelAccess {
    WorldType getWorldType();
    void setWorldType(WorldType worldType);
}
