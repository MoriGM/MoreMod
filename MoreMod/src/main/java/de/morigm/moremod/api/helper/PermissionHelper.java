package de.morigm.moremod.api.helper;

import java.io.InputStream;
import java.util.Properties;

import org.bukkit.command.CommandSender;

import lombok.SneakyThrows;

public class PermissionHelper 
{

	private Properties prop;

	@SneakyThrows
	public PermissionHelper(InputStream in)
	{
		this.prop = new Properties();
		this.prop.load(in);
	}
	
	public String getPermission(String permission)
	{
		if (prop.containsKey(permission))
			return prop.getProperty(permission);
		return permission;
	}
	
	public boolean testPermission(CommandSender sender, String permission)
	{
		return sender.hasPermission(getPermission(permission));
	}
	
}
