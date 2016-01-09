package com.themuso.mobsonyourterms.handler;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;

import com.themuso.mobsonyourterms.reference.Settings;
import com.themuso.mobsonyourterms.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RuleHandler
{
	@SubscribeEvent
	public void adjustGameRules(WorldEvent.PotentialSpawns event)
	{
		if ((!event.world.isRemote) && (!Settings.General.spawnHostileMobs) && (event.type == EnumCreatureType.monster))
		{
			event.setCanceled(true);

			/* Exception for Extra Utilities cursed earth */
			float x = event.x + 0.5F;
			float y = event.y;
			float z = event.z + 0.5F;

			Block block = event.world.getBlock((int)x, (int)y, (int)z);
			String blockName = block.getUnlocalizedName();

			if (blockName.equals("tile.extrautils:cursedearthside"))
			{
				event.setCanceled(false);
			}
		}
	}
}
