package com.themuso.mobsonyourterms.item;

import com.themuso.mobsonyourterms.reference.Reference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMOYT extends Item
{
	private final String NAME;

	public ItemMOYT(String name)
	{
		setRegistryName(name);
		setUnlocalizedName(Reference.MOD_ID + "." + name);
		this.setCreativeTab(CreativeTabMOYT.MOYT_Tab);
		NAME = name;
	}

	@SideOnly(Side.CLIENT)
	public void initModel()
	{
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
