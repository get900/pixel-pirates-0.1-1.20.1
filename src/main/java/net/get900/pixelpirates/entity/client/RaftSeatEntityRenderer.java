package net.get900.pixelpirates.entity.client;

import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.entity.custom.RaftSeatEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RaftSeatEntityRenderer extends EntityRenderer<RaftSeatEntity> {
    private final RaftSeatModel model;

    public RaftSeatEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new RaftSeatModel(context.getPart(ModModelLayers.RAFT_SEAT));
    }

    @Override
    public void render(RaftSeatEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.translate(0.0D, 1.5D, 0.0D);
        matrices.scale(-1.0F, -1.0F, 1.0F);
        model.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityCutout(getTexture(entity))),
                light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        matrices.pop();

        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(RaftSeatEntity entity) {
        return new Identifier(PixelPirates.MOD_ID, "textures/entity/raft_seat.png");
    }
}