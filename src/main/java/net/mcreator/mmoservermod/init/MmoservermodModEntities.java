
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mmoservermod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.mmoservermod.entity.StoneGolemEntity;
import net.mcreator.mmoservermod.entity.GoldGolemEntity;
import net.mcreator.mmoservermod.entity.EmeraldGolemEntity;
import net.mcreator.mmoservermod.MmoservermodMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MmoservermodModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, MmoservermodMod.MODID);
	public static final RegistryObject<EntityType<GoldGolemEntity>> GOLD_GOLEM = register("gold_golem",
			EntityType.Builder.<GoldGolemEntity>of(GoldGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GoldGolemEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<StoneGolemEntity>> STONE_GOLEM = register("stone_golem",
			EntityType.Builder.<StoneGolemEntity>of(StoneGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StoneGolemEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EmeraldGolemEntity>> EMERALD_GOLEM = register("emerald_golem",
			EntityType.Builder.<EmeraldGolemEntity>of(EmeraldGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EmeraldGolemEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			GoldGolemEntity.init();
			StoneGolemEntity.init();
			EmeraldGolemEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(GOLD_GOLEM.get(), GoldGolemEntity.createAttributes().build());
		event.put(STONE_GOLEM.get(), StoneGolemEntity.createAttributes().build());
		event.put(EMERALD_GOLEM.get(), EmeraldGolemEntity.createAttributes().build());
	}
}
