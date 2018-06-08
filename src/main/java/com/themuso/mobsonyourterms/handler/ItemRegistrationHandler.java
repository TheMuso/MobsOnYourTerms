package com.themuso.mobsonyourterms.handler;

import com.themuso.mobsonyourterms.init.ModItems;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemRegistrationHandler
{
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(ModItems.mobSpawningStaff);
		event.getRegistry().register(ModItems.staffFragment);
	}
}
