package esoij.terrariamod.world.level.block.grower;

import esoij.terrariamod.data.worldgen.features.ModTreeFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrower {
    public static final TreeGrower FOREST = new TreeGrower("forest", 0.1F, Optional.empty(), Optional.empty(), Optional.of(ModTreeFeatures.FOREST), Optional.of(ModTreeFeatures.FANCY_FOREST), Optional.empty(), Optional.empty());
    public static final TreeGrower BOREAL = new TreeGrower("boreal", 0.5F, Optional.of(ModTreeFeatures.MEGA_BOREAL), Optional.of(ModTreeFeatures.MEGA_FANCY_BOREAL), Optional.of(ModTreeFeatures.BOREAL), Optional.of(ModTreeFeatures.FANCY_BOREAL), Optional.empty(), Optional.empty());
}
