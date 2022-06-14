package net.mcreator.mmoservermod.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.Entity;

import net.mcreator.mmoservermod.network.MmoservermodModVariables;

import java.util.HashMap;

public class SetExperienceCommandExecutedProcedure {
	public static void execute(Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "");
			entity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.player_experience = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		PlayerUpdateLevelProcedure.execute(entity);
	}
}
