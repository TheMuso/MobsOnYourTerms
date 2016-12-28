package com.themuso.mobsonyourterms.item;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.SkeletonType;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.themuso.mobsonyourterms.reference.MobList;
import com.themuso.mobsonyourterms.reference.MobSettings;
import com.themuso.mobsonyourterms.reference.Names;
import com.themuso.mobsonyourterms.reference.Settings;
import com.themuso.mobsonyourterms.utility.EntityNBTHelper;
import com.themuso.mobsonyourterms.utility.ItemHelper;
import com.themuso.mobsonyourterms.utility.ItemNBTHelper;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMobSpawningStaff extends ItemMOYT
{
	public ItemMobSpawningStaff()
	{
		super(Names.Items.MOB_SPAWNING_STAFF);
		setMaxStackSize(1);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list, boolean flag)
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
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer, EnumHand hand)
	{
		Iterator iterator;
		String mobToSpawn;
		int minMobsToSpawn = 0;
		int maxMobsToSpawn = 0;
		int spawnRangeFromPlayerMin = 0;
		int spawnRangeFromPlayerMax = 0;
		int spawnXPLevel = 0;
		int staffCooldown = 0;
		int mobsToBeSpawned = 0;
		int mobsToBeSpawnedRange = 0;
		int mobSpawnCount = 0;
		int distanceFromPlayer = 0;
		int mobSpawnRange = 0;
		int yaw = 0;
		int facing = 0;
		long currentTime;
		long coolDownTime = 0;
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		boolean spawnMobsBehindPlayer = false;
		boolean mobOnlySpawnableAtNight = false;
		boolean validMobConfigFound = false;
		boolean spawnBehindPlayer = false;
		Entity mob;
		MobSettings mobConfig;

		if (!world.isRemote)
		{
			EnumDifficulty difficulty = world.getDifficulty();

			if (difficulty == EnumDifficulty.PEACEFUL)
			{
				entityPlayer.addChatMessage(new TextComponentString("This item is useless in peaceful mode."));
				return new ActionResult<>(EnumActionResult.PASS, itemStack);
			}

			if (Settings.General.staffHasOwner)
			{
				if (ItemHelper.hasOwner(itemStack) && !ItemHelper.getOwnerName(itemStack).equals(entityPlayer.getName()))
				{
					return new ActionResult<>(EnumActionResult.PASS, itemStack);
				}
				else if (!ItemHelper.hasOwner(itemStack))
				{
					ItemHelper.setOwner(itemStack, entityPlayer);
				}
			}

			if (ItemNBTHelper.getString(itemStack, Names.NBTTags.STAFF_MOB_TO_SPAWN).isEmpty())
			{
				entityPlayer.addChatMessage(new TextComponentString("This staff cannot spawn a mob. You need to imbue the staff with a staff fragment or another item using an anvil."));
				return new ActionResult<>(EnumActionResult.PASS, itemStack);
			}

			mobToSpawn = ItemNBTHelper.getString(itemStack, Names.NBTTags.STAFF_MOB_TO_SPAWN);
			iterator = MobList.mobList.values().iterator();

			if (Settings.General.useIndividualMobSpawnSettings)
			{
				if (difficulty == EnumDifficulty.EASY)
				{
					spawnXPLevel = Settings.General.spawnXPLevelEasy;
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
					spawnXPLevel = Settings.General.spawnXPLevelNormal;
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
					spawnXPLevel = Settings.General.spawnXPLevelHard;
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
				mobConfig = (MobSettings)iterator.next();

				if (MobList.getKey(mobConfig).equals(mobToSpawn))
				{
					validMobConfigFound = true;
					if (difficulty == EnumDifficulty.EASY)
					{
						if (!Settings.General.useIndividualMobSpawnSettings)
						{
							spawnXPLevel = mobConfig.spawnXPLevelEasy;
							minMobsToSpawn = mobConfig.minMobsToSpawnEasy;
							maxMobsToSpawn = mobConfig.maxMobsToSpawnEasy;
							spawnRangeFromPlayerMin = mobConfig.spawnRangeFromPlayerMinEasy;
							spawnRangeFromPlayerMax = mobConfig.spawnRangeFromPlayerMaxEasy;
							staffCooldown = mobConfig.staffCooldownEasy;
							spawnMobsBehindPlayer = mobConfig.spawnMobsBehindPlayerEasy;
							mobOnlySpawnableAtNight = mobConfig.mobOnlySpawnableAtNightEasy;
						}
					}
					else if (difficulty == EnumDifficulty.NORMAL)
					{
						if (!Settings.General.useIndividualMobSpawnSettings)
						{
							spawnXPLevel = mobConfig.spawnXPLevelNormal;
							minMobsToSpawn = mobConfig.minMobsToSpawnNormal;
							maxMobsToSpawn = mobConfig.maxMobsToSpawnNormal;
							spawnRangeFromPlayerMin = mobConfig.spawnRangeFromPlayerMinNormal;
							spawnRangeFromPlayerMax = mobConfig.spawnRangeFromPlayerMaxNormal;
							staffCooldown = mobConfig.staffCooldownNormal;
							spawnMobsBehindPlayer = mobConfig.spawnMobsBehindPlayerNormal;
							mobOnlySpawnableAtNight = mobConfig.mobOnlySpawnableAtNightNormal;
						}
					}
					else if (difficulty == EnumDifficulty.HARD)
					{
						if (!Settings.General.useIndividualMobSpawnSettings)
						{
							spawnXPLevel = mobConfig.spawnXPLevelHard;
							minMobsToSpawn = mobConfig.minMobsToSpawnHard;
							maxMobsToSpawn = mobConfig.maxMobsToSpawnHard;
							spawnRangeFromPlayerMin = mobConfig.spawnRangeFromPlayerMinHard;
							spawnRangeFromPlayerMax = mobConfig.spawnRangeFromPlayerMaxHard;
							staffCooldown = mobConfig.staffCooldownHard;
							spawnMobsBehindPlayer = mobConfig.spawnMobsBehindPlayerHard;
							mobOnlySpawnableAtNight = mobConfig.mobOnlySpawnableAtNightHard;
						}
					}
				}
			}

			if (!validMobConfigFound)
			{
				entityPlayer.addChatMessage(new TextComponentString("Unknown mob to be spawned: " + mobToSpawn));
				return new ActionResult<>(EnumActionResult.PASS, itemStack);
			}

			if (staffCooldown > 0)
			{
				currentTime = (new Date().getTime());
				if (ItemNBTHelper.hasTag(itemStack, Names.NBTTags.STAFF_SPAWN_TIMESTAMP))
				{
					coolDownTime = ItemNBTHelper.getLong(itemStack, Names.NBTTags.STAFF_SPAWN_TIMESTAMP) + (staffCooldown * 1000);

					if (currentTime < coolDownTime)
					{
						entityPlayer.addChatMessage(new TextComponentString("Slow down, you need to let the staff cooldown expire."));
						return new ActionResult<>(EnumActionResult.PASS, itemStack);
					}
					ItemNBTHelper.setLong(itemStack, Names.NBTTags.STAFF_SPAWN_TIMESTAMP, currentTime);
				}
				else
				{
					ItemNBTHelper.setLong(itemStack, Names.NBTTags.STAFF_SPAWN_TIMESTAMP, currentTime);
				}
			}

			if (mobOnlySpawnableAtNight && world.isDaytime())
			{
				entityPlayer.addChatMessage(new TextComponentString("This mob can only be spawned at night."));
				return new ActionResult<>(EnumActionResult.PASS, itemStack);
			}

			if (!entityPlayer.capabilities.isCreativeMode)
			{
				if (entityPlayer.experienceLevel < spawnXPLevel)
				{
					entityPlayer.addChatMessage(new TextComponentString("You do not have enough XP to spawn this mob. You need at least " + spawnXPLevel + " levels."));
					return new ActionResult<>(EnumActionResult.PASS, itemStack);
				}

				entityPlayer.addExperienceLevel(-spawnXPLevel);
			}

			mobsToBeSpawnedRange = maxMobsToSpawn - minMobsToSpawn;
			if (mobsToBeSpawnedRange <= 0)
			{
				mobsToBeSpawnedRange = 1;
			}
			mobsToBeSpawned = world.rand.nextInt(mobsToBeSpawnedRange) + minMobsToSpawn;

			if (itemStack.getMaxDamage() > 0 && !entityPlayer.capabilities.isCreativeMode)
			{
				itemStack.damageItem(1, entityPlayer);
			}

			while (mobSpawnCount < mobsToBeSpawned)
			{
				/* Special case various entities that require custom variable settings */
				if (mobToSpawn.equals("WitherSkeleton"))
				{
					mob = EntityList.createEntityByIDFromName("Skeleton", world);
					((EntitySkeleton)mob).setSkeletonType(SkeletonType.WITHER);
				}
				else
				{
					mob = EntityList.createEntityByIDFromName(mobToSpawn, world);
				}

				if (!(mob instanceof IMob))
				{
					entityPlayer.addChatMessage(new TextComponentString("This mob is not hostile."));
					return new ActionResult<>(EnumActionResult.PASS, itemStack);
				}

				/*
				 * Z = North/South, south being positive.
				 * X = West/East, east being positive.
				 * Facing value ranges from 0-7.
				 * Facing values: South = 0, West = 2, North = 4, East = 6.
				 * South west, north east etc should be self explanitory.
				 * Facing code below taken from a post on the minecraft forge
				 * forums.
				 */

				yaw = (int)entityPlayer.rotationYaw;

				if (yaw < 0)              //due to the yaw running a -360 to positive 360
				{
					yaw+=360;    //not sure why it's that way
				}

				yaw+=22;     //centers coordinates you may want to drop this line
				yaw%=360;  //and this one if you want a strict interpretation of the zones

				facing = yaw/45;   //  360degrees divided by 45 == 8 zones

				mobSpawnRange = spawnRangeFromPlayerMax - spawnRangeFromPlayerMin;
				if (mobSpawnRange <= 0)
				{
					distanceFromPlayer = 1;
				}
				else
				{
					distanceFromPlayer = world.rand.nextInt(mobSpawnRange) + 1;
				}

				if (spawnMobsBehindPlayer)
				{
					spawnBehindPlayer = world.rand.nextBoolean();
				}

				posX = entityPlayer.posX;
				posY = entityPlayer.posY;
				posZ = entityPlayer.posZ;

				/* Calculate posZ based on the facing value */
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
				EntityNBTHelper.setBoolean(mob, Names.NBTTags.MOB_SPAWNED_WITH_STAFF, true);
				world.spawnEntityInWorld(mob);

				mobSpawnCount++;
			}
		}

		return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
	}
}
