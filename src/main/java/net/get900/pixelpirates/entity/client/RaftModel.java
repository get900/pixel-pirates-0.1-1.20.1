package net.get900.pixelpirates.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class RaftModel extends EntityModel<Entity> {
	private final ModelPart raft_base;
	private final ModelPart mast;
	private final ModelPart sail;
	public RaftModel(ModelPart root) {
		this.raft_base = root.getChild("raft_base");
		this.mast = root.getChild("mast");
		this.sail = root.getChild("sail");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData raft_base = modelPartData.addChild("raft_base", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(0, 115).cuboid(-9.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(0, 230).cuboid(-15.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(232, 0).cuboid(-21.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(232, 115).cuboid(-27.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(232, 230).cuboid(9.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(0, 345).cuboid(15.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(232, 345).cuboid(21.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(0, 460).cuboid(27.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(464, 115).cuboid(39.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(464, 230).cuboid(33.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(232, 460).cuboid(3.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(464, 0).cuboid(-33.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(464, 345).cuboid(-45.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F))
		.uv(464, 460).cuboid(-39.0F, -3.0F, -56.0F, 4.0F, 3.0F, 112.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData plank_r1 = raft_base.addChild("plank_r1", ModelPartBuilder.create().uv(564, 575).cuboid(-3.0F, -3.0F, -22.0F, 4.0F, 3.0F, 90.0F, new Dilation(0.0F)), ModelTransform.of(22.0F, 1.0F, 51.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData plank_r2 = raft_base.addChild("plank_r2", ModelPartBuilder.create().uv(376, 575).cuboid(-3.0F, -3.0F, -22.0F, 4.0F, 3.0F, 90.0F, new Dilation(0.0F)), ModelTransform.of(22.0F, 1.0F, -25.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData plank_r3 = raft_base.addChild("plank_r3", ModelPartBuilder.create().uv(188, 575).cuboid(-3.0F, -3.0F, -22.0F, 4.0F, 3.0F, 90.0F, new Dilation(0.0F)), ModelTransform.of(22.0F, 1.0F, 11.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData plank_r4 = raft_base.addChild("plank_r4", ModelPartBuilder.create().uv(0, 575).cuboid(-3.0F, -3.0F, -22.0F, 4.0F, 3.0F, 90.0F, new Dilation(0.0F)), ModelTransform.of(22.0F, 1.0F, -49.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData mast = modelPartData.addChild("mast", ModelPartBuilder.create().uv(200, 668).cuboid(-6.0F, -7.0F, -32.0F, 10.0F, 7.0F, 12.0F, new Dilation(0.0F))
		.uv(0, 668).cuboid(-4.0F, -82.0F, -29.0F, 6.0F, 75.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData mast_bottom_r1 = mast.addChild("mast_bottom_r1", ModelPartBuilder.create().uv(166, 668).cuboid(-2.0F, -73.0F, -1.0F, 4.0F, 75.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-37.0F, -27.0F, -30.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData mast_top_r1 = mast.addChild("mast_top_r1", ModelPartBuilder.create().uv(24, 668).cuboid(-2.0F, -73.0F, -1.0F, 4.0F, 75.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-37.0F, -84.0F, -27.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData sail = modelPartData.addChild("sail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData sail_part_8_r1 = sail.addChild("sail_part_8_r1", ModelPartBuilder.create().uv(148, 668).cuboid(-1.0F, -73.0F, 1.0F, 7.0F, 75.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-37.0F, -35.0F, -32.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData sail_part_7_r1 = sail.addChild("sail_part_7_r1", ModelPartBuilder.create().uv(130, 668).cuboid(-1.0F, -73.0F, 1.0F, 7.0F, 75.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-37.0F, -42.0F, -32.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData sail_part_6_r1 = sail.addChild("sail_part_6_r1", ModelPartBuilder.create().uv(112, 668).cuboid(-1.0F, -73.0F, 1.0F, 7.0F, 75.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-37.0F, -49.0F, -32.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData sail_part_5_r1 = sail.addChild("sail_part_5_r1", ModelPartBuilder.create().uv(94, 668).cuboid(-1.0F, -73.0F, 1.0F, 7.0F, 75.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-37.0F, -56.0F, -32.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData sail_part_4_r1 = sail.addChild("sail_part_4_r1", ModelPartBuilder.create().uv(76, 668).cuboid(-1.0F, -73.0F, 1.0F, 7.0F, 75.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-37.0F, -63.0F, -32.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData sail_part_3_r1 = sail.addChild("sail_part_3_r1", ModelPartBuilder.create().uv(58, 668).cuboid(-1.0F, -73.0F, 1.0F, 7.0F, 75.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-37.0F, -70.0F, -32.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData sail_part_2_r1 = sail.addChild("sail_part_2_r1", ModelPartBuilder.create().uv(182, 668).cuboid(-1.0F, -73.0F, 1.0F, 7.0F, 75.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-37.0F, -77.0F, -32.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData sail_part_1_r1 = sail.addChild("sail_part_1_r1", ModelPartBuilder.create().uv(40, 668).cuboid(-1.0F, -73.0F, 1.0F, 7.0F, 75.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-37.0F, -84.0F, -31.0F, 0.0F, 0.0F, 1.5708F));
		return TexturedModelData.of(modelData, 1024, 1024);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		raft_base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		mast.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		sail.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}