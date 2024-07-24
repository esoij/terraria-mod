package esoij.terrariamod.world.level.levelgen;

import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public enum ModVeinType {
    COPPER(ModBlocks.COPPER.defaultBlockState(), ModBlocks.COPPER.defaultBlockState(), ModBlocks.STONE.defaultBlockState(), 0, 50),
    IRON(ModBlocks.IRON.defaultBlockState(), ModBlocks.IRON.defaultBlockState(), ModBlocks.STONE.defaultBlockState(), -60, -8);
    final BlockState ore;
    final BlockState rawOreBlock;
    final BlockState filler;
    protected final int minY;
    protected final int maxY;
    ModVeinType(final BlockState ore, final BlockState rawOreBlock, final BlockState filler, final int minY, final int maxY) {
        this.ore = ore;
        this.rawOreBlock = rawOreBlock;
        this.filler = filler;
        this.minY = minY;
        this.maxY = maxY;
    }
}
