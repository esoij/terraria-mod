package esoij.terrariamod.mixin.client.renderer;

import esoij.terrariamod.resources.ResourceLocationHelper;
import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Sheets.class)
public abstract class SheetsMixin {
    @Shadow @Final public static ResourceLocation CHEST_SHEET;
    @Unique
    private static Material terrariaChestMaterial(String chestName) {
        return new Material(CHEST_SHEET, ResourceLocationHelper.parse("entity/chest/" + chestName));
    }
    @Unique
    private static final Material TERRARIA_CHEST_LOCATION = terrariaChestMaterial("chest");
    @Unique
    private static final Material GOLD_CHEST_LOCATION = terrariaChestMaterial("gold");
    @Unique
    private static final Material LOCKED_GOLD_CHEST_LOCATION = terrariaChestMaterial("locked_gold");
    @Inject(method = "chooseMaterial(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/level/block/state/properties/ChestType;Z)Lnet/minecraft/client/resources/model/Material;", at = @At("HEAD"), cancellable = true)
    private static void terrariaChestMaterial(BlockEntity blockEntity, ChestType chestType, boolean holiday, CallbackInfoReturnable<Material> cir) {
        if (blockEntity.getBlockState().getBlock().equals(ModBlocks.CHEST)) {
            cir.setReturnValue(TERRARIA_CHEST_LOCATION);
            cir.cancel();
        } else if (blockEntity.getBlockState().getBlock().equals(ModBlocks.GOLD_CHEST)) {
            cir.setReturnValue(GOLD_CHEST_LOCATION);
            cir.cancel();
        } else if (blockEntity.getBlockState().getBlock().equals(ModBlocks.LOCKED_GOLD_CHEST)) {
            cir.setReturnValue(LOCKED_GOLD_CHEST_LOCATION);
            cir.cancel();
        }
    }
}
