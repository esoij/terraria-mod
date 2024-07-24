package esoij.terrariamod.network.protocol.game;

import esoij.terrariamod.world.level.WorldType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record ClientboundChangeWorldTypePacket(WorldType worldType) implements CustomPacketPayload {
    public static final StreamCodec<FriendlyByteBuf, ClientboundChangeWorldTypePacket> STREAM_CODEC = StreamCodec.composite(WorldType.STREAM_CODEC, ClientboundChangeWorldTypePacket::worldType, ClientboundChangeWorldTypePacket::new);
    @Override
    public Type<ClientboundChangeWorldTypePacket> type() {
        return ModGamePacketTypes.CLIENTBOUND_CHANGE_WORLD_TYPE;
    }
}
