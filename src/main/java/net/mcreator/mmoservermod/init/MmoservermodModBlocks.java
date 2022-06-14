
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mmoservermod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.mmoservermod.block.RawOrichalcumBlockBlock;
import net.mcreator.mmoservermod.block.RawMithrilBlockBlock;
import net.mcreator.mmoservermod.block.OrichalcumBlockBlock;
import net.mcreator.mmoservermod.block.MithrilOreBlock;
import net.mcreator.mmoservermod.block.MithrilBlockBlock;
import net.mcreator.mmoservermod.block.LonsdaleiteBlockBlock;
import net.mcreator.mmoservermod.block.DeepslateMithrilOreBlock;
import net.mcreator.mmoservermod.block.DeepslateLonsdaleiteOreBlock;
import net.mcreator.mmoservermod.MmoservermodMod;

public class MmoservermodModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MmoservermodMod.MODID);
	public static final RegistryObject<Block> MITHRIL_ORE = REGISTRY.register("mithril_ore", () -> new MithrilOreBlock());
	public static final RegistryObject<Block> MITHRIL_BLOCK = REGISTRY.register("mithril_block", () -> new MithrilBlockBlock());
	public static final RegistryObject<Block> DEEPSLATE_MITHRIL_ORE = REGISTRY.register("deepslate_mithril_ore",
			() -> new DeepslateMithrilOreBlock());
	public static final RegistryObject<Block> LONSDALEITE_BLOCK = REGISTRY.register("lonsdaleite_block", () -> new LonsdaleiteBlockBlock());
	public static final RegistryObject<Block> DEEPSLATE_LONSDALEITE_ORE = REGISTRY.register("deepslate_lonsdaleite_ore",
			() -> new DeepslateLonsdaleiteOreBlock());
	public static final RegistryObject<Block> RAW_MITHRIL_BLOCK = REGISTRY.register("raw_mithril_block", () -> new RawMithrilBlockBlock());
	public static final RegistryObject<Block> ORICHALCUM_BLOCK = REGISTRY.register("orichalcum_block", () -> new OrichalcumBlockBlock());
	public static final RegistryObject<Block> RAW_ORICHALCUM_BLOCK = REGISTRY.register("raw_orichalcum_block", () -> new RawOrichalcumBlockBlock());
}
