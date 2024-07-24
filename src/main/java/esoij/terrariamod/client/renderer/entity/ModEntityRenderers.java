package esoij.terrariamod.client.renderer.entity;

import esoij.terrariamod.world.entity.ModEntityType;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class ModEntityRenderers extends EntityRenderers {
    public static void init() {
        register(ModEntityType.ANGRY_BONES, AngryBonesRenderer::new);
        register(ModEntityType.BLUE_SLIME, BlueSlimeRenderer::new);
        register(ModEntityType.GREEN_SLIME, GreenSlimeRenderer::new);
        register(ModEntityType.DUNGEON_SLIME, DungeonSlimeRenderer::new);
        register(ModEntityType.PINKY, PinkyRenderer::new);
    }
}
