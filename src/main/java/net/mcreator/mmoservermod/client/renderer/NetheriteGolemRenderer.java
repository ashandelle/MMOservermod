
package net.mcreator.mmoservermod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.mmoservermod.entity.NetheriteGolemEntity;

public class NetheriteGolemRenderer extends HumanoidMobRenderer<NetheriteGolemEntity, HumanoidModel<NetheriteGolemEntity>> {
	public NetheriteGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(NetheriteGolemEntity entity) {
		return new ResourceLocation("mmoservermod:textures/bdf9df6bebc7aae9.png");
	}
}
