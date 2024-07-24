package esoij.terrariamod.world.entity;

import esoij.terrariamod.access.world.level.LevelAccess;
import esoij.terrariamod.world.item.ModItems;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class GreenSlime extends BlueSlime {
    public GreenSlime(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    public Item banner() {
        return ModItems.GREEN_SLIME_BANNER;
    }
    /**
     * Returns the maximum health of the entity (what it is able to regenerate up to, what it spawned with, etc.)
     */
    @Override
    public float getMaxHealth() {
        return (float)switch (this.level().getDifficulty()) {
            default -> 14;
            case NORMAL -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 28;
                case HARDMODE -> 246;
                case POST_PLANTERA -> 338;
            };
            case HARD -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 42;
                case HARDMODE -> 369;
                case POST_PLANTERA -> 507;
            };
        };
    }
    @Override
    protected float getAttackDamage() {
        double attackDamage = this.getAttributeValue(Attributes.ATTACK_DAMAGE) - 6;
        return (float)switch (this.level().getDifficulty()) {
            default -> 6 + attackDamage;
            case NORMAL -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 12 + attackDamage;
                case HARDMODE -> 86 + attackDamage;
                case POST_PLANTERA -> 118 + attackDamage;
            };
            case HARD -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 18 + attackDamage;
                case HARDMODE -> 129 + attackDamage;
                case POST_PLANTERA -> 177 + attackDamage;
            };
        };
    }
    public static AttributeSupplier.Builder createEntityAttributes() {
        return AttributeSupplier.builder()
                .add(Attributes.MAX_HEALTH, 14)
                .add(Attributes.KNOCKBACK_RESISTANCE, -0.2)
                .add(Attributes.MOVEMENT_SPEED)
                .add(Attributes.ARMOR, 0)
                .add(Attributes.ARMOR_TOUGHNESS)
                .add(Attributes.MAX_ABSORPTION)
                .add(Attributes.STEP_HEIGHT)
                .add(Attributes.SCALE)
                .add(Attributes.GRAVITY)
                .add(Attributes.SAFE_FALL_DISTANCE)
                .add(Attributes.FALL_DAMAGE_MULTIPLIER)
                .add(Attributes.JUMP_STRENGTH)
                .add(Attributes.OXYGEN_BONUS)
                .add(Attributes.BURNING_TIME)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY)
                .add(Attributes.MOVEMENT_EFFICIENCY)
                .add(Attributes.ATTACK_KNOCKBACK)
                .add(Attributes.FOLLOW_RANGE, MinecraftServer.ABSOLUTE_MAX_WORLD_SIZE)
                .add(Attributes.ATTACK_DAMAGE, 6);
    }
    @Override
    public double getKnockbackResistance() {
        return (float)switch (this.level().getDifficulty()) {
            default -> -0.2;
            case NORMAL -> -0.08;
            case HARD -> 0.04;
        };
    }
    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    @Override
    public int getArmorValue() {
        double armor = this.getAttributeValue(Attributes.ARMOR) - 2;
        return Mth.floor(armor);
    }
}
