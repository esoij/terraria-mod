package esoij.terrariamod.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class AngryBonesModel<T extends Mob> extends HumanoidModel<T> {
    public AngryBonesModel(ModelPart root) {
        super(root);
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();
        createDefaultSkeletonMesh(partDefinition);
        return LayerDefinition.create(meshDefinition, 64, 32);
    }
    protected static void createDefaultSkeletonMesh(PartDefinition partDefinition) {
        partDefinition.addOrReplaceChild(
                "right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offset(-5.0F, 2.0F, 0.0F)
        );
        partDefinition.addOrReplaceChild(
                "left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offset(5.0F, 2.0F, 0.0F)
        );
        partDefinition.addOrReplaceChild(
                "right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offset(-2.0F, 12.0F, 0.0F)
        );
        partDefinition.addOrReplaceChild(
                "left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offset(2.0F, 12.0F, 0.0F)
        );
    }
    /**
     * Sets this entity's model rotation angles
     */
    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        ItemStack itemStack = entity.getMainHandItem();
        if (entity.isAggressive() && (itemStack.isEmpty())) {
            float f = Mth.sin(this.attackTime * (float) Math.PI);
            float g = Mth.sin((1.0F - (1.0F - this.attackTime) * (1.0F - this.attackTime)) * (float) Math.PI);
            this.rightArm.zRot = 0.0F;
            this.leftArm.zRot = 0.0F;
            this.rightArm.yRot = -(0.1F - f * 0.6F);
            this.leftArm.yRot = 0.1F - f * 0.6F;
            this.rightArm.xRot = (float) (-Math.PI / 2);
            this.leftArm.xRot = (float) (-Math.PI / 2);
            this.rightArm.xRot -= f * 1.2F - g * 0.4F;
            this.leftArm.xRot -= f * 1.2F - g * 0.4F;
            AnimationUtils.bobArms(this.rightArm, this.leftArm, ageInTicks);
        }
    }
    @Override
    public void translateToHand(HumanoidArm side, PoseStack poseStack) {
        float f = side == HumanoidArm.RIGHT ? 1.0F : -1.0F;
        ModelPart modelPart = this.getArm(side);
        modelPart.x += f;
        modelPart.translateAndRotate(poseStack);
        modelPart.x -= f;
    }
}
