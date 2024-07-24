package esoij.terrariamod.world.level.block.entity;

import com.mojang.datafixers.types.Type;
import esoij.terrariamod.resources.ResourceLocationHelper;
import esoij.terrariamod.world.level.block.ModBlocks;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntityType {
    public static final BlockEntityType<TerrariaChestBlockEntity> TERRARIA_CHEST = register("chest", BlockEntityType.Builder.of(TerrariaChestBlockEntity::new, ModBlocks.CHEST, ModBlocks.GOLD_CHEST, ModBlocks.LOCKED_GOLD_CHEST));
    private static <T extends BlockEntity> BlockEntityType<T> register(String key, BlockEntityType.Builder<T> builder) {
        //if (builder.validBlocks.isEmpty()) {
        //    LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", key);
        //}

        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, key);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, ResourceLocationHelper.parse(key), builder.build(type));
    }
    public static void init() {
    }
}
