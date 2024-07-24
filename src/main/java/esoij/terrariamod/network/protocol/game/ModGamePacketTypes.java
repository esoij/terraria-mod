package esoij.terrariamod.network.protocol.game;

import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public class ModGamePacketTypes {
    public static final CustomPacketPayload.Type<ClientboundChangeWorldTypePacket> CLIENTBOUND_CHANGE_WORLD_TYPE = new CustomPacketPayload.Type<>(ResourceLocationHelper.parse("change_world_type"));
    public static final CustomPacketPayload.Type<ServerboundQuickBuffPacket> SERVERBOUND_QUICK_BUFF = new CustomPacketPayload.Type<>(ResourceLocationHelper.parse("quick_buff"));
}
