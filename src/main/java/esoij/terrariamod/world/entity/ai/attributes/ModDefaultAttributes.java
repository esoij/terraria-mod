package esoij.terrariamod.world.entity.ai.attributes;

import esoij.terrariamod.world.entity.*;
import esoij.terrariamod.world.entity.BlueSlime;
import esoij.terrariamod.world.entity.DungeonSlime;
import esoij.terrariamod.world.entity.GreenSlime;
import esoij.terrariamod.world.entity.Pinky;
import esoij.terrariamod.world.entity.monster.AngryBones;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;

public class ModDefaultAttributes extends DefaultAttributes {
    public static void init() {
        FabricDefaultAttributeRegistry.register(ModEntityType.BLUE_SLIME, BlueSlime.createEntityAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntityType.GREEN_SLIME, GreenSlime.createEntityAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntityType.DUNGEON_SLIME, DungeonSlime.createEntityAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntityType.PINKY, Pinky.createEntityAttributes().build());
        FabricDefaultAttributeRegistry.register(ModEntityType.ANGRY_BONES, AngryBones.createAttributes().build());
    }
}
