package esoij.terrariamod.sounds;

import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class ModSoundEvents extends SoundEvents {
    public static final SoundEvent CONSUME_SHIMMER = register("consume_shimmer");
    public static final SoundEvent CRYSTAL = register("crystal");
    public static final Holder<SoundEvent> DD2_EXPLOSIVE_TRAP_EXPLODE = registerForHolder("dd2_explosive_trap_explode");
    public static final SoundEvent DIG_BREAK = register("dig_break");
    public static final SoundEvent DIG_STEP = register("dig_step");
    public static final SoundEvent DIG_PLACE = register("dig_place");
    public static final SoundEvent DIG_HIT = register("dig_hit");
    public static final SoundEvent DIG_FALL = register("dig_fall");
    public static final SoundEvent DOOR_CLOSED = register("door_closed");
    public static final SoundEvent DOOR_OPENED = register("door_opened");
    public static final SoundEvent DRINK = register("drink");
    public static final SoundEvent EAT = register("eat");
    public static final SoundEvent GRASS_BREAK = register("grass_break");
    public static final SoundEvent GRASS_STEP = register("grass_step");
    public static final SoundEvent GRASS_PLACE = register("grass_place");
    public static final SoundEvent GRASS_HIT = register("grass_hit");
    public static final SoundEvent GRASS_FALL = register("grass_fall");
    public static final SoundEvent ICE_BREAK = register("ice_break");
    public static final SoundEvent ICE_HIT = register("ice_hit");
    public static final SoundEvent SNOW_BREAK = register("snow_break");
    public static final SoundEvent SNOW_HIT = register("snow_hit");
    public static final SoundEvent TINK_BREAK = register("tink_break");
    public static final SoundEvent TINK_HIT = register("tink_hit");
    private static SoundEvent register(String name) {
        return register(ResourceLocationHelper.parse(name));
    }
    private static SoundEvent register(ResourceLocation name) {
        return register(name, name);
    }
    private static SoundEvent register(ResourceLocation name, ResourceLocation location) {
        return Registry.register(BuiltInRegistries.SOUND_EVENT, name, SoundEvent.createVariableRangeEvent(location));
    }
    private static Holder.Reference<SoundEvent> registerForHolder(String name) {
        return registerForHolder(ResourceLocationHelper.parse(name));
    }
    private static Holder.Reference<SoundEvent> registerForHolder(ResourceLocation name) {
        return registerForHolder(name, name);
    }
    private static Holder.Reference<SoundEvent> registerForHolder(ResourceLocation name, ResourceLocation location) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, name, SoundEvent.createVariableRangeEvent(location));
    }
}
