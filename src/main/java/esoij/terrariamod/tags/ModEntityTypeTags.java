package esoij.terrariamod.tags;

import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public interface ModEntityTypeTags extends EntityTypeTags {
    private static TagKey<EntityType<?>> create(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, ResourceLocationHelper.parse(name));
    }
}
