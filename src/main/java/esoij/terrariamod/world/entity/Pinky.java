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

public class Pinky extends BlueSlime {
    public Pinky(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    public Item banner() {
        return ModItems.PINKY_BANNER;
    }
    /**
     * Returns the maximum health of the entity (what it is able to regenerate up to, what it spawned with, etc.)
     */
    @Override
    public float getMaxHealth() {
        double health = this.getAttributeValue(Attributes.MAX_HEALTH) - 150;
        return (float)switch (this.level().getDifficulty()) {
            case PEACEFUL, EASY -> 150 + health;
            case NORMAL -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 300 + health;
                case HARDMODE -> 330 + health;
                case POST_PLANTERA -> 660 + health;
            };
            case HARD -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 450 + health;
                case HARDMODE -> 495 + health;
                case POST_PLANTERA -> 990 + health;
            };
        };
    }
    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    @Override
    public int getArmorValue() {
        double armor = this.getAttributeValue(Attributes.ARMOR) - 5;
        return Mth.floor(switch(this.level().getDifficulty()) {
            default -> 5 + armor;
            case NORMAL, HARD -> switch(((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE, HARDMODE -> 5 + armor;
                case POST_PLANTERA -> 10 + armor;
            };
        });
    }
    @Override
    public double getKnockbackResistance() {
        double kbr = this.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE) - -0.4;
        return (float)switch (this.level().getDifficulty()) {
            case PEACEFUL, EASY -> -0.4 + kbr;
            case NORMAL -> -0.26 + kbr;
            case HARD -> -0.12 + kbr;
        };
    }
    @Override
    protected float getAttackDamage() {
        double attackDamage = this.getAttributeValue(Attributes.ATTACK_DAMAGE) - 5;
        return (float)switch (this.level().getDifficulty()) {
            case PEACEFUL, EASY -> 5 + attackDamage;
            case NORMAL -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 10 + attackDamage;
                case HARDMODE -> 8 + attackDamage;
                case POST_PLANTERA -> 18 + attackDamage;
            };
            case HARD -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 15 + attackDamage;
                case HARDMODE -> 12 + attackDamage;
                case POST_PLANTERA -> 27 + attackDamage;
            };
        };
    }
    public static AttributeSupplier.Builder createEntityAttributes() {
        return AttributeSupplier.builder()
                .add(Attributes.MAX_HEALTH, 150)
                .add(Attributes.KNOCKBACK_RESISTANCE, -0.4)
                .add(Attributes.MOVEMENT_SPEED)
                .add(Attributes.ARMOR, 5)
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
                .add(Attributes.ATTACK_DAMAGE, 5);
    }
}
