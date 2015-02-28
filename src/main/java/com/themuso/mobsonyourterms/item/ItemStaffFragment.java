package com.themuso.mobsonyourterms.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.themuso.mobsonyourterms.reference.Names;
import com.themuso.mobsonyourterms.utility.ItemNBTHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStaffFragment extends ItemMOYT
{
	public ItemStaffFragment()
	{
		super();
		this.setUnlocalizedName(Names.Items.STAFF_FRAGMENT);
		maxStackSize = 64;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean flag)
	{
		if (!ItemNBTHelper.getString(itemStack, Names.NBTTags.FRAGMENT_IS_FOR_MOB).isEmpty())
		{
			list.add("Mob to spawn: " + ItemNBTHelper.getString(itemStack, Names.NBTTags.FRAGMENT_IS_FOR_MOB));
		}
	}
}
