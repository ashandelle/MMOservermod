
package net.mcreator.mmoservermod.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.mmoservermod.init.MmoservermodModItems;

public class LonsdaleiteHoeItem extends HoeItem {
	public LonsdaleiteHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 3439;
			}

			public float getSpeed() {
				return 14f;
			}

			public float getAttackDamageBonus() {
				return -0.5f;
			}

			public int getLevel() {
				return 6;
			}

			public int getEnchantmentValue() {
				return 25;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(MmoservermodModItems.LONSDALEITE.get()));
			}
		}, 0, 1f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
	}
}
