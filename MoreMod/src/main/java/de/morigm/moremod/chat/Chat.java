package de.morigm.moremod.chat;

import de.morigm.moremod.Main;

public class Chat 
{
	public static final String name = Main.getInstance().getDescription().getName();
	public static final String prefix = "[" + name + "]";
	public static final String version = Main.getInstance().getDescription().getVersion();
}
