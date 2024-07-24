package esoij.terrariamod.world.level.block;

import esoij.terrariamod.sounds.ModSoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

public class ModSoundType extends SoundType {
    public static final SoundType DIG = new ModSoundType(
            1.0F,
            1.0F,
            ModSoundEvents.DIG_BREAK,
            ModSoundEvents.DIG_STEP,
            ModSoundEvents.DIG_PLACE,
            ModSoundEvents.DIG_HIT,
            ModSoundEvents.DIG_FALL
    );
    public static final SoundType GRASS = new ModSoundType(
            1.0F,
            1.0F,
            ModSoundEvents.GRASS_BREAK,
            ModSoundEvents.GRASS_STEP,
            ModSoundEvents.GRASS_PLACE,
            ModSoundEvents.GRASS_HIT,
            ModSoundEvents.GRASS_FALL
    );
    public static final SoundType ICE = new ModSoundType(
            1.0F,
            1.0F,
            ModSoundEvents.ICE_BREAK,
            ModSoundEvents.DIG_STEP,
            ModSoundEvents.DIG_PLACE,
            ModSoundEvents.ICE_HIT,
            ModSoundEvents.DIG_FALL
    );
    public static final SoundType SNOW = new ModSoundType(
            1.0F,
            1.0F,
            ModSoundEvents.SNOW_BREAK,
            ModSoundEvents.DIG_STEP,
            ModSoundEvents.DIG_PLACE,
            ModSoundEvents.SNOW_HIT,
            ModSoundEvents.DIG_FALL
    );
    public static final SoundType TINK = new ModSoundType(
            1.0F,
            1.0F,
            ModSoundEvents.TINK_BREAK,
            ModSoundEvents.DIG_STEP,
            ModSoundEvents.DIG_PLACE,
            ModSoundEvents.TINK_HIT,
            ModSoundEvents.DIG_FALL
    );
    public ModSoundType(float volume, float pitch, SoundEvent breakSound, SoundEvent stepSound, SoundEvent placeSound, SoundEvent hitSound, SoundEvent fallSound) {
        super(volume, pitch, breakSound, stepSound, placeSound, hitSound, fallSound);
    }
}
