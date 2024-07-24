package esoij.terrariamod.world.entity;

import esoij.terrariamod.world.entity.monster.AngryBones;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

public class ModSpawnPlacements extends SpawnPlacements {
    public static void init() {
        register(ModEntityType.BLUE_SLIME, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BlueSlime::checkSlimeSpawnRules);
        register(ModEntityType.GREEN_SLIME, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GreenSlime::checkSlimeSpawnRules);
        register(ModEntityType.DUNGEON_SLIME, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DungeonSlime::checkSlimeSpawnRules);
        register(ModEntityType.PINKY, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Pinky::checkSlimeSpawnRules);
        register(ModEntityType.ANGRY_BONES, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AngryBones::checkMonsterSpawnRules);
    }
}
