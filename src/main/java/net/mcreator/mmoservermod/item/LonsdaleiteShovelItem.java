
package net.mcreator.mmoservermod.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.mmoservermod.init.MmoservermodModItems;

public class LonsdaleiteShovelItem extends ShovelItem {
	public LonsdaleiteShovelItem() {
		super(new Tier() {
			public int getUses() {
				return 3439;
			}

			public float getSpeed() {
				return 14f;
			}

			public float getAttackDamageBonus() {
				return 9.5f;
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
		}, 1, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
	}
}
