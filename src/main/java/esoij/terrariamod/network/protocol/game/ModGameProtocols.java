package esoij.terrariamod.network.protocol.game;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class ModGameProtocols {
    public static void init() {
        PayloadTypeRegistry.playS2C().register(ModGamePacketTypes.CLIENTBOUND_CHANGE_WORLD_TYPE, ClientboundChangeWorldTypePacket.STREAM_CODEC);
    }
}
