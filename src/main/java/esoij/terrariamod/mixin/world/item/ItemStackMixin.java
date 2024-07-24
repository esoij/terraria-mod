package esoij.terrariamod.mixin.world.item;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Mutable
    @Shadow @Final public static Codec<ItemStack> CODEC;

    @Shadow @Final public static Codec<Holder<Item>> ITEM_NON_AIR_CODEC;

    @Inject(method = "<clinit>", at=@At("TAIL"))
    private static void clinit(CallbackInfo ci) {
        CODEC = Codec.lazyInitialized(
                () -> RecordCodecBuilder.create(
                        instance -> instance.group(
                                        ITEM_NON_AIR_CODEC.fieldOf("id").forGetter(ItemStack::getItemHolder),
                                        ExtraCodecs.intRange(1, 9999).fieldOf("count").orElse(1).forGetter(ItemStack::getCount),
                                        DataComponentPatch.CODEC.optionalFieldOf("components", DataComponentPatch.EMPTY).forGetter(itemStack -> itemStack.components.asPatch())
                                )
                                .apply(instance, ItemStack::new)
                )
        );
    }
}
