package com.themuso.mobsonyourterms.handler;

import java.lang.reflect.Field;
import java.util.Iterator;

import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.world.ChunkEvent;

import com.themuso.mobsonyourterms.reference.Settings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ChunkLoadEventHandler 
{
	@SubscribeEvent
	public void onChunkLoad(ChunkEvent.Load event)
	{
		Iterator iterator;
		Chunk chunk = event.getChunk();
		TileEntity tileentity;
		MobSpawnerBaseLogic spawnerlogic;

		if (!chunk.worldObj.isRemote)
		{
			if (Settings.Spawner.changeMobSpawnerBehavior == true)
			{
				iterator = chunk.chunkTileEntityMap.values().iterator();

				while (iterator.hasNext())
				{
					tileentity = (TileEntity)iterator.next();
					if (tileentity instanceof TileEntityMobSpawner)
					{
						spawnerlogic = ((TileEntityMobSpawner)tileentity).func_145881_a();
						changeSpawnerPlayerRange(spawnerlogic);
					}
				}
			}
		}
	}
	
	private void changeSpawnerPlayerRange(MobSpawnerBaseLogic spawnerlogic)
	{
		Field[] fields = MobSpawnerBaseLogic.class.getDeclaredFields();
		
		for (Field f : fields)
		{
			if (f.getName() == "activatingRangeFromPlayer")
			{
				f.setAccessible(true);
				try
				{
					f.set(spawnerlogic, Settings.Spawner.activatingRangeFromPlayer);
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}

			if (f.getName() == "spawnRange")
			{
				f.setAccessible(true);
				try
				{
					f.set(spawnerlogic, Settings.Spawner.spawnRange);
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}
	}
}
