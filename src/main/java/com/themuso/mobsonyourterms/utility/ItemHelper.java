package com.themuso.mobsonyourterms.utility;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.themuso.mobsonyourterms.reference.Names;

public class ItemHelper
{
	public static boolean hasOwner(ItemStack itemStack)
	{
		return (ItemNBTHelper.hasTag(itemStack, Names.NBTTags.OWNER_UUID_MOST_SIG) && ItemNBTHelper.hasTag(itemStack, Names.NBTTags.OWNER_UUID_LEAST_SIG)) || ItemNBTHelper.hasTag(itemStack, Names.NBTTags.OWNER);
	}

	public static String getOwnerName(ItemStack itemStack)
	{
		if (ItemNBTHelper.hasTag(itemStack, Names.NBTTags.OWNER))
		{
			return ItemNBTHelper.getString(itemStack, Names.NBTTags.OWNER);
		}

		return "";
	}

	public static UUID getOwnerUUID(ItemStack itemStack)
	{
		if (ItemNBTHelper.hasTag(itemStack, Names.NBTTags.OWNER_UUID_MOST_SIG) && ItemNBTHelper.hasTag(itemStack, Names.NBTTags.OWNER_UUID_LEAST_SIG))
		{
			return new UUID(ItemNBTHelper.getLong(itemStack, Names.NBTTags.OWNER_UUID_MOST_SIG), ItemNBTHelper.getLong(itemStack, Names.NBTTags.OWNER_UUID_LEAST_SIG));
		}

		return null;
	}

	public static void setOwner(ItemStack itemStack, EntityPlayer entityPlayer)
	{
		ItemNBTHelper.setString(itemStack, Names.NBTTags.OWNER, entityPlayer.getName());
		ItemNBTHelper.setLong(itemStack, Names.NBTTags.OWNER_UUID_MOST_SIG, entityPlayer.getUniqueID().getMostSignificantBits());
		ItemNBTHelper.setLong(itemStack, Names.NBTTags.OWNER_UUID_LEAST_SIG, entityPlayer.getUniqueID().getLeastSignificantBits());
	}
}
