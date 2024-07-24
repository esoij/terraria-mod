package esoij.terrariamod.world.level.material;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ModMapColor {
    public static final int totalColours = 42;
    public Supplier<BiMap<Block, ModMapColor>> BLOCK_MAP_COLOURS = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, ModMapColor>builder()
                    .put(ModBlocks.AIR,                          NONE)
                    .put(ModBlocks.DIRT,                         DIRT)
                    .put(ModBlocks.STONE,                        STONE)
                    .put(ModBlocks.GRASS,                        GRASS)
                    .put(ModBlocks.BEACH_GRASS,                  GRASS)
                    .put(ModBlocks.TALL_GRASS,                   TALL_GRASS)
                    .put(ModBlocks.MUSHROOM,                     TALL_GRASS)
                    .put(ModBlocks.TORCH,                        TORCH)
                    .put(ModBlocks.TREE_LOG,                     DIRT)
                    .put(ModBlocks.GLOWING_MUSHROOM_TREE_LOG,    DIRT)
                    .put(ModBlocks.TREE_LEAVES,                  GRASS)
                    .put(ModBlocks.GLOWING_MUSHROOM_TREE_LEAVES, MUSHROOM_GRASS)
                    .put(ModBlocks.IRON,                         IRON)
                    .put(ModBlocks.COPPER,                       COPPER)
                    .put(ModBlocks.GOLD,                         GOLD)
                    .put(ModBlocks.SILVER,                       SILVER)
                    .put(ModBlocks.WORK_BENCH,                   WORK_BENCH)
                    .put(ModBlocks.FOREST_SAPLING,               SAPLING)
                    .put(ModBlocks.DEMONITE,                     DEMONITE)
                    .put(ModBlocks.CORRUPT_GRASS,                CORRUPT_GRASS)
                    .put(ModBlocks.CORRUPT_PLANTS,               CORRUPT_PLANTS)
                    .put(ModBlocks.EBONSTONE,                    EBONSTONE)
                    .put(ModBlocks.WOOD_BLOCK,                   WOOD_BLOCK)
                    .put(ModBlocks.METEORITE,                    METEORITE)
                    .put(ModBlocks.GRAY_BRICK,                   GRAY_BRICK)
                    .put(ModBlocks.RED_BRICK,                    RED_BRICK)
                    .put(ModBlocks.CLAY_BLOCK,                   CLAY_BLOCK)
                    .put(ModBlocks.BLUE_DUNGEON_BRICK,           BLUE_DUNGEON_BRICK)
                    .put(ModBlocks.GREEN_DUNGEON_BRICK,          GREEN_DUNGEON_BRICK)
                    .put(ModBlocks.PINK_DUNGEON_BRICK,           PINK_DUNGEON_BRICK)
                    .put(ModBlocks.GOLD_BRICK,                   GOLD)
                    .put(ModBlocks.SILVER_BRICK,                 SILVER)
                    .put(ModBlocks.SAND,                         SAND)
                    .put(ModBlocks.MUD,                          MUD)
                    .put(ModBlocks.JUNGLE_GRASS,                 JUNGLE_GRASS)
                    .put(ModBlocks.AMETHYST,                     AMETHYST)
                    .put(ModBlocks.DIAMOND,                      DIAMOND)
                    .put(ModBlocks.MUSHROOM_GRASS,               MUSHROOM_GRASS)
                    .put(ModBlocks.MUSHROOM_PLANTS,              MUSHROOM_PLANTS)
                    .put(ModBlocks.SILT,                         SILT)
                    .put(ModBlocks.SNOW_BLOCK,                   SNOW_BLOCK)
                    .put(ModBlocks.RED_STUCCO,                   RED_STUCCO)
                    .put(ModBlocks.YELLOW_STUCCO,                YELLOW_STUCCO)
                    .put(ModBlocks.GRAY_STUCCO,                  GRAY_STUCCO)
                    .put(ModBlocks.ICE_BLOCK,                    ICE_BLOCK)
                    .put(ModBlocks.AMETHYST_GEM,                 GEM)
                    .put(ModBlocks.DIAMOND_GEM,                  GEM)
                    .put(ModBlocks.MUSHROOM_BLOCK,               MUSHROOM_PLANTS)
                    .put(ModBlocks.SLUSH,                        SLUSH)
                    .put(ModBlocks.CRIMSAND,                     CRIMSAND)
                    .put(ModBlocks.SANDSTONE,                    SANDSTONE)
                    .put(ModBlocks.CRIMSON_SANDSTONE,            CRIMSON_SANDSTONE)
                    .build()
    );
    public static final ModMapColor[] MATERIAL_COLORS =   new ModMapColor[totalColours];
    public static final ModMapColor NONE =                new ModMapColor(0,         0);
    public static final ModMapColor TALL_GRASS =          new ModMapColor(4,   1483610);
    public static final ModMapColor GRASS =               new ModMapColor(3,   1552973);
    public static final ModMapColor CRIMSAND =            new ModMapColor(32,  2827297);
    public static final ModMapColor BLUE_DUNGEON_BRICK =  new ModMapColor(18,  3556698);
    public static final ModMapColor CRIMSON_SANDSTONE =   new ModMapColor(34,  3682602);
    public static final ModMapColor GREEN_DUNGEON_BRICK = new ModMapColor(19,  4543028);
    public static final ModMapColor MUD =                 new ModMapColor(22,  4995132);
    public static final ModMapColor MUSHROOM_GRASS =      new ModMapColor(24,  5007827);
    public static final ModMapColor DEMONITE =            new ModMapColor(9,   5328522);
    public static final ModMapColor METEORITE =           new ModMapColor(14,  5654341);
    public static final ModMapColor SILT =                new ModMapColor(25,  5724257);
    public static final ModMapColor PINK_DUNGEON_BRICK =  new ModMapColor(20,  5781585);
    public static final ModMapColor SLUSH =               new ModMapColor(31,  5795187);
    public static final ModMapColor EBONSTONE =           new ModMapColor(12,  5917289);
    public static final ModMapColor CORRUPT_PLANTS =      new ModMapColor(11,  6578100);
    public static final ModMapColor DIAMOND =             new ModMapColor(40,  6790819);
    public static final ModMapColor STONE =               new ModMapColor(2,   6908265);
    public static final ModMapColor AMETHYST =            new ModMapColor(38,  7548809);
    public static final ModMapColor IRON =                new ModMapColor(5,   7557954);
    public static final ModMapColor CORRUPT_GRASS =       new ModMapColor(10,  7631288);
    public static final ModMapColor JUNGLE_GRASS =        new ModMapColor(23,  7778583);
    public static final ModMapColor GRAY_BRICK =          new ModMapColor(15,  7829367);
    public static final ModMapColor ICE_BLOCK =           new ModMapColor(30,  7840191);
    public static final ModMapColor CLAY_BLOCK =          new ModMapColor(17,  7881528);
    public static final ModMapColor COPPER =              new ModMapColor(6,   8140562);
    public static final ModMapColor DIRT =                new ModMapColor(1,   8149054);
    public static final ModMapColor SAPLING =             new ModMapColor(37,  8806211);
    public static final ModMapColor WOOD_BLOCK =          new ModMapColor(13,  9200453);
    public static final ModMapColor GRAY_STUCCO =         new ModMapColor(29,  9211265);
    public static final ModMapColor RED_BRICK =           new ModMapColor(16,  9777968);
    public static final ModMapColor MUSHROOM_PLANTS =     new ModMapColor(41,  9867371);
    public static final ModMapColor GOLD =                new ModMapColor(7,  10061587);
    public static final ModMapColor SILVER =              new ModMapColor(8,  10068129);
    public static final ModMapColor YELLOW_STUCCO =       new ModMapColor(28, 10325325);
    public static final ModMapColor WORK_BENCH =          new ModMapColor(35, 10384731);
    public static final ModMapColor SANDSTONE =           new ModMapColor(33, 10708544);
    public static final ModMapColor SNOW_BLOCK =          new ModMapColor(26, 11453383);
    public static final ModMapColor RED_STUCCO =          new ModMapColor(27, 12940392);
    public static final ModMapColor TORCH =               new ModMapColor(36, 13743618);
    public static final ModMapColor GEM =                 new ModMapColor(39, 13828307);
    public static final ModMapColor SAND =                new ModMapColor(21, 13874222);
    public final int col;
    public final int id;
    public ModMapColor(int id, int col) {
        if (id >= 0 && id <= totalColours) {
            this.id = id;
            this.col = col;
            MATERIAL_COLORS[id] = this;
        } else throw new IndexOutOfBoundsException("Mod Map colour ID must be between 0 and " + totalColours + " (inclusive)");
    }
}
