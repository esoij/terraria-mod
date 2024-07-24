package esoij.terrariamod.tags;

import com.mojang.logging.LogUtils;
import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;

import static esoij.terrariamod.ModSharedConstants.IDE;

public class ModItemTags {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final TagKey<Item> HAMMERS = bind("hammers");
    public static final TagKey<Item> DISPLAYS_TIME = bind("displays_time");
    public static final TagKey<Item> DISPLAYS_DEPTH = bind("dislplays_depth");
    public static final TagKey<Item> WOOD = bind("wood");
    private static TagKey<Item> bind(String name) {
        if (IDE) LOGGER.info("Binding {}", name);
        return TagKey.create(Registries.ITEM, ResourceLocationHelper.parse(name));
    }
    public static void init() {
        if (IDE) LOGGER.info("Initialized Mod Item Tags!");
    }
}
