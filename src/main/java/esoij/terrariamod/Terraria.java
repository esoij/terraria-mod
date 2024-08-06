package esoij.terrariamod;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.logging.LogUtils;
import esoij.terrariamod.commands.ModCommands;
import esoij.terrariamod.network.protocol.game.ModGameProtocols;
import esoij.terrariamod.stats.ModStats;
import esoij.terrariamod.tags.ModItemTags;
import esoij.terrariamod.world.effect.ModMobEffects;
import esoij.terrariamod.world.entity.ModEntityType;
import esoij.terrariamod.world.entity.ModSpawnPlacements;
import esoij.terrariamod.world.entity.ai.attributes.ModDefaultAttributes;
import esoij.terrariamod.world.inventory.ModMenuType;
import esoij.terrariamod.world.item.ModCreativeModeTabs;
import esoij.terrariamod.world.item.ModItems;
import esoij.terrariamod.world.item.crafting.ModRecipeSerializer;
import esoij.terrariamod.world.item.crafting.ModRecipeType;
import esoij.terrariamod.world.level.biome.ModBiomes;
import esoij.terrariamod.world.level.block.ModBlockTypes;
import esoij.terrariamod.world.level.block.entity.ModBlockEntityType;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;

// (20/(4+item_attack_speed))/20 is the amount of time in seconds it takes for weapon to charge up
public class Terraria implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LogUtils.getLogger();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.init();
		ModCreativeModeTabs.init();
		ModMobEffects.init();
		ModStats.init();
		ModBlockTypes.init();
		ModMenuType.init();
		ModRecipeType.init();
		ModRecipeSerializer.init();
		ModBiomes.init();
		ModItemTags.init();
		ModEntityType.init();
		ModSpawnPlacements.init();
		ModCommands.init();
		ModGameProtocols.init();
		ModDefaultAttributes.init();
		CommandSyntaxException.ENABLE_COMMAND_STACK_TRACES = true;
		LOGGER.info("{}", this);
		ModBlockEntityType.init();
    }
}