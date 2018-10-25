package de.morigm.moremod.api.helper;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.morigm.moremod.Main;
import de.morigm.moremod.api.MoreMod;

public abstract class CommandHelper implements CommandExecutor
{

	private String name;

	public void register(String name)
	{
		this.name = name;
		Main.getInstance().getCommand(name).setExecutor(this);
	}
	
	public String getCommand()
	{
		return name;
	}
	
	public String getPermission(String permission)
	{
		return MoreMod.getPermissionHelper().getPermission(permission);
	}
	
	public boolean testPermission(CommandSender sender, String permission)
	{
		return sender.hasPermission(getPermission(permission));
	}
	
}
