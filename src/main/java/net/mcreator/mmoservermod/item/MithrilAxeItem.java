
package net.mcreator.mmoservermod.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.AxeItem;

import net.mcreator.mmoservermod.init.MmoservermodModItems;

public class MithrilAxeItem extends AxeItem {
	public MithrilAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 2643;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 11f;
			}

			public int getLevel() {
				return 5;
			}

			public int getEnchantmentValue() {
				return 25;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MmoservermodModItems.MITHRIL_INGOT.get()));
			}
		}, 1, -2.9000000000000001f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
	}
}
