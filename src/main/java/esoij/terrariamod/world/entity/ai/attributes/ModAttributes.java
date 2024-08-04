package esoij.terrariamod.world.entity.ai.attributes;

import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

public class ModAttributes {
    public static final Holder<Attribute> MELEE_DAMAGE = register("generic.melee_damage", new RangedAttribute("attribute.name.generic.melee_damage", 2.0, 0.0, 2048));
    public static final Holder<Attribute> RANGED_DAMAGE = register("generic.ranged_damage", new RangedAttribute("attribute.name.generic.ranged_damage", 2.0, 0.0, 2048));
    public static final Holder<Attribute> MAGIC_DAMAGE = register("generic.magic_damage", new RangedAttribute("attribute.name.generic.magic_damage", 2.0, 0.0, 2048));
    public static final Holder<Attribute> SUMMON_DAMAGE = register("generic.summon_damage", new RangedAttribute("attribute.name.generic.summon_damage", 2.0, 0.0, 2048));
    private static Holder<Attribute> register(String name, Attribute attribute) {
        return Registry.registerForHolder(BuiltInRegistries.ATTRIBUTE, ResourceLocationHelper.parse(name), attribute);
    }
    public static void init() {
    }
}
