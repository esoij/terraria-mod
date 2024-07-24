package esoij.terrariamod.stats;

import com.mojang.logging.LogUtils;
import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import org.slf4j.Logger;

import static esoij.terrariamod.ModSharedConstants.IDE;

public class ModStats extends Stats {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final ResourceLocation INTERACT_WITH_TERRARIA_CRAFTER = makeCustomStat("interact_with_terraria_crafter", StatFormatter.DEFAULT);
    private static ResourceLocation makeCustomStat(String key, StatFormatter formatter) {
        if (IDE) LOGGER.info("Making custom stat: {}, formatter: {}", key, formatter);
        ResourceLocation resourceLocation = ResourceLocationHelper.parse(key);
        Registry.register(BuiltInRegistries.CUSTOM_STAT, key, resourceLocation);
        CUSTOM.get(resourceLocation, formatter);
        return resourceLocation;
    }
    public static void init() {
        if (IDE) LOGGER.info("Initialized Mod Stats!");
    }
}
