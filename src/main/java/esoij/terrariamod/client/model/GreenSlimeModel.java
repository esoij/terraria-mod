package esoij.terrariamod.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

public class GreenSlimeModel<T extends Entity> extends BlueSlimeModel<T> {
    public GreenSlimeModel(ModelPart root) {
        super(root);
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 14.0F, -8.0F, 16.0F, 11.0F, 16.0F), PartPose.ZERO);
        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}
