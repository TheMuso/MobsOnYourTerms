package com.themuso.mobsonyourterms.item;

import java.util.List;

import com.themuso.mobsonyourterms.reference.Names;
import com.themuso.mobsonyourterms.utility.ItemNBTHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStaffFragment extends ItemMOYT
{
	public ItemStaffFragment()
	{
		super(Names.Items.STAFF_FRAGMENT);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemStack, World player, List<String> list, ITooltipFlag whatIsThis)
	{
		if (!ItemNBTHelper.getString(itemStack, Names.NBTTags.FRAGMENT_IS_FOR_MOB).isEmpty())
		{
			list.add("Mob to spawn: " + ItemNBTHelper.getString(itemStack, Names.NBTTags.FRAGMENT_IS_FOR_MOB));
		}
	}
}
