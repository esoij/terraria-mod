package esoij.terrariamod.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class BlockPosWithDimension extends BlockPos {
    private ResourceKey<Level> dimension;
    public BlockPosWithDimension(int x, int y, int z, ResourceKey<Level> dimension) {
        super(x, y, z);
        this.dimension = dimension;
    }
    public BlockPosWithDimension(Vec3i vector, ResourceKey<Level> dimension) {
        super(vector);
        this.dimension = dimension;
    }
    public BlockPos toBlockPos() {
        return new BlockPos(this.getX(), this.getY(), this.getZ());
    }
}
