package esoij.terrariamod.server.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import esoij.terrariamod.access.server.MinecraftServerAccess;
import esoij.terrariamod.access.world.level.LevelAccess;
import esoij.terrariamod.access.world.level.storage.WorldDataAccess;
import esoij.terrariamod.world.level.WorldType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;

public class WorldTypeCommand {
    private static final DynamicCommandExceptionType ERROR_ALREADY_DIFFICULT = new DynamicCommandExceptionType(
            object -> Component.translatableEscape("commands.world_type.failure", object)
    );
    public static LiteralArgumentBuilder register(CommandDispatcher<CommandSourceStack> dispatcher) {
        LiteralArgumentBuilder<CommandSourceStack> literalArgumentBuilder = Commands.literal("worldtype");

        for(WorldType worldType : WorldType.values()) {
            literalArgumentBuilder.then(Commands.literal(worldType.getKey()).executes(commandContext -> setDifficulty(commandContext.getSource(), worldType)));
        }

        return dispatcher.register(literalArgumentBuilder.requires(commandSourceStack -> commandSourceStack.hasPermission(2)).executes(commandContext -> {
            WorldType worldType = (((LevelAccess)commandContext.getSource().getLevel()).getWorldType());
            commandContext.getSource().sendSuccess(() -> Component.translatable("commands.world_type.query", worldType.getDisplayName()), false);
            return worldType.getId();
        })).createBuilder();
    }
    public static int setDifficulty(CommandSourceStack source, WorldType worldType) throws CommandSyntaxException {
        MinecraftServer minecraftServer = source.getServer();
        if ((((WorldDataAccess)minecraftServer.getWorldData()).getWorldType()) == worldType) {
            throw ERROR_ALREADY_DIFFICULT.create(worldType.getKey());
        } else {
            ((MinecraftServerAccess)minecraftServer).setWorldType(worldType, true);
            source.sendSuccess(() -> Component.translatable("commands.world_type.success", worldType.getDisplayName()), true);
            return worldType.getId();
        }
    }
}
