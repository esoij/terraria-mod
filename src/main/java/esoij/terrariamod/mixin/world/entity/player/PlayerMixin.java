package esoij.terrariamod.mixin.world.entity.player;

import esoij.terrariamod.world.entity.ai.attributes.ModAttributes;
import esoij.terrariamod.world.item.MagicItem;
import esoij.terrariamod.world.item.MeleeItem;
import esoij.terrariamod.world.item.RangedItem;
import esoij.terrariamod.world.item.SummonItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
    @Shadow protected abstract float getEnchantedDamage(Entity entity, float damage, DamageSource damageSource);

    @Shadow public abstract float getAttackStrengthScale(float adjustTicks);

    @Shadow public abstract void resetAttackStrengthTicker();

    @Shadow public abstract void sweepAttack();

    @Shadow public abstract void crit(Entity entityHit);

    @Shadow public abstract void magicCrit(Entity entityHit);

    @Shadow public abstract void awardStat(ResourceLocation stat, int increment);

    @Shadow public abstract void causeFoodExhaustion(float exhaustion);

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    /**
     * @author
     * esoij
     * @reason
     * default max health -> 100
     */
    @Overwrite
    public static AttributeSupplier.Builder createAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 1.0)
                .add(ModAttributes.MELEE_DAMAGE, 0.0)
                .add(ModAttributes.RANGED_DAMAGE, 0.0)
                .add(ModAttributes.MAGIC_DAMAGE, 0.0)
                .add(ModAttributes.SUMMON_DAMAGE, 0.0)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_SPEED)
                .add(Attributes.LUCK)
                .add(Attributes.BLOCK_INTERACTION_RANGE, 4.5)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 3.0)
                .add(Attributes.BLOCK_BREAK_SPEED)
                .add(Attributes.SUBMERGED_MINING_SPEED)
                .add(Attributes.SNEAKING_SPEED)
                .add(Attributes.MINING_EFFICIENCY)
                .add(Attributes.SWEEPING_DAMAGE_RATIO)
                .add(Attributes.MAX_HEALTH, 100);
    }
    //@Inject(method = "tick", at = @At("TAIL"))
    //public void tick(CallbackInfo ci) {
    //    if (this.getMainHandItem().getItem() instanceof RangedItem) this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(this.getAttributeValue(ModAttributes.RANGED_DAMAGE) == 0 ? 1 : this.getAttributeValue(ModAttributes.RANGED_DAMAGE));
    //    else if (this.getMainHandItem().getItem() instanceof MagicItem) this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(this.getAttributeValue(ModAttributes.MAGIC_DAMAGE) == 0 ? 1 : this.getAttributeValue(ModAttributes.MAGIC_DAMAGE));
    //    else if (this.getMainHandItem().getItem() instanceof SummonItem) this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(this.getAttributeValue(ModAttributes.SUMMON_DAMAGE) == 0 ? 1 : this.getAttributeValue(ModAttributes.SUMMON_DAMAGE));
    //    else this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(this.getAttributeValue(ModAttributes.MELEE_DAMAGE) == 0 ? 1 : this.getAttributeValue(ModAttributes.MELEE_DAMAGE));
    //}
    /**
     * Attacks for the player the targeted entity with the currently equipped item.  The equipped item has hitEntity called on it. Args: targetEntity
     * @author
     * esoij
     * @reason
     * damage classes
     */
    @Overwrite
    public void attack(Entity target) {
        if (target.isAttackable()) {
            if (!target.skipAttackInteraction(this)) {
                //float f = this.isAutoSpinAttack() ? this.autoSpinAttackDmg : (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                double f = this.getMainHandItem().getItem() instanceof RangedItem ? this.getAttributeValue(ModAttributes.RANGED_DAMAGE) : this.getMainHandItem().getItem() instanceof MagicItem ? this.getAttributeValue(ModAttributes.MAGIC_DAMAGE) : this.getMainHandItem().getItem() instanceof SummonItem ? this.getAttributeValue(ModAttributes.SUMMON_DAMAGE) : this.getMainHandItem().getItem() instanceof MeleeItem ? this.getAttributeValue(ModAttributes.MELEE_DAMAGE) : this.isAutoSpinAttack() ? this.autoSpinAttackDmg : this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                ItemStack itemStack = this.getWeaponItem();
                DamageSource damageSource = this.damageSources().playerAttack((Player)(Object)this);
                double g = this.getEnchantedDamage(target, (float)f, damageSource) - f;
                float h = this.getAttackStrengthScale(0.5F);
                f *= 0.2F + h * h * 0.8F;
                g *= h;
                this.resetAttackStrengthTicker();
                if (target.getType().is(EntityTypeTags.REDIRECTABLE_PROJECTILE)
                        && target instanceof Projectile projectile
                        && projectile.deflect(ProjectileDeflection.AIM_DEFLECT, this, this, true)) {
                    this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_NODAMAGE, this.getSoundSource());
                    return;
                }

                if (f > 0.0F || g > 0.0F) {
                    boolean bl = h > 0.9F;
                    boolean bl2;
                    if (this.isSprinting() && bl) {
                        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, this.getSoundSource(), 1.0F, 1.0F);
                        bl2 = true;
                    } else {
                        bl2 = false;
                    }

                    f += itemStack.getItem().getAttackDamageBonus(target, (float)f, damageSource);
                    boolean bl3 = bl
                            && this.fallDistance > 0.0F
                            && !this.onGround()
                            && !this.onClimbable()
                            && !this.isInWater()
                            && !this.hasEffect(MobEffects.BLINDNESS)
                            && !this.isPassenger()
                            && target instanceof LivingEntity
                            && !this.isSprinting();
                    if (bl3) {
                        f *= 1.5F;
                    }

                    double i = f + g;
                    boolean bl4 = false;
                    double d = (double)(this.walkDist - this.walkDistO);
                    if (bl && !bl3 && !bl2 && this.onGround() && d < (double)this.getSpeed()) {
                        ItemStack itemStack2 = this.getItemInHand(InteractionHand.MAIN_HAND);
                        if (itemStack2.getItem() instanceof SwordItem) {
                            bl4 = true;
                        }
                    }

                    float j = 0.0F;
                    if (target instanceof LivingEntity livingEntity) {
                        j = livingEntity.getHealth();
                    }

                    Vec3 vec3 = target.getDeltaMovement();
                    boolean bl5 = target.hurt(damageSource, (float)i);
                    if (bl5) {
                        float k = this.getKnockback(target, damageSource) + (bl2 ? 1.0F : 0.0F);
                        if (k > 0.0F) {
                            if (target instanceof LivingEntity livingEntity2) {
                                livingEntity2.knockback(
                                        (double)(k * 0.5F), (double) Mth.sin(this.getYRot() * (float) (Math.PI / 180.0)), (double)(-Mth.cos(this.getYRot() * (float) (Math.PI / 180.0)))
                                );
                            } else {
                                target.push(
                                        (double)(-Mth.sin(this.getYRot() * (float) (Math.PI / 180.0)) * k * 0.5F),
                                        0.1,
                                        (double)(Mth.cos(this.getYRot() * (float) (Math.PI / 180.0)) * k * 0.5F)
                                );
                            }

                            this.setDeltaMovement(this.getDeltaMovement().multiply(0.6, 1.0, 0.6));
                            this.setSprinting(false);
                        }

                        if (bl4) {
                            double l = 1.0F + (float)this.getAttributeValue(Attributes.SWEEPING_DAMAGE_RATIO) * f;

                            for(LivingEntity livingEntity3 : this.level().getEntitiesOfClass(LivingEntity.class, target.getBoundingBox().inflate(1.0, 0.25, 1.0))) {
                                if (livingEntity3 != this
                                        && livingEntity3 != target
                                        && !this.isAlliedTo(livingEntity3)
                                        && (!(livingEntity3 instanceof ArmorStand) || !((ArmorStand)livingEntity3).isMarker())
                                        && this.distanceToSqr(livingEntity3) < 9.0) {
                                    float m = this.getEnchantedDamage(livingEntity3, (float)l, damageSource) * h;
                                    livingEntity3.knockback(
                                            0.4F, (double)Mth.sin(this.getYRot() * (float) (Math.PI / 180.0)), (double)(-Mth.cos(this.getYRot() * (float) (Math.PI / 180.0)))
                                    );
                                    livingEntity3.hurt(damageSource, m);
                                    Level var24 = this.level();
                                    if (var24 instanceof ServerLevel serverLevel) {
                                        EnchantmentHelper.doPostAttackEffects(serverLevel, livingEntity3, damageSource);
                                    }
                                }
                            }

                            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, this.getSoundSource(), 1.0F, 1.0F);
                            this.sweepAttack();
                        }

                        if (target instanceof ServerPlayer && target.hurtMarked) {
                            ((ServerPlayer)target).connection.send(new ClientboundSetEntityMotionPacket(target));
                            target.hurtMarked = false;
                            target.setDeltaMovement(vec3);
                        }

                        if (bl3) {
                            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_CRIT, this.getSoundSource(), 1.0F, 1.0F);
                            this.crit(target);
                        }

                        if (!bl3 && !bl4) {
                            if (bl) {
                                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_STRONG, this.getSoundSource(), 1.0F, 1.0F);
                            } else {
                                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_WEAK, this.getSoundSource(), 1.0F, 1.0F);
                            }
                        }

                        if (g > 0.0F) {
                            this.magicCrit(target);
                        }

                        this.setLastHurtMob(target);
                        Entity entity = target;
                        if (target instanceof EnderDragonPart) {
                            entity = ((EnderDragonPart)target).parentMob;
                        }

                        boolean bl6 = false;
                        Level var36 = this.level();
                        if (var36 instanceof ServerLevel serverLevel2) {
                            if (entity instanceof LivingEntity livingEntity3) {
                                bl6 = itemStack.hurtEnemy(livingEntity3, (Player)(Object)this);
                            }

                            EnchantmentHelper.doPostAttackEffects(serverLevel2, target, damageSource);
                        }

                        if (!this.level().isClientSide && !itemStack.isEmpty() && entity instanceof LivingEntity) {
                            if (bl6) {
                                itemStack.postHurtEnemy((LivingEntity)entity, (Player)(Object)this);
                            }

                            if (itemStack.isEmpty()) {
                                if (itemStack == this.getMainHandItem()) {
                                    this.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
                                } else {
                                    this.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
                                }
                            }
                        }

                        if (target instanceof LivingEntity) {
                            float n = j - ((LivingEntity)target).getHealth();
                            this.awardStat(Stats.DAMAGE_DEALT, Math.round(n * 10.0F));
                            if (this.level() instanceof ServerLevel && n > 2.0F) {
                                int o = (int)((double)n * 0.5);
                                ((ServerLevel)this.level()).sendParticles(ParticleTypes.DAMAGE_INDICATOR, target.getX(), target.getY(0.5), target.getZ(), o, 0.1, 0.0, 0.1, 0.2);
                            }
                        }

                        this.causeFoodExhaustion(0.1F);
                    } else {
                        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PLAYER_ATTACK_NODAMAGE, this.getSoundSource(), 1.0F, 1.0F);
                    }
                }
            }
        }
    }
}
