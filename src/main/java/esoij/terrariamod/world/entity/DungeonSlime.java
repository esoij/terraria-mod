package esoij.terrariamod.world.entity;

import esoij.terrariamod.access.world.level.LevelAccess;
import esoij.terrariamod.world.item.ModItems;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class DungeonSlime extends BlueSlime {
    public DungeonSlime(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    public Item banner() {
        return ModItems.DUNGEON_SLIME_BANNER;
    }
    /**
     * Returns the maximum health of the entity (what it is able to regenerate up to, what it spawned with, etc.)
     */
    @Override
    public float getMaxHealth() {
        double health = this.getAttributeValue(Attributes.MAX_HEALTH) - 150;
        return (float)switch (this.level().getDifficulty()) {
            default -> 150 + health;
            case NORMAL -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 300 + health;
                case HARDMODE, POST_PLANTERA -> 330 + health;
            };
            case HARD -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 450 + health;
                case HARDMODE, POST_PLANTERA -> 495 + health;
            };
        };
    }
    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    @Override
    public int getArmorValue() {
        double armor = this.getAttributeValue(Attributes.ARMOR) - 7;
        return Mth.floor(armor + 7);
    }
    @Override
    public double getKnockbackResistance() {
        double kbr = this.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE) - 0.4;
        return (float)switch (this.level().getDifficulty()) {
            default -> 0.4 + kbr;
            case NORMAL -> 0.46 + kbr;
            case HARD -> 0.52 + kbr;
        };
    }
    @Override
    protected float getAttackDamage() {
        double attackDamage = this.getAttributeValue(Attributes.ATTACK_DAMAGE) - 30;
        return (float)switch (this.level().getDifficulty()) {
            default -> 30 + attackDamage;
            case NORMAL -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 60 + attackDamage;
                case HARDMODE, POST_PLANTERA -> 54 + attackDamage;
            };
            case HARD -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 90 + attackDamage;
                case HARDMODE, POST_PLANTERA -> 81 + attackDamage;
            };
        };
    }
    public static AttributeSupplier.Builder createEntityAttributes() {
        return AttributeSupplier.builder()
                .add(Attributes.MAX_HEALTH, 150)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.4)
                .add(Attributes.MOVEMENT_SPEED)
                .add(Attributes.ARMOR, 7)
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
                .add(Attributes.ATTACK_DAMAGE, 30);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new BlueSlime.BlueSlimeFloatGoal(this));
        this.goalSelector.addGoal(2, new BlueSlime.BlueSlimeAttackGoal(this));
        this.goalSelector.addGoal(3, new BlueSlime.BlueSlimeRandomDirectionGoal(this));
        this.goalSelector.addGoal(5, new BlueSlime.BlueSlimeKeepOnJumpingGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, false, false, livingEntity -> true));
    }
}
