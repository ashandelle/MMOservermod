package net.mcreator.mmoservermod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.mmoservermod.network.MmoservermodModVariables;

public class StatsCommandExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("\u00A7bLevel: "
					+ new java.text.DecimalFormat("##").format((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MmoservermodModVariables.PlayerVariables())).player_level))),
					(false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(
					("\u00A7aExperience: "
							+ new java.text.DecimalFormat("##").format(
									(entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
											new MmoservermodModVariables.PlayerVariables())).player_experience)
							+ "/"
							+ new java.text.DecimalFormat("##")
									.format((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MmoservermodModVariables.PlayerVariables())).player_max_experience)
							+ " ("
							+ new java.text.DecimalFormat("##.###")
									.format(((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MmoservermodModVariables.PlayerVariables())).player_experience
											/ (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new MmoservermodModVariables.PlayerVariables())).player_max_experience)
											* 100)
							+ "%)")),
					(false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("\u00A7cStat Points: "
					+ new java.text.DecimalFormat("##").format((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MmoservermodModVariables.PlayerVariables())).player_statpoints))),
					(false));
	}
}
