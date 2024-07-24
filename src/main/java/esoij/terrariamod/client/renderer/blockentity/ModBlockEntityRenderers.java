package esoij.terrariamod.client.renderer.blockentity;

import esoij.terrariamod.world.level.block.entity.ModBlockEntityType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntityRenderers extends BlockEntityRenderers {
    public static void init() {
        register(ModBlockEntityType.TERRARIA_CHEST, ChestRenderer::new);
    }
}
