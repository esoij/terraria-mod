package esoij.terrariamod.world.level.block;

import esoij.terrariamod.world.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class LockedChestBlock extends TerrariaChestBlock {
    public LockedChestBlock(Properties properties) {
        super(properties);
    }
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        return InteractionResult.PASS;
    }
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.is(ModItems.GOLDEN_KEY)) {
            BlockEntity thiz = level.getBlockEntity(pos);
            level.setBlock(pos, ModBlocks.LOCKED_GOLD_CHEST.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(WATERLOGGED, state.getValue(WATERLOGGED)), 1 | 2);
            level.setBlockEntity(thiz);
            stack.shrink(1);
            return ItemInteractionResult.CONSUME;
        } else {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }
}
