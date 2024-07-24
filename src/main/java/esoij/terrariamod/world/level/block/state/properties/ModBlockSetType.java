package esoij.terrariamod.world.level.block.state.properties;

import esoij.terrariamod.sounds.ModSoundEvents;
import esoij.terrariamod.world.level.block.ModSoundType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class ModBlockSetType {
    public static final BlockSetType WOOD = new BlockSetType("wood", true, true, true, BlockSetType.PressurePlateSensitivity.EVERYTHING, ModSoundType.DIG, ModSoundEvents.DOOR_CLOSED, ModSoundEvents.DOOR_OPENED, SoundEvents.CHERRY_WOOD_TRAPDOOR_CLOSE, SoundEvents.CHERRY_WOOD_TRAPDOOR_OPEN, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_OFF, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_ON);
}
