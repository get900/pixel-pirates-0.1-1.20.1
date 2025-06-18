package net.get900.pixelpirates.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class RaftSeatModel extends EntityModel<Entity> {
	private final ModelPart raftseatbase;
	public RaftSeatModel(ModelPart root) {
		this.raftseatbase = root.getChild("raftseatbase");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData raftseatbase = modelPartData.addChild("raftseatbase", ModelPartBuilder.create().uv(0, 0).cuboid(-10.0F, -2.0F, -3.0F, 20.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		raftseatbase.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}