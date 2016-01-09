package com.themuso.mobsonyourterms.handler;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;

import com.themuso.mobsonyourterms.reference.Settings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RuleHandler
{
	@SubscribeEvent
	public void adjustGameRules(WorldEvent.PotentialSpawns event)
	{
		if ((!event.world.isRemote) && (!Settings.General.spawnHostileMobs) && (event.type == EnumCreatureType.monster))
		{
			event.setCanceled(true);
		}
	}
}
