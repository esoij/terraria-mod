package esoij.terrariamod.world.item;

import net.minecraft.world.item.Item;

public enum TerrariaArmorSets {
    COPPER(ModItems.COPPER_GREAVES, ModItems.COPPER_LEGGINGS, ModItems.COPPER_CHAINMAIL, ModItems.COPPER_HELMET);
    private final Item boots;
    private final Item leggings;
    private final Item chestplate;
    private final Item helmet;
    TerrariaArmorSets(Item boots, Item leggings, Item chestplate, Item helmet) {
        this.boots = boots;
        this.leggings = leggings;
        this.chestplate = chestplate;
        this.helmet = helmet;
    }
    public Item getBoots(TerrariaArmorSets set) {
        return set.boots;
    }
    public Item getLeggings(TerrariaArmorSets set) {
        return set.leggings;
    }
    public Item getChestplate(TerrariaArmorSets set) {
        return set.chestplate;
    }
    public Item getHelmet(TerrariaArmorSets set) {
        return set.helmet;
    }
}
