package esoij.terrariamod.client.multiplayer;

import esoij.terrariamod.access.client.multiplayer.ClientLevelAccess;
import esoij.terrariamod.network.protocol.game.ModGamePacketTypes;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class ModClientPacketListener {
    public static void init() {
        ClientPlayNetworking.registerGlobalReceiver(ModGamePacketTypes.CLIENTBOUND_CHANGE_WORLD_TYPE, ((payload, context) -> ((ClientLevelAccess)context.client().level).setWorldType(payload.worldType())));
    }
}
