package esoij.terrariamod.world.level.block;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.MapCodec;
import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BlockTypes;
import org.slf4j.Logger;

import static esoij.terrariamod.ModSharedConstants.IDE;

public class ModBlockTypes extends BlockTypes {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final MapCodec<? extends Block> CORRUPT_SPREADING = register("corrupt_spreading", CorruptSpreadingBlock.CODEC);
    public static final MapCodec<? extends Block> CORRUPT_SPREADING_GRASS = register("corrupt_spreading_grass", CorruptSpreadingGrassBlock.CODEC);
    public static final MapCodec<? extends Block> CORRUPT_SPREADING_TALL_GRASS = register("corrupt_spreading_tall_grass", CorruptSpreadingTallGrassBlock.CODEC);
    public static final MapCodec<? extends Block> CRIMSON_SPREADING = register("crimson_spreading", CrimsonSpreadingBlock.CODEC);
    public static final MapCodec<? extends Block> CRIMSON_SPREADING_COLORED_FALLING = register("crimson_spreading_colored_falling", CrimsonSpreadingColoredFallingBlock.CODEC);
    public static final MapCodec<? extends Block> HELLSTONE = register("hellstone", HellstoneBlock.CODEC);
    public static final MapCodec<? extends Block> METEORITE = register("meteorite", MeteoriteBlock.CODEC);
    public static final MapCodec<? extends Block> TERRARIA_SAPLING = register("terraria_sapling", TerrariaSaplingBlock.CODEC);
    public static final MapCodec<? extends Block> MUSHROOM_SPREADING = register("mushroom_spreading", MushroomSpreadingBlock.CODEC);
    public static final MapCodec<? extends Block> MUSHROOM_SPREADING_GRASS = register("mushroom_spreading_grass", MushroomSpreadingGrassBlock.CODEC);
    public static final MapCodec<? extends Block> SPIKES = register("spikes", SpikesBlock.CODEC);
    public static final MapCodec<? extends Block> TERRARIA_BANNER = register("terraria_banner", TerrariaBannerBlock.CODEC);
    public static final MapCodec<? extends Block> TERRARIA_CHEST = register("terraria_chest", TerrariaChestBlock.CODEC);
    public static final MapCodec<? extends Block> TERRARIA_CRAFTER = register("terraria_crafter", TerrariaCrafterBlock.CODEC);
    public static final MapCodec<? extends Block> TERRARIA_GRASS = register("terraria_grass", TerrariaGrassBlock.CODEC);
    public static final MapCodec<? extends Block> TERRARIA_TORCH = register("terraria_torch", TerrariaTorchBlock.CODEC);
    public static MapCodec<? extends Block> register(String key, MapCodec<? extends Block> block) {
        if (IDE) LOGGER.info("Registering {}, codec: {}", key, block);
        return Registry.register(BuiltInRegistries.BLOCK_TYPE, ResourceLocationHelper.parse(key), block);
    }
    public static void init() {
        if (IDE) LOGGER.info("Initializing Mod Block Types...");
    }
}
