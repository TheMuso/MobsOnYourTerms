package com.themuso.mobsonyourterms.handler;

import net.minecraft.block.Block;
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

			/* Exception for Extra Utilities cursed earth */
			int x = event.x;
			int y = event.y;
			int z = event.z;

			Block block = event.world.getBlock(x, y, z);
			String blockName = block.getUnlocalizedName();

			if (blockName.equals("tile.extrautils:cursedearthside"))
			{
				event.setCanceled(false);
			}
		}
	}
}
