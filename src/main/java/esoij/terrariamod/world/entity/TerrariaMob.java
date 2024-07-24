package esoij.terrariamod.world.entity;

import esoij.terrariamod.access.world.level.LevelAccess;
import esoij.terrariamod.world.level.WorldType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTable;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public abstract class TerrariaMob extends Mob {
    @Nullable
    private ResourceKey<LootTable> easyLootTable;
    @Nullable
    private ResourceKey<LootTable> normalLootTable;
    @Nullable
    private ResourceKey<LootTable> normalHardmodeLootTable;
    @Nullable
    private ResourceKey<LootTable> normalPlanteraLootTable;
    @Nullable
    private ResourceKey<LootTable> hardLootTable;
    @Nullable
    private ResourceKey<LootTable> hardHardmodeLootTable;
    @Nullable
    private ResourceKey<LootTable> hardPlanteraLootTable;
    protected TerrariaMob(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    public ResourceKey<LootTable> getLootTable() {
        ResourceKey<LootTable> lootTable;
        if (this.easyLootTable == null) {
            ResourceLocation resourceLocation = BuiltInRegistries.ENTITY_TYPE.getKey(this.getType());
            this.easyLootTable = ResourceKey.create(Registries.LOOT_TABLE, resourceLocation.withPrefix( "entities/easy/"));
        }
        if (this.normalLootTable == null) {
            ResourceLocation resourceLocation = BuiltInRegistries.ENTITY_TYPE.getKey(this.getType());
            this.normalLootTable = ResourceKey.create(Registries.LOOT_TABLE, resourceLocation.withPrefix( "entities/normal/pre_hardmode/"));
        }
        if (this.normalHardmodeLootTable == null) {
            ResourceLocation resourceLocation = BuiltInRegistries.ENTITY_TYPE.getKey(this.getType());
            this.normalHardmodeLootTable = ResourceKey.create(Registries.LOOT_TABLE, resourceLocation.withPrefix( "entities/normal/hardmode/"));
        }
        if (this.normalPlanteraLootTable == null) {
            ResourceLocation resourceLocation = BuiltInRegistries.ENTITY_TYPE.getKey(this.getType());
            this.normalPlanteraLootTable = ResourceKey.create(Registries.LOOT_TABLE, resourceLocation.withPrefix( "entities/normal/post_plantera/"));
        }
        if (this.hardLootTable == null) {
            ResourceLocation resourceLocation = BuiltInRegistries.ENTITY_TYPE.getKey(this.getType());
            this.hardLootTable = ResourceKey.create(Registries.LOOT_TABLE, resourceLocation.withPrefix("entities/hard/pre_hardmode/"));
        }
        if (this.hardHardmodeLootTable == null) {
            ResourceLocation resourceLocation = BuiltInRegistries.ENTITY_TYPE.getKey(this.getType());
            this.hardHardmodeLootTable = ResourceKey.create(Registries.LOOT_TABLE, resourceLocation.withPrefix( "entities/hard/hardmode/"));
        }
        if (this.hardPlanteraLootTable == null) {
            ResourceLocation resourceLocation = BuiltInRegistries.ENTITY_TYPE.getKey(this.getType());
            this.hardPlanteraLootTable = ResourceKey.create(Registries.LOOT_TABLE, resourceLocation.withPrefix( "entities/hard/post_plantera/"));
        }
        switch(this.level().getDifficulty()) {
            default -> lootTable = this.easyLootTable;
            case NORMAL -> {
                switch (((LevelAccess)this.level()).getWorldType()) {
                    default -> lootTable = this.normalLootTable;
                    case HARDMODE -> lootTable = this.normalHardmodeLootTable;
                    case POST_PLANTERA -> lootTable = this.normalPlanteraLootTable;
                }
            }
            case HARD -> {
                switch (((LevelAccess)this.level()).getWorldType()) {
                    default -> lootTable = this.hardLootTable;
                    case HARDMODE -> lootTable = this.hardHardmodeLootTable;
                    case POST_PLANTERA -> lootTable = this.hardPlanteraLootTable;
                }
            }
        }
        return lootTable;
    }
    @Override
    protected void dropCustomDeathLoot(ServerLevel level, DamageSource damageSource, boolean recentlyHit) {
        super.dropCustomDeathLoot(level, damageSource, recentlyHit);
        Entity entity = damageSource.getEntity();
        if (entity instanceof ServerPlayer player && (player.getStats().getValue(Stats.ENTITY_KILLED, this.getType()) % 50) - 1 == 0 && (player.getStats().getValue(Stats.ENTITY_KILLED, this.getType())) != 0) {
            this.spawnAtLocation(this::banner);
        }
    }
    public abstract Item banner();
}
