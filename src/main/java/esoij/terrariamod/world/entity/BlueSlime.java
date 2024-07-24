package esoij.terrariamod.world.entity;

import esoij.terrariamod.access.world.level.LevelAccess;
import esoij.terrariamod.world.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class BlueSlime extends TerrariaMob implements Enemy {
    public float targetSquish;
    public float squish;
    public float oSquish;
    private boolean wasOnGround;
    private boolean shouldAttackPlayer = false;
    public BlueSlime(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new BlueSlime.BlueSlimeMoveControl(this);
    }
    @Override
    public Item banner() {
        return ModItems.SLIME_BANNER;
    }
    /**
     * Returns the maximum health of the entity (what it is able to regenerate up to, what it spawned with, etc.)
     */
    @Override
    public float getMaxHealth() {
        double health = this.getAttributeValue(Attributes.MAX_HEALTH) - 25;
        return (float)switch (this.level().getDifficulty()) {
            case PEACEFUL, EASY -> 25 + health;
            case NORMAL -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 50 + health;
                case HARDMODE -> 274 + health;
                case POST_PLANTERA -> 330 + health;
            };
            case HARD -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 75 + health;
                case HARDMODE -> 411 + health;
                case POST_PLANTERA -> 495 + health;
            };
        };
    }
    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    @Override
    public int getArmorValue() {
        double armor = this.getAttributeValue(Attributes.ARMOR) - 2;
        return Mth.floor(switch (this.level().getDifficulty()) {
            case PEACEFUL, EASY -> 2 + armor;
            case NORMAL, HARD -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 2 + armor;
                case HARDMODE -> 10 + armor;
                case POST_PLANTERA -> 12 + armor;
            };
        });
    }
    public double getKnockbackResistance() {
        double kbr = this.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
        return (float)switch (this.level().getDifficulty()) {
            case PEACEFUL, EASY -> kbr * 0;
            case NORMAL -> kbr + 0.1;
            case HARD -> kbr + 0.2;
        };
    }
    protected float getAttackDamage() {
        double attackDamage = this.getAttributeValue(Attributes.ATTACK_DAMAGE) - 7;
        return (float)switch (this.level().getDifficulty()) {
            case PEACEFUL, EASY -> 7 + attackDamage;
            case NORMAL -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 14 + attackDamage;
                case HARDMODE -> 62 + attackDamage;
                case POST_PLANTERA -> 74 + attackDamage;
            };
            case HARD -> switch (((LevelAccess)this.level()).getWorldType()) {
                case PRE_HARDMODE -> 21 + attackDamage;
                case HARDMODE -> 93 + attackDamage;
                case POST_PLANTERA -> 111 + attackDamage;
            };
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
    public boolean hurt(DamageSource source, float amount) {
        if (source.getEntity() != null) this.shouldAttackPlayer = true;
        return super.hurt(source, amount);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new BlueSlime.BlueSlimeFloatGoal(this));
        this.goalSelector.addGoal(2, new BlueSlime.BlueSlimeAttackGoal(this));
        this.goalSelector.addGoal(3, new BlueSlime.BlueSlimeRandomDirectionGoal(this));
        this.goalSelector.addGoal(5, new BlueSlime.BlueSlimeKeepOnJumpingGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, false, false, livingEntity -> shouldAttackPlayer));
    }
    public static AttributeSupplier.Builder createEntityAttributes() {
        return AttributeSupplier.builder()
                .add(Attributes.MAX_HEALTH, 25)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0)
                .add(Attributes.MOVEMENT_SPEED)
                .add(Attributes.ARMOR, 2)
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
                .add(Attributes.ATTACK_DAMAGE, 7);
    }
    @Override
    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("wasOnGround", this.wasOnGround);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.wasOnGround = compound.getBoolean("wasOnGround");
    }
    @Override
    public void tick() {
        this.squish += (this.targetSquish - this.squish) * 0.5F;
        this.oSquish = this.squish;
        super.tick();
        if (this.onGround() && !this.wasOnGround) this.targetSquish = -0.5F;
        else if (!this.onGround() && this.wasOnGround) this.targetSquish = 1.0F;

        this.wasOnGround = this.onGround();
        this.decreaseSquish();
    }
    protected void decreaseSquish() {
        this.targetSquish *= 0.6F;
    }
    /**
     * Gets the amount of time the slime needs to wait between jumps.
     */
    protected int getJumpDelay() {
        return this.random.nextInt(20) + 10;
    }
    @Override
    public void refreshDimensions() {
        double d = this.getX();
        double e = this.getY();
        double f = this.getZ();
        super.refreshDimensions();
        this.setPos(d, e, f);
    }
    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        this.refreshDimensions();
        this.setYRot(this.yHeadRot);
        this.yBodyRot = this.yHeadRot;
        if (this.isInWater() && this.random.nextInt(20) == 0) {
            this.doWaterSplashEffect();
        }

        super.onSyncedDataUpdated(dataAccessor);
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
    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions dimensions, float partialTick) {
        return new Vec3(0.0, (double)dimensions.height() - 0.015625 * (double)partialTick, 0.0);
    }
    /**
     * Indicates weather the slime is able to damage the player (based upon the slime's size)
     */
    protected boolean isDealsDamage() {
        return this.isEffectiveAi();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.SLIME_HURT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SLIME_DEATH;
    }
    public static boolean checkSlimeSpawnRules(EntityType<? extends BlueSlime> slime, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        if (MobSpawnType.isSpawner(spawnType)) {
            return checkMobSpawnRules(slime, level, spawnType, pos, random);
        } else {
            if (level.getDifficulty() != Difficulty.PEACEFUL) {
                if (spawnType == MobSpawnType.SPAWNER) {
                    return checkMobSpawnRules(slime, level, spawnType, pos, random);
                }

                if (pos.getY() > 50 && pos.getY() < 70 && level.dayTime() > 0 && level.dayTime() < 13000) {
                    return checkMobSpawnRules(slime, level, spawnType, pos, random);
                }
            }

            return false;
        }
    }
    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }
    @Override
    public int getMaxHeadXRot() {
        return 0;
    }
    @Override
    public void jumpFromGround() {
        Vec3 vec3 = this.getDeltaMovement();
        this.setDeltaMovement(vec3.x, this.getJumpPower(), vec3.z);
        this.hasImpulse = true;
    }
    static class BlueSlimeAttackGoal extends Goal {
        private final BlueSlime slime;
        private int growTiredTimer;
        public BlueSlimeAttackGoal(BlueSlime slime) {
            this.slime = slime;
            this.setFlags(EnumSet.of(Flag.LOOK));
        }
        @Override
        public boolean canUse() {
            LivingEntity livingEntity = this.slime.getTarget();
            if (livingEntity == null) {
                return false;
            } else {
                return this.slime.canAttack(livingEntity) && this.slime.getMoveControl() instanceof BlueSlimeMoveControl;
            }
        }
        @Override
        public void start() {
            this.growTiredTimer = reducedTickDelay(300);
            super.start();
        }
        @Override
        public boolean canContinueToUse() {
            LivingEntity livingEntity = this.slime.getTarget();
            if (livingEntity == null) {
                return false;
            } else if (!this.slime.canAttack(livingEntity)) {
                return false;
            } else {
                return --this.growTiredTimer > 0;
            }
        }
        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
        @Override
        public void tick() {
            LivingEntity livingEntity = this.slime.getTarget();
            if (livingEntity != null) {
                this.slime.lookAt(livingEntity, 10.0F, 10.0F);
            }

            MoveControl var3 = this.slime.getMoveControl();
            if (var3 instanceof BlueSlime.BlueSlimeMoveControl slimeMoveControl) {
                slimeMoveControl.setDirection(this.slime.getYRot(), this.slime.isDealsDamage());
            }
        }
    }
    static class BlueSlimeFloatGoal extends Goal {
        private final BlueSlime slime;
        public BlueSlimeFloatGoal(BlueSlime slime) {
            this.slime = slime;
            this.setFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
            slime.getNavigation().setCanFloat(true);
        }
        @Override
        public boolean canUse() {
            return (this.slime.isInWater() || this.slime.isInLava()) && this.slime.getMoveControl() instanceof BlueSlime.BlueSlimeMoveControl;
        }
        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
        @Override
        public void tick() {
            if (this.slime.getRandom().nextFloat() < 0.8F) {
                this.slime.getJumpControl().jump();
            }

            MoveControl var2 = this.slime.getMoveControl();
            if (var2 instanceof BlueSlime.BlueSlimeMoveControl slimeMoveControl) {
                slimeMoveControl.setWantedMovement(1.2);
            }
        }
    }
    static class BlueSlimeKeepOnJumpingGoal extends Goal {
        private final BlueSlime slime;
        public BlueSlimeKeepOnJumpingGoal(BlueSlime slime) {
            this.slime = slime;
            this.setFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
        }
        @Override
        public boolean canUse() {
            return !this.slime.isPassenger();
        }
        @Override
        public void tick() {
            MoveControl var2 = this.slime.getMoveControl();
            if (var2 instanceof BlueSlime.BlueSlimeMoveControl slimeMoveControl) {
                slimeMoveControl.setWantedMovement(1.0);
            }
        }
    }
    static class BlueSlimeMoveControl extends MoveControl {
        private float yRot;
        private int jumpDelay;
        private final BlueSlime slime;
        private boolean isAggressive;
        public BlueSlimeMoveControl(BlueSlime blueSlime) {
            super(blueSlime);
            this.slime = blueSlime;
            this.yRot = 180.0F * blueSlime.getYRot() / (float) Math.PI;
        }
        public void setDirection(float yRot, boolean aggressive) {
            this.yRot = yRot;
            this.isAggressive = aggressive;
        }
        public void setWantedMovement(double speed) {
            this.speedModifier = speed;
            this.operation = Operation.MOVE_TO;
        }
        @Override
        public void tick() {
            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), this.yRot, 90.0F));
            this.mob.yHeadRot = this.mob.getYRot();
            this.mob.yBodyRot = this.mob.getYRot();
            if (this.operation != Operation.MOVE_TO) {
                this.mob.setZza(0.0F);
            } else {
                this.operation = Operation.WAIT;
                if (this.mob.onGround()) {
                    this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                    if (this.jumpDelay-- <= 0) {
                        this.jumpDelay = this.slime.getJumpDelay();
                        if (this.isAggressive) {
                            this.jumpDelay /= 3;
                        }

                        this.slime.getJumpControl().jump();
                    } else {
                        this.slime.xxa = 0.0F;
                        this.slime.zza = 0.0F;
                        this.mob.setSpeed(0.0F);
                    }
                } else {
                    this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                }
            }
        }
    }
    static class BlueSlimeRandomDirectionGoal extends Goal {
        private final BlueSlime slime;
        private float chosenDegrees;
        private int nextRandomizeTime;
        public BlueSlimeRandomDirectionGoal(BlueSlime slime) {
            this.slime = slime;
            this.setFlags(EnumSet.of(Flag.LOOK));
        }
        @Override
        public boolean canUse() {
            return this.slime.getTarget() == null
                    && (this.slime.onGround() || this.slime.isInWater() || this.slime.isInLava() || this.slime.hasEffect(MobEffects.LEVITATION))
                    && this.slime.getMoveControl() instanceof BlueSlime.BlueSlimeMoveControl;
        }
        @Override
        public void tick() {
            if (--this.nextRandomizeTime <= 0) {
                this.nextRandomizeTime = this.adjustedTickDelay(40 + this.slime.getRandom().nextInt(60));
                this.chosenDegrees = (float)this.slime.getRandom().nextInt(360);
            }

            MoveControl var2 = this.slime.getMoveControl();
            if (var2 instanceof BlueSlime.BlueSlimeMoveControl slimeMoveControl) {
                slimeMoveControl.setDirection(this.chosenDegrees, false);
            }
        }
    }
}
