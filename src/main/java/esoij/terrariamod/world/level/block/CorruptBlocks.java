package esoij.terrariamod.world.level.block;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public interface CorruptBlocks {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, Block>builder()
                    .put(ModBlocks.STONE,       ModBlocks.EBONSTONE)
                    .put(ModBlocks.GRASS,       ModBlocks.CORRUPT_GRASS)
                    .put(ModBlocks.BEACH_GRASS, ModBlocks.CORRUPT_GRASS)
                    .put(ModBlocks.TALL_GRASS,  ModBlocks.CORRUPT_PLANTS)
                    .put(ModBlocks.MUSHROOM,    ModBlocks.VILE_MUSHROOM)
                    .build()
    );
    static Optional<Block> getNext(Block block) {
        return Optional.ofNullable((Block)((BiMap<?, ?>)NEXT_BY_BLOCK.get()).get(block));
    }
    default Optional<BlockState> getNext(BlockState state) {
        return getNext(state.getBlock()).map(block -> block.withPropertiesOf(state));
    }
}
