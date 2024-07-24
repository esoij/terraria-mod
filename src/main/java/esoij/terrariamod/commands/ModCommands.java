package esoij.terrariamod.commands;

import esoij.terrariamod.server.commands.WorldTypeCommand;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

@SuppressWarnings("unchecked")
public class ModCommands {
    public static void init() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> {
            dispatcher.register(WorldTypeCommand.register(dispatcher));
        }));
    }
}
