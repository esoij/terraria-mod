package esoij.terrariamod.world.effect;

import com.mojang.logging.LogUtils;
import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.slf4j.Logger;

import static esoij.terrariamod.ModSharedConstants.IDE;

public class ModMobEffects extends MobEffects {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final Holder<MobEffect> OBSIDIAN_SKIN = register(1, "obsidian_skin", new ObsidianSkinMobEffect(MobEffectCategory.BENEFICIAL, 0x862349).addAttributeModifier(Attributes.BURNING_TIME, ResourceLocationHelper.parse("effect.obsidian_skin"), -1, AttributeModifier.Operation.ADD_VALUE));
    public static final Holder<MobEffect> REGENERATION = register(2, "regeneration", new ModRegenerationMobEffect(MobEffectCategory.BENEFICIAL, 0xf71318));
    public static final Holder<MobEffect> SWIFTNESS = register(3, "swiftness", new TerrariaMobEffect(MobEffectCategory.BENEFICIAL, 0x02bb2e).addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocationHelper.parse("effect.swiftness"), 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL).addAttributeModifier(Attributes.FLYING_SPEED, ResourceLocationHelper.parse("effect.swiftness"), 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    public static final Holder<MobEffect> GILLS = register(4, "gills", new TerrariaMobEffect(MobEffectCategory.BENEFICIAL, 0xffc000).addAttributeModifier(Attributes.OXYGEN_BONUS, ResourceLocationHelper.parse("effect.gills"), 1024, AttributeModifier.Operation.ADD_VALUE));
    public static final Holder<MobEffect> IRONSKIN = register(5, "ironskin", new TerrariaMobEffect(MobEffectCategory.BENEFICIAL, 0x979fb4).addAttributeModifier(Attributes.ARMOR, ResourceLocationHelper.parse("effect.ironskin"), 8, AttributeModifier.Operation.ADD_VALUE));

    public static final Holder<MobEffect> FEATHERFALL = register(8, "featherfall", new TerrariaMobEffect(MobEffectCategory.BENEFICIAL, 0x0).addAttributeModifier(Attributes.GRAVITY, ResourceLocationHelper.parse("effect.featherfall"), -0.6666666666666666, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL).addAttributeModifier(Attributes.FALL_DAMAGE_MULTIPLIER, ResourceLocationHelper.parse("effect.featherfall"), -1, AttributeModifier.Operation.ADD_VALUE));

    public static final Holder<MobEffect> POTION_SICKNESS = register(21, "potion_sickness", new TerrariaMobEffect(MobEffectCategory.HARMFUL, 0x890d27));

    public static final Holder<MobEffect> BLEEDING = register(30, "bleeding", new BleedingMobEffect(MobEffectCategory.HARMFUL, 0x0));

    public static final Holder<MobEffect> BURNING = register(67, "burning", new BurningMobEffect(MobEffectCategory.HARMFUL, 0xff7f27));

    public static final Holder<MobEffect> MONSTER_BANNER = register(147, "monster_banner", new MonsterBannerMobEffect(MobEffectCategory.BENEFICIAL, 0x0));
    private static Holder<MobEffect> register(int terrariaEffectID, String name, MobEffect effect) {
        if (IDE) LOGGER.info("Registering {}, ID: {}, Effect: {}", name, terrariaEffectID, effect);
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, ResourceLocationHelper.parse(name), effect);
    }
    public static void init() {
        if (IDE) LOGGER.info("Initialized Mod Mob Effects!");
    }
}
