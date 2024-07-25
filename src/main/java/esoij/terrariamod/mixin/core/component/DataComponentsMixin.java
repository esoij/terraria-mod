package esoij.terrariamod.mixin.core.component;

import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.UnaryOperator;

@Mixin(DataComponents.class)
public abstract class DataComponentsMixin {
    @Mutable
    @Shadow @Final public static DataComponentType<Integer> MAX_STACK_SIZE;

    @Shadow
    private static <T> DataComponentType<T> register(String string, UnaryOperator<DataComponentType.Builder<T>> unaryOperator) {
        return null;
    }

    @Mutable
    @Shadow @Final public static DataComponentMap COMMON_ITEM_COMPONENTS;

    @Shadow @Final public static DataComponentType<ItemLore> LORE;

    @Shadow @Final public static DataComponentType<ItemEnchantments> ENCHANTMENTS;

    @Shadow @Final public static DataComponentType<Integer> REPAIR_COST;

    @Shadow @Final public static DataComponentType<ItemAttributeModifiers> ATTRIBUTE_MODIFIERS;

    @Shadow @Final public static DataComponentType<Rarity> RARITY;

    @Inject(method = "<clinit>", at=@At("TAIL"))
    private static void clinit(CallbackInfo ci) {
        MAX_STACK_SIZE = register(
                "max_stack_size", p_333287_ -> p_333287_.persistent(ExtraCodecs.intRange(Integer.MIN_VALUE, Integer.MAX_VALUE)).networkSynchronized(ByteBufCodecs.VAR_INT)
        );
        COMMON_ITEM_COMPONENTS = DataComponentMap.builder()
                .set(MAX_STACK_SIZE, 9999)
                .set(LORE, ItemLore.EMPTY)
                .set(ENCHANTMENTS, ItemEnchantments.EMPTY)
                .set(REPAIR_COST, 0)
                .set(ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY)
                .set(RARITY, Rarity.COMMON)
                .build();
    }
}
