package de.morigm.moremod.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;

import de.morigm.moremod.api.helper.ItemHelper;
import de.morigm.moremod.api.weapon.Click;
import de.morigm.moremod.api.weapon.Weapon;

public class WeaponManager
{
	
	private List<Weapon> weapons = new ArrayList<>();
	private Map<Player,Long> last = new HashMap<>();
	
	public void registerWeapon(Weapon w)
	{
		if (!containsWeapon(w.getId()) && !weapons.contains(w))
			weapons.add(w);
	}
	
	public void removeWeapon(Weapon w)
	{
		if (weapons.contains(w))
			weapons.remove(w);
	}
	
	public Weapon getWeapon(String id)
	{
		for (Weapon w : getWeapons())
			if(w.getId().equals(id))
				return w;
		return null;
	}
	
	public Weapon[] getWeapons()
	{
		return weapons.toArray(new Weapon[weapons.size()]);
	}
	
	public boolean containsWeapon(String id)
	{
		return getWeapon(id) != null;
	}
	
	public void click(Click click)
	{
		if (last.containsKey(click.getPlayer()))
			if ((System.currentTimeMillis() - last.get(click.getPlayer())) < 200)
				return;
			else
				last.remove(click.getPlayer());
		
		for (Weapon w : MoreMod.getWeaponManager().getWeapons())
			if (ItemHelper.isSame(w.getItem(), click.getPlayer().getInventory().getItemInMainHand()))
				{
					w.click(click);
					last.put(click.getPlayer(), System.currentTimeMillis());
				}
	}
}
