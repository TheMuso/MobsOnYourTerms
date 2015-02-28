package com.themuso.mobsonyourterms.init;

import com.themuso.mobsonyourterms.item.ItemMOYT;
import com.themuso.mobsonyourterms.item.ItemMobSpawningStaff;
import com.themuso.mobsonyourterms.item.ItemStaffFragment;
import com.themuso.mobsonyourterms.reference.Names;
import com.themuso.mobsonyourterms.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
	public static final ItemMOYT mobSpawningStaff = new ItemMobSpawningStaff();
	public static final ItemMOYT staffFragment = new ItemStaffFragment();

	public static void init()
	{
		GameRegistry.registerItem(mobSpawningStaff, Names.Items.MOB_SPAWNING_STAFF);
		GameRegistry.registerItem(staffFragment, Names.Items.STAFF_FRAGMENT);
	}
}
