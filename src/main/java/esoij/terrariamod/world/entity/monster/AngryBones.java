package esoij.terrariamod.world.entity.monster;

import esoij.terrariamod.access.world.level.LevelAccess;
import esoij.terrariamod.world.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class AngryBones extends TerrariaMonster {
    public AngryBones(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public Item banner() {
        return ModItems.ANGRY_BONES_BANNER;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, false, false, livingEntity -> true));
    }
    /**
     * Returns the maximum health of the entity (what it is able to regenerate up to, what it spawned with, etc.)
     */
    @Override
    public float getMaxHealth() {
        double health = this.getAttributeValue(Attributes.MAX_HEALTH) - 80;
        return (float)switch (this.level().getDifficulty()) {
            case PEACEFUL, EASY -> 80 + health;
            case NORMAL -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 160 + health;
                case HARDMODE, POST_PLANTERA -> 176 + health;
            };
            case HARD -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 240 + health;
                case HARDMODE, POST_PLANTERA -> 264 + health;
            };
        };
    }
    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    @Override
    public int getArmorValue() {
        double armor = this.getAttributeValue(Attributes.ARMOR) - 8;
        return Mth.floor(armor + 8);
    }
    public double getKnockbackResistance() {
        double kbr = this.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE) - 0.2;
        return (float)switch (this.level().getDifficulty()) {
            case PEACEFUL, EASY -> kbr + 0.2;
            case NORMAL -> kbr + 0.28;
            case HARD -> kbr + 0.36;
        };
    }
    @Override
    public void knockback(double strength, double x, double z) {
        strength *= 1.0 - this.getKnockbackResistance();
        if (!(strength <= 0.0)) {
            this.hasImpulse = true;

            Vec3 vec3;
            for(vec3 = this.getDeltaMovement(); x * x + z * z < 1.0E-5F; z = (Math.random() - Math.random()) * 0.01) {
                x = (Math.random() - Math.random()) * 0.01;
            }

            Vec3 vec32 = new Vec3(x, 0.0, z).normalize().scale(strength);
            this.setDeltaMovement(vec3.x / 2.0 - vec32.x, this.onGround() ? Math.min(0.4, vec3.y / 2.0 + strength) : vec3.y, vec3.z / 2.0 - vec32.z);
        }
    }
    @Override
    public void push(Entity entity) {
        if (entity instanceof LivingEntity livingEntity && this.isDealsDamage() && !(livingEntity instanceof Mob)) this.dealDamage(livingEntity);
        super.push(entity);
    }
    protected void dealDamage(LivingEntity livingEntity) {
        if (this.isAlive() && this.isWithinMeleeAttackRange(livingEntity)) {
            DamageSource damageSource = this.damageSources().mobAttack(this);
            if (livingEntity.hurt(damageSource, this.getAttackDamage())) {
                if (this.level() instanceof ServerLevel serverLevel) {
                    EnchantmentHelper.doPostAttackEffects(serverLevel, livingEntity, damageSource);
                }
            }
        }
    }
    /**
     * Indicates weather the slime is able to damage the player (based upon the slime's size)
     */
    protected boolean isDealsDamage() {
        return this.isEffectiveAi();
    }
    protected float getAttackDamage() {
        double attackDamage = this.getAttributeValue(Attributes.ATTACK_DAMAGE) - 26;
        return (float)switch (this.level().getDifficulty()) {
            case PEACEFUL, EASY -> 26 + attackDamage;
            case NORMAL -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 52 + attackDamage;
                case HARDMODE, POST_PLANTERA -> 46 + attackDamage;
            };
            case HARD -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 78 + attackDamage;
                case HARDMODE, POST_PLANTERA -> 69 + attackDamage;
            };
        };
    }
    public static AttributeSupplier.Builder createAttributes() {
        return AttributeSupplier.builder()
                .add(Attributes.MAX_HEALTH, 80)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2)
                .add(Attributes.ARMOR, 8)
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
                .add(Attributes.FOLLOW_RANGE, 16.0)
                .add(Attributes.ATTACK_DAMAGE, 26)
                .add(Attributes.MOVEMENT_SPEED, 0.25);
    }
    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }
    SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.SKELETON_HURT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }
    @Override
    public void rideTick() {
        super.rideTick();
        Entity var2 = this.getControlledVehicle();
        if (var2 instanceof PathfinderMob pathfinderMob) {
            this.yBodyRot = pathfinderMob.yBodyRot;
        }
    }
}
