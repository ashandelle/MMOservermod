
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
import net.mcreator.mmoservermod.entity.OrichalcumGolemEntity;
import net.mcreator.mmoservermod.entity.NetheriteGolemEntity;
import net.mcreator.mmoservermod.entity.MithrilGolemEntity;
import net.mcreator.mmoservermod.entity.LonsdaleiteGolemEntity;
import net.mcreator.mmoservermod.entity.GoldGolemEntity;
import net.mcreator.mmoservermod.entity.EmeraldGolemEntity;
import net.mcreator.mmoservermod.entity.DiamondGolemEntity;
import net.mcreator.mmoservermod.entity.AdamantineGolemEntity;
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
	public static final RegistryObject<EntityType<DiamondGolemEntity>> DIAMOND_GOLEM = register("diamond_golem",
			EntityType.Builder.<DiamondGolemEntity>of(DiamondGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DiamondGolemEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NetheriteGolemEntity>> NETHERITE_GOLEM = register("netherite_golem",
			EntityType.Builder.<NetheriteGolemEntity>of(NetheriteGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NetheriteGolemEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MithrilGolemEntity>> MITHRIL_GOLEM = register("mithril_golem",
			EntityType.Builder.<MithrilGolemEntity>of(MithrilGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MithrilGolemEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LonsdaleiteGolemEntity>> LONSDALEITE_GOLEM = register("lonsdaleite_golem",
			EntityType.Builder.<LonsdaleiteGolemEntity>of(LonsdaleiteGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LonsdaleiteGolemEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<OrichalcumGolemEntity>> ORICHALCUM_GOLEM = register("orichalcum_golem",
			EntityType.Builder.<OrichalcumGolemEntity>of(OrichalcumGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OrichalcumGolemEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AdamantineGolemEntity>> ADAMANTINE_GOLEM = register("adamantine_golem",
			EntityType.Builder.<AdamantineGolemEntity>of(AdamantineGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AdamantineGolemEntity::new).fireImmune().sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			GoldGolemEntity.init();
			StoneGolemEntity.init();
			EmeraldGolemEntity.init();
			DiamondGolemEntity.init();
			NetheriteGolemEntity.init();
			MithrilGolemEntity.init();
			LonsdaleiteGolemEntity.init();
			OrichalcumGolemEntity.init();
			AdamantineGolemEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(GOLD_GOLEM.get(), GoldGolemEntity.createAttributes().build());
		event.put(STONE_GOLEM.get(), StoneGolemEntity.createAttributes().build());
		event.put(EMERALD_GOLEM.get(), EmeraldGolemEntity.createAttributes().build());
		event.put(DIAMOND_GOLEM.get(), DiamondGolemEntity.createAttributes().build());
		event.put(NETHERITE_GOLEM.get(), NetheriteGolemEntity.createAttributes().build());
		event.put(MITHRIL_GOLEM.get(), MithrilGolemEntity.createAttributes().build());
		event.put(LONSDALEITE_GOLEM.get(), LonsdaleiteGolemEntity.createAttributes().build());
		event.put(ORICHALCUM_GOLEM.get(), OrichalcumGolemEntity.createAttributes().build());
		event.put(ADAMANTINE_GOLEM.get(), AdamantineGolemEntity.createAttributes().build());
	}
}
