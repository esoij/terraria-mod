package esoij.terrariamod.world.level;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import java.util.function.IntFunction;

@SuppressWarnings("deprecation")
public enum WorldType implements StringRepresentable {
    PRE_HARDMODE(0, "pre_hardmode"),
    HARDMODE(1, "hardmode"),
    POST_PLANTERA(2, "post_plantera");
    public static final StringRepresentable.EnumCodec<WorldType> CODEC = StringRepresentable.fromEnum(WorldType::values);
    private static final IntFunction<WorldType> BY_ID = ByIdMap.continuous(WorldType::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
    public static final StreamCodec<ByteBuf, WorldType> STREAM_CODEC = new StreamCodec<ByteBuf, WorldType>() {
        @Override
        public WorldType decode(ByteBuf byteBuf) {
            return WorldType.readByteBuf(byteBuf);
        }

        @Override
        public void encode(ByteBuf byteBuf, WorldType worldType) {
            byteBuf.writeByte(worldType.getId());
        }
    };
    private final String key;
    private final int id;
    WorldType(final int id, final String key) {
        this.id = id;
        this.key = key;
    }
    public static WorldType readByteBuf(ByteBuf byteBuf) {
        return byId(byteBuf.readByte());
    }
    public static WorldType byId(int id) {
        return (WorldType)BY_ID.apply(id);
    }
    public int getId() {
        return this.id;
    }
    public Component getDisplayName() {
        return Component.translatable("world_type." + this.key);
    }
    @Override
    public String getSerializedName() {
        return key;
    }
    public String getKey() {
        return this.key;
    }
}
