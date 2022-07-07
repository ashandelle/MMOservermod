package net.mcreator.mmoservermod.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvents;

public class DiamondGolemRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double f1 = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) != (entity instanceof LivingEntity _livEnt
				? _livEnt.getMaxHealth()
				: -1) && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) Math.min((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 50,
						entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1));
			((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
			f1 = 1 + (Math.random() - Math.random()) * 2;
			entity.playSound(SoundEvents.IRON_GOLEM_REPAIR, 1.0F, (float) f1);
		}
	}
}
