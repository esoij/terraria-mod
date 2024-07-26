package esoij.terrariamod.world.entity;

import com.google.common.collect.ImmutableSet;
import com.mojang.logging.LogUtils;
import esoij.terrariamod.resources.ResourceLocationHelper;
import esoij.terrariamod.world.entity.monster.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;

import static esoij.terrariamod.ModSharedConstants.IDE;

public class ModEntityType<T extends Entity> extends EntityType<T> {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final EntityType<Pinky> PINKY = register(-4, "pinky", EntityType.Builder.of(Pinky::new, MobCategory.MONSTER).sized((1.2f) * (2f/3f), (0.75f) * (2f/3f)).eyeHeight(0.8f * ((0.75f) * (2f/3f))).clientTrackingRange(MinecraftServer.ABSOLUTE_MAX_WORLD_SIZE));
    public static final EntityType<GreenSlime> GREEN_SLIME = register(-3, "green_slime", EntityType.Builder.of(GreenSlime::new, MobCategory.MONSTER).sized((1.8f) * (2f/3f), (1.125f) * (2f/3f)).eyeHeight(0.8f * ((1.125f) * (2f/3f))).clientTrackingRange(MinecraftServer.ABSOLUTE_MAX_WORLD_SIZE));

    public static final EntityType<BlueSlime> BLUE_SLIME = register(1, "blue_slime", EntityType.Builder.of(BlueSlime::new, MobCategory.MONSTER).sized((2) * (2f/3f), (1.25F) * (2f/3f)).eyeHeight(0.8f * ((1.25F) * (2f/3f))).clientTrackingRange(MinecraftServer.ABSOLUTE_MAX_WORLD_SIZE));

    public static final EntityType<AngryBones> ANGRY_BONES = register(31, "angry_bones", EntityType.Builder.of(AngryBones::new, MobCategory.MONSTER).sized((2.1333334f) * (2f/3f), (2.5833333f) * (2f/3f)).eyeHeight(0.8f * ((2.5833333f) * (2f/3f))).clientTrackingRange(MinecraftServer.ABSOLUTE_MAX_WORLD_SIZE));

    public static final EntityType<DungeonSlime> DUNGEON_SLIME = register(71, "dungeon_slime", EntityType.Builder.of(DungeonSlime::new, MobCategory.MONSTER).sized((2.75f) * (2f/3f), (1.71875f) * (2f/3f)).eyeHeight(0.8f * ((1.71875f) * (2f/3f))).clientTrackingRange(MinecraftServer.ABSOLUTE_MAX_WORLD_SIZE));
    private static <T extends Entity> EntityType<T> register(int terrariaNPCID, String key, EntityType.Builder<T> builder) {
        if (IDE) LOGGER.info("Registering {}, ID: {}, Builder: {}", key, terrariaNPCID, builder);
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, ResourceLocationHelper.parse(key), builder.build(key));
    }
    public ModEntityType(EntityFactory<T> factory, MobCategory category, boolean serialize, boolean summon, boolean fireImmune, boolean canSpawnFarFromPlayer, ImmutableSet<Block> immuneTo, EntityDimensions dimensions, float spawnDimensionsScale, int clientTrackingRange, int updateInterval, FeatureFlagSet requiredFeatures) {
        super(factory, category, serialize, summon, fireImmune, canSpawnFarFromPlayer, immuneTo, dimensions, spawnDimensionsScale, clientTrackingRange, updateInterval, requiredFeatures);
    }

    public static void init() {
        if (IDE) LOGGER.info("Initialized Mod Entity Types!");
    }
}
