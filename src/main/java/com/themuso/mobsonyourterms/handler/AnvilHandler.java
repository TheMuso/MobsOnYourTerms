package com.themuso.mobsonyourterms.handler;

import java.util.Iterator;

import net.minecraft.item.Item;
import net.minecraftforge.event.AnvilUpdateEvent;

import com.themuso.mobsonyourterms.init.ModItems;
import com.themuso.mobsonyourterms.reference.MobList;
import com.themuso.mobsonyourterms.reference.MobSettings;
import com.themuso.mobsonyourterms.reference.Names;
import com.themuso.mobsonyourterms.reference.Settings;
import com.themuso.mobsonyourterms.utility.ItemNBTHelper;
import com.themuso.mobsonyourterms.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AnvilHandler
{
	@SubscribeEvent
	public void onAnvilEvent(AnvilUpdateEvent event)
	{
		Iterator iterator;
		String rightSlotItemName;
		String staffFragmentItemName;
		MobSettings mobConfig;

		if (event.left == null || event.left.stackSize != 1 ||
		    event.left.getItem() != (Item)ModItems.mobSpawningStaff ||
		    event.right == null ||
		    !ItemNBTHelper.getString(event.left, Names.NBTTags.STAFF_MOB_TO_SPAWN).isEmpty())
		{
			return;
		}

		rightSlotItemName = Item.itemRegistry.getNameForObject(event.right.getItem());
		staffFragmentItemName = Item.itemRegistry.getNameForObject(ModItems.staffFragment);
		iterator = MobList.mobList.values().iterator();

		while (iterator.hasNext())
		{
			mobConfig = (MobSettings)iterator.next();

			if (mobConfig.enableStaffCreationPrimaryItem && (mobConfig.staffCreationPrimaryItem.equals(rightSlotItemName))
			 && event.right.stackSize >= mobConfig.staffCreationPrimaryItemAmount)
			{
				LogHelper.info("Primary item enabled for entity " + MobList.getKey(mobConfig));
				event.output = event.left.copy();
				ItemNBTHelper.setString(event.output, Names.NBTTags.STAFF_MOB_TO_SPAWN, MobList.getKey(mobConfig));
				event.cost = mobConfig.staffCreationPrimaryItemLevels;
				event.materialCost = mobConfig.staffCreationPrimaryItemAmount;
				return;
			}
			else if (mobConfig.enableStaffCreationSecondaryItem && (mobConfig.staffCreationSecondaryItem.equals(rightSlotItemName))
			  && event.right.stackSize >= mobConfig.staffCreationSecondaryItemAmount)
			{
				LogHelper.info("Secondary item enabled for entity " + MobList.getKey(mobConfig));
				event.output = event.left.copy();
				ItemNBTHelper.setString(event.output, Names.NBTTags.STAFF_MOB_TO_SPAWN, MobList.getKey(mobConfig));
				event.cost = mobConfig.staffCreationSecondaryItemLevels;
				event.materialCost = mobConfig.staffCreationSecondaryItemAmount;
				return;
			}
			else if (Settings.General.enableStaffFragmentItem && (rightSlotItemName.equals(staffFragmentItemName)) && ItemNBTHelper.hasTag(event.right, Names.NBTTags.FRAGMENT_IS_FOR_MOB)
			  && (event.right.stackSize >= mobConfig.staffFragmentAnvilCost) && (ItemNBTHelper.getString(event.right, Names.NBTTags.FRAGMENT_IS_FOR_MOB).equals(MobList.getKey(mobConfig))))
			{
				event.output = event.left.copy();
				ItemNBTHelper.setString(event.output, Names.NBTTags.STAFF_MOB_TO_SPAWN, ItemNBTHelper.getString(event.right, Names.NBTTags.FRAGMENT_IS_FOR_MOB));
				event.cost = mobConfig.staffFragmentAnvilLevels;
				event.materialCost = mobConfig.staffFragmentAnvilCost;
				return;
			}
		}
	}
}
