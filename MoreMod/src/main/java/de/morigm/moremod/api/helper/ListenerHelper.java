package de.morigm.moremod.api.helper;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import de.morigm.moremod.Main;

public class ListenerHelper implements Listener
{
	public void register()
	{
		Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
	}
}
