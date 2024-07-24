package esoij.terrariamod.world.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.SpawnEggItem;

public class TerrariaSpawnEggItem extends SpawnEggItem {
    public TerrariaSpawnEggItem(Properties properties, EntityType<? extends Mob> defaultType, int backgroundColor, int highlightColor) {
        super(defaultType, backgroundColor, highlightColor, properties);
    }
}
