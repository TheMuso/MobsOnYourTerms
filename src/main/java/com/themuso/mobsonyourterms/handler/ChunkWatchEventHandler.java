package com.themuso.mobsonyourterms.handler;

import java.lang.reflect.Field;
import java.util.Iterator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.World;
import net.minecraftforge.event.world.ChunkWatchEvent;

import com.themuso.mobsonyourterms.reference.Settings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ChunkWatchEventHandler
{
	@SubscribeEvent
	public void onChunkWatch(ChunkWatchEvent.Watch event)
	{
		Iterator iterator;
		Chunk chunk;
		TileEntity tileEntity;
		MobSpawnerBaseLogic spawnerLogic;
		TileEntityMobSpawner spawner;

		if (!event.player.worldObj.isRemote)
		{
			if (Settings.Spawner.changeMobSpawnerBehavior)
			{
				chunk = event.player.worldObj.getChunkFromChunkCoords(event.chunk.chunkXPos, event.chunk.chunkZPos);
				iterator = chunk.chunkTileEntityMap.values().iterator();

				while (iterator.hasNext())
				{
					tileEntity = (TileEntity)iterator.next();
					if (tileEntity instanceof TileEntityMobSpawner)
					{
						spawner = (TileEntityMobSpawner)tileEntity;
						NBTTagCompound nbt = new NBTTagCompound();
						spawner.writeToNBT(nbt);

						nbt.setShort("RequiredPlayerRange", (short)Settings.Spawner.activatingRangeFromPlayer);
						nbt.setShort("SpawnRange", (short)Settings.Spawner.spawnRange);
						spawner.readFromNBT(nbt);
					}
				}
			}
		}
	}

}
