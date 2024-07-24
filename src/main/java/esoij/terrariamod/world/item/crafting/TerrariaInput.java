package esoij.terrariamod.world.item.crafting;

import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.List;

@SuppressWarnings("deprecation")
public class TerrariaInput implements RecipeInput {
    public static final TerrariaInput EMPTY = new TerrariaInput(0, 0, List.of());
    private final int width;
    private final int height;
    private final List<ItemStack> items;
    private final StackedContents stackedContents = new StackedContents();
    private final int ingredientCount;
    public TerrariaInput(int width, int height, List<ItemStack> item) {
        this.width = width;
        this.height = height;
        this.items = item;
        int i = 0;

        for(ItemStack itemStack : item) {
            if (!itemStack.isEmpty()) {
                ++i;
                this.stackedContents.accountStack(itemStack, 1);
            }
        }

        this.ingredientCount = i;
    }
    @Override
    public ItemStack getItem(int index) {
        return (ItemStack)this.items.get(index);
    }
    @Override
    public int size() {
        return this.items.size();
    }
    @Override
    public boolean isEmpty() {
        return this.ingredientCount == 0;
    }
    public StackedContents stackedContents() {
        return this.stackedContents;
    }
    public List<ItemStack> items() {
        return this.items;
    }
    public int ingredientCount() {
        return this.ingredientCount;
    }
    public int width() {
        return this.width;
    }
    public int height() {
        return this.height;
    }
    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (!(object instanceof TerrariaInput)) {
            return false;
        } else {
            TerrariaInput craftingInput = (TerrariaInput)object;
            return this.width == craftingInput.width
                    && this.height == craftingInput.height
                    && this.ingredientCount == craftingInput.ingredientCount
                    && ItemStack.listMatches(this.items, craftingInput.items);
        }
    }
    @Override
    public int hashCode() {
        int i = ItemStack.hashStackList(this.items);
        i = 31 * i + this.width;
        return 31 * i + this.height;
    }
}
