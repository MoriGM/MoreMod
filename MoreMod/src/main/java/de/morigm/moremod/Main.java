package de.morigm.moremod;

import org.bukkit.plugin.java.JavaPlugin;

import de.morigm.moremod.loader.PluginLoader;
import lombok.Getter;

public class Main extends JavaPlugin
{
	
	@Getter private static Main instance;
	@Getter private PluginLoader DefaultPluginLoader;
	
	@Override
	public void onEnable()
	{
		Main.instance = this;
		this.DefaultPluginLoader = new PluginLoader();
		this.DefaultPluginLoader.loadCommands();
		this.DefaultPluginLoader.loadListener();
		this.DefaultPluginLoader.loadWeapons();
	}
	
	@Override
	public void onDisable()
	{
		
	}
	
}
