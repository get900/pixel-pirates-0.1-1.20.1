package net.get900.pixelpirates.entity.client;

import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.entity.custom.RaftEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class RaftEntityRenderer extends EntityRenderer<RaftEntity> {

    private static final Identifier TEXTURE = new Identifier(PixelPirates.MOD_ID, "textures/entity/raft.png");
    private final RaftModel model;

    public RaftEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new RaftModel(context.getPart(ModModelLayers.RAFT));
    }

    @Override
    public void render(RaftEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {

        matrices.push();

        // Position and orientation
        matrices.translate(0.0, 1.5, 0.0); // adjust height
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0f - yaw));

        // Render the raft model
        model.render(matrices, vertexConsumers.getBuffer(model.getLayer(TEXTURE)), light,
                net.minecraft.client.render.OverlayTexture.DEFAULT_UV,
                1.0f, 1.0f, 1.0f, 1.0f);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(RaftEntity entity) {
        return TEXTURE;
    }
}