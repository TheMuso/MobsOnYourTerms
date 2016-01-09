package com.themuso.mobsonyourterms.handler;

import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import com.themuso.mobsonyourterms.reference.Settings;
import com.themuso.mobsonyourterms.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntitySpawnerHandler
{
	@SubscribeEvent
	public void EntitySpawn(EntityJoinWorldEvent event)
	{
		if ((!event.world.isRemote && event.entity instanceof EntityLiving)
		&&  (!Settings.General.spawnHostileMobs))
		{
			if ((event.entity instanceof EntityPlayer)
			||  (event.world.difficultySetting == EnumDifficulty.PEACEFUL)
			||  (!event.entity.isCreatureType(EnumCreatureType.monster, false)))
			{
				return;
			}

			event.setCanceled(true);

			/* Exception for Extra Utilities cursed earth */
			NBTTagCompound entityData = event.entity.getEntityData();
			if (entityData.hasKey("CursedEarth"))
			{
				if (entityData.getLong("CursedEarth") == 3600L)
				{
					event.setCanceled(false);
					return;
				}
			}

			/* Exception for vanilla mob spawners */
			Iterator iterator = event.world.loadedTileEntityList.iterator();

			while (iterator.hasNext())
			{
				TileEntity tileEntity = (TileEntity)iterator.next();
				if (tileEntity instanceof TileEntityMobSpawner)
				{
					TileEntityMobSpawner mobSpawner = (TileEntityMobSpawner)tileEntity;
					MobSpawnerBaseLogic spawnerLogic = mobSpawner.func_145881_a();
					NBTTagCompound nbt = new NBTTagCompound();
					mobSpawner.writeToNBT(nbt);
					String entityId = nbt.getString("EntityId");
					String spawningEntityId = EntityList.getEntityString(event.entity);
					int spawnRange = nbt.getInteger("SpawnRange");
					int minSpawnAreaX = spawnerLogic.getSpawnerX() - spawnRange;
					int maxSpawnAreaX = spawnerLogic.getSpawnerX() + spawnRange;
					int minSpawnAreaY = spawnerLogic.getSpawnerY();
					int maxSpawnAreaY = spawnerLogic.getSpawnerY() + 1;
					int minSpawnAreaZ = spawnerLogic.getSpawnerZ() - spawnRange;
					int maxSpawnAreaZ = spawnerLogic.getSpawnerZ() + spawnRange;

					if (entityId.equals(spawningEntityId)
					&&  (event.entity.posX >= minSpawnAreaX && event.entity.posX <= maxSpawnAreaX)
					&&  (event.entity.posY >= minSpawnAreaY && event.entity.posY <= maxSpawnAreaY)
					&&  (event.entity.posZ >= minSpawnAreaZ && event.entity.posZ <= maxSpawnAreaZ))
					{
						event.setCanceled(false);
						return;
					}
				}
			}
		}
	}
}
