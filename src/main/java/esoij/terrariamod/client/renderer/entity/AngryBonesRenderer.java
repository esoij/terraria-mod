package esoij.terrariamod.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import esoij.terrariamod.client.model.AngryBonesModel;
import esoij.terrariamod.client.model.geom.ModModelLayers;
import esoij.terrariamod.resources.ResourceLocationHelper;
import esoij.terrariamod.world.entity.monster.AngryBones;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class AngryBonesRenderer<T extends AngryBones> extends HumanoidMobRenderer<T, AngryBonesModel<T>> {
    private static final ResourceLocation SKELETON_LOCATION = ResourceLocationHelper.parse("textures/entity/angry_bones/angry_bones.png");
    public AngryBonesRenderer(EntityRendererProvider.Context context) {
        this(context, ModModelLayers.ANGRY_BONES);
    }
    public AngryBonesRenderer(EntityRendererProvider.Context context, ModelLayerLocation skeletonLayer) {
        this(context, new AngryBonesModel<>(context.bakeLayer(skeletonLayer)));
    }
    public AngryBonesRenderer(EntityRendererProvider.Context context, AngryBonesModel<T> model) {
        super(context, model, 0.5F);
    }
    @Override
    protected void renderNameTag(T entity, Component displayName, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, float partialTick) {
        displayName = Component.translatable("entity.terraria.angry_bones.health", (int)entity.getHealth(), (int)entity.getMaxHealth());
        super.renderNameTag(entity, displayName, poseStack, bufferSource, packedLight, partialTick);
    }
    @Override
    protected boolean shouldShowName(T entity) {
        return !Minecraft.getInstance().options.hideGui;
    }
    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return SKELETON_LOCATION;
    }
    @Override
    protected void scale(T livingEntity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(1, 1, 1);
    }
}
