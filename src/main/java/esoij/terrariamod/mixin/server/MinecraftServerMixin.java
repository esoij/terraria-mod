package esoij.terrariamod.mixin.server;

import esoij.terrariamod.access.server.MinecraftServerAccess;
import esoij.terrariamod.access.world.level.LevelAccess;
import esoij.terrariamod.network.protocol.game.ClientboundChangeWorldTypePacket;
import esoij.terrariamod.world.level.WorldType;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.WorldData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin implements MinecraftServerAccess {
    @Shadow protected abstract void updateMobSpawningFlags();
    @Shadow public abstract PlayerList getPlayerList();
    @Shadow public abstract Iterable<ServerLevel> getAllLevels();
    @Unique
    @Override
    public void setWorldType(WorldType worldType, boolean forced) {
        if (forced) {
            this.getAllLevels().forEach(level -> ((LevelAccess)level).setWorldType(worldType));
            this.updateMobSpawningFlags();
            this.getPlayerList().getPlayers().forEach(this::sendWorldTypeUpdate);
        }
    }
    @Unique
    private void sendWorldTypeUpdate(ServerPlayer player) {
        Level level = player.level();
        ServerPlayNetworking.send(player, new ClientboundChangeWorldTypePacket(((LevelAccess)level).getWorldType()));
    }
}
