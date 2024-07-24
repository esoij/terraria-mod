package esoij.terrariamod.world.level.block;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.function.Supplier;

public interface CrimsonBlocks {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, Block>builder()
                    .put(ModBlocks.SAND, ModBlocks.CRIMSAND)
                    .build()
    );
    static Optional<Block> getNext(Block block) {
        return Optional.ofNullable((Block)((BiMap<?, ?>)NEXT_BY_BLOCK.get()).get(block));
    }
    default Optional<BlockState> getNext(BlockState state) {
        return getNext(state.getBlock()).map(block -> block.withPropertiesOf(state));
    }
}
