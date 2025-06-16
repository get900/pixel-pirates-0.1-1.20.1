package net.get900.pixelpirates.entity.client;

import net.get900.pixelpirates.entity.custom.ShipEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ModelShip<T extends ShipEntity> extends SinglePartEntityModel<T> {
	private final ModelPart hull;
	private final ModelPart sail;
	private final ModelPart bb_main;
	public ModelShip(ModelPart root) {
		this.hull = root.getChild("hull");
		this.sail = root.getChild("sail");
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData hull = modelPartData.addChild("hull", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -6.0F, -5.0F, 6.0F, 5.0F, 13.0F, new Dilation(0.0F))
		.uv(20, 33).cuboid(-2.5F, -7.0F, -6.0F, 5.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 40).cuboid(-1.5F, -7.0F, -7.0F, 3.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(40, 20).cuboid(-0.5F, -7.0F, -10.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 18).cuboid(-2.5F, -2.0F, -5.0F, 5.0F, 2.0F, 13.0F, new Dilation(0.0F))
		.uv(20, 40).cuboid(-2.5F, -10.0F, 8.5F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 33).cuboid(-3.0F, -9.0F, 5.0F, 6.0F, 3.0F, 4.0F, new Dilation(0.0F))
		.uv(32, 33).cuboid(-2.5F, -6.0F, 8.0F, 5.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData railing_6_r1 = hull.addChild("railing_6_r1", ModelPartBuilder.create().uv(40, 18).cuboid(0.5F, -1.0F, -1.5F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -9.0F, 4.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData railing_5_r1 = hull.addChild("railing_5_r1", ModelPartBuilder.create().uv(8, 40).cuboid(0.5F, -1.0F, -1.5F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -9.0F, 4.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData railing_4_r1 = hull.addChild("railing_4_r1", ModelPartBuilder.create().uv(38, 16).cuboid(-0.5F, -1.0F, -1.5F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -6.0F, 3.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData railing_3_r1 = hull.addChild("railing_3_r1", ModelPartBuilder.create().uv(38, 14).cuboid(-0.5F, -1.0F, -1.5F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -6.0F, 3.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData railing_2_r1 = hull.addChild("railing_2_r1", ModelPartBuilder.create().uv(32, 39).cuboid(-0.5F, -1.0F, -1.5F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -6.0F, -5.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData railing_1_r1 = hull.addChild("railing_1_r1", ModelPartBuilder.create().uv(38, 12).cuboid(-0.5F, -1.0F, -1.5F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -6.0F, -5.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData sail = modelPartData.addChild("sail", ModelPartBuilder.create().uv(38, 9).cuboid(-3.0F, -12.0F, -2.5F, 6.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData sail_seg_3_r1 = sail.addChild("sail_seg_3_r1", ModelPartBuilder.create().uv(38, 6).cuboid(-6.0F, -18.0F, -1.5F, 6.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.0F, -1.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData sail_seg_2_r1 = sail.addChild("sail_seg_2_r1", ModelPartBuilder.create().uv(38, 3).cuboid(-6.0F, -16.0F, -1.5F, 6.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.0F, -1.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData sail_seg_1_r1 = sail.addChild("sail_seg_1_r1", ModelPartBuilder.create().uv(38, 0).cuboid(-6.0F, -14.0F, -1.5F, 6.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.0F, -1.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(36, 18).cuboid(-0.5F, -19.0F, 0.0F, 1.0F, 13.0F, 1.0F, new Dilation(0.0F))
		.uv(40, 24).cuboid(-0.5F, -11.0F, -2.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// No animation logic needed for now
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		hull.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		sail.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
	@Override
	public ModelPart getPart() {
		return bb_main;
	}
}