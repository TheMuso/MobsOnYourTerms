package com.themuso.mobsonyourterms.item;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.themuso.mobsonyourterms.reference.MobList;
import com.themuso.mobsonyourterms.reference.MobSettings;
import com.themuso.mobsonyourterms.reference.Names;
import com.themuso.mobsonyourterms.reference.Settings;
import com.themuso.mobsonyourterms.utility.ItemHelper;
import com.themuso.mobsonyourterms.utility.ItemNBTHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMobSpawningStaff extends ItemMOYT
{
	public ItemMobSpawningStaff()
	{
		super();
		this.setUnlocalizedName(Names.Items.MOB_SPAWNING_STAFF);
		maxStackSize = 1;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean flag)
	{
		if (!ItemNBTHelper.getString(itemStack, Names.NBTTags.STAFF_MOB_TO_SPAWN).isEmpty())
		{
			list.add("Mob to spawn: " + ItemNBTHelper.getString(itemStack, Names.NBTTags.STAFF_MOB_TO_SPAWN));
		}

		if (ItemHelper.hasOwner(itemStack))
		{
			list.add("Owner: " + ItemHelper.getOwnerName(itemStack));
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		if (!world.isRemote)
		{
			EnumDifficulty difficulty = world.difficultySetting;

			if (difficulty == EnumDifficulty.PEACEFUL)
			{
				entityPlayer.addChatComponentMessage(new ChatComponentText("This item is useless in peaceful mode."));
				return itemStack;
			}

			if (Settings.General.staffHasOwner)
			{
				if (ItemHelper.hasOwner(itemStack) && !ItemHelper.getOwnerName(itemStack).equals(entityPlayer.getDisplayName()))
				{
					return itemStack;
				}
				else if (!ItemHelper.hasOwner(itemStack))
				{
					ItemHelper.setOwner(itemStack, entityPlayer);
				}
			}
	
			if (ItemNBTHelper.getString(itemStack, Names.NBTTags.STAFF_MOB_TO_SPAWN).isEmpty())
			{
				entityPlayer.addChatComponentMessage(new ChatComponentText("This staff cannot spawn a mob. You need to imbue the staff with a staff fragment or another item using an anvil."));
				return itemStack;
			}

			String mobToSpawn = ItemNBTHelper.getString(itemStack, Names.NBTTags.STAFF_MOB_TO_SPAWN);
			Iterator iterator = MobList.mobList.values().iterator();

			int minMobsToSpawn = 0;
			int maxMobsToSpawn = 0;
			int spawnRangeFromPlayerMin = 0;
			int spawnRangeFromPlayerMax = 0;
			int spawnXPLevel = 0;
			int staffCooldown = 0;
			int mobsToBeSpawned = 0;
			int mobsToBeSpawnedRange = 0;
			int mobSpawnCount = 0;
			boolean spawnMobsBehindPlayer = false;
			boolean mobOnlySpawnableAtNight = false;
			boolean validMobConfigFound = false;
			Entity mob;

			if (!Settings.General.useIndividualMobSpawnSettings)
			{
				if (difficulty == EnumDifficulty.EASY)
				{
					minMobsToSpawn = Settings.General.minMobsToSpawnEasy;
					maxMobsToSpawn = Settings.General.maxMobsToSpawnEasy;
					spawnRangeFromPlayerMin = Settings.General.spawnRangeFromPlayerMinEasy;
					spawnRangeFromPlayerMax = Settings.General.spawnRangeFromPlayerMaxEasy;
					staffCooldown = Settings.General.staffCooldownEasy;
					spawnMobsBehindPlayer = Settings.General.spawnMobsBehindPlayerEasy;
					mobOnlySpawnableAtNight = Settings.General.mobOnlySpawnableAtNightEasy;
				}
				else if (difficulty == EnumDifficulty.NORMAL)
				{
					minMobsToSpawn = Settings.General.minMobsToSpawnNormal;
					maxMobsToSpawn = Settings.General.maxMobsToSpawnNormal;
					spawnRangeFromPlayerMin = Settings.General.spawnRangeFromPlayerMinNormal;
					spawnRangeFromPlayerMax = Settings.General.spawnRangeFromPlayerMaxNormal;
					staffCooldown = Settings.General.staffCooldownNormal;
					spawnMobsBehindPlayer = Settings.General.spawnMobsBehindPlayerNormal;
					mobOnlySpawnableAtNight = Settings.General.mobOnlySpawnableAtNightNormal;
				}
				else if (difficulty == EnumDifficulty.HARD)
				{
					minMobsToSpawn = Settings.General.minMobsToSpawnHard;
					maxMobsToSpawn = Settings.General.maxMobsToSpawnHard;
					spawnRangeFromPlayerMin = Settings.General.spawnRangeFromPlayerMinHard;
					spawnRangeFromPlayerMax = Settings.General.spawnRangeFromPlayerMaxHard;
					staffCooldown = Settings.General.staffCooldownHard;
					spawnMobsBehindPlayer = Settings.General.spawnMobsBehindPlayerHard;
					mobOnlySpawnableAtNight = Settings.General.mobOnlySpawnableAtNightHard;
				}
			}

			while (iterator.hasNext())
			{
				MobSettings mobConfig = (MobSettings)iterator.next();

				if (MobList.getKey(mobConfig).equals(mobToSpawn))
				{
					validMobConfigFound = true;
					if (difficulty == EnumDifficulty.EASY)
					{
						if (Settings.General.useIndividualMobSpawnSettings)
						{
							minMobsToSpawn = mobConfig.minMobsToSpawnEasy;
							maxMobsToSpawn = mobConfig.maxMobsToSpawnEasy;
							spawnRangeFromPlayerMin = mobConfig.spawnRangeFromPlayerMinEasy;
							spawnRangeFromPlayerMax = mobConfig.spawnRangeFromPlayerMaxEasy;
							staffCooldown = mobConfig.staffCooldownEasy;
							spawnMobsBehindPlayer = mobConfig.spawnMobsBehindPlayerEasy;
							mobOnlySpawnableAtNight = mobConfig.mobOnlySpawnableAtNightEasy;
						}
						spawnXPLevel = mobConfig.spawnXPLevelEasy;
					}
					else if (difficulty == EnumDifficulty.NORMAL)
					{
						if (Settings.General.useIndividualMobSpawnSettings)
						{
							minMobsToSpawn = mobConfig.minMobsToSpawnNormal;
							maxMobsToSpawn = mobConfig.maxMobsToSpawnNormal;
							spawnRangeFromPlayerMin = mobConfig.spawnRangeFromPlayerMinNormal;
							spawnRangeFromPlayerMax = mobConfig.spawnRangeFromPlayerMaxNormal;
							staffCooldown = mobConfig.staffCooldownNormal;
							spawnMobsBehindPlayer = mobConfig.spawnMobsBehindPlayerNormal;
							mobOnlySpawnableAtNight = mobConfig.mobOnlySpawnableAtNightNormal;
						}
						spawnXPLevel = mobConfig.spawnXPLevelNormal;
					}
					else if (difficulty == EnumDifficulty.HARD)
					{
						if (Settings.General.useIndividualMobSpawnSettings)
						{
							minMobsToSpawn = mobConfig.minMobsToSpawnHard;
							maxMobsToSpawn = mobConfig.maxMobsToSpawnHard;
							spawnRangeFromPlayerMin = mobConfig.spawnRangeFromPlayerMinHard;
							spawnRangeFromPlayerMax = mobConfig.spawnRangeFromPlayerMaxHard;
							staffCooldown = mobConfig.staffCooldownHard;
							spawnMobsBehindPlayer = mobConfig.spawnMobsBehindPlayerHard;
							mobOnlySpawnableAtNight = mobConfig.mobOnlySpawnableAtNightHard;
						}
						spawnXPLevel = mobConfig.spawnXPLevelHard;
					}
				}
			}

			if (!validMobConfigFound)
			{
				entityPlayer.addChatComponentMessage(new ChatComponentText("Unknown mob to be spawned: " + mobToSpawn));
				return itemStack;
			}

			if (mobOnlySpawnableAtNight && world.isDaytime())
			{
				entityPlayer.addChatComponentMessage(new ChatComponentText("This mob can only be spawned at night."));
				return itemStack;
			}

			if (!entityPlayer.capabilities.isCreativeMode)
			{
				if (entityPlayer.experienceLevel < spawnXPLevel)
				{
					entityPlayer.addChatComponentMessage(new ChatComponentText("You do not have enough XP to spawn this mob. You need at least " + spawnXPLevel + " levels."));
					return itemStack;
				}

				entityPlayer.addExperienceLevel(-spawnXPLevel);
			}

			mobsToBeSpawnedRange = maxMobsToSpawn - minMobsToSpawn;
			if (mobsToBeSpawnedRange <= 0)
			{
				mobsToBeSpawnedRange = 1;
			}
			mobsToBeSpawned = world.rand.nextInt(mobsToBeSpawnedRange) + minMobsToSpawn;

			while (mobSpawnCount < mobsToBeSpawned)
			{
				mob = EntityList.createEntityByName(mobToSpawn, world);

				/*
				 * Z = North/South, south being positive.
				 * X = West/East, east being positive.
				 * Facing value ranges from 0-7.
				 * Facing values: South = 0, West = 2, North = 4, East = 6.
				 * South west, north east etc should be self explanitory.
				 * Facing code below taken from a post on the minecraft forge
				 * forums.
				 */

				int yaw = (int)entityPlayer.rotationYaw;

				if (yaw < 0)              //due to the yaw running a -360 to positive 360
				{
					yaw+=360;    //not sure why it's that way
				}

				yaw+=22;     //centers coordinates you may want to drop this line
				yaw%=360;  //and this one if you want a strict interpretation of the zones

				int facing = yaw/45;   //  360degrees divided by 45 == 8 zones

				int mobSpawnRange = spawnRangeFromPlayerMax - spawnRangeFromPlayerMin;
				int distanceFromPlayer = world.rand.nextInt(mobSpawnRange) + 1;
				boolean spawnBehindPlayer = false;
				if (spawnMobsBehindPlayer)
				{
					spawnBehindPlayer = world.rand.nextBoolean();
				}

				double posX = entityPlayer.posX;
				double posY = entityPlayer.posY;
				double posZ = entityPlayer.posZ;

				/* Calculate posz based on the facing value */
				if (facing == 0 || facing == 1 || facing == 7)
				{
					if (spawnBehindPlayer)
					{
						posZ = entityPlayer.posZ - distanceFromPlayer;
					}
					else
					{
						posZ = entityPlayer.posZ + distanceFromPlayer;
					}
				}

				if (facing == 3 || facing == 4 || facing == 5)
				{
					if (spawnBehindPlayer)
					{
						posZ = entityPlayer.posZ + distanceFromPlayer;
					}
					else
					{
						posZ = entityPlayer.posZ - distanceFromPlayer;
					}
				}

				/* Calculate posx based on facing value */
				if (facing == 1 || facing == 2 || facing == 3)
				{
					if (spawnBehindPlayer)
					{
						posX = entityPlayer.posX + distanceFromPlayer;
					}
					else
					{
						posX = entityPlayer.posX - distanceFromPlayer;
					}
				}

				if (facing == 5 || facing == 6 || facing == 7)
				{
					if (spawnBehindPlayer)
					{
						posX = entityPlayer.posX - distanceFromPlayer;
					}
					else
					{
						posX = entityPlayer.posX + distanceFromPlayer;
					}
				}

				mob.setLocationAndAngles(posX, posY, posZ, world.rand.nextFloat() * 360.0F, 0.0F);
				world.spawnEntityInWorld(mob);			

				mobSpawnCount++;
			}
		}

		return itemStack;
	}
}
