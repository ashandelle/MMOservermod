
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mmoservermod.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.mmoservermod.network.OpenStatsMenuMessage;
import net.mcreator.mmoservermod.MmoservermodMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class MmoservermodModKeyMappings {
	public static final KeyMapping OPEN_STATS_MENU = new KeyMapping("key.mmoservermod.open_stats_menu", GLFW.GLFW_KEY_M, "key.categories.ui");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(OPEN_STATS_MENU);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == OPEN_STATS_MENU.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						MmoservermodMod.PACKET_HANDLER.sendToServer(new OpenStatsMenuMessage(0, 0));
						OpenStatsMenuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
