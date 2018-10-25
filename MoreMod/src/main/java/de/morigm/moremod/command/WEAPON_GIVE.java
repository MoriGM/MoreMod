package de.morigm.moremod.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.morigm.moremod.api.MoreMod;
import de.morigm.moremod.api.helper.CommandHelper;
import de.morigm.moremod.api.helper.PlayerHelper;
import de.morigm.moremod.api.weapon.Weapon;
import de.morigm.moremod.chat.Chat;

public class WEAPON_GIVE extends CommandHelper
{

	@Override
	public boolean onCommand(CommandSender com, Command cmd, String lebel, String[] args) 
	{
		if (PlayerHelper.isPlayer(com))
		{
			if (testPermission(com, "weapon_give"))
			{
				if(args.length >= 1)
				{
					Weapon w = MoreMod.getWeaponManager().getWeapon(args[0]);
					if (w != null)
					{
						Player p = (Player) com;
						p.getInventory().addItem(w.getItem());
						p.sendMessage(Chat.prefix + "Added Item");
					}
					else
						com.sendMessage(Chat.prefix + "Weapon doesn't exists");
				}
				else
					com.sendMessage(Chat.prefix + "/" + getCommand() + " <weapon>");
			}
			else
				com.sendMessage(Chat.prefix + "You have no Permission");
		}
		else
			com.sendMessage(Chat.prefix + "You must be a Player");
		return false;
	}
	

}
