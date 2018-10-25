package de.morigm.moremod.api;

import de.morigm.moremod.api.helper.PermissionHelper;
import de.morigm.moremod.Main;
import lombok.Getter;

public class MoreMod
{
	@Getter private static WeaponManager weaponManager;
	@Getter private static PermissionHelper permissionHelper;

	static
	{
		MoreMod.weaponManager = new WeaponManager();
		permissionHelper = new PermissionHelper(Main.getInstance().getResource("Permission.yml"));
	}
	
	public static String getName()
	{
		return "MoreMod";
	}
	
}
