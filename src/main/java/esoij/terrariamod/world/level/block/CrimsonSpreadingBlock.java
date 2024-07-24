package esoij.terrariamod.world.level.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;

public class CrimsonSpreadingBlock extends Block implements CrimsonBlocks {
    public static final MapCodec<? extends CrimsonSpreadingBlock> CODEC = simpleCodec(CrimsonSpreadingBlock::new);
    @Override
    public MapCodec<? extends CrimsonSpreadingBlock> codec() {
        return CODEC;
    }
    public CrimsonSpreadingBlock(Properties properties) {
        super(properties);
    }
    protected static boolean canBeGrass(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockPos blockPos = pos.above();
        BlockState blockState = levelReader.getBlockState(blockPos);
        if (blockState.is(Blocks.SNOW) && blockState.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else {
            int i = LightEngine.getLightBlockInto(levelReader, state, pos, blockState, blockPos, Direction.UP, blockState.getLightBlock(levelReader, blockPos));
            return i < levelReader.getMaxLightLevel();
        }
    }
    public static void replaceBlocks(ServerLevel level, BlockPos blockPos) {
        if (level.getBlockState(blockPos).is(ModBlocks.SAND)) level.setBlockAndUpdate(blockPos, ModBlocks.CRIMSAND.defaultBlockState());
    }
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextInt(10) == 1) {
            for (int i = 0; i < 4; ++i) {
                BlockPos blockPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                replaceBlocks(level, blockPos);
            }
        }
    }
}
