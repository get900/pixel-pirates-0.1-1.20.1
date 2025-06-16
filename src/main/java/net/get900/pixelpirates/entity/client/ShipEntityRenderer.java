package net.get900.pixelpirates.entity.client;

import net.get900.pixelpirates.PixelPirates;
import net.get900.pixelpirates.entity.custom.ShipEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class ShipEntityRenderer extends EntityRenderer<ShipEntity> {
    private static final Identifier TEXTURE = new Identifier(PixelPirates.MOD_ID, "textures/entity/ship.png");
    private final ModelShip<ShipEntity> model;

    public ShipEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new ModelShip<>(context.getPart(ModModelLayers.SHIP));
        this.shadowRadius = 2.5f; // size of the shadow under the ship
    }

    @Override
    public void render(ShipEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        // Position + rotation
        matrices.translate(0.0, 20.0, 0.0);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180.0F));

        // Scale to 30 block length (if model is ~6 blocks)
        matrices.scale(15.0f, 15.0f, 15.0f); // Adjust this if needed

        // Render the model
        model.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityCutout(TEXTURE)),
                light,
                net.minecraft.client.render.OverlayTexture.DEFAULT_UV,
                1f, 1f, 1f, 1f);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(ShipEntity entity) {
        return TEXTURE;
    }
}