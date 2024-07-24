package esoij.terrariamod.world.level.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class MushroomSpreadingGrassBlock extends MushroomSpreadingBlock implements MushroomBlocks {
    public static final MapCodec<? extends MushroomSpreadingGrassBlock> CODEC = simpleCodec(MushroomSpreadingGrassBlock::new);
    @Override
    public MapCodec<? extends MushroomSpreadingGrassBlock> codec() {
        return CODEC;
    }
    public MushroomSpreadingGrassBlock(Properties properties) {
        super(properties);
    }
    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if (!canBeGrass(state, level, pos)) level.setBlockAndUpdate(pos, ModBlocks.MUD.defaultBlockState());
    }
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (canBeGrass(state, level, pos) && random.nextInt(10) == 1) for (int i = 0; i < 4; ++i) {
            BlockPos blockPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
            replaceBlocks(level, blockPos);
        }
    }
}
