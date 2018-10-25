package de.morigm.moremod.api.weapon;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import de.morigm.moremod.Main;
import de.morigm.moremod.api.MoreMod;

public interface Weapon extends Listener
{

	public ItemStack getItem();
	public void click(Click click);
	public String getId();
	
	public default void register()
	{
		MoreMod.getWeaponManager().registerWeapon(this);
		Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
	}
	
}
