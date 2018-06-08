package com.themuso.mobsonyourterms.handler;

import java.util.Iterator;

import com.themuso.mobsonyourterms.reference.MobList;
import com.themuso.mobsonyourterms.reference.MobSettings;
import com.themuso.mobsonyourterms.reference.Names;
import com.themuso.mobsonyourterms.reference.Reference;
import com.themuso.mobsonyourterms.reference.Settings;
import com.themuso.mobsonyourterms.utility.ItemNBTHelper;
import com.themuso.mobsonyourterms.utility.LogHelper;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class AnvilHandler
{
	@SubscribeEvent
	public void onAnvilEvent(AnvilUpdateEvent event)
	{
		Iterator iterator;
		String rightSlotItemName;
		int rightSlotItemDamage;
		String staffFragmentItemName;
		MobSettings mobConfig;

		if (event.getLeft() == null || event.getLeft().getCount() != 1 ||
		    event.getLeft().getItem() != (Item)ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MOD_ID, Names.Items.MOB_SPAWNING_STAFF)) ||
		    event.getRight() == null ||
		    !ItemNBTHelper.getString(event.getLeft(), Names.NBTTags.STAFF_MOB_TO_SPAWN).isEmpty())
		{
			return;
		}

		rightSlotItemName = ForgeRegistries.ITEMS.getKey(event.getRight().getItem()).toString();
		rightSlotItemDamage = event.getRight().getItemDamage();
		staffFragmentItemName = Reference.MOD_ID + ":" + Names.Items.STAFF_FRAGMENT.toLowerCase();
		iterator = MobList.mobList.values().iterator();

		while (iterator.hasNext())
		{
			mobConfig = (MobSettings)iterator.next();

			if (mobConfig.enableStaffCreationPrimaryItem && (mobConfig.staffCreationPrimaryItem.equals(rightSlotItemName)
			 && mobConfig.staffCreationPrimaryItemDamage == rightSlotItemDamage)
			 && event.getRight().getCount() >= mobConfig.staffCreationPrimaryItemAmount)
			{
				LogHelper.info("Primary item enabled for entity " + MobList.getKey(mobConfig));
				event.setOutput(event.getLeft().copy());
				ItemNBTHelper.setString(event.getOutput(), Names.NBTTags.STAFF_MOB_TO_SPAWN, MobList.getKey(mobConfig));
				event.getOutput().getItem().setMaxDamage(mobConfig.staffCreationPrimaryItemUses);
				event.setCost(mobConfig.staffCreationPrimaryItemLevels);
				event.setMaterialCost(mobConfig.staffCreationPrimaryItemAmount);
				return;
			}
			else if (mobConfig.enableStaffCreationSecondaryItem && (mobConfig.staffCreationSecondaryItem.equals(rightSlotItemName)
			  && mobConfig.staffCreationSecondaryItemDamage == rightSlotItemDamage)
			  && event.getRight().getCount() >= mobConfig.staffCreationSecondaryItemAmount)
			{
				LogHelper.info("Secondary item enabled for entity " + MobList.getKey(mobConfig));
				event.setOutput(event.getLeft().copy());
				ItemNBTHelper.setString(event.getOutput(), Names.NBTTags.STAFF_MOB_TO_SPAWN, MobList.getKey(mobConfig));
				event.getOutput().getItem().setMaxDamage(mobConfig.staffCreationSecondaryItemUses);
				event.setCost(mobConfig.staffCreationSecondaryItemLevels);
				event.setMaterialCost(mobConfig.staffCreationSecondaryItemAmount);
				return;
			}
			else if (Settings.General.enableStaffFragmentItem && (rightSlotItemName.equals(staffFragmentItemName)) && ItemNBTHelper.hasTag(event.getRight(), Names.NBTTags.FRAGMENT_IS_FOR_MOB)
			  && (event.getRight().getCount() >= mobConfig.staffFragmentAnvilAmount) && (ItemNBTHelper.getString(event.getRight(), Names.NBTTags.FRAGMENT_IS_FOR_MOB).equals(MobList.getKey(mobConfig))))
			{
				event.setOutput(event.getLeft().copy());
				ItemNBTHelper.setString(event.getOutput(), Names.NBTTags.STAFF_MOB_TO_SPAWN, ItemNBTHelper.getString(event.getRight(), Names.NBTTags.FRAGMENT_IS_FOR_MOB));
				event.getOutput().getItem().setMaxDamage(mobConfig.staffFragmentAnvilUses);
				event.setCost(mobConfig.staffFragmentAnvilLevels);
				event.setMaterialCost(mobConfig.staffFragmentAnvilAmount);
				return;
			}
		}
	}
}
