package net.get900.pixelpirates.entity.client;

import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.entity.custom.RaftEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RaftEntityRenderer extends EntityRenderer<RaftEntity> {

    private static final Identifier TEXTURE = new Identifier(PixelPirates.MOD_ID, "textures/entity/raft.png");
    private final RaftModel model;

    public RaftEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new RaftModel(context.getPart(ModModelLayers.RAFT));
    }

    @Override
    public void render(RaftEntity entity, float entityYaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        // Move model origin to entity position
        matrices.translate(0.0, 1.5, 0.0);  // Raise up (adjust if needed)
        matrices.scale(1.0F, -1.0F, 1.0F);  // Flip vertically to fix upside-down issue

        this.model.setAngles(entity, 0.0F, 0.0F, 0.0F, entityYaw, entity.getPitch());
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(model.getLayer(TEXTURE));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1F, 1F, 1F, 1F);

        matrices.pop();
        super.render(entity, entityYaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(RaftEntity entity) {
        return TEXTURE;
    }
}