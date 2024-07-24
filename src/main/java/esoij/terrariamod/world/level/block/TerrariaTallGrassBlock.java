package esoij.terrariamod.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TerrariaTallGrassBlock extends TallGrassBlock {
    public TerrariaTallGrassBlock(Properties properties) {
        super(properties);
    }
    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return false;
    }
}
