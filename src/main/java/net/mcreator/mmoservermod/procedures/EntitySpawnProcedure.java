package net.mcreator.mmoservermod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;
import net.minecraft.world.entity.Mob;

@Mod.EventBusSubscriber
public class EntitySpawnProcedure {
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
		if (entity instanceof Creeper) {
			((Mob) entity).targetSelector.addGoal(2, new NearestAttackableTargetGoal<>((Mob) entity, AbstractVillager.class, true));
		}
		if (entity instanceof Skeleton || entity instanceof WitherSkeleton) {
			((Mob) entity).targetSelector.addGoal(3, new NearestAttackableTargetGoal<>((Mob) entity, AbstractVillager.class, true));
		}
		if (entity instanceof Spider || entity instanceof CaveSpider) {
			((Mob) entity).targetSelector.addGoal(3, new SpiderTargetGoal<>((Spider) entity, AbstractVillager.class));
		}

	}

	static class SpiderTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
      public SpiderTargetGoal(Spider p_33832_, Class<T> p_33833_) {
         super(p_33832_, p_33833_, true);
      }

      public boolean canUse() {
         float f = this.mob.getBrightness();
         return f >= 0.5F ? false : super.canUse();
      }
   }
}
