package esoij.terrariamod.client.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class WatchModel extends HumanoidModel<LivingEntity> {
    public WatchModel(ModelPart root) {
        super(root);
        this.setAllVisible(false);
        this.rightArm.visible = true;
    }
    public static LayerDefinition createBodyLayer() {
        CubeDeformation cubeDeformation = CubeDeformation.NONE;
        MeshDefinition mesh = HumanoidModel.createMesh(cubeDeformation, 0);
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-2, -2, -2, 4, 12, 4, cubeDeformation), PartPose.offset(5, 2, 0));
        root.addOrReplaceChild("right_sleeve", CubeListBuilder.create().texOffs(40, 32).addBox(-2, -2, -2, 4, 12, 4, cubeDeformation.extend(.25f)), PartPose.offset(5, 2, 0));
        return LayerDefinition.create(mesh, 64, 32);
    }
}
