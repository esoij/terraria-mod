package esoij.terrariamod.data.advancements.packs;

import esoij.terrariamod.resources.ResourceLocationHelper;
import esoij.terrariamod.tags.ModItemTags;
import esoij.terrariamod.world.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }
    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> writer) {
        generateCollectorAdvancements(writer);
    }
    public void generateCollectorAdvancements(Consumer<AdvancementHolder> writer) {
        AdvancementHolder root = root(writer);
        AdvancementHolder timber = timber(writer, root);

        obtain_hammer(writer, timber);
    }
    public AdvancementHolder root(Consumer<AdvancementHolder> writer) {
        return Advancement.Builder.advancement()
                .display(ModItems.COLLECTOR,
                        Component.translatable("advancements.collector.root.title"),
                        Component.translatable("advancements.collector.root.description"),
                        ResourceLocationHelper.parse("textures/gui/advancements/backgrounds/stone.png"),
                        AdvancementType.TASK,
                        false,
                        false,
                        false)
                .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                .save(writer, "collector/root");
    }
    public AdvancementHolder timber(Consumer<AdvancementHolder> writer, AdvancementHolder root) {
        return Advancement.Builder.advancement()
                .parent(root)
                .display(ModItems.TIMBER,
                        Component.translatable("advancements.collector.timber.title"),
                        Component.translatable("advancements.collector.timber.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("get_wood", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ModItemTags.WOOD)))
                .save(writer, "collector/timber");
    }
    public void obtain_hammer(Consumer<AdvancementHolder> writer, AdvancementHolder timber) {
        Advancement.Builder.advancement()
                .parent(timber)
                .display(ModItems.OBTAIN_HAMMER,
                        Component.translatable("advancements.collector.obtain_hammer.title"),
                        Component.translatable("advancements.collector.obtain_hammer.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("get_hammer", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ModItemTags.HAMMERS)))
                .save(writer, "collector/obtain_hammer");
    }
}
