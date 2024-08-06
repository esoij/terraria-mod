package esoij.terrariamod.data.loot.packs;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.concurrent.CompletableFuture;

import static esoij.terrariamod.world.level.block.ModBlocks.*;

public class ModBlockLoot extends FabricBlockLootTableProvider {
    public ModBlockLoot(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }
    @Override
    public void generate() {
        this.add(AMETHYST, block -> this.createSingleItemTableWithSilkTouch(block, AMETHYST_GEM));
        this.dropSelf(AMETHYST_GEM);
        this.dropSelf(ANGRY_BONES_BANNER);
        this.dropSelf(ASH);
        this.add(ASH_GRASS, block -> this.createSingleItemTableWithSilkTouch(block, ASH));
        this.dropSelf(ASH_WOOD);
        this.add(BEACH_GRASS, block -> this.createSingleItemTableWithSilkTouch(block, DIRT));
        this.dropSelf(BLUE_DUNGEON_BRICK);
        this.dropSelf(BLUE_SLIME_BANNER);
        this.add(BOREAL_SAPLING, block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        this.add(BOREAL_TREE_LEAVES, block -> this.createLeavesDrops(block, FOREST_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(BOREAL_TREE_LOG, block -> this.createSingleItemTableWithSilkTouch(block, BOREAL_WOOD));
        this.dropSelf(BOREAL_WOOD);
        this.dropSelf(BOTTLE);
        this.add(CHEST, this::createNameableBlockEntityTable);
        this.dropSelf(CLAY_BLOCK);
        this.dropSelf(COPPER);
        this.dropSelf(COPPER_BAR);
        this.dropSelf(COPPER_BRICK);
        this.dropSelf(COPPER_COIN_PILE);
        this.add(CORRUPT_GRASS, block -> this.createSingleItemTableWithSilkTouch(block, DIRT));
        this.dropWhenSilkTouch(CORRUPT_PLANTS);
        this.dropSelf(CRIMSAND);
        this.dropSelf(CRIMSON_SANDSTONE);
        this.dropSelf(DEMONITE);
        this.add(DIAMOND, block -> this.createSingleItemTableWithSilkTouch(block, DIAMOND_GEM));
        this.dropSelf(DIAMOND_GEM);
        this.dropSelf(DIRT);
        this.dropSelf(DUNGEON_SLIME_BANNER);
        this.dropSelf(EBONSTONE);
        this.add(EMERALD, block -> this.createSingleItemTableWithSilkTouch(block, EMERALD_GEM));
        this.dropSelf(EMERALD_GEM);
        this.add(FOREST_SAPLING, block -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        this.add(GLOWING_MUSHROOM_TREE_LEAVES, block -> this.createLeavesDrops(block, MUSHROOM_PLANTS, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(GLOWING_MUSHROOM_TREE_LOG, block -> this.createSingleItemTableWithSilkTouch(block, MUSHROOM_PLANTS));
        this.dropSelf(GOLD);
        this.dropSelf(GOLD_BAR);
        this.dropSelf(GOLD_BRICK);
        this.add(GOLD_CHEST, this::createNameableBlockEntityTable);
        this.dropSelf(GOLD_COIN_PILE);
        this.add(GRASS, block -> this.createSingleItemTableWithSilkTouch(block, DIRT));
        this.dropSelf(GRANITE);
        this.dropSelf(GRAY_BRICK);
        this.dropSelf(GRAY_STUCCO);
        this.dropSelf(GREEN_DUNGEON_BRICK);
        this.dropSelf(GREEN_SLIME_BANNER);
        this.dropSelf(HELLSTONE);
        this.dropSelf(ICE_BLOCK);
        this.dropSelf(IRON);
        this.dropSelf(IRON_BAR);
        this.add(JUNGLE_GRASS, block -> this.createSingleItemTableWithSilkTouch(block, MUD));
        this.add(JUNGLE_TREE_LEAVES, block -> this.createLeavesDrops(block, FOREST_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(JUNGLE_TREE_LOG, block -> this.createSingleItemTableWithSilkTouch(block, RICH_MAHOGANY));
        this.add(LOCKED_GOLD_CHEST, this::createNameableBlockEntityTable);
        this.dropSelf(MARBLE);
        this.dropSelf(METEORITE);
        this.dropSelf(MUD);
        this.dropSelf(MUSHROOM);
        this.dropSelf(MUSHROOM_BLOCK);
        this.add(MUSHROOM_GRASS, block -> this.createSingleItemTableWithSilkTouch(block, MUD));
        this.add(MUSHROOM_PLANTS, block -> this.createSingleItemTableWithSilkTouch(block, MUSHROOM_BLOCK));
        this.add(PALM_TREE_LEAVES, block -> this.createLeavesDrops(block, FOREST_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(PALM_TREE_LOG, block -> this.createSingleItemTableWithSilkTouch(block, PALM_WOOD));
        this.dropSelf(PALM_WOOD);
        this.dropSelf(PINK_DUNGEON_BRICK);
        this.dropSelf(PINK_SLIME_BLOCK);
        this.dropSelf(PINKY_BANNER);
        this.dropSelf(RED_BRICK);
        this.dropSelf(RED_STUCCO);
        this.dropSelf(RICH_MAHOGANY);
        this.dropSelf(SAND);
        this.dropSelf(SILT);
        this.dropSelf(SILVER);
        this.dropSelf(SILVER_BAR);
        this.dropSelf(SILVER_BRICK);
        this.dropSelf(SILVER_COIN_PILE);
        this.dropSelf(SLUSH);
        this.dropSelf(SNOW_BLOCK);
        this.dropSelf(SPIKES);
        this.dropSelf(STONE);
        this.dropWhenSilkTouch(TALL_GRASS);
        this.add(TREE_ASH_LEAVES, block -> this.createLeavesDrops(block, FOREST_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(TREE_ASH_LOG, block -> this.createSingleItemTableWithSilkTouch(block, ASH_WOOD));
        this.add(TREE_LEAVES, block -> this.createLeavesDrops(block, FOREST_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(TREE_LOG, block -> this.createSingleItemTableWithSilkTouch(block, WOOD_BLOCK));
        this.dropSelf(VILE_MUSHROOM);
        this.add(WOODEN_DOOR, this::createDoorTable);
        this.dropSelf(WOOD_BLOCK);
        this.dropSelf(WORK_BENCH);
        this.dropSelf(YELLOW_STUCCO);
    }
}
