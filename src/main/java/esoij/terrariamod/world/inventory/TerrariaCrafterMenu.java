package esoij.terrariamod.world.inventory;

import com.google.common.collect.Lists;
import esoij.terrariamod.world.item.crafting.ModRecipeType;
import esoij.terrariamod.world.item.crafting.TerrariaInput;
import esoij.terrariamod.world.item.crafting.TerrariaRecipe;
import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class TerrariaCrafterMenu extends AbstractContainerMenu {
    public static final int INPUT_SLOT = 0;
    public static final int RESULT_SLOT = 1;
    private static final int INV_SLOT_START = 2;
    private static final int INV_SLOT_END = 29;
    private static final int USE_ROW_SLOT_START = 29;
    private static final int USE_ROW_SLOT_END = 38;
    private final ContainerLevelAccess access;
    /**
     * The index of the selected recipe in the GUI.
     */
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private final Level level;
    private List<RecipeHolder<TerrariaRecipe>> recipes = Lists.newArrayList();
    /**
     * The {@linkplain net.minecraft.world.item.ItemStack} set in the input slot by the player.
     */
    private ItemStack input = ItemStack.EMPTY;
    /**
     * Stores the game time of the last time the player took items from the the crafting result slot. This is used to prevent the sound from being played multiple times on the same tick.
     */
    long lastSoundTime;
    private final CraftingContainer craftSlots = new TransientCraftingContainer(this, 3, 3) {
        @Override
        public void setChanged() {
            super.setChanged();
            TerrariaCrafterMenu.this.slotsChanged(this);
            TerrariaCrafterMenu.this.slotUpdateListener.run();
        }
    };
    private final ResultContainer resultSlots = new ResultContainer();
    Runnable slotUpdateListener = () -> {
    };
    public final Container container = new SimpleContainer(1) {
        @Override
        public void setChanged() {
            super.setChanged();
            TerrariaCrafterMenu.this.slotsChanged(this);
            TerrariaCrafterMenu.this.slotUpdateListener.run();
        }
    };
    /**
     * The inventory that stores the output of the crafting recipe.
     */
    final ResultContainer resultContainer = new ResultContainer();
    public TerrariaCrafterMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, ContainerLevelAccess.NULL);
    }
    public TerrariaCrafterMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access) {
        super(ModMenuType.TERRARIA_CRAFTER, containerId);
        this.access = access;
        this.level = playerInventory.player.level();
        this.addSlot(new ResultSlot(playerInventory.player, this.craftSlots, this.resultSlots, 0, 143, 33) {
            public boolean mayPlace(ItemStack stack) {
                return false;
            }
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level(), player, stack.getCount());
                TerrariaCrafterMenu.this.resultContainer.awardUsedRecipes(player, this.getRelevantItems());
                for (ItemStack itemStack : TerrariaCrafterMenu.this.craftSlots.getItems()) {
                    itemStack.shrink(1);
                    if (!itemStack.isEmpty()) {
                        TerrariaCrafterMenu.this.setupResultSlot();
                    }
                }

                access.execute((level, blockPos) -> {
                    long l = level.getGameTime();
                    if (TerrariaCrafterMenu.this.lastSoundTime != l) {
                        level.playSound(null, blockPos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        TerrariaCrafterMenu.this.lastSoundTime = l;
                    }
                });
                super.onTake(player, stack);
            }
            private List<ItemStack> getRelevantItems() {
                ItemStack[] items = new ItemStack[craftSlots.getContainerSize()];
                for (int i = 0; i < craftSlots.getContainerSize(); i++) items[i] = craftSlots.getItem(i);
                return List.of(items);
            }
        });

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                this.addSlot(new Slot(this.craftSlots, j + i * 3, 20 + j * 18, 33 + i * 18));
            }
        }

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }
    /**
     * Returns the index of the selected recipe.
     */
    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }
    public List<RecipeHolder<TerrariaRecipe>> getRecipes() {
        return this.recipes;
    }
    public int getNumRecipes() {
        return this.recipes.size();
    }
    public boolean hasInputItem() {
        return !this.craftSlots.isEmpty() && !this.recipes.isEmpty();
    }
    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, ModBlocks.TERRARIA_CRAFTER);
    }
    private boolean isValidRecipeIndex(int recipeIndex) {
        return recipeIndex >= 0 && recipeIndex < this.recipes.size();
    }
    @Override
    public void slotsChanged(Container container) {
        for (int i = 0; i < craftSlots.getContainerSize(); i++) {
            ItemStack itemStack = this.craftSlots.getItem(i);
            if (!itemStack.is(this.input.getItem())) {
                this.input = itemStack.copy();
                this.setupRecipeList(container, itemStack);
            }
        }
    }
    private static TerrariaInput createRecipeInput(Container container) {
        ItemStack[] items = new ItemStack[container.getContainerSize()];
        for (int i = 0; i < container.getContainerSize(); i++) items[i] = container.getItem(i);
        return new TerrariaInput(3, 3, List.of(items));
    }
    private void setupRecipeList(Container container, ItemStack stack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        for (int i = 0; i < resultSlots.getContainerSize(); i++) {
            this.resultSlots.setItem(i, ItemStack.EMPTY);
        }
        if (!stack.isEmpty()) {
            this.recipes = this.level.getRecipeManager().getRecipesFor(ModRecipeType.TERRARIA_CRAFTING, createRecipeInput(container), this.level);
        }
    }
    void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            RecipeHolder<TerrariaRecipe> recipeHolder = this.recipes.get(this.selectedRecipeIndex.get());
            ItemStack itemStack = recipeHolder.value().assemble(createRecipeInput(this.craftSlots), this.level.registryAccess());
            if (itemStack.isItemEnabled(this.level.enabledFeatures())) {
                this.resultContainer.setRecipeUsed(recipeHolder);
                for (int i = 0; i < this.resultSlots.getContainerSize(); i++) {
                    this.resultSlots.setItem(i, itemStack);
                }
            } else {
                for (int i = 0; i < this.resultSlots.getContainerSize(); i++) {
                    this.resultSlots.setItem(i, ItemStack.EMPTY);
                }
            }
        } else {
            for (int i = 0; i < this.resultSlots.getContainerSize(); i++) {
                this.resultSlots.setItem(i, ItemStack.EMPTY);
            }
        }

        this.broadcastChanges();
    }
    @Override
    public MenuType<?> getType() {
        return ModMenuType.TERRARIA_CRAFTER;
    }
    public void registerUpdateListener(Runnable listener) {
        this.slotUpdateListener = listener;
    }
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
    }
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemStack2 = slot.getItem();
            Item item = itemStack2.getItem();
            itemStack = itemStack2.copy();
            ItemStack[] items = new ItemStack[craftSlots.getContainerSize()];
            for (int i = 0; i < craftSlots.getContainerSize(); i++) items[i] = craftSlots.getItem(i);
            if (index == 1) {
                item.onCraftedBy(itemStack2, player.level(), player);
                if (!this.moveItemStackTo(itemStack2, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemStack2, itemStack);
            } else if (index == INPUT_SLOT) {
                if (!this.moveItemStackTo(itemStack2, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(ModRecipeType.TERRARIA_CRAFTING, new TerrariaInput(1, 1, List.of(items)), this.level).isPresent()) {
                if (!this.moveItemStackTo(itemStack2, INPUT_SLOT, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 2 && index < 29) {
                if (!this.moveItemStackTo(itemStack2, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 29 && index < 38 && !this.moveItemStackTo(itemStack2, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemStack2);
            this.broadcastChanges();
        }

        return itemStack;
    }
    @Override
    public void removed(Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((level, blockPos) -> this.clearContainer(player, this.craftSlots));
    }
    @Override
    public boolean clickMenuButton(Player player, int id) {
        if (this.isValidRecipeIndex(id)) {
            this.selectedRecipeIndex.set(id);
            this.setupResultSlot();
        }

        return true;
    }
    //todo;1
}
