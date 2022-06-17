// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelirongolem<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "irongolem"), "main");
	private final ModelPart body;

	public Modelirongolem(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-7.0F, -2.0F, -4.0F, 14.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(45, 0)
						.addBox(-4.0F, 10.0F, -3.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(34, 21)
						.addBox(-3.0F, -10.0F, -3.5F, 6.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(45, 12)
						.addBox(-1.0F, -5.0F, -5.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition arm0 = body.addOrReplaceChild("arm0", CubeListBuilder.create().texOffs(17, 21).addBox(-10.0F,
				-2.5F, -3.0F, 3.0F, 28.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arm1 = body.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(0, 21).addBox(7.0F, -2.5F,
				-3.0F, 3.0F, 28.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg0 = body.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(53, 37).addBox(-1.5F,
				-3.0F, -3.0F, 4.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 18.0F, 0.0F));

		PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(34, 37).addBox(-3.5F,
				-3.0F, -3.0F, 4.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 18.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}