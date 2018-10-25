package de.morigm.moremod.api.helper;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemHelper 
{

	public static boolean isSame(ItemStack item, ItemStack item2)
	{
		if (item == null || item2 == null)
			return false;
		if (item.getType().equals(Material.AIR) || item2.getType().equals(Material.AIR))
			return false;
		if (!item.hasItemMeta() || !item2.hasItemMeta())
			return false;
		if (!item.getType().equals(item2.getType()))
			return false;
		if (!item.getItemMeta().hasDisplayName() || !item2.getItemMeta().hasDisplayName())
			return false;
		if (!item.getItemMeta().getDisplayName().equals(item2.getItemMeta().getDisplayName()))
			return false;
		return true;
	}

}
