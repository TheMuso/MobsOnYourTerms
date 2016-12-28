package com.themuso.mobsonyourterms.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.themuso.mobsonyourterms.item.CreativeTabMOYT;
import com.themuso.mobsonyourterms.reference.Reference;

public class ItemMOYT extends Item
{

	private final String NAME;

	public ItemMOYT(String name)
	{
		super();
		setRegistryName(name);
		setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabMOYT.MOYT_Tab);
		NAME = name;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return String.format("item.%s:%s", Reference.MOD_ID.toLowerCase(), NAME);
	}
}
