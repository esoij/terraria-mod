package esoij.terrariamod.world.level.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.ToIntFunction;

public class TerrariaTorchBlock extends MultifaceBlock {
    public static final MapCodec<? extends TerrariaTorchBlock> CODEC = simpleCodec(TerrariaTorchBlock::new);
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    private final MultifaceSpreader spreader = new MultifaceSpreader(this);
    public MapCodec<? extends TerrariaTorchBlock> codec() {
        return CODEC;
    }
    public TerrariaTorchBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, Boolean.valueOf(true)));
    }
    public MultifaceSpreader getSpreader() {
        return this.spreader;
    }
    @Override
    protected boolean isFaceSupported(Direction face) {
        return face != Direction.UP;
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LIT);
    }
}
