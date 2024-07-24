package esoij.terrariamod.world.level.block;

import com.mojang.serialization.MapCodec;
import esoij.terrariamod.stats.ModStats;
import esoij.terrariamod.world.inventory.TerrariaCrafterMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.StonecutterMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class TerrariaCrafterBlock extends Block {
    public static final MapCodec<? extends TerrariaCrafterBlock> CODEC = simpleCodec(TerrariaCrafterBlock::new);
    private static final Component CONTAINER_TITLE = Component.translatable("container.terraria_crafter");
    @Override
    public MapCodec<? extends TerrariaCrafterBlock> codec() {
        return CODEC;
    }
    public TerrariaCrafterBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(state.getMenuProvider(level, pos));
            player.awardStat(ModStats.INTERACT_WITH_TERRARIA_CRAFTER);
            return InteractionResult.CONSUME;
        }
    }
    @Nullable
    @Override
    protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((i, inventory, player) -> new TerrariaCrafterMenu(i, inventory, ContainerLevelAccess.create(level, pos)), CONTAINER_TITLE);
    }
}
