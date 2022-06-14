package net.mcreator.mmoservermod.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.mmoservermod.MmoservermodMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MmoservermodModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		MmoservermodMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.player_experience = original.player_experience;
			clone.player_level = original.player_level;
			clone.player_max_experience = original.player_max_experience;
			clone.player_percent_experience = original.player_percent_experience;
			clone.player_stat_vitality = original.player_stat_vitality;
			clone.player_statpoints = original.player_statpoints;
			clone.player_truestat_vitality = original.player_truestat_vitality;
			clone.player_mana = original.player_mana;
			clone.player_max_mana = original.player_max_mana;
			clone.player_stat_intelligence = original.player_stat_intelligence;
			clone.player_truestat_intelligence = original.player_truestat_intelligence;
			if (!event.isWasDeath()) {
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("mmoservermod", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double player_experience = 0.0;
		public double player_level = 1.0;
		public double player_max_experience = 1000.0;
		public double player_percent_experience = 0;
		public double player_stat_vitality = 0;
		public double player_statpoints = 0;
		public double player_truestat_vitality = 20.0;
		public double player_mana = 100.0;
		public double player_max_mana = 100.0;
		public double player_stat_intelligence = 0;
		public double player_truestat_intelligence = 10.0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				MmoservermodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("player_experience", player_experience);
			nbt.putDouble("player_level", player_level);
			nbt.putDouble("player_max_experience", player_max_experience);
			nbt.putDouble("player_percent_experience", player_percent_experience);
			nbt.putDouble("player_stat_vitality", player_stat_vitality);
			nbt.putDouble("player_statpoints", player_statpoints);
			nbt.putDouble("player_truestat_vitality", player_truestat_vitality);
			nbt.putDouble("player_mana", player_mana);
			nbt.putDouble("player_max_mana", player_max_mana);
			nbt.putDouble("player_stat_intelligence", player_stat_intelligence);
			nbt.putDouble("player_truestat_intelligence", player_truestat_intelligence);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			player_experience = nbt.getDouble("player_experience");
			player_level = nbt.getDouble("player_level");
			player_max_experience = nbt.getDouble("player_max_experience");
			player_percent_experience = nbt.getDouble("player_percent_experience");
			player_stat_vitality = nbt.getDouble("player_stat_vitality");
			player_statpoints = nbt.getDouble("player_statpoints");
			player_truestat_vitality = nbt.getDouble("player_truestat_vitality");
			player_mana = nbt.getDouble("player_mana");
			player_max_mana = nbt.getDouble("player_max_mana");
			player_stat_intelligence = nbt.getDouble("player_stat_intelligence");
			player_truestat_intelligence = nbt.getDouble("player_truestat_intelligence");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.player_experience = message.data.player_experience;
					variables.player_level = message.data.player_level;
					variables.player_max_experience = message.data.player_max_experience;
					variables.player_percent_experience = message.data.player_percent_experience;
					variables.player_stat_vitality = message.data.player_stat_vitality;
					variables.player_statpoints = message.data.player_statpoints;
					variables.player_truestat_vitality = message.data.player_truestat_vitality;
					variables.player_mana = message.data.player_mana;
					variables.player_max_mana = message.data.player_max_mana;
					variables.player_stat_intelligence = message.data.player_stat_intelligence;
					variables.player_truestat_intelligence = message.data.player_truestat_intelligence;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
