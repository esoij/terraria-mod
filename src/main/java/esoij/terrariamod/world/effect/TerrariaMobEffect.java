package esoij.terrariamod.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class TerrariaMobEffect extends MobEffect {
    private final MobEffectCategory category;
    private final int color;
    protected TerrariaMobEffect(MobEffectCategory category, int color) {
        super(category, color);
        this.category = category;
        this.color = color;
    }
    @Override
    public String toString() {
        return "Category: " + category + ", Color: " + color;
    }
}
