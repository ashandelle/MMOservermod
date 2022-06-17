
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mmoservermod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.mmoservermod.item.SkillbookItem;
import net.mcreator.mmoservermod.item.RawOrichalcumItem;
import net.mcreator.mmoservermod.item.RawMithrilItem;
import net.mcreator.mmoservermod.item.RawAdamantineItem;
import net.mcreator.mmoservermod.item.OrichalcumSwordItem;
import net.mcreator.mmoservermod.item.OrichalcumShovelItem;
import net.mcreator.mmoservermod.item.OrichalcumPickaxeItem;
import net.mcreator.mmoservermod.item.OrichalcumIngotItem;
import net.mcreator.mmoservermod.item.OrichalcumHoeItem;
import net.mcreator.mmoservermod.item.OrichalcumAxeItem;
import net.mcreator.mmoservermod.item.OrichalcumArmorItem;
import net.mcreator.mmoservermod.item.MithrilSwordItem;
import net.mcreator.mmoservermod.item.MithrilShovelItem;
import net.mcreator.mmoservermod.item.MithrilPickaxeItem;
import net.mcreator.mmoservermod.item.MithrilIngotItem;
import net.mcreator.mmoservermod.item.MithrilHoeItem;
import net.mcreator.mmoservermod.item.MithrilAxeItem;
import net.mcreator.mmoservermod.item.MithrilArmorItem;
import net.mcreator.mmoservermod.item.LonsdaleiteSwordItem;
import net.mcreator.mmoservermod.item.LonsdaleiteShovelItem;
import net.mcreator.mmoservermod.item.LonsdaleitePickaxeItem;
import net.mcreator.mmoservermod.item.LonsdaleiteItem;
import net.mcreator.mmoservermod.item.LonsdaleiteHoeItem;
import net.mcreator.mmoservermod.item.LonsdaleiteAxeItem;
import net.mcreator.mmoservermod.item.LonsdaleiteArmorItem;
import net.mcreator.mmoservermod.item.AdamantineSwordItem;
import net.mcreator.mmoservermod.item.AdamantineShovelItem;
import net.mcreator.mmoservermod.item.AdamantinePickaxeItem;
import net.mcreator.mmoservermod.item.AdamantineIngotItem;
import net.mcreator.mmoservermod.item.AdamantineHoeItem;
import net.mcreator.mmoservermod.item.AdamantineAxeItem;
import net.mcreator.mmoservermod.item.AdamantineArmorItem;
import net.mcreator.mmoservermod.MmoservermodMod;

public class MmoservermodModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MmoservermodMod.MODID);
	public static final RegistryObject<Item> MITHRIL_INGOT = REGISTRY.register("mithril_ingot", () -> new MithrilIngotItem());
	public static final RegistryObject<Item> MITHRIL_ORE = block(MmoservermodModBlocks.MITHRIL_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> MITHRIL_BLOCK = block(MmoservermodModBlocks.MITHRIL_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> MITHRIL_SHOVEL = REGISTRY.register("mithril_shovel", () -> new MithrilShovelItem());
	public static final RegistryObject<Item> MITHRIL_PICKAXE = REGISTRY.register("mithril_pickaxe", () -> new MithrilPickaxeItem());
	public static final RegistryObject<Item> MITHRIL_AXE = REGISTRY.register("mithril_axe", () -> new MithrilAxeItem());
	public static final RegistryObject<Item> MITHRIL_HOE = REGISTRY.register("mithril_hoe", () -> new MithrilHoeItem());
	public static final RegistryObject<Item> MITHRIL_SWORD = REGISTRY.register("mithril_sword", () -> new MithrilSwordItem());
	public static final RegistryObject<Item> MITHRIL_ARMOR_HELMET = REGISTRY.register("mithril_armor_helmet", () -> new MithrilArmorItem.Helmet());
	public static final RegistryObject<Item> MITHRIL_ARMOR_CHESTPLATE = REGISTRY.register("mithril_armor_chestplate",
			() -> new MithrilArmorItem.Chestplate());
	public static final RegistryObject<Item> MITHRIL_ARMOR_LEGGINGS = REGISTRY.register("mithril_armor_leggings",
			() -> new MithrilArmorItem.Leggings());
	public static final RegistryObject<Item> MITHRIL_ARMOR_BOOTS = REGISTRY.register("mithril_armor_boots", () -> new MithrilArmorItem.Boots());
	public static final RegistryObject<Item> DEEPSLATE_MITHRIL_ORE = block(MmoservermodModBlocks.DEEPSLATE_MITHRIL_ORE,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LONSDALEITE = REGISTRY.register("lonsdaleite", () -> new LonsdaleiteItem());
	public static final RegistryObject<Item> LONSDALEITE_BLOCK = block(MmoservermodModBlocks.LONSDALEITE_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DEEPSLATE_LONSDALEITE_ORE = block(MmoservermodModBlocks.DEEPSLATE_LONSDALEITE_ORE,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LONSDALEITE_ARMOR_HELMET = REGISTRY.register("lonsdaleite_armor_helmet",
			() -> new LonsdaleiteArmorItem.Helmet());
	public static final RegistryObject<Item> LONSDALEITE_ARMOR_CHESTPLATE = REGISTRY.register("lonsdaleite_armor_chestplate",
			() -> new LonsdaleiteArmorItem.Chestplate());
	public static final RegistryObject<Item> LONSDALEITE_ARMOR_LEGGINGS = REGISTRY.register("lonsdaleite_armor_leggings",
			() -> new LonsdaleiteArmorItem.Leggings());
	public static final RegistryObject<Item> LONSDALEITE_ARMOR_BOOTS = REGISTRY.register("lonsdaleite_armor_boots",
			() -> new LonsdaleiteArmorItem.Boots());
	public static final RegistryObject<Item> RAW_MITHRIL = REGISTRY.register("raw_mithril", () -> new RawMithrilItem());
	public static final RegistryObject<Item> RAW_MITHRIL_BLOCK = block(MmoservermodModBlocks.RAW_MITHRIL_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LONSDALEITE_SWORD = REGISTRY.register("lonsdaleite_sword", () -> new LonsdaleiteSwordItem());
	public static final RegistryObject<Item> LONSDALEITE_PICKAXE = REGISTRY.register("lonsdaleite_pickaxe", () -> new LonsdaleitePickaxeItem());
	public static final RegistryObject<Item> LONSDALEITE_AXE = REGISTRY.register("lonsdaleite_axe", () -> new LonsdaleiteAxeItem());
	public static final RegistryObject<Item> LONSDALEITE_SHOVEL = REGISTRY.register("lonsdaleite_shovel", () -> new LonsdaleiteShovelItem());
	public static final RegistryObject<Item> LONSDALEITE_HOE = REGISTRY.register("lonsdaleite_hoe", () -> new LonsdaleiteHoeItem());
	public static final RegistryObject<Item> ORICHALCUM_INGOT = REGISTRY.register("orichalcum_ingot", () -> new OrichalcumIngotItem());
	public static final RegistryObject<Item> RAW_ORICHALCUM = REGISTRY.register("raw_orichalcum", () -> new RawOrichalcumItem());
	public static final RegistryObject<Item> ORICHALCUM_BLOCK = block(MmoservermodModBlocks.ORICHALCUM_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> RAW_ORICHALCUM_BLOCK = block(MmoservermodModBlocks.RAW_ORICHALCUM_BLOCK,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ADAMANTINE_INGOT = REGISTRY.register("adamantine_ingot", () -> new AdamantineIngotItem());
	public static final RegistryObject<Item> RAW_ADAMANTINE = REGISTRY.register("raw_adamantine", () -> new RawAdamantineItem());
	public static final RegistryObject<Item> RAW_ADAMANTINE_BLOCK = block(MmoservermodModBlocks.RAW_ADAMANTINE_BLOCK,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ADAMANTINE_BLOCK = block(MmoservermodModBlocks.ADAMANTINE_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ORICHALCUM_ARMOR_HELMET = REGISTRY.register("orichalcum_armor_helmet",
			() -> new OrichalcumArmorItem.Helmet());
	public static final RegistryObject<Item> ORICHALCUM_ARMOR_CHESTPLATE = REGISTRY.register("orichalcum_armor_chestplate",
			() -> new OrichalcumArmorItem.Chestplate());
	public static final RegistryObject<Item> ORICHALCUM_ARMOR_LEGGINGS = REGISTRY.register("orichalcum_armor_leggings",
			() -> new OrichalcumArmorItem.Leggings());
	public static final RegistryObject<Item> ORICHALCUM_ARMOR_BOOTS = REGISTRY.register("orichalcum_armor_boots",
			() -> new OrichalcumArmorItem.Boots());
	public static final RegistryObject<Item> ADAMANTINE_ARMOR_HELMET = REGISTRY.register("adamantine_armor_helmet",
			() -> new AdamantineArmorItem.Helmet());
	public static final RegistryObject<Item> ADAMANTINE_ARMOR_CHESTPLATE = REGISTRY.register("adamantine_armor_chestplate",
			() -> new AdamantineArmorItem.Chestplate());
	public static final RegistryObject<Item> ADAMANTINE_ARMOR_LEGGINGS = REGISTRY.register("adamantine_armor_leggings",
			() -> new AdamantineArmorItem.Leggings());
	public static final RegistryObject<Item> ADAMANTINE_ARMOR_BOOTS = REGISTRY.register("adamantine_armor_boots",
			() -> new AdamantineArmorItem.Boots());
	public static final RegistryObject<Item> ORICHALCUM_SWORD = REGISTRY.register("orichalcum_sword", () -> new OrichalcumSwordItem());
	public static final RegistryObject<Item> ORICHALCUM_PICKAXE = REGISTRY.register("orichalcum_pickaxe", () -> new OrichalcumPickaxeItem());
	public static final RegistryObject<Item> ORICHALCUM_AXE = REGISTRY.register("orichalcum_axe", () -> new OrichalcumAxeItem());
	public static final RegistryObject<Item> ORICHALCUM_SHOVEL = REGISTRY.register("orichalcum_shovel", () -> new OrichalcumShovelItem());
	public static final RegistryObject<Item> ORICHALCUM_HOE = REGISTRY.register("orichalcum_hoe", () -> new OrichalcumHoeItem());
	public static final RegistryObject<Item> ADAMANTINE_SWORD = REGISTRY.register("adamantine_sword", () -> new AdamantineSwordItem());
	public static final RegistryObject<Item> ADAMANTINE_PICKAXE = REGISTRY.register("adamantine_pickaxe", () -> new AdamantinePickaxeItem());
	public static final RegistryObject<Item> ADAMANTINE_AXE = REGISTRY.register("adamantine_axe", () -> new AdamantineAxeItem());
	public static final RegistryObject<Item> ADAMANTINE_SHOVEL = REGISTRY.register("adamantine_shovel", () -> new AdamantineShovelItem());
	public static final RegistryObject<Item> ADAMANTINE_HOE = REGISTRY.register("adamantine_hoe", () -> new AdamantineHoeItem());
	public static final RegistryObject<Item> SKILLBOOK = REGISTRY.register("skillbook", () -> new SkillbookItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
