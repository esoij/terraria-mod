package esoij.terrariamod.data;

import esoij.terrariamod.data.advancements.packs.ModAdvancementProvider;
import esoij.terrariamod.data.models.ModItemModelGenerators;
import esoij.terrariamod.data.recipes.packs.ModRecipeProvider;
import esoij.terrariamod.data.loot.packs.ModBlockLoot;
import esoij.terrariamod.data.registries.ModRegistries;
import esoij.terrariamod.data.tags.ModBlockTagsProvider;
import esoij.terrariamod.data.tags.ModEntityTypeTagsProvider;
import esoij.terrariamod.data.tags.ModItemTagsProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import org.jetbrains.annotations.Nullable;

public class TerrariaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModBlockLoot::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModItemModelGenerators::new);
		pack.addProvider(ModItemTagsProvider::new);
		pack.addProvider(ModEntityTypeTagsProvider::new);
		pack.addProvider(ModAdvancementProvider::new);
	}

	@Override
	public @Nullable String getEffectiveModId() {
		return "terraria";
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		ModRegistries.init(registryBuilder);
	}
}
