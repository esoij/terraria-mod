package esoij.terrariamod.world.item;

import com.mojang.logging.LogUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;

public class TerrariaArmorItem extends ArmorItem {
    public static final Logger LOGGER = LogUtils.getLogger();
    private final TerrariaArmorSets set;
    public TerrariaArmorItem(Properties properties, Holder<ArmorMaterial> material, Type type, TerrariaArmorSets set) {
        super(material, type, properties);
        this.set = set;
    }
    /**
     * Called each tick as long the item is in a player's inventory. Used by maps to check if it's in a player's hand and update its contents.
     */
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (itemIsOfSet(0, entity) && itemIsOfSet(1, entity) && itemIsOfSet(2, entity) && itemIsOfSet(3, entity)) {
            if (set == TerrariaArmorSets.COPPER) {
                if (entity instanceof LivingEntity livingEntity) {
                    //todo
                }
            }
        }
    }
    private boolean itemIsOfSet(int slot, Entity entity) {
        return entity.getSlot(slot).get().getItem() == set.getBoots(set) || entity.getSlot(slot).get().getItem() == set.getLeggings(set) || entity.getSlot(slot).get().getItem() == set.getChestplate(set) || entity.getSlot(slot).get().getItem() == set.getHelmet(set);
    }
}
