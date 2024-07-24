package esoij.terrariamod.world.item;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

import static esoij.terrariamod.world.item.ModItems.*;

public class VanillaModAlternatives {
    public static final Supplier<BiMap<Item, Item>> ALTERNATIVES = Suppliers.memoize(
            () -> ImmutableBiMap.<Item, Item>builder()
                    .put(UTIL_HIGH_VALUE_FAST_EAT_FOOD, Items.AIR)
                    .put(Items.AIR, Items.AIR)                 //none
                    .put(Items.STONE, STONE_BLOCK)
                    .put(Items.GRANITE, GRANITE)
                    .put(Items.POLISHED_GRANITE, Items.AIR)    //none
                    .put(Items.DIORITE, Items.AIR)             //none
                    .put(Items.POLISHED_DIORITE, Items.AIR)    //none
                    .put(Items.ANDESITE, Items.AIR)            //none
                    .put(Items.POLISHED_ANDESITE, Items.AIR)   //none
                    .put(Items.DEEPSLATE, Items.AIR)           //none
                    .put(Items.COBBLED_DEEPSLATE, Items.AIR)   //none
                    .put(Items.POLISHED_DEEPSLATE, Items.AIR)  //none
                    .put(Items.CALCITE, Items.AIR)             //none
                    .put(Items.TUFF, Items.AIR)                //none
                    .put(Items.TUFF_SLAB, Items.AIR)           //none
                    .put(Items.TUFF_STAIRS, Items.AIR)         //none
                    .put(Items.TUFF_WALL, Items.AIR)           //none
                    .put(Items.CHISELED_TUFF, Items.AIR)       //none
                    .put(Items.POLISHED_TUFF, Items.AIR)       //none
                    .put(Items.POLISHED_TUFF_SLAB, Items.AIR)  //none
                    .put(Items.POLISHED_TUFF_STAIRS, Items.AIR)//none
                    .put(Items.POLISHED_TUFF_WALL, Items.AIR)  //none
                    .put(Items.TUFF_BRICKS, Items.AIR)         //none
                    .put(Items.TUFF_BRICK_SLAB, Items.AIR)     //none
                    .put(Items.TUFF_BRICK_STAIRS, Items.AIR)   //none
                    .put(Items.TUFF_BRICK_WALL, Items.AIR)     //none
                    .put(Items.CHISELED_TUFF_BRICKS, Items.AIR)//none
                    .put(Items.DRIPSTONE_BLOCK, Items.AIR)     //none
                    .put(Items.GRASS_BLOCK, GRASS_BLOCK)
                    .put(Items.DIRT, DIRT_BLOCK)
                    .put(Items.COARSE_DIRT, Items.AIR)         //none
                    .put(Items.PODZOL, Items.AIR)              //none
                    .put(Items.ROOTED_DIRT, Items.AIR)         //none
                    .put(Items.MUD, MUD_BLOCK)
                    .build()
    );
}
