package esoij.terrariamod.mixin.world.level.block.piston;

import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(PistonStructureResolver.class)
public class PistonStructureResolverMixin {
    /**
     * @author
     * esoij
     * @reason
     * make slime blocks sticky
     */
    @Overwrite
    private static boolean isSticky(BlockState state) {
        return state.is(Blocks.SLIME_BLOCK) || state.is(Blocks.HONEY_BLOCK) || state.is(ModBlocks.PINK_SLIME_BLOCK);
    }
    /**
     * @author
     * esoij
     * @reason
     * make slime blocks sticky
     */
    @Overwrite
    private static boolean canStickToEachOther(BlockState state1, BlockState state2) {
        if (state1.is(Blocks.HONEY_BLOCK) && state2.is(Blocks.SLIME_BLOCK)) {
            return false;
        } else if (state1.is(Blocks.SLIME_BLOCK) && state2.is(Blocks.HONEY_BLOCK)) {
            return false;
        } else if (state1.is(Blocks.HONEY_BLOCK) && state2.is(ModBlocks.PINK_SLIME_BLOCK)) {
            return false;
        } else if (state1.is(ModBlocks.PINK_SLIME_BLOCK) && state2.is(Blocks.HONEY_BLOCK)) {
            return false;
        } else if (state1.is(Blocks.SLIME_BLOCK) && state2.is(ModBlocks.PINK_SLIME_BLOCK)) {
            return false;
        } else if (state1.is(ModBlocks.PINK_SLIME_BLOCK) && state2.is(Blocks.SLIME_BLOCK)) {
            return false;
        } else {
            return isSticky(state1) || isSticky(state2);
        }
    }
}
