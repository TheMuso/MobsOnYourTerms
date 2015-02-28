package com.themuso.mobsonyourterms.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.themuso.mobsonyourterms.init.ModItems;
import com.themuso.mobsonyourterms.reference.Reference;

public class CreativeTabMOYT
{
	public static final CreativeTabs MOYT_Tab = new CreativeTabs(Reference.MOD_ID.toLowerCase())
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.mobSpawningStaff;
		}
	};
}
