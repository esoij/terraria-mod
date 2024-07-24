package esoij.terrariamod.client.renderer.accessories;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import esoij.terrariamod.client.model.WatchModel;
import esoij.terrariamod.resources.ResourceLocationHelper;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class GoldWatchRenderer implements TrinketRenderer {
    public HumanoidModel<LivingEntity> model = new WatchModel(WatchModel.createBodyLayer().bakeRoot());
    public ResourceLocation texture = ResourceLocationHelper.parse("textures/models/accessories/gold_watch");
    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, PoseStack matrices, MultiBufferSource vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        this.model.setupAnim(entity, limbAngle, limbDistance, animationProgress, animationProgress, headPitch);
        this.model.prepareMobModel(entity, limbAngle, limbDistance, tickDelta);
        TrinketRenderer.followBodyRotations(entity, this.model);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.model.renderType(this.texture));
        this.model.renderToBuffer(matrices, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1);
    }
}
