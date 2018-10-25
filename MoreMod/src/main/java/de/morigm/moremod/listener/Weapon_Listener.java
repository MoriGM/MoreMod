package de.morigm.moremod.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import de.morigm.moremod.api.MoreMod;
import de.morigm.moremod.api.helper.ListenerHelper;
import de.morigm.moremod.api.weapon.Click;
import de.morigm.moremod.api.weapon.Click.ClickMod;
import de.morigm.moremod.api.weapon.Weapon;

public class Weapon_Listener extends ListenerHelper 
{
	
	@EventHandler
	public void on(PlayerInteractEvent e)
	{
	
		if (e.getPlayer().getInventory().getItemInMainHand() == null || e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR))
			return;
		Click.ClickMod clickMod = null;
		if (e.getAction().equals(Action.LEFT_CLICK_AIR))
			clickMod = Click.ClickMod.LEFT_CLICK_AIR;
		if (e.getAction().equals(Action.LEFT_CLICK_BLOCK))
			clickMod = Click.ClickMod.LEFT_CLICK_BLOCK;
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR))
			clickMod = Click.ClickMod.RIGHT_CLICK_AIR;
		if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
			clickMod = Click.ClickMod.RIGHT_CLICK_BLOCK;
		Click click = new Click(clickMod, e.getPlayer(), null, e.getClickedBlock());
		MoreMod.getWeaponManager().click(click);
	}
	
	@EventHandler
	public void on(PlayerInteractAtEntityEvent e)
	{
		Click click = new Click(ClickMod.CLICK_ENTITY, e.getPlayer(), e.getRightClicked(), null);
		MoreMod.getWeaponManager().click(click);
	}
	
	@EventHandler
	public void on(PlayerJoinEvent e)
	{
		for (Weapon w : MoreMod.getWeaponManager().getWeapons())
			e.getPlayer().getInventory().addItem(w.getItem());
	}

}
