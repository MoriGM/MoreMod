package de.morigm.moremod.weapons;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftFallingBlock;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;

import de.morigm.moremod.api.helper.PlayerHelper;
import de.morigm.moremod.api.weapon.Click;
import de.morigm.moremod.api.weapon.Click.ClickMod;
import de.morigm.moremod.api.weapon.Weapon;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_12_R1.EntityFallingBlock;
import net.minecraft.server.v1_12_R1.PacketPlayOutEntityTeleport;

public class GravityGun implements Weapon 
{
	
	private ItemStack item;
	
	private Map<Player,Block> player = new HashMap<>();
	private Map<Player,FallingBlock> block = new HashMap<>();
	
	public GravityGun() 
	{
		this.item = new ItemStack(Material.STICK);
		ItemMeta meta = this.item.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN + getId());
		this.item.setItemMeta(meta);
	}

	public ItemStack getItem() 
	{
		return item;
	}

	public void click(Click click) 
	{
		if (click.getClickMod().equals(ClickMod.RIGHT_CLICK_BLOCK))
			if (player.containsKey(click.getPlayer()))
			{
				player.remove(click.getPlayer());
				block.get(click.getPlayer()).setGravity(true);
				block.remove(click.getPlayer());
			}
			else
				player.put(click.getPlayer(), click.getBlock());
		
		if (click.getClickMod().equals(ClickMod.RIGHT_CLICK_AIR))
			if (player.containsKey(click.getPlayer()))
			{
				player.remove(click.getPlayer());
				block.get(click.getPlayer()).setGravity(true);
				block.remove(click.getPlayer());
			}
			
	}

	@Override
	public String getId() 
	{
		return "gravitygun";
	}
	
	@EventHandler
	public void on(PlayerMoveEvent e)
	{
		Player p = e.getPlayer();
		if (player.containsKey(p))
		{
			if (!block.containsKey(p))
			{
				Material m = player.get(p).getType();
				player.get(p).setType(Material.AIR);
				Location loc = e.getTo().clone();
				Vector v = p.getLocation().getDirection().multiply(3);
				loc.setX(p.getEyeLocation().getX() + v.getX());
				loc.setY(PlayerHelper.getPlayerHighestBlock(p.getLocation()) + 1);
				loc.setZ(p.getEyeLocation().getZ() + v.getZ());
				FallingBlock fb = p.getWorld().spawnFallingBlock(loc, new MaterialData(m));
				fb.setGravity(false);
				block.put(p, fb);
			}
			else
			{
				Location loc = e.getTo().clone();
				Vector v = p.getLocation().getDirection().multiply(3);
				loc.setX(p.getEyeLocation().getX() + v.getX());
				loc.setY(PlayerHelper.getPlayerHighestBlock(p.getLocation()) + 1 + v.getY());
				loc.setZ(p.getEyeLocation().getZ() + v.getZ());
				EntityFallingBlock efb = ((CraftFallingBlock)block.get(p)).getHandle();
				efb.setPosition(loc.getX(), loc.getY(), loc.getZ());
				
				for (Player t : Bukkit.getOnlinePlayers())
					((CraftPlayer)t).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityTeleport(efb));
			}
		}
	}

}
