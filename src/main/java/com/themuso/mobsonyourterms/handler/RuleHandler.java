package com.themuso.mobsonyourterms.handler;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;

import com.themuso.mobsonyourterms.reference.Settings;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RuleHandler
{
	@SubscribeEvent
	public void adjustGameRules(WorldEvent.PotentialSpawns event)
	{
		if ((!event.getWorld().isRemote) && (!Settings.General.spawnHostileMobs) && (event.getType() == EnumCreatureType.MONSTER))
		{
			event.setCanceled(true);

			/* Exception for Extra Utilities cursed earth */
			Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
			String blockName = block.getUnlocalizedName();

			if (blockName.equals("tile.extrautils:cursedearthside"))
			{
				event.setCanceled(false);
			}
		}
	}
}
