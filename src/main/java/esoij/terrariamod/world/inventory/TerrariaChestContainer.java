package esoij.terrariamod.world.inventory;

import esoij.terrariamod.world.level.block.entity.TerrariaChestBlockEntity;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.EnderChestBlockEntity;
import org.jetbrains.annotations.Nullable;

public class TerrariaChestContainer extends SimpleContainer {
    @Nullable
    private TerrariaChestBlockEntity activeChest;
    public TerrariaChestContainer() {
        super(27);
    }
    @Override
    public boolean stillValid(Player player) {
        return (this.activeChest == null || this.activeChest.stillValid(player)) && super.stillValid(player);
    }
    @Override
    public void startOpen(Player player) {
        if (this.activeChest != null) {
            this.activeChest.startOpen(player);
        }

        super.startOpen(player);
    }
    @Override
    public void stopOpen(Player player) {
        if (this.activeChest != null) {
            this.activeChest.stopOpen(player);
        }

        super.stopOpen(player);
        this.activeChest = null;
    }
}
