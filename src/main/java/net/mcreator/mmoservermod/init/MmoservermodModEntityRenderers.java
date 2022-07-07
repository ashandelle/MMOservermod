
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mmoservermod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.mmoservermod.client.renderer.StoneGolemRenderer;
import net.mcreator.mmoservermod.client.renderer.GoldGolemRenderer;
import net.mcreator.mmoservermod.client.renderer.EmeraldGolemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MmoservermodModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MmoservermodModEntities.GOLD_GOLEM.get(), GoldGolemRenderer::new);
		event.registerEntityRenderer(MmoservermodModEntities.STONE_GOLEM.get(), StoneGolemRenderer::new);
		event.registerEntityRenderer(MmoservermodModEntities.EMERALD_GOLEM.get(), EmeraldGolemRenderer::new);
	}
}
