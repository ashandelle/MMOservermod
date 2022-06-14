package net.mcreator.mmoservermod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.Giant;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.animal.horse.ZombieHorse;
import net.minecraft.world.entity.animal.horse.TraderLlama;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.GlowSquid;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.mmoservermod.network.MmoservermodModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityDeathExperienceProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double exp = 0;
		if (sourceentity instanceof Player) {
			if (entity instanceof Axolotl || entity instanceof Bat || entity instanceof Bee || entity instanceof Cat || entity instanceof Cod
					|| entity instanceof Fox || entity instanceof GlowSquid || entity instanceof Ocelot || entity instanceof Parrot
					|| entity instanceof Pufferfish || entity instanceof Rabbit || entity instanceof Salmon || entity instanceof Squid
					|| entity instanceof TropicalFish || entity instanceof Turtle) {
				exp = 10;
			} else if (entity instanceof Blaze || entity instanceof Hoglin || entity instanceof Illusioner || entity instanceof PiglinBrute
					|| entity instanceof WitherSkeleton || entity instanceof Zoglin) {
				exp = 200;
			} else if (entity instanceof CaveSpider || entity instanceof Creeper || entity instanceof Drowned || entity instanceof Ghast
					|| entity instanceof Guardian || entity instanceof Husk || entity instanceof Phantom || entity instanceof Piglin
					|| entity instanceof Pillager || entity instanceof PolarBear || entity instanceof Shulker || entity instanceof Skeleton
					|| entity instanceof SnowGolem || entity instanceof Spider || entity instanceof Stray || entity instanceof Vindicator
					|| entity instanceof Witch || entity instanceof Zombie || entity instanceof ZombifiedPiglin) {
				exp = 100;
			} else if (entity instanceof Chicken || entity instanceof Cow || entity instanceof Dolphin || entity instanceof Donkey
					|| entity instanceof Endermite || entity instanceof Goat || entity instanceof Horse || entity instanceof Llama
					|| entity instanceof MagmaCube || entity instanceof Mule || entity instanceof Panda || entity instanceof Pig
					|| entity instanceof Sheep || entity instanceof Silverfish || entity instanceof SkeletonHorse || entity instanceof Slime
					|| entity instanceof Strider || entity instanceof TraderLlama || entity instanceof Vex || entity instanceof Villager
					|| entity instanceof WanderingTrader || entity instanceof Wolf || entity instanceof ZombieHorse
					|| entity instanceof ZombieVillager) {
				if (entity instanceof LivingEntity _livEnt ? _livEnt.isBaby() : false) {
					exp = 25;
				} else {
					exp = 50;
				}
			} else if (entity instanceof EnderDragon) {
				exp = 10000;
			} else if (entity instanceof ElderGuardian || entity instanceof IronGolem || entity instanceof Ravager) {
				exp = 400;
			} else if (entity instanceof EnderMan || entity instanceof Evoker) {
				exp = 300;
			} else if (entity instanceof Giant) {
				exp = 750;
			} else if (entity instanceof WitherBoss) {
				exp = 1250;
			}
			//if (entity.isInvisible()) {
			//	exp = Math.ceil(exp * 1.25);
			//}
			{
				double _setval = (sourceentity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MmoservermodModVariables.PlayerVariables())).player_experience + exp;
				sourceentity.getCapability(MmoservermodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.player_experience = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("\u00A7a+" + new java.text.DecimalFormat("##").format(exp) + "XP")), (false));
			PlayerUpdateLevelProcedure.execute(sourceentity);
		}
	}
}
