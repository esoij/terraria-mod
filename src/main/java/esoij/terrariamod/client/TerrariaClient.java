package esoij.terrariamod.client;

import esoij.terrariamod.client.events.ModEvents;
import esoij.terrariamod.client.gui.screens.ModMenuScreens;
import esoij.terrariamod.client.model.geom.ModLayerDefinitions;
import esoij.terrariamod.client.model.geom.ModModelLayers;
import esoij.terrariamod.client.multiplayer.ModClientPacketListener;
import esoij.terrariamod.client.renderer.ModItemBlockRenderTypes;
import esoij.terrariamod.client.renderer.accessories.AccessoryRenderers;
import esoij.terrariamod.client.renderer.entity.ModEntityRenderers;
import esoij.terrariamod.network.protocol.game.ModGamePacketTypes;
import esoij.terrariamod.world.level.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

public class TerrariaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModMenuScreens.init();
        ModEvents.init();
        ModEntityRenderers.init();
        ModModelLayers.init();
        ModLayerDefinitions.init();
        ModItemBlockRenderTypes.init();
        ModClientPacketListener.init();
        ModOptions.init();
        AccessoryRenderers.init();
    }
}
