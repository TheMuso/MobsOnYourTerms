package com.themuso.mobsonyourterms.handler;

import java.io.File;
import java.util.Iterator;

import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import com.themuso.mobsonyourterms.reference.MobList;
import com.themuso.mobsonyourterms.reference.MobSettings;
import com.themuso.mobsonyourterms.reference.Settings;
import com.themuso.mobsonyourterms.reference.VanillaMobSettings;
import com.themuso.mobsonyourterms.utility.LogHelper;

public class ConfigurationHandler
{
	public static Configuration configuration;

	public static void init(File configFile)
	{
		if (configuration == null)
		{
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}

	private static void loadConfiguration()
	{
		// General settings
		Settings.General.spawnHostileMobs = configuration.getBoolean("spawnHostileMobs", Configuration.CATEGORY_GENERAL, false, "Whether hostile mobs spawn in the world normally.");
		Settings.General.useIndividualMobSpawnSettings = configuration.getBoolean("useIndividualMobSpawnSettings", Configuration.CATEGORY_GENERAL, false, "Use individual mob spawn settings.");
		Settings.General.registerWitherSkeletonEntity = configuration.getBoolean("registerWitherSkeletonEntity", Configuration.CATEGORY_GENERAL, true, "Whether to register the Wither Skeleton as a separate entity. Enabling this option will allow the player to craft Wither Skeleton mob spawners.");
		Settings.General.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", Configuration.CATEGORY_GENERAL, 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		Settings.General.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", Configuration.CATEGORY_GENERAL, 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		Settings.General.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", Configuration.CATEGORY_GENERAL, 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
		Settings.General.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", Configuration.CATEGORY_GENERAL, 1, 1 ,10, "minimum number of mobs to spawn on easy.");
		Settings.General.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Maximum number of mobs to spawn on easy.");
		Settings.General.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", Configuration.CATEGORY_GENERAL, 1, 1, 10, "minimum number of mobs to spawn on normal.");
		Settings.General.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", Configuration.CATEGORY_GENERAL, 2, 1, 10, "Maximum number of mobs to spawn on normal.");
		Settings.General.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", Configuration.CATEGORY_GENERAL, 1, 1, 10, "minimum number of mobs to spawn on hard.");
		Settings.General.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", Configuration.CATEGORY_GENERAL, 3, 1, 10, "Maximum number of mobs to spawn on hard.");
		Settings.General.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", Configuration.CATEGORY_GENERAL, 2, 1, 10, "Minimum range that a mob can spawn from the player on easy.");
		Settings.General.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", Configuration.CATEGORY_GENERAL, 5, 1, 10, "Maximum range that a mob can spawn from the player in easy.");
		Settings.General.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Minimum range that a mob can spawn from the player in normal.");
		Settings.General.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", Configuration.CATEGORY_GENERAL, 3, 1, 10, "Maximum range that a mob can spawn from a player in normal.");
		Settings.General.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Minimum range that a mob can spawn from a player in hard.");
		Settings.General.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", Configuration.CATEGORY_GENERAL, 2, 1, 10, "Maximum range that a mob can spawn from a player in hard.");
		Settings.General.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", Configuration.CATEGORY_GENERAL, false, "Whether mobs can be spawned behind the player on easy difficulty.");
		Settings.General.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", Configuration.CATEGORY_GENERAL, true, "Whether mobs can be spawned behind the player on normal difficulty.");
		Settings.General.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", Configuration.CATEGORY_GENERAL, true, "Whether mobs can be spawned behind the player on hard difficulty.");
		Settings.General.staffCooldownEasy = configuration.getInt("staffCooldownEasy", Configuration.CATEGORY_GENERAL, 0, 0, 30, "THe amount of time the player must wait before the staff can be used to spawn another mob on easy difficulty.");
		Settings.General.staffCooldownNormal = configuration.getInt("staffCooldownNormal", Configuration.CATEGORY_GENERAL, 5, 0, 30, "THe amount of time the player must wait before the staff can be used to spawn another mob on normal difficulty.");
		Settings.General.staffCooldownHard = configuration.getInt("staffCooldownHard", Configuration.CATEGORY_GENERAL, 10, 0, 30, "THe amount of time the player must wait before the staff can be used to spawn another mob on hard difficulty.");
		Settings.General.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", Configuration.CATEGORY_GENERAL, false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		Settings.General.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", Configuration.CATEGORY_GENERAL, true, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		Settings.General.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", Configuration.CATEGORY_GENERAL, true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		Settings.General.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", Configuration.CATEGORY_GENERAL, true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		Settings.General.registerMobSpawnerRecipes = configuration.getBoolean("registerMobSpawnerRecipes", Configuration.CATEGORY_GENERAL, true, "Should recipes to make mob spawners get registered.");
		Settings.General.staffHasOwner = configuration.getBoolean("staffHasOwner", Configuration.CATEGORY_GENERAL, true, "Determines whether a mob spawning staff has an owner after first use.");

		// Mob spawner settings
		Settings.Spawner.changeMobSpawnerBehavior = configuration.getBoolean("changeMobSpawnerBehavior", "Mob Spawner Settings", true, "Whether mob spawner characteristics are changed.");
		Settings.Spawner.activatingRangeFromPlayer = configuration.getInt("activatingRangeFromPlayer", "Mob Spawner Settings", 6, 2, 32, "The distance in blocks a player needs to bbe from the spawner to activate it.");
		Settings.Spawner.spawnRange = configuration.getInt("spawnRange", "Mob Spawner Settings", 4, 2, 32, "The range in blocks where mobs can be spawned.");

		MobSettings mobConfig, mobDefaultSet;

		// Load vanilla mob default settings
		for (String mob : VanillaMobSettings.defaults.keySet())
		{
			mobDefaultSet = VanillaMobSettings.defaults.get(mob);
			mobConfig = populateConfig(mob, mobDefaultSet);

			MobList.mobList.put(mob, mobConfig);
		}

		if (configuration.hasChanged())
		{
			configuration.save();
		}
	}

	public static void validate()
	{
		Iterator iterator;
		Iterator subIterator;
		String key;
		String subKey;
		MobSettings config;
		MobSettings subConfig;

		if (MobList.mobList != null)
		{
			iterator = MobList.mobList.values().iterator();

			while (iterator.hasNext())
			{
				config = (MobSettings)iterator.next();
				if (Item.itemRegistry.getObject(config.staffCreationPrimaryItem) == null)
				{
					key = MobList.getKey(config);
					LogHelper.warn("Invalid item ID " + config.staffCreationPrimaryItem + "for staffCreationPrimaryItem for entity " + key + ", Disabling");
					config.staffCreationPrimaryItem = "";
					config.enableStaffCreationPrimaryItem = false;
				}

				if (Item.itemRegistry.getObject(config.staffCreationSecondaryItem) == null)
				{
					key = MobList.getKey(config);
					LogHelper.warn("Invalid item ID " + config.staffCreationSecondaryItem + "for staffCreationSecondaryItem for entity " + key + ", disabling");
					config.staffCreationSecondaryItem = "";
					config.enableStaffCreationSecondaryItem = false;
				}

				// Duplicate primary/secondary item checking.
				subIterator = MobList.mobList.values().iterator();
				key = MobList.getKey(config);

				while (subIterator.hasNext())
				{
					subConfig = (MobSettings)subIterator.next();
					subKey = MobList.getKey(subConfig);

					if (!key.equals(subKey))
					{
						if (config.staffCreationPrimaryItem.equals(subConfig.staffCreationPrimaryItem))
						{
							LogHelper.warn("The primary staff creation item for mob " + key + " is the same as the primary staff creation item for mob " + subKey);
						}

						if (config.staffCreationSecondaryItem.equals(subConfig.staffCreationSecondaryItem))
						{
							LogHelper.warn("The secondary staff creation item for mob " + key + " is the same as the secondary staff creation item for mob " + subKey);
						}

						if (config.staffCreationPrimaryItem.equals(subConfig.staffCreationSecondaryItem))
						{
							LogHelper.warn("The primary staff creation item for mob " + key + " is the same as the secondary staff creation item for mob " + subKey);
						}

						if (config.staffCreationSecondaryItem.equals(subConfig.staffCreationPrimaryItem))
						{
							LogHelper.warn("The secondary staff creation item for mob " + key + " is the same as the primary staff creation item for mob " + subKey);
						}

						if (config.staffSpawnedMobDropsFragmentForEntity.equals(subConfig.staffSpawnedMobDropsFragmentForEntity))
						{
							LogHelper.warn("The staff fragments that will be dropped by " + key + " and " + subKey + " are for the same mob.");
						}
					}

					/* We special case the Wither Skeleton config as no separate entity exists for it */
					if (!config.staffSpawnedMobDropsFragmentForEntity.equals("WitherSkeleton")
					  && (EntityList.stringToClassMapping.get(config.staffSpawnedMobDropsFragmentForEntity) == null))
					{
						LogHelper.warn("No such entity named " + config.staffSpawnedMobDropsFragmentForEntity + ". Disabling the dropping of staff fragments by mob " + key + ".");
						config.mobDropsStaffFragment = false;
						config.staffSpawnedMobDropsFragmentForEntity = "";
					}
				}
			}
		}
	}

	private static MobSettings populateConfig(String mobName, MobSettings mobSet)
	{
		MobSettings mobConfig = new MobSettings();
		mobConfig.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", "Mobs." + mobName, mobSet.spawnXPLevelEasy, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		mobConfig.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", "Mobs." + mobName, mobSet.spawnXPLevelNormal, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		mobConfig.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", "Mobs." + mobName, mobSet.spawnXPLevelHard, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
		mobConfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs." + mobName, mobSet.minMobsToSpawnEasy, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobConfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs." + mobName, mobSet.maxMobsToSpawnEasy, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobConfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs." + mobName, mobSet.minMobsToSpawnNormal, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobConfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs." + mobName, mobSet.maxMobsToSpawnNormal, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobConfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs." + mobName, mobSet.minMobsToSpawnHard, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobConfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs." + mobName, mobSet.maxMobsToSpawnHard, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobConfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs." + mobName, mobSet.spawnRangeFromPlayerMinEasy, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobConfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs." + mobName, mobSet.spawnRangeFromPlayerMaxEasy, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobConfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs." + mobName, mobSet.spawnRangeFromPlayerMinNormal, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobConfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs." + mobName, mobSet.spawnRangeFromPlayerMaxNormal, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobConfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs." + mobName, mobSet.spawnRangeFromPlayerMinHard, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobConfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs." + mobName, mobSet.spawnRangeFromPlayerMaxHard, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobConfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs." + mobName, mobSet.spawnMobsBehindPlayerEasy, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobConfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs." + mobName, mobSet.spawnMobsBehindPlayerNormal, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobConfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs." + mobName, mobSet.spawnMobsBehindPlayerHard, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobConfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs." + mobName, mobSet.enableStaffCreationPrimaryItem, "Whether to enable the use of the primary item to create the staff.");
		mobConfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs." + mobName, mobSet.staffCreationPrimaryItem, "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobConfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs." + mobName, mobSet.staffCreationPrimaryItemAmount, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobConfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs." + mobName, mobSet.staffCreationPrimaryItemLevels, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobConfig.staffCreationPrimaryItemUses = configuration.getInt("staffCreationPrimaryItemUses", "Mobs." + mobName, mobSet.staffCreationPrimaryItemUses, 0, 100, "The number of times the staff can be used when it is created with the primary item. A value of 0 gives unlimited uses.");
		mobConfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs." + mobName, mobSet.enableStaffCreationSecondaryItem, "Whether to enable the use of a secondary item to create the staff.");
		mobConfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs." + mobName, mobSet.staffCreationSecondaryItem, "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobConfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs." + mobName, mobSet.staffCreationSecondaryItemAmount, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobConfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs." + mobName, mobSet.staffCreationSecondaryItemLevels, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobConfig.staffCreationSecondaryItemUses = configuration.getInt("staffCreationSecondaryItemUses", "Mobs." + mobName, mobSet.staffCreationSecondaryItemUses, 0, 100, "The number of times the staff can be used when it is created with the secondary item. A value of 0 gives unlimited uses.");
		mobConfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs." + mobName, mobSet.mobDropsStaffFragment, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobConfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs." + mobName, mobSet.staffSpawnedMobDropsFragmentForEntity, "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobConfig.minDroppedStaffFragmentsEasy = configuration.getInt("minDroppedStaffFragmentsEasy", "Mobs." + mobName, mobSet.minDroppedStaffFragmentsEasy, 1, 10, "The minimum number of staff fragments the mob will drop when killed on easy difficulty. A random value will be chosen between the minimum and maximum dropped staff fragments settings, and will then be multiplied by the fortune level. If there is no fortune on the weapon used to kill the mobName, a fortune level of 1 is used.");
		mobConfig.maxDroppedStaffFragmentsEasy = configuration.getInt("maxDroppedStaffFragmentsEasy", "Mobs." + mobName, mobSet.maxDroppedStaffFragmentsEasy, 1, 10, "The maximum number of staff fragments the mob will drop when killed on easy difficulty. A random value will be chosen between the minimum and maximum dropped staff fragments settings, and will then be multiplied by the fortune level. If there is no fortune on the weapon used to kill the mobName, a fortune level of 1 is used.");
		mobConfig.minDroppedStaffFragmentsNormal = configuration.getInt("minDroppedStaffFragmentsNormal", "Mobs." + mobName, mobSet.minDroppedStaffFragmentsNormal, 1, 5, "The minimum number of staff fragments the mob will drop when killed on normal difficulty. A random value will be chosen between the minimum and maximum dropped staff fragments settings, and will then be multiplied by the fortune level. If there is no fortune on the weapon used to kill the mobName, a fortune level of 1 is used.");
		mobConfig.maxDroppedStaffFragmentsNormal = configuration.getInt("maxDroppedStaffFragmentsNormal", "Mobs." + mobName, mobSet.maxDroppedStaffFragmentsNormal, 1, 5, "The maximum number of staff fragments the mob will drop when killed on normal difficulty. A value will be chosen between the minimum and maximum dropped staff fragments settings, and will then be multiplied by the fortune level. If there is no fortune on the weapon used to kill the mobName, a fortune level of 1 is used.");
		mobConfig.minDroppedStaffFragmentsHard = configuration.getInt("minDroppedStaffFragmentsHard", "Mobs." + mobName, mobSet.minDroppedStaffFragmentsHard, 1, 3, "The minimum number of staff fragments the mob will drop when killed on hard difficulty. A random value will be chosen between the minimum and maximum dropped staff fragments settings, and will then be multiplied by the fortune level. If there is no fortune on the weapon used to kill the mobName, a fortune level of 1 is used.");
		mobConfig.maxDroppedStaffFragmentsHard = configuration.getInt("maxDroppedStaffFragmentsHard", "Mobs." + mobName, mobSet.maxDroppedStaffFragmentsHard, 1, 3, "The maximum number of staff fragments the mob will drop when killed on Hard difficulty. A value will be chosen between the minimum and maximum dropped staff fragments settings, and will then be multiplied by the fortune level. If there is no fortune on the weapon used to kill the mobName, a fortune level of 1 is used.");
		mobConfig.staffFragmentAnvilAmount = configuration.getInt("staffFragmentAnvilAmount", "Mobs." + mobName, mobSet.staffFragmentAnvilAmount, 1, 10, "The number of staff fragments needed to embew a spawning staff in an Anvil.");
		mobConfig.staffFragmentAnvilLevels = configuration.getInt("staffFragmentAnvilLevels", "Mobs." + mobName, mobSet.staffFragmentAnvilLevels, 1, 10, "The required number of experience levels to embue a spawning staff on an anvil with staff fragments.");
		mobConfig.staffFragmentAnvilUses = configuration.getInt("staffFragmentAnvilUses", "Mobs." + mobName, mobSet.staffFragmentAnvilUses, 0, 100, "The number of times the staff can be used when it is created with staff fragments. A value of 0 gives unlimited uses.");
		mobConfig.staffCooldownEasy = configuration.getInt("staffCooldownEasy", "Mobs." + mobName, mobSet.staffCooldownEasy, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on easy difficulty.");
		mobConfig.staffCooldownNormal = configuration.getInt("staffCooldownNormal", "Mobs." + mobName, mobSet.staffCooldownNormal, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on normal difficulty.");
		mobConfig.staffCooldownHard = configuration.getInt("staffCooldownHard", "Mobs." + mobName, mobSet.staffCooldownHard, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on hard difficulty.");
		mobConfig.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", "Mobs." + mobName, mobSet.mobOnlySpawnableAtNightEasy, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		mobConfig.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", "Mobs." + mobName, mobSet.mobOnlySpawnableAtNightNormal, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		mobConfig.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", "Mobs." + mobName, mobSet.mobOnlySpawnableAtNightHard, "SHould the mob only be spawnable with the staff at night on hard difficulty.");

		return mobConfig;
	}
}
