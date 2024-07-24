package esoij.terrariamod.network.protocol.game;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record ServerboundQuickBuffPacket() implements CustomPacketPayload {
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ModGamePacketTypes.SERVERBOUND_QUICK_BUFF;
    }
    //todo
}
