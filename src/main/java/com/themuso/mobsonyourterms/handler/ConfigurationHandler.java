package com.themuso.mobsonyourterms.handler;

import java.io.File;
import java.util.HashMap;

import net.minecraftforge.common.config.Configuration;

import com.themuso.mobsonyourterms.reference.Settings;
import com.themuso.mobsonyourterms.reference.MobSettings;

public class ConfigurationHandler
{
	public static Configuration Configuration;
	public static HashMap<String, MobSettings> mobList;

	public static void init(File configFile)
	{
		if (Configuration == null)
		{
			Configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}

	private static void loadConfiguration()
	{
		MobSettings mobconfig;

		// General settings
		Settings.General.doMobSpawningGameRule = Configuration.getBoolean("doMobSpawningGameRule", Configuration.CATEGORY_GENERAL, false, "Do you want the game rule for mob spawning turned on.");
		Settings.General.mobSpawnRuleEnableXPMultiply = Configuration.getInt("mobSpawnRuleEnableXPMultiply", Configuration.CATEGORY_GENERAL, 4, 1, 10, "Multiplication of XP");
		Settings.General.useIndividualMobSpawnSettings = Configuration.getBoolean("useIndividualMobSpawnSettings", Configuration.CATEGORY_GENERAL, false, "Use individual mob spawn settings.");
		Settings.General.minMobsToSpawnEasy = Configuration.getInt("minMobsToSpawnEasy", Configuration.CATEGORY_GENERAL, 1, 1,10, "minimum number of mobs to spawn on easy.");
		Settings.General.maxMobsToSpawnEasy = Configuration.getInt("maxMobsToSpawnEasy", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Maximum number of mobs to spawn on easy.");
		Settings.General.minMobsToSpawnNormal = Configuration.getInt("minMobsToSpawnNormal", Configuration.CATEGORY_GENERAL, 1, 1, 10, "minimum number of mobs to spawn on normal.");
		Settings.General.maxMobsToSpawnNormal = Configuration.getInt("maxMobsToSpawnNormal", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Maximum number of mobs to spawn on normal.");
		Settings.General.minMobsToSpawnHard = Configuration.getInt("minMobsToSpawnHard", Configuration.CATEGORY_GENERAL, 1, 1,10, "minimum number of mobs to spawn on hard.");
		Settings.General.maxMobsToSpawnHard = Configuration.getInt("maxMobsToSpawnHard", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Maximum number of mobs to spawn on hard.");
		Settings.General.spawnRangeFromPlayerMinEasy = Configuration.getInt("spawnRangeFromPlayerMinEasy", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Minimum range that a mob can spawn from the player on easy.");
		Settings.General.spawnRangeFromPlayerMaxEasy = Configuration.getInt("spawnRangeFromPlayerMaxEasy", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Maximum range that a mob can spawn from the player in easy.");
		Settings.General.spawnRangeFromPlayerMinNormal = Configuration.getInt("spawnRangeFromPlayerMinNormal", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Minimum range that a mob can spawn from the player in normal.");
		Settings.General.spawnRangeFromPlayerMaxNormal = Configuration.getInt("spawnRangeFromPlayerMaxNormal", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Maximum range that a mob can spawn from a player in normal.");
		Settings.General.spawnRangeFromPlayerMinHard = Configuration.getInt("spawnRangeFromPlayerMinHard", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Minimum range that a mob can spawn from a player in hard.");
		Settings.General.spawnRangeFromPlayerMaxHard = Configuration.getInt("spawnRangeFromPlayerMaxHard", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Maximum range that a mob can spawn from a player in hard.");
		Settings.General.spawnMobsBehindPlayerEasy = Configuration.getBoolean("spawnMobsBehindPlayerEasy", Configuration.CATEGORY_GENERAL, false, "Whether mobs can be spawned behind the player on easy difficulty.");
		Settings.General.spawnMobsBehindPlayerNormal = Configuration.getBoolean("spawnMobsBehindPlayerNormal", Configuration.CATEGORY_GENERAL, true, "Whether mobs can be spawned behind the player on normal difficulty.");
		Settings.General.spawnMobsBehindPlayerHard = Configuration.getBoolean("spawnMobsBehindPlayerHard", Configuration.CATEGORY_GENERAL, true, "Whether mobs can be spawned behind the player on hard difficulty.");
		Settings.General.staffCooldown = Configuration.getInt("staffCooldown", Configuration.CATEGORY_GENERAL, 0, 0, 30, "THe amount of time the player must wait before the staff can be used to spawn another mob.");
		Settings.General.mobsOnlySpawnableAtNight = Configuration.getBoolean("mobsOnlySpawnableAtNight", Configuration.CATEGORY_GENERAL, true, "SHould mobs only be spawnable with the staff at night.");
		Settings.General.registerMobSpawnerRecipes = Configuration.getBoolean("registerMobSpawnerRecipes", Configuration.CATEGORY_GENERAL, true, "Should recipes to make mob spawners get registered.");

		// Mob spawner settings
		Settings.Spawner.changeMobSpawnerBehavior = Configuration.getBoolean("changeMobSpawnerBehavior", "Mob Spawner Settings", true, "Whether mob spawner characteristics are changed.");
		Settings.Spawner.activatingRangeFromPlayer = Configuration.getInt("activatingRangeFromPlayer", "Mob Spawner Settings", 4, 2, 32, "The distance in blocks a player needs to bbe from the spawner to activate it.");
		Settings.Spawner.spawnRange = Configuration.getInt("spawnRange", "Mob Spawner Settings", 8, 2, 32, "The range in blocks where mobs can be spawned.");

		// Mob settings
		mobList = new HashMap();

		// Zombie
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = Configuration.getInt("spawnXPLevel", "Mobs.Zombie", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = Configuration.getInt("minMobsToSpawnEasy", "Mobs.Zombie", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = Configuration.getInt("maxMobsToSpawnEasy", "Mobs.Zombie", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = Configuration.getInt("minMobsToSpawnNormal", "Mobs.Zombie", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = Configuration.getInt("maxMobsToSpawnNormal", "Mobs.Zombie", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = Configuration.getInt("minMobsToSpawnHard", "Mobs.Zombie", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = Configuration.getInt("maxMobsToSpawnHard", "Mobs.Zombie", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = Configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Zombie", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = Configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Zombie", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = Configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Zombie", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = Configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Zombie", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = Configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Zombie", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = Configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Zombie", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = Configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Zombie", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = Configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Zombie", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = Configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Zombie", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = Configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Zombie", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = Configuration.getString("staffCreationPrimaryItem", "Mobs.Zombie", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = Configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Zombie", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = Configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Zombie", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = Configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Zombie", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = Configuration.getString("staffCreationSecondaryItem", "Mobs.Zombie", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = Configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Zombie", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = Configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Zombie", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = Configuration.getBoolean("enableStaffFragmentItem", "Mobs.Zombie", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = Configuration.getBoolean("mobDropsStaffFragment", "Mobs.Zombie", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = Configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Zombie", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = Configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Zombie", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = Configuration.getInt("staffCooldown", "Mobs.Zombie", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Zombie", mobconfig);
		mobconfig = null;

		if (Configuration.hasChanged())
		{
			Configuration.save();
		}
	}
}
