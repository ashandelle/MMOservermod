package net.mcreator.mmoservermod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BlockBreakingProcedure {
	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		if (event.getHand() != event.getPlayer().getUsedItemHand())
			return;
		execute(event, event.getWorld().getBlockState(event.getPos()), event.getPlayer());
	}

	public static void execute(BlockState blockstate, Entity entity) {
		execute(null, blockstate, entity);
	}

	private static void execute(@Nullable Event event, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem().isCorrectToolForDrops(blockstate)
				|| (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) || blockstate == Blocks.GRASS_BLOCK.defaultBlockState()
				|| blockstate == Blocks.DIRT_PATH.defaultBlockState() || blockstate == Blocks.MYCELIUM.defaultBlockState()
				|| blockstate == Blocks.DIRT.defaultBlockState() || blockstate == Blocks.COARSE_DIRT.defaultBlockState()
				|| blockstate == Blocks.PODZOL.defaultBlockState() || blockstate == Blocks.ROOTED_DIRT.defaultBlockState()
				|| blockstate == Blocks.MOSS_BLOCK.defaultBlockState() || blockstate == Blocks.MOSS_CARPET.defaultBlockState()
				|| blockstate == Blocks.OAK_PLANKS.defaultBlockState() || blockstate == Blocks.SPRUCE_PLANKS.defaultBlockState()
				|| blockstate == Blocks.BIRCH_PLANKS.defaultBlockState() || blockstate == Blocks.JUNGLE_PLANKS.defaultBlockState()
				|| blockstate == Blocks.ACACIA_PLANKS.defaultBlockState() || blockstate == Blocks.DARK_OAK_PLANKS.defaultBlockState()
				|| blockstate == Blocks.OAK_SAPLING.defaultBlockState() || blockstate == Blocks.SPRUCE_SAPLING.defaultBlockState()
				|| blockstate == Blocks.BIRCH_SAPLING.defaultBlockState() || blockstate == Blocks.JUNGLE_SAPLING.defaultBlockState()
				|| blockstate == Blocks.ACACIA_SAPLING.defaultBlockState() || blockstate == Blocks.DARK_OAK_SAPLING.defaultBlockState()
				|| blockstate == Blocks.SUGAR_CANE.defaultBlockState() || blockstate == Blocks.SAND.defaultBlockState()
				|| blockstate == Blocks.RED_SAND.defaultBlockState() || blockstate == Blocks.GRAVEL.defaultBlockState()
				|| blockstate == Blocks.SLIME_BLOCK.defaultBlockState() || blockstate == Blocks.OAK_LOG.defaultBlockState()
				|| blockstate == Blocks.SPRUCE_LOG.defaultBlockState() || blockstate == Blocks.BIRCH_LOG.defaultBlockState()
				|| blockstate == Blocks.JUNGLE_LOG.defaultBlockState() || blockstate == Blocks.ACACIA_LOG.defaultBlockState()
				|| blockstate == Blocks.DARK_OAK_LOG.defaultBlockState() || blockstate == Blocks.STRIPPED_OAK_LOG.defaultBlockState()
				|| blockstate == Blocks.STRIPPED_SPRUCE_LOG.defaultBlockState() || blockstate == Blocks.STRIPPED_BIRCH_LOG.defaultBlockState()
				|| blockstate == Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState() || blockstate == Blocks.STRIPPED_ACACIA_LOG.defaultBlockState()
				|| blockstate == Blocks.STRIPPED_DARK_OAK_LOG.defaultBlockState() || blockstate == Blocks.OAK_WOOD.defaultBlockState()
				|| blockstate == Blocks.SPRUCE_WOOD.defaultBlockState() || blockstate == Blocks.BIRCH_WOOD.defaultBlockState()
				|| blockstate == Blocks.JUNGLE_WOOD.defaultBlockState() || blockstate == Blocks.ACACIA_WOOD.defaultBlockState()
				|| blockstate == Blocks.DARK_OAK_WOOD.defaultBlockState() || blockstate == Blocks.STRIPPED_OAK_WOOD.defaultBlockState()
				|| blockstate == Blocks.STRIPPED_SPRUCE_WOOD.defaultBlockState() || blockstate == Blocks.STRIPPED_BIRCH_WOOD.defaultBlockState()
				|| blockstate == Blocks.STRIPPED_JUNGLE_WOOD.defaultBlockState() || blockstate == Blocks.STRIPPED_ACACIA_WOOD.defaultBlockState()
				|| blockstate == Blocks.STRIPPED_DARK_OAK_WOOD.defaultBlockState() || blockstate == Blocks.OAK_LEAVES.defaultBlockState()
				|| blockstate == Blocks.SPRUCE_LEAVES.defaultBlockState() || blockstate == Blocks.BIRCH_LEAVES.defaultBlockState()
				|| blockstate == Blocks.JUNGLE_LEAVES.defaultBlockState() || blockstate == Blocks.ACACIA_LEAVES.defaultBlockState()
				|| blockstate == Blocks.DARK_OAK_LEAVES.defaultBlockState() || blockstate == Blocks.AZALEA_LEAVES.defaultBlockState()
				|| blockstate == Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState() || blockstate == Blocks.SPONGE.defaultBlockState()
				|| blockstate == Blocks.WET_SPONGE.defaultBlockState() || blockstate == Blocks.WHITE_BED.defaultBlockState()
				|| blockstate == Blocks.ORANGE_BED.defaultBlockState() || blockstate == Blocks.MAGENTA_BED.defaultBlockState()
				|| blockstate == Blocks.LIGHT_BLUE_BED.defaultBlockState() || blockstate == Blocks.YELLOW_BED.defaultBlockState()
				|| blockstate == Blocks.LIME_BED.defaultBlockState() || blockstate == Blocks.PINK_BED.defaultBlockState()
				|| blockstate == Blocks.GRAY_BED.defaultBlockState() || blockstate == Blocks.LIGHT_GRAY_BED.defaultBlockState()
				|| blockstate == Blocks.CYAN_BED.defaultBlockState() || blockstate == Blocks.PURPLE_BED.defaultBlockState()
				|| blockstate == Blocks.BLUE_BED.defaultBlockState() || blockstate == Blocks.BROWN_BED.defaultBlockState()
				|| blockstate == Blocks.GREEN_BED.defaultBlockState() || blockstate == Blocks.RED_BED.defaultBlockState()
				|| blockstate == Blocks.BLACK_BED.defaultBlockState() || blockstate == Blocks.COBWEB.defaultBlockState()
				|| blockstate == Blocks.DEAD_BUSH.defaultBlockState() || blockstate == Blocks.GRASS.defaultBlockState()
				|| blockstate == Blocks.DANDELION.defaultBlockState() || blockstate == Blocks.POPPY.defaultBlockState()
				|| blockstate == Blocks.BLUE_ORCHID.defaultBlockState() || blockstate == Blocks.ALLIUM.defaultBlockState()
				|| blockstate == Blocks.AZURE_BLUET.defaultBlockState() || blockstate == Blocks.RED_TULIP.defaultBlockState()
				|| blockstate == Blocks.ORANGE_TULIP.defaultBlockState() || blockstate == Blocks.WHITE_TULIP.defaultBlockState()
				|| blockstate == Blocks.PINK_TULIP.defaultBlockState() || blockstate == Blocks.OXEYE_DAISY.defaultBlockState()
				|| blockstate == Blocks.CORNFLOWER.defaultBlockState() || blockstate == Blocks.LILY_OF_THE_VALLEY.defaultBlockState()
				|| blockstate == Blocks.WITHER_ROSE.defaultBlockState() || blockstate == Blocks.SUNFLOWER.defaultBlockState()
				|| blockstate == Blocks.LILAC.defaultBlockState() || blockstate == Blocks.TALL_GRASS.defaultBlockState()
				|| blockstate == Blocks.LARGE_FERN.defaultBlockState() || blockstate == Blocks.ROSE_BUSH.defaultBlockState()
				|| blockstate == Blocks.PEONY.defaultBlockState() || blockstate == Blocks.BROWN_MUSHROOM.defaultBlockState()
				|| blockstate == Blocks.RED_MUSHROOM.defaultBlockState() || blockstate == Blocks.WARPED_FUNGUS.defaultBlockState()
				|| blockstate == Blocks.CRIMSON_FUNGUS.defaultBlockState() || blockstate == Blocks.BROWN_MUSHROOM_BLOCK.defaultBlockState()
				|| blockstate == Blocks.RED_MUSHROOM_BLOCK.defaultBlockState() || blockstate == Blocks.WARPED_WART_BLOCK.defaultBlockState()
				|| blockstate == Blocks.MUSHROOM_STEM.defaultBlockState() || blockstate == Blocks.TNT.defaultBlockState()
				|| blockstate == Blocks.BOOKSHELF.defaultBlockState() || blockstate == Blocks.TORCH.defaultBlockState()
				|| blockstate == Blocks.WALL_TORCH.defaultBlockState() || blockstate == Blocks.SOUL_TORCH.defaultBlockState()
				|| blockstate == Blocks.SOUL_WALL_TORCH.defaultBlockState() || blockstate == Blocks.FIRE.defaultBlockState()
				|| blockstate == Blocks.SOUL_FIRE.defaultBlockState() || blockstate == Blocks.LANTERN.defaultBlockState()
				|| blockstate == Blocks.SOUL_LANTERN.defaultBlockState() || blockstate == Blocks.CAMPFIRE.defaultBlockState()
				|| blockstate == Blocks.SOUL_CAMPFIRE.defaultBlockState() || blockstate == Blocks.CANDLE.defaultBlockState()
				|| blockstate == Blocks.WHITE_CANDLE.defaultBlockState() || blockstate == Blocks.ORANGE_CANDLE.defaultBlockState()
				|| blockstate == Blocks.MAGENTA_CANDLE.defaultBlockState() || blockstate == Blocks.LIGHT_BLUE_CANDLE.defaultBlockState()
				|| blockstate == Blocks.YELLOW_CANDLE.defaultBlockState() || blockstate == Blocks.LIME_CANDLE.defaultBlockState()
				|| blockstate == Blocks.PINK_CANDLE.defaultBlockState() || blockstate == Blocks.GRAY_CANDLE.defaultBlockState()
				|| blockstate == Blocks.LIGHT_GRAY_CANDLE.defaultBlockState() || blockstate == Blocks.CYAN_CANDLE.defaultBlockState()
				|| blockstate == Blocks.PURPLE_CANDLE.defaultBlockState() || blockstate == Blocks.BLUE_CANDLE.defaultBlockState()
				|| blockstate == Blocks.BROWN_CANDLE.defaultBlockState() || blockstate == Blocks.GREEN_CANDLE.defaultBlockState()
				|| blockstate == Blocks.RED_CANDLE.defaultBlockState() || blockstate == Blocks.BLACK_CANDLE.defaultBlockState()
				|| blockstate == Blocks.OAK_STAIRS.defaultBlockState() || blockstate == Blocks.SPRUCE_STAIRS.defaultBlockState()
				|| blockstate == Blocks.BIRCH_STAIRS.defaultBlockState() || blockstate == Blocks.JUNGLE_STAIRS.defaultBlockState()
				|| blockstate == Blocks.ACACIA_STAIRS.defaultBlockState() || blockstate == Blocks.DARK_OAK_STAIRS.defaultBlockState()
				|| blockstate == Blocks.CHEST.defaultBlockState() || blockstate == Blocks.TRAPPED_CHEST.defaultBlockState()
				|| blockstate == Blocks.CRAFTING_TABLE.defaultBlockState() || blockstate == Blocks.WHEAT.defaultBlockState()
				|| blockstate == Blocks.FARMLAND.defaultBlockState() || blockstate == Blocks.OAK_SIGN.defaultBlockState()
				|| blockstate == Blocks.SPRUCE_SIGN.defaultBlockState() || blockstate == Blocks.BIRCH_SIGN.defaultBlockState()
				|| blockstate == Blocks.ACACIA_SIGN.defaultBlockState() || blockstate == Blocks.JUNGLE_SIGN.defaultBlockState()
				|| blockstate == Blocks.DARK_OAK_SIGN.defaultBlockState() || blockstate == Blocks.OAK_WALL_SIGN.defaultBlockState()
				|| blockstate == Blocks.SPRUCE_WALL_SIGN.defaultBlockState() || blockstate == Blocks.BIRCH_WALL_SIGN.defaultBlockState()
				|| blockstate == Blocks.ACACIA_WALL_SIGN.defaultBlockState() || blockstate == Blocks.JUNGLE_WALL_SIGN.defaultBlockState()
				|| blockstate == Blocks.DARK_OAK_WALL_SIGN.defaultBlockState() || blockstate == Blocks.OAK_DOOR.defaultBlockState()
				|| blockstate == Blocks.SPRUCE_DOOR.defaultBlockState() || blockstate == Blocks.BIRCH_DOOR.defaultBlockState()
				|| blockstate == Blocks.JUNGLE_DOOR.defaultBlockState() || blockstate == Blocks.ACACIA_DOOR.defaultBlockState()
				|| blockstate == Blocks.DARK_OAK_DOOR.defaultBlockState() || blockstate == Blocks.OAK_TRAPDOOR.defaultBlockState()
				|| blockstate == Blocks.SPRUCE_TRAPDOOR.defaultBlockState() || blockstate == Blocks.BIRCH_TRAPDOOR.defaultBlockState()
				|| blockstate == Blocks.JUNGLE_TRAPDOOR.defaultBlockState() || blockstate == Blocks.ACACIA_TRAPDOOR.defaultBlockState()
				|| blockstate == Blocks.DARK_OAK_TRAPDOOR.defaultBlockState() || blockstate == Blocks.LADDER.defaultBlockState()
				|| blockstate == Blocks.LEVER.defaultBlockState() || blockstate == Blocks.OAK_BUTTON.defaultBlockState()
				|| blockstate == Blocks.SPRUCE_BUTTON.defaultBlockState() || blockstate == Blocks.BIRCH_BUTTON.defaultBlockState()
				|| blockstate == Blocks.JUNGLE_BUTTON.defaultBlockState() || blockstate == Blocks.ACACIA_BUTTON.defaultBlockState()
				|| blockstate == Blocks.DARK_OAK_BUTTON.defaultBlockState() || blockstate == Blocks.OAK_PRESSURE_PLATE.defaultBlockState()
				|| blockstate == Blocks.SPRUCE_PRESSURE_PLATE.defaultBlockState() || blockstate == Blocks.BIRCH_PRESSURE_PLATE.defaultBlockState()
				|| blockstate == Blocks.JUNGLE_PRESSURE_PLATE.defaultBlockState() || blockstate == Blocks.ACACIA_PRESSURE_PLATE.defaultBlockState()
				|| blockstate == Blocks.DARK_OAK_PRESSURE_PLATE.defaultBlockState() || blockstate == Blocks.TRIPWIRE_HOOK.defaultBlockState()
				|| blockstate == Blocks.TRIPWIRE.defaultBlockState() || blockstate == Blocks.REDSTONE_TORCH.defaultBlockState()
				|| blockstate == Blocks.REDSTONE_WALL_TORCH.defaultBlockState() || blockstate == Blocks.REDSTONE_TORCH.defaultBlockState()
				|| blockstate == Blocks.REDSTONE_WIRE.defaultBlockState() || blockstate == Blocks.REPEATER.defaultBlockState()
				|| blockstate == Blocks.REPEATER.defaultBlockState() || blockstate == Blocks.COMPARATOR.defaultBlockState()
				|| blockstate == Blocks.COMPARATOR.defaultBlockState() || blockstate == Blocks.SCULK_SENSOR.defaultBlockState()
				|| blockstate == Blocks.SNOW.defaultBlockState() || blockstate == Blocks.SNOW_BLOCK.defaultBlockState()
				|| blockstate == Blocks.POWDER_SNOW.defaultBlockState() || blockstate == Blocks.CLAY.defaultBlockState()
				|| blockstate == Blocks.JUKEBOX.defaultBlockState() || blockstate == Blocks.OAK_FENCE.defaultBlockState()
				|| blockstate == Blocks.SPRUCE_FENCE.defaultBlockState() || blockstate == Blocks.BIRCH_FENCE.defaultBlockState()
				|| blockstate == Blocks.JUNGLE_FENCE.defaultBlockState() || blockstate == Blocks.ACACIA_FENCE.defaultBlockState()
				|| blockstate == Blocks.DARK_OAK_FENCE.defaultBlockState() || blockstate == Blocks.OAK_FENCE_GATE.defaultBlockState()
				|| blockstate == Blocks.SPRUCE_FENCE_GATE.defaultBlockState() || blockstate == Blocks.BIRCH_FENCE_GATE.defaultBlockState()
				|| blockstate == Blocks.JUNGLE_FENCE_GATE.defaultBlockState() || blockstate == Blocks.ACACIA_FENCE_GATE.defaultBlockState()
				|| blockstate == Blocks.DARK_OAK_FENCE_GATE.defaultBlockState() || blockstate == Blocks.SOUL_SAND.defaultBlockState()
				|| blockstate == Blocks.SOUL_SOIL.defaultBlockState() || blockstate == Blocks.GLOWSTONE.defaultBlockState()
				|| blockstate == Blocks.SHROOMLIGHT.defaultBlockState() || blockstate == Blocks.NETHER_WART.defaultBlockState()
				|| blockstate == Blocks.NETHER_WART_BLOCK.defaultBlockState() || blockstate == Blocks.CAKE.defaultBlockState()
				|| blockstate == Blocks.MELON.defaultBlockState() || blockstate == Blocks.MELON_STEM.defaultBlockState()
				|| blockstate == Blocks.ATTACHED_MELON_STEM.defaultBlockState() || blockstate == Blocks.PUMPKIN.defaultBlockState()
				|| blockstate == Blocks.CARVED_PUMPKIN.defaultBlockState() || blockstate == Blocks.JACK_O_LANTERN.defaultBlockState()
				|| blockstate == Blocks.PUMPKIN_STEM.defaultBlockState() || blockstate == Blocks.ATTACHED_PUMPKIN_STEM.defaultBlockState()
				|| blockstate == Blocks.SWEET_BERRY_BUSH.defaultBlockState() || blockstate == Blocks.VINE.defaultBlockState()
				|| blockstate == Blocks.GLOW_LICHEN.defaultBlockState() || blockstate == Blocks.LILY_PAD.defaultBlockState()
				|| blockstate == Blocks.BEETROOTS.defaultBlockState() || blockstate == Blocks.END_ROD.defaultBlockState()
				|| blockstate == Blocks.CHORUS_PLANT.defaultBlockState() || blockstate == Blocks.CHORUS_FLOWER.defaultBlockState()
				|| blockstate == Blocks.OAK_SLAB.defaultBlockState() || blockstate == Blocks.SPRUCE_SLAB.defaultBlockState()
				|| blockstate == Blocks.BIRCH_SLAB.defaultBlockState() || blockstate == Blocks.JUNGLE_SLAB.defaultBlockState()
				|| blockstate == Blocks.ACACIA_SLAB.defaultBlockState() || blockstate == Blocks.DARK_OAK_SLAB.defaultBlockState()
				|| blockstate == Blocks.COCOA.defaultBlockState() || blockstate == Blocks.FLOWER_POT.defaultBlockState()
				|| blockstate == Blocks.POTTED_OAK_SAPLING.defaultBlockState() || blockstate == Blocks.POTTED_SPRUCE_SAPLING.defaultBlockState()
				|| blockstate == Blocks.POTTED_BIRCH_SAPLING.defaultBlockState() || blockstate == Blocks.POTTED_JUNGLE_SAPLING.defaultBlockState()
				|| blockstate == Blocks.POTTED_ACACIA_SAPLING.defaultBlockState() || blockstate == Blocks.POTTED_DARK_OAK_SAPLING.defaultBlockState()
				|| blockstate == Blocks.POTTED_FERN.defaultBlockState() || blockstate == Blocks.POTTED_DANDELION.defaultBlockState()
				|| blockstate == Blocks.POTTED_POPPY.defaultBlockState() || blockstate == Blocks.POTTED_BLUE_ORCHID.defaultBlockState()
				|| blockstate == Blocks.POTTED_ALLIUM.defaultBlockState() || blockstate == Blocks.POTTED_AZURE_BLUET.defaultBlockState()
				|| blockstate == Blocks.POTTED_RED_TULIP.defaultBlockState() || blockstate == Blocks.POTTED_ORANGE_TULIP.defaultBlockState()
				|| blockstate == Blocks.POTTED_WHITE_TULIP.defaultBlockState() || blockstate == Blocks.POTTED_PINK_TULIP.defaultBlockState()
				|| blockstate == Blocks.POTTED_OXEYE_DAISY.defaultBlockState() || blockstate == Blocks.POTTED_CORNFLOWER.defaultBlockState()
				|| blockstate == Blocks.POTTED_LILY_OF_THE_VALLEY.defaultBlockState() || blockstate == Blocks.POTTED_WITHER_ROSE.defaultBlockState()
				|| blockstate == Blocks.POTTED_RED_MUSHROOM.defaultBlockState() || blockstate == Blocks.POTTED_BROWN_MUSHROOM.defaultBlockState()
				|| blockstate == Blocks.POTTED_DEAD_BUSH.defaultBlockState() || blockstate == Blocks.POTTED_CACTUS.defaultBlockState()
				|| blockstate == Blocks.POTTED_BAMBOO.defaultBlockState() || blockstate == Blocks.POTTED_CRIMSON_FUNGUS.defaultBlockState()
				|| blockstate == Blocks.POTTED_WARPED_FUNGUS.defaultBlockState() || blockstate == Blocks.POTTED_CRIMSON_ROOTS.defaultBlockState()
				|| blockstate == Blocks.POTTED_WARPED_ROOTS.defaultBlockState() || blockstate == Blocks.POTTED_AZALEA.defaultBlockState()
				|| blockstate == Blocks.POTTED_FLOWERING_AZALEA.defaultBlockState() || blockstate == Blocks.CARROTS.defaultBlockState()
				|| blockstate == Blocks.POTATOES.defaultBlockState() || blockstate == Blocks.HAY_BLOCK.defaultBlockState()
				|| blockstate == Blocks.SKELETON_SKULL.defaultBlockState() || blockstate == Blocks.WITHER_SKELETON_SKULL.defaultBlockState()
				|| blockstate == Blocks.ZOMBIE_HEAD.defaultBlockState() || blockstate == Blocks.PLAYER_HEAD.defaultBlockState()
				|| blockstate == Blocks.CREEPER_HEAD.defaultBlockState() || blockstate == Blocks.DRAGON_HEAD.defaultBlockState()
				|| blockstate == Blocks.SKELETON_WALL_SKULL.defaultBlockState() || blockstate == Blocks.WITHER_SKELETON_WALL_SKULL.defaultBlockState()
				|| blockstate == Blocks.ZOMBIE_WALL_HEAD.defaultBlockState() || blockstate == Blocks.PLAYER_WALL_HEAD.defaultBlockState()
				|| blockstate == Blocks.CREEPER_WALL_HEAD.defaultBlockState() || blockstate == Blocks.DRAGON_WALL_HEAD.defaultBlockState()
				|| blockstate == Blocks.WHITE_WOOL.defaultBlockState() || blockstate == Blocks.ORANGE_WOOL.defaultBlockState()
				|| blockstate == Blocks.MAGENTA_WOOL.defaultBlockState() || blockstate == Blocks.LIGHT_BLUE_WOOL.defaultBlockState()
				|| blockstate == Blocks.YELLOW_WOOL.defaultBlockState() || blockstate == Blocks.LIME_WOOL.defaultBlockState()
				|| blockstate == Blocks.PINK_WOOL.defaultBlockState() || blockstate == Blocks.GRAY_WOOL.defaultBlockState()
				|| blockstate == Blocks.LIGHT_GRAY_WOOL.defaultBlockState() || blockstate == Blocks.CYAN_WOOL.defaultBlockState()
				|| blockstate == Blocks.PURPLE_WOOL.defaultBlockState() || blockstate == Blocks.BLUE_WOOL.defaultBlockState()
				|| blockstate == Blocks.BROWN_WOOL.defaultBlockState() || blockstate == Blocks.GREEN_WOOL.defaultBlockState()
				|| blockstate == Blocks.RED_WOOL.defaultBlockState() || blockstate == Blocks.BLACK_WOOL.defaultBlockState()
				|| blockstate == Blocks.WHITE_CONCRETE_POWDER.defaultBlockState() || blockstate == Blocks.ORANGE_CONCRETE_POWDER.defaultBlockState()
				|| blockstate == Blocks.MAGENTA_CONCRETE_POWDER.defaultBlockState()
				|| blockstate == Blocks.LIGHT_BLUE_CONCRETE_POWDER.defaultBlockState()
				|| blockstate == Blocks.YELLOW_CONCRETE_POWDER.defaultBlockState() || blockstate == Blocks.LIME_CONCRETE_POWDER.defaultBlockState()
				|| blockstate == Blocks.PINK_CONCRETE_POWDER.defaultBlockState() || blockstate == Blocks.GRAY_CONCRETE_POWDER.defaultBlockState()
				|| blockstate == Blocks.LIGHT_GRAY_CONCRETE_POWDER.defaultBlockState()
				|| blockstate == Blocks.CYAN_CONCRETE_POWDER.defaultBlockState() || blockstate == Blocks.PURPLE_CONCRETE_POWDER.defaultBlockState()
				|| blockstate == Blocks.BLUE_CONCRETE_POWDER.defaultBlockState() || blockstate == Blocks.BROWN_CONCRETE_POWDER.defaultBlockState()
				|| blockstate == Blocks.GREEN_CONCRETE_POWDER.defaultBlockState() || blockstate == Blocks.RED_CONCRETE_POWDER.defaultBlockState()
				|| blockstate == Blocks.BLACK_CONCRETE_POWDER.defaultBlockState() || blockstate == Blocks.WHITE_CARPET.defaultBlockState()
				|| blockstate == Blocks.ORANGE_CARPET.defaultBlockState() || blockstate == Blocks.MAGENTA_CARPET.defaultBlockState()
				|| blockstate == Blocks.LIGHT_BLUE_CARPET.defaultBlockState() || blockstate == Blocks.YELLOW_CARPET.defaultBlockState()
				|| blockstate == Blocks.LIME_CARPET.defaultBlockState() || blockstate == Blocks.PINK_CARPET.defaultBlockState()
				|| blockstate == Blocks.GRAY_CARPET.defaultBlockState() || blockstate == Blocks.LIGHT_GRAY_CARPET.defaultBlockState()
				|| blockstate == Blocks.CYAN_CARPET.defaultBlockState() || blockstate == Blocks.PURPLE_CARPET.defaultBlockState()
				|| blockstate == Blocks.BLUE_CARPET.defaultBlockState() || blockstate == Blocks.BROWN_CARPET.defaultBlockState()
				|| blockstate == Blocks.GREEN_CARPET.defaultBlockState() || blockstate == Blocks.RED_CARPET.defaultBlockState()
				|| blockstate == Blocks.BLACK_CARPET.defaultBlockState() || blockstate == Blocks.GLASS.defaultBlockState()
				|| blockstate == Blocks.TINTED_GLASS.defaultBlockState() || blockstate == Blocks.WHITE_STAINED_GLASS.defaultBlockState()
				|| blockstate == Blocks.ORANGE_STAINED_GLASS.defaultBlockState() || blockstate == Blocks.MAGENTA_STAINED_GLASS.defaultBlockState()
				|| blockstate == Blocks.LIGHT_BLUE_STAINED_GLASS.defaultBlockState() || blockstate == Blocks.YELLOW_STAINED_GLASS.defaultBlockState()
				|| blockstate == Blocks.LIME_STAINED_GLASS.defaultBlockState() || blockstate == Blocks.PINK_STAINED_GLASS.defaultBlockState()
				|| blockstate == Blocks.GRAY_STAINED_GLASS.defaultBlockState() || blockstate == Blocks.LIGHT_GRAY_STAINED_GLASS.defaultBlockState()
				|| blockstate == Blocks.CYAN_STAINED_GLASS.defaultBlockState() || blockstate == Blocks.PURPLE_STAINED_GLASS.defaultBlockState()
				|| blockstate == Blocks.BLUE_STAINED_GLASS.defaultBlockState() || blockstate == Blocks.BROWN_STAINED_GLASS.defaultBlockState()
				|| blockstate == Blocks.GREEN_STAINED_GLASS.defaultBlockState() || blockstate == Blocks.RED_STAINED_GLASS.defaultBlockState()
				|| blockstate == Blocks.BLACK_STAINED_GLASS.defaultBlockState() || blockstate == Blocks.GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.WHITE_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.ORANGE_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.MAGENTA_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.LIGHT_BLUE_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.YELLOW_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.LIME_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.PINK_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.GRAY_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.LIGHT_GRAY_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.CYAN_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.PURPLE_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.BLUE_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.BROWN_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.GREEN_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.RED_STAINED_GLASS_PANE.defaultBlockState()
				|| blockstate == Blocks.BLACK_STAINED_GLASS_PANE.defaultBlockState() || blockstate == Blocks.SEA_LANTERN.defaultBlockState()
				|| blockstate == Blocks.SHULKER_BOX.defaultBlockState() || blockstate == Blocks.WHITE_SHULKER_BOX.defaultBlockState()
				|| blockstate == Blocks.ORANGE_SHULKER_BOX.defaultBlockState() || blockstate == Blocks.MAGENTA_SHULKER_BOX.defaultBlockState()
				|| blockstate == Blocks.LIGHT_BLUE_SHULKER_BOX.defaultBlockState() || blockstate == Blocks.YELLOW_SHULKER_BOX.defaultBlockState()
				|| blockstate == Blocks.LIME_SHULKER_BOX.defaultBlockState() || blockstate == Blocks.PINK_SHULKER_BOX.defaultBlockState()
				|| blockstate == Blocks.GRAY_SHULKER_BOX.defaultBlockState() || blockstate == Blocks.LIGHT_GRAY_SHULKER_BOX.defaultBlockState()
				|| blockstate == Blocks.CYAN_SHULKER_BOX.defaultBlockState() || blockstate == Blocks.PURPLE_SHULKER_BOX.defaultBlockState()
				|| blockstate == Blocks.BLUE_SHULKER_BOX.defaultBlockState() || blockstate == Blocks.BROWN_SHULKER_BOX.defaultBlockState()
				|| blockstate == Blocks.GREEN_SHULKER_BOX.defaultBlockState() || blockstate == Blocks.RED_SHULKER_BOX.defaultBlockState()
				|| blockstate == Blocks.BLACK_SHULKER_BOX.defaultBlockState() || blockstate == Blocks.WHITE_BANNER.defaultBlockState()
				|| blockstate == Blocks.WHITE_BANNER.defaultBlockState() || blockstate == Blocks.ORANGE_BANNER.defaultBlockState()
				|| blockstate == Blocks.MAGENTA_BANNER.defaultBlockState() || blockstate == Blocks.LIGHT_BLUE_BANNER.defaultBlockState()
				|| blockstate == Blocks.YELLOW_BANNER.defaultBlockState() || blockstate == Blocks.LIME_BANNER.defaultBlockState()
				|| blockstate == Blocks.PINK_BANNER.defaultBlockState() || blockstate == Blocks.GRAY_BANNER.defaultBlockState()
				|| blockstate == Blocks.LIGHT_GRAY_BANNER.defaultBlockState() || blockstate == Blocks.CYAN_BANNER.defaultBlockState()
				|| blockstate == Blocks.PURPLE_BANNER.defaultBlockState() || blockstate == Blocks.BLUE_BANNER.defaultBlockState()
				|| blockstate == Blocks.BROWN_BANNER.defaultBlockState() || blockstate == Blocks.GREEN_BANNER.defaultBlockState()
				|| blockstate == Blocks.RED_BANNER.defaultBlockState() || blockstate == Blocks.BLACK_BANNER.defaultBlockState()
				|| blockstate == Blocks.WHITE_WALL_BANNER.defaultBlockState() || blockstate == Blocks.WHITE_WALL_BANNER.defaultBlockState()
				|| blockstate == Blocks.ORANGE_WALL_BANNER.defaultBlockState() || blockstate == Blocks.MAGENTA_WALL_BANNER.defaultBlockState()
				|| blockstate == Blocks.LIGHT_BLUE_WALL_BANNER.defaultBlockState() || blockstate == Blocks.YELLOW_WALL_BANNER.defaultBlockState()
				|| blockstate == Blocks.LIME_WALL_BANNER.defaultBlockState() || blockstate == Blocks.PINK_WALL_BANNER.defaultBlockState()
				|| blockstate == Blocks.GRAY_WALL_BANNER.defaultBlockState() || blockstate == Blocks.LIGHT_GRAY_WALL_BANNER.defaultBlockState()
				|| blockstate == Blocks.CYAN_WALL_BANNER.defaultBlockState() || blockstate == Blocks.PURPLE_WALL_BANNER.defaultBlockState()
				|| blockstate == Blocks.BLUE_WALL_BANNER.defaultBlockState() || blockstate == Blocks.BROWN_WALL_BANNER.defaultBlockState()
				|| blockstate == Blocks.GREEN_WALL_BANNER.defaultBlockState() || blockstate == Blocks.RED_WALL_BANNER.defaultBlockState()
				|| blockstate == Blocks.BLACK_WALL_BANNER.defaultBlockState() || blockstate == Blocks.KELP.defaultBlockState()
				|| blockstate == Blocks.KELP_PLANT.defaultBlockState() || blockstate == Blocks.SEAGRASS.defaultBlockState()
				|| blockstate == Blocks.TALL_SEAGRASS.defaultBlockState() || blockstate == Blocks.SEA_PICKLE.defaultBlockState()
				|| blockstate == Blocks.TURTLE_EGG.defaultBlockState() || blockstate == Blocks.BAMBOO_SAPLING.defaultBlockState()
				|| blockstate == Blocks.BAMBOO.defaultBlockState() || blockstate == Blocks.DEAD_TUBE_CORAL_BLOCK.defaultBlockState()
				|| blockstate == Blocks.DEAD_BRAIN_CORAL_BLOCK.defaultBlockState() || blockstate == Blocks.DEAD_BUBBLE_CORAL_BLOCK.defaultBlockState()
				|| blockstate == Blocks.DEAD_FIRE_CORAL_BLOCK.defaultBlockState() || blockstate == Blocks.DEAD_HORN_CORAL_BLOCK.defaultBlockState()
				|| blockstate == Blocks.TUBE_CORAL_BLOCK.defaultBlockState() || blockstate == Blocks.BRAIN_CORAL_BLOCK.defaultBlockState()
				|| blockstate == Blocks.BUBBLE_CORAL_BLOCK.defaultBlockState() || blockstate == Blocks.FIRE_CORAL_BLOCK.defaultBlockState()
				|| blockstate == Blocks.HORN_CORAL_BLOCK.defaultBlockState() || blockstate == Blocks.DEAD_TUBE_CORAL.defaultBlockState()
				|| blockstate == Blocks.DEAD_BRAIN_CORAL.defaultBlockState() || blockstate == Blocks.DEAD_BUBBLE_CORAL.defaultBlockState()
				|| blockstate == Blocks.DEAD_FIRE_CORAL.defaultBlockState() || blockstate == Blocks.DEAD_HORN_CORAL.defaultBlockState()
				|| blockstate == Blocks.TUBE_CORAL.defaultBlockState() || blockstate == Blocks.BRAIN_CORAL.defaultBlockState()
				|| blockstate == Blocks.BUBBLE_CORAL.defaultBlockState() || blockstate == Blocks.FIRE_CORAL.defaultBlockState()
				|| blockstate == Blocks.HORN_CORAL.defaultBlockState() || blockstate == Blocks.DEAD_TUBE_CORAL_FAN.defaultBlockState()
				|| blockstate == Blocks.DEAD_BRAIN_CORAL_FAN.defaultBlockState() || blockstate == Blocks.DEAD_BUBBLE_CORAL_FAN.defaultBlockState()
				|| blockstate == Blocks.DEAD_FIRE_CORAL_FAN.defaultBlockState() || blockstate == Blocks.DEAD_HORN_CORAL_FAN.defaultBlockState()
				|| blockstate == Blocks.TUBE_CORAL_FAN.defaultBlockState() || blockstate == Blocks.BRAIN_CORAL_FAN.defaultBlockState()
				|| blockstate == Blocks.BUBBLE_CORAL_FAN.defaultBlockState() || blockstate == Blocks.FIRE_CORAL_FAN.defaultBlockState()
				|| blockstate == Blocks.HORN_CORAL_FAN.defaultBlockState() || blockstate == Blocks.DEAD_TUBE_CORAL_WALL_FAN.defaultBlockState()
				|| blockstate == Blocks.DEAD_BRAIN_CORAL_WALL_FAN.defaultBlockState()
				|| blockstate == Blocks.DEAD_BUBBLE_CORAL_WALL_FAN.defaultBlockState()
				|| blockstate == Blocks.DEAD_FIRE_CORAL_WALL_FAN.defaultBlockState()
				|| blockstate == Blocks.DEAD_HORN_CORAL_WALL_FAN.defaultBlockState() || blockstate == Blocks.TUBE_CORAL_WALL_FAN.defaultBlockState()
				|| blockstate == Blocks.BRAIN_CORAL_WALL_FAN.defaultBlockState() || blockstate == Blocks.BUBBLE_CORAL_WALL_FAN.defaultBlockState()
				|| blockstate == Blocks.FIRE_CORAL_WALL_FAN.defaultBlockState() || blockstate == Blocks.HORN_CORAL_WALL_FAN.defaultBlockState()
				|| blockstate == Blocks.DRIED_KELP_BLOCK.defaultBlockState() || blockstate == Blocks.CONDUIT.defaultBlockState()
				|| blockstate == Blocks.SCAFFOLDING.defaultBlockState() || blockstate == Blocks.LOOM.defaultBlockState()
				|| blockstate == Blocks.BARREL.defaultBlockState() || blockstate == Blocks.CARTOGRAPHY_TABLE.defaultBlockState()
				|| blockstate == Blocks.FLETCHING_TABLE.defaultBlockState() || blockstate == Blocks.LECTERN.defaultBlockState()
				|| blockstate == Blocks.SMITHING_TABLE.defaultBlockState() || blockstate == Blocks.COMPOSTER.defaultBlockState()
				|| blockstate == Blocks.BEEHIVE.defaultBlockState() || blockstate == Blocks.BEE_NEST.defaultBlockState()
				|| blockstate == Blocks.HONEY_BLOCK.defaultBlockState() || blockstate == Blocks.HONEYCOMB_BLOCK.defaultBlockState()
				|| blockstate == Blocks.WARPED_ROOTS.defaultBlockState() || blockstate == Blocks.NETHER_SPROUTS.defaultBlockState()
				|| blockstate == Blocks.WEEPING_VINES.defaultBlockState() || blockstate == Blocks.WEEPING_VINES_PLANT.defaultBlockState()
				|| blockstate == Blocks.TWISTING_VINES.defaultBlockState() || blockstate == Blocks.TWISTING_VINES_PLANT.defaultBlockState()
				|| blockstate == Blocks.CRIMSON_ROOTS.defaultBlockState() || blockstate == Blocks.CAVE_VINES.defaultBlockState()
				|| blockstate == Blocks.CAVE_VINES_PLANT.defaultBlockState() || blockstate == Blocks.SPORE_BLOSSOM.defaultBlockState()
				|| blockstate == Blocks.AZALEA.defaultBlockState() || blockstate == Blocks.FLOWERING_AZALEA.defaultBlockState()
				|| blockstate == Blocks.BIG_DRIPLEAF.defaultBlockState() || blockstate == Blocks.BIG_DRIPLEAF_STEM.defaultBlockState()
				|| blockstate == Blocks.SMALL_DRIPLEAF.defaultBlockState() || blockstate == Blocks.HANGING_ROOTS.defaultBlockState()
				|| blockstate == Blocks.CANDLE_CAKE.defaultBlockState() || blockstate == Blocks.WHITE_CANDLE_CAKE.defaultBlockState()
				|| blockstate == Blocks.ORANGE_CANDLE_CAKE.defaultBlockState() || blockstate == Blocks.MAGENTA_CANDLE_CAKE.defaultBlockState()
				|| blockstate == Blocks.LIGHT_BLUE_CANDLE_CAKE.defaultBlockState() || blockstate == Blocks.YELLOW_CANDLE_CAKE.defaultBlockState()
				|| blockstate == Blocks.LIME_CANDLE_CAKE.defaultBlockState() || blockstate == Blocks.PINK_CANDLE_CAKE.defaultBlockState()
				|| blockstate == Blocks.GRAY_CANDLE_CAKE.defaultBlockState() || blockstate == Blocks.LIGHT_GRAY_CANDLE_CAKE.defaultBlockState()
				|| blockstate == Blocks.CYAN_CANDLE_CAKE.defaultBlockState() || blockstate == Blocks.PURPLE_CANDLE_CAKE.defaultBlockState()
				|| blockstate == Blocks.BLUE_CANDLE_CAKE.defaultBlockState() || blockstate == Blocks.BROWN_CANDLE_CAKE.defaultBlockState()
				|| blockstate == Blocks.GREEN_CANDLE_CAKE.defaultBlockState() || blockstate == Blocks.RED_CANDLE_CAKE.defaultBlockState()
				|| blockstate == Blocks.BLACK_CANDLE_CAKE.defaultBlockState())) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
