package net.mcreator.mmoservermod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.mmoservermod.network.MmoservermodModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerUpdateStatsProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinWorldEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
						("/attribute @s minecraft:generic.max_health base set "
								+ ((entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new MmoservermodModVariables.PlayerVariables())).player_truestat_vitality
										+ (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new MmoservermodModVariables.PlayerVariables())).player_stat_vitality * 5
										+ (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new MmoservermodModVariables.PlayerVariables())).player_level * 2)));
		}
		{
			double _setval = (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MmoservermodModVariables.PlayerVariables())).player_truestat_intelligence
					+ (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MmoservermodModVariables.PlayerVariables())).player_stat_intelligence * 10
					+ (entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MmoservermodModVariables.PlayerVariables())).player_level * 5;
			entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.player_max_mana = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
