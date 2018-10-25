package de.morigm.moremod.api.weapon;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import lombok.Getter;

public class Click
{
	
	public static enum ClickMod
	{
		LEFT_CLICK_AIR,
		LEFT_CLICK_BLOCK,
		RIGHT_CLICK_AIR,
		RIGHT_CLICK_BLOCK,
		CLICK_ENTITY
	}

	@Getter private ClickMod clickMod;
	@Getter private Player player;
	@Getter private Entity entity;
	@Getter private Block block;
	
	public Click(ClickMod clickMod,Player player,Entity entity,Block block) 
	{
		this.clickMod = clickMod;
		this.player = player;
		this.entity = entity;
		this.block = block;
	}

}
