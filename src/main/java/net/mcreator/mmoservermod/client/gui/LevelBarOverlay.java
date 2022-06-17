
package net.mcreator.mmoservermod.client.gui;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.mmoservermod.network.MmoservermodModVariables;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class LevelBarOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			int w = event.getWindow().getGuiScaledWidth();
			int h = event.getWindow().getGuiScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			Level _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.level;
				_x = entity.getX();
				_y = entity.getY();
				_z = entity.getZ();
			}
			Level world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			if (true) {
				Minecraft.getInstance().font
						.draw(event.getMatrixStack(),
								"LVL: " + (int) ((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new MmoservermodModVariables.PlayerVariables())).player_level) + "",
								20, h - 100, -2302756);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"EXP: " + (int) ((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MmoservermodModVariables.PlayerVariables())).player_experience) + "/"
								+ (int) ((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new MmoservermodModVariables.PlayerVariables())).player_max_experience)
								+ " ("
								+ (100 * ((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MmoservermodModVariables.PlayerVariables())).player_experience) / ((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new MmoservermodModVariables.PlayerVariables())).player_max_experience))
								+ "%)",
						20, h - 90, -2302756);
			}
		}
	}
}
