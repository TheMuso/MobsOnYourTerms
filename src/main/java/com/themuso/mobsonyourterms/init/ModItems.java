package com.themuso.mobsonyourterms.init;

import com.themuso.mobsonyourterms.item.ItemMOYT;
import com.themuso.mobsonyourterms.item.ItemMobSpawningStaff;
import com.themuso.mobsonyourterms.item.ItemStaffFragment;
import com.themuso.mobsonyourterms.reference.Names;
import com.themuso.mobsonyourterms.reference.Reference;

import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems
{
	public static ItemMobSpawningStaff mobSpawningStaff;
	public static ItemStaffFragment staffFragment;

	public static void init()
	{
		mobSpawningStaff = new ItemMobSpawningStaff();
		staffFragment = new ItemStaffFragment();
	}
}
