package esoij.terrariamod.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import esoij.terrariamod.client.model.GreenSlimeModel;
import esoij.terrariamod.client.model.geom.ModModelLayers;
import esoij.terrariamod.resources.ResourceLocationHelper;
import esoij.terrariamod.world.entity.GreenSlime;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GreenSlimeRenderer extends MobRenderer<GreenSlime, GreenSlimeModel<GreenSlime>> {
    private static final ResourceLocation SLIME_LOCATION = ResourceLocationHelper.parse("textures/entity/slime/green_slime.png");
    public GreenSlimeRenderer(EntityRendererProvider.Context context) {
        super(context, new GreenSlimeModel<>(context.bakeLayer(ModModelLayers.GREEN_SLIME)), 0.25F);
    }
    @Override
    protected void renderNameTag(GreenSlime entity, Component displayName, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, float partialTick) {
        displayName = Component.translatable("entity.terraria.green_slime.health", (int)entity.getHealth(), (int)entity.getMaxHealth());
        super.renderNameTag(entity, displayName, poseStack, bufferSource, packedLight, partialTick);
    }
    @Override
    protected boolean shouldShowName(GreenSlime entity) {
        return true;
    }
    @Override
    public void render(GreenSlime entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        this.shadowRadius = 0.25F;
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
    @Override
    protected void scale(GreenSlime livingEntity, PoseStack poseStack, float partialTickTime) {
        float f = 0.999F;
        poseStack.scale(f, f, f);
        poseStack.translate(0.0F, 0.001F, 0.0F);
        float h = Mth.lerp(partialTickTime, livingEntity.oSquish, livingEntity.squish) / (0.5F + 1.0F);
        float i = 1.0F / (h + 1.0F);
        poseStack.scale(((i * 2) * (2f/3f) * 0.9f), ((1.0F / i * 2) * (2f/3f)) * 0.9f, ((i * 2) * (2f/3f)) * 0.9f);
    }
    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getTextureLocation(GreenSlime entity) {
        return SLIME_LOCATION;
    }
}
