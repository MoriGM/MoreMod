package de.morigm.moremod.api.helper;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerHelper
{
	
	public static Integer getPlayerHighestBlock(Location loc)
	{
		for (int i = loc.getBlockY();i < 255;i++)
			if(loc.getWorld().getBlockAt(loc.getBlockX(), i, loc.getBlockZ()).getType().equals(Material.AIR))
				return i + 1;
		return loc.getBlockY();
	}
	
	public static boolean isPlayer(CommandSender sender)
	{
		return sender instanceof Player;
	}

}
