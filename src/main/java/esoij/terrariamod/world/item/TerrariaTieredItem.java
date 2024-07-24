package esoij.terrariamod.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class TerrariaTieredItem extends Item {
    private final Tier tier;
    public TerrariaTieredItem(Tier tier, Item.Properties properties) {
        super(properties);
        this.tier = tier;
    }
    @Override
    public int getEnchantmentValue() {
        return this.tier.getEnchantmentValue();
    }
    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) {
        return this.tier.getRepairIngredient().test(repairCandidate) || super.isValidRepairItem(stack, repairCandidate);
    }
}
