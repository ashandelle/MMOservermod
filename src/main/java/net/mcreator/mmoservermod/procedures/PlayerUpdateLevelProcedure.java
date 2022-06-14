package net.mcreator.mmoservermod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.mmoservermod.network.MmoservermodModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerUpdateLevelProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinWorldEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double level = 0;
		level = (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MmoservermodModVariables.PlayerVariables())).player_level;
		if (level > 50) {
			{
				double _setval = 1000 * (level % 50 + 50) * Math.pow(2, Math.floor(level / 50) - 1);
				entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_max_experience = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = 1000 * level;
				entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_max_experience = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		{
			double _setval = Math.floor(((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MmoservermodModVariables.PlayerVariables())).player_experience
					/ (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MmoservermodModVariables.PlayerVariables())).player_max_experience)
					* 10000) / 100;
			entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.player_percent_experience = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		while ((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MmoservermodModVariables.PlayerVariables())).player_experience >= (entity
						.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MmoservermodModVariables.PlayerVariables())).player_max_experience) {
			{
				double _setval = (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MmoservermodModVariables.PlayerVariables())).player_experience
						- (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MmoservermodModVariables.PlayerVariables())).player_max_experience;
				entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_experience = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MmoservermodModVariables.PlayerVariables())).player_statpoints
						+ Math.pow(2, Math.floor((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MmoservermodModVariables.PlayerVariables())).player_level / 50) + 1);
				entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_statpoints = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MmoservermodModVariables.PlayerVariables())).player_level + 1;
				entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_level = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			PlayerUpdateStatsProcedure.execute(entity);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7bYou've Leveled Up!"), (false));
			level = (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MmoservermodModVariables.PlayerVariables())).player_level;
			if (level > 50) {
				{
					double _setval = 1000 * (level % 50 + 50) * Math.pow(2, Math.floor(level / 50) - 1);
					entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.player_max_experience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					double _setval = 1000 * level;
					entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.player_max_experience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			{
				double _setval = Math.floor(((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MmoservermodModVariables.PlayerVariables())).player_experience
						/ (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MmoservermodModVariables.PlayerVariables())).player_max_experience)
						* 10000) / 100;
				entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_percent_experience = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
