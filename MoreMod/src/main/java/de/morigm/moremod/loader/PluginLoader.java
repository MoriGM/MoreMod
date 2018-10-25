package de.morigm.moremod.loader;

import de.morigm.moremod.command.WEAPON_GIVE;
import de.morigm.moremod.listener.Weapon_Listener;
import de.morigm.moremod.weapons.GravityGun;

public class PluginLoader 
{
	
	public void loadCommands()
	{
		new WEAPON_GIVE().register("weapon-give");;
	}
	
	public void loadListener()
	{
		new Weapon_Listener().register();
	}
	
	public void loadWeapons()
	{
		new GravityGun().register();
	}
	
}
