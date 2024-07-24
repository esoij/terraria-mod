package esoij.terrariamod.data.tags;

import esoij.terrariamod.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

import static esoij.terrariamod.world.item.ModItems.*;

public class ModItemTagsProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }
    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.AXES).add(IRON_AXE);
        getOrCreateTagBuilder(ItemTags.BREAKS_DECORATED_POTS).addTag(ModItemTags.HAMMERS);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(COPPER_CHAINMAIL);
        getOrCreateTagBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES).add(IRON_PICKAXE);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).addTag(ModItemTags.HAMMERS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(COPPER_GREAVES);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(COPPER_HELMET);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(COPPER_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE).addTag(ModItemTags.HAMMERS);
        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(ModItemTags.HAMMERS);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(IRON_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SWORDS).add(FIERY_GREATSWORD, IRON_BROADSWORD, IRON_SHORTSWORD, WOODEN_SWORD);
        getOrCreateTagBuilder(ModItemTags.DISPLAYS_DEPTH).add(DEPTH_METER);
        getOrCreateTagBuilder(ModItemTags.DISPLAYS_TIME).add(COPPER_WATCH, GOLD_WATCH, SILVER_WATCH);
        getOrCreateTagBuilder(ModItemTags.HAMMERS).add(IRON_HAMMER);
        getOrCreateTagBuilder(ModItemTags.WOOD).add(ASH_WOOD, BOREAL_WOOD, PALM_WOOD, RICH_MAHOGANY, WOOD);
    }
}
