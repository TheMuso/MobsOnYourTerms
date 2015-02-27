package com.themuso.mobsonyourterms.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import com.themuso.mobsonyourterms.reference.Settings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RuleHandler
{
	@SubscribeEvent
	public void adjustGameRules(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			if (!event.world.isRemote)
			{
				if (event.world.getGameRules().getGameRuleBooleanValue("doMobSpawning"));
				{
					event.world.getGameRules().setOrCreateGameRule("doMobSpawning", Boolean.toString(Settings.General.doMobSpawningGameRule));
					EntityPlayer player = (EntityPlayer)event.entity;
					player.addChatComponentMessage(new ChatComponentText("Mob spawning is set to " + Boolean.toString(Settings.General.doMobSpawningGameRule)));
				}
			}
		}
	}
}
