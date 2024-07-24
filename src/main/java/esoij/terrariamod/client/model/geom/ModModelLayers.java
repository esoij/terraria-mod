package esoij.terrariamod.client.model.geom;

import com.google.common.collect.Sets;
import com.mojang.logging.LogUtils;
import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import org.slf4j.Logger;

import java.util.Set;

import static esoij.terrariamod.ModSharedConstants.IDE;

public class ModModelLayers extends ModelLayers {
    public static final Logger LOGGER = LogUtils.getLogger();
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    public static final ModelLayerLocation ANGRY_BONES = register("angry_bones");
    public static final ModelLayerLocation BLUE_SLIME = register("blue_slime");
    public static final ModelLayerLocation DUNGEON_SLIME = register("dungeon_slime");
    public static final ModelLayerLocation GREEN_SLIME = register("green_slime");
    public static final ModelLayerLocation PINKY = register("pinky");
    private static ModelLayerLocation register(String path) {
        if (IDE) LOGGER.info("Registering {}", path);
        return register(path, "main");
    }
    private static ModelLayerLocation register(String path, String model) {
        ModelLayerLocation modelLayerLocation = createLocation(path, model);
        if (!ALL_MODELS.add(modelLayerLocation)) {
            throw new IllegalStateException("Duplicate registration for " + modelLayerLocation);
        } else {
            return modelLayerLocation;
        }
    }
    private static ModelLayerLocation createLocation(String path, String model) {
        return new ModelLayerLocation(ResourceLocationHelper.parse(path), model);
    }
    public static void init() {
        if (IDE) LOGGER.info("Initialized Mod Model Layers!");
    }
}
