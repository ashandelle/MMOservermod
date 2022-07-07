package net.mcreator.mmoservermod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.mmoservermod.init.MmoservermodModEntities;
import net.mcreator.mmoservermod.entity.StoneGolemEntity;
import net.mcreator.mmoservermod.entity.NetheriteGolemEntity;
import net.mcreator.mmoservermod.entity.GoldGolemEntity;
import net.mcreator.mmoservermod.entity.EmeraldGolemEntity;
import net.mcreator.mmoservermod.entity.DiamondGolemEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BlockPlacedProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		execute(null, world, x, y, z, blockstate);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock() == Blocks.CARVED_PUMPKIN || blockstate.getBlock() == Blocks.JACK_O_LANTERN)
				&& (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.STONE
				&& (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.STONE) {
			if ((world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == Blocks.STONE
					&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == Blocks.STONE) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x + 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x - 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new StoneGolemEntity(MmoservermodModEntities.STONE_GOLEM.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y - 2), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if ((world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == Blocks.STONE
					&& (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == Blocks.STONE) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new StoneGolemEntity(MmoservermodModEntities.STONE_GOLEM.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y - 2), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		}
		if ((blockstate.getBlock() == Blocks.CARVED_PUMPKIN || blockstate.getBlock() == Blocks.JACK_O_LANTERN)
				&& (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.GOLD_BLOCK
				&& (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.GOLD_BLOCK) {
			if ((world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == Blocks.GOLD_BLOCK
					&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == Blocks.GOLD_BLOCK) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x + 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x - 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new GoldGolemEntity(MmoservermodModEntities.GOLD_GOLEM.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y - 2), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if ((world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == Blocks.GOLD_BLOCK
					&& (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == Blocks.GOLD_BLOCK) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new GoldGolemEntity(MmoservermodModEntities.GOLD_GOLEM.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y - 2), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		}
		if ((blockstate.getBlock() == Blocks.CARVED_PUMPKIN || blockstate.getBlock() == Blocks.JACK_O_LANTERN)
				&& (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.EMERALD_BLOCK
				&& (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.EMERALD_BLOCK) {
			if ((world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == Blocks.EMERALD_BLOCK
					&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == Blocks.EMERALD_BLOCK) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x + 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x - 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new EmeraldGolemEntity(MmoservermodModEntities.EMERALD_GOLEM.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y - 2), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if ((world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == Blocks.EMERALD_BLOCK
					&& (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == Blocks.EMERALD_BLOCK) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new EmeraldGolemEntity(MmoservermodModEntities.EMERALD_GOLEM.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y - 2), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		}
		if ((blockstate.getBlock() == Blocks.CARVED_PUMPKIN || blockstate.getBlock() == Blocks.JACK_O_LANTERN)
				&& (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.DIAMOND_BLOCK
				&& (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.DIAMOND_BLOCK) {
			if ((world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == Blocks.DIAMOND_BLOCK
					&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == Blocks.DIAMOND_BLOCK) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x + 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x - 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new DiamondGolemEntity(MmoservermodModEntities.DIAMOND_GOLEM.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y - 2), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if ((world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == Blocks.DIAMOND_BLOCK
					&& (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == Blocks.DIAMOND_BLOCK) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new DiamondGolemEntity(MmoservermodModEntities.DIAMOND_GOLEM.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y - 2), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		}
		if ((blockstate.getBlock() == Blocks.CARVED_PUMPKIN || blockstate.getBlock() == Blocks.JACK_O_LANTERN)
				&& (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.NETHERITE_BLOCK
				&& (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.NETHERITE_BLOCK) {
			if ((world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == Blocks.NETHERITE_BLOCK
					&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == Blocks.NETHERITE_BLOCK) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x + 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x - 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new NetheriteGolemEntity(MmoservermodModEntities.NETHERITE_GOLEM.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y - 2), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if ((world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == Blocks.NETHERITE_BLOCK
					&& (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == Blocks.NETHERITE_BLOCK) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new NetheriteGolemEntity(MmoservermodModEntities.NETHERITE_GOLEM.get(), _level);
					entityToSpawn.moveTo((x + 0.5), (y - 2), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
