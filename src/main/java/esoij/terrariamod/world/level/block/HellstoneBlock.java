package esoij.terrariamod.world.level.block;

import com.mojang.serialization.MapCodec;
import esoij.terrariamod.world.level.biome.ModBiomes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class HellstoneBlock extends MeteoriteBlock {
    public static final MapCodec<? extends HellstoneBlock> CODEC = simpleCodec(HellstoneBlock::new);
    @Override
    public MapCodec<? extends HellstoneBlock> codec() {
        return CODEC;
    }
    public HellstoneBlock(Properties properties) {
        super(properties);
    }
    @Override
    public void destroy(LevelAccessor level, BlockPos pos, BlockState state) {
        if (level.getBiome(pos).is(ModBiomes.UNDERWORLD) || level.getBiome(pos).is(ModBiomes.UNDERWORLD_FOREST)) level.setBlock(pos, Blocks.LAVA.defaultBlockState(), 1 | 2);
    }
}
