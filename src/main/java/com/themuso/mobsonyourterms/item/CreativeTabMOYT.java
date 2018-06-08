package com.themuso.mobsonyourterms.item;

import com.themuso.mobsonyourterms.init.ModItems;
import com.themuso.mobsonyourterms.reference.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabMOYT
{
	public static final CreativeTabs MOYT_Tab = new CreativeTabs(Reference.MOD_ID.toLowerCase())
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(ModItems.mobSpawningStaff);
		}
	};
}
