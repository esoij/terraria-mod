package esoij.terrariamod.client.model.geom;

import esoij.terrariamod.client.model.*;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.geom.LayerDefinitions;

public class ModLayerDefinitions extends LayerDefinitions {
    public static void init() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BLUE_SLIME, BlueSlimeModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GREEN_SLIME, GreenSlimeModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DUNGEON_SLIME, DungeonSlimeModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PINKY, PinkyModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ANGRY_BONES, AngryBonesModel::createBodyLayer);
    }
}
