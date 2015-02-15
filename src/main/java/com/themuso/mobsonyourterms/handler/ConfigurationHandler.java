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

		// Creeper
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = Configuration.getInt("spawnXPLevel", "Mobs.Creeper", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = Configuration.getInt("minMobsToSpawnEasy", "Mobs.Creeper", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = Configuration.getInt("maxMobsToSpawnEasy", "Mobs.Creeper", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = Configuration.getInt("minMobsToSpawnNormal", "Mobs.Creeper", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = Configuration.getInt("maxMobsToSpawnNormal", "Mobs.Creeper", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = Configuration.getInt("minMobsToSpawnHard", "Mobs.Creeper", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = Configuration.getInt("maxMobsToSpawnHard", "Mobs.Creeper", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = Configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Creeper", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = Configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Creeper", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = Configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Creeper", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = Configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Creeper", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = Configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Creeper", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = Configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Creeper", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = Configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Creeper", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = Configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Creeper", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = Configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Creeper", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = Configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Creeper", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = Configuration.getString("staffCreationPrimaryItem", "Mobs.Creeper", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = Configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Creeper", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = Configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Creeper", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = Configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Creeper", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = Configuration.getString("staffCreationSecondaryItem", "Mobs.Creeper", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = Configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Creeper", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = Configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Creeper", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = Configuration.getBoolean("enableStaffFragmentItem", "Mobs.Creeper", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = Configuration.getBoolean("mobDropsStaffFragment", "Mobs.Creeper", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = Configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Creeper", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = Configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Creeper", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = Configuration.getInt("staffCooldown", "Mobs.Creeper", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Creeper", mobconfig);
		mobconfig = null;

		// Spider
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = Configuration.getInt("spawnXPLevel", "Mobs.Spider", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = Configuration.getInt("minMobsToSpawnEasy", "Mobs.Spider", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = Configuration.getInt("maxMobsToSpawnEasy", "Mobs.Spider", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = Configuration.getInt("minMobsToSpawnNormal", "Mobs.Spider", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = Configuration.getInt("maxMobsToSpawnNormal", "Mobs.Spider", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = Configuration.getInt("minMobsToSpawnHard", "Mobs.Spider", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = Configuration.getInt("maxMobsToSpawnHard", "Mobs.Spider", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = Configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Spider", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = Configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Spider", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = Configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Spider", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = Configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Spider", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = Configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Spider", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = Configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Spider", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = Configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Spider", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = Configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Spider", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = Configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Spider", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = Configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Spider", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = Configuration.getString("staffCreationPrimaryItem", "Mobs.Spider", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = Configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Spider", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = Configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Spider", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = Configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Spider", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = Configuration.getString("staffCreationSecondaryItem", "Mobs.Spider", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = Configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Spider", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = Configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Spider", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = Configuration.getBoolean("enableStaffFragmentItem", "Mobs.Spider", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = Configuration.getBoolean("mobDropsStaffFragment", "Mobs.Spider", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = Configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Spider", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = Configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Spider", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = Configuration.getInt("staffCooldown", "Mobs.Spider", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Spider", mobconfig);
		mobconfig = null;

		// Slime
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = Configuration.getInt("spawnXPLevel", "Mobs.Slime", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = Configuration.getInt("minMobsToSpawnEasy", "Mobs.Slime", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = Configuration.getInt("maxMobsToSpawnEasy", "Mobs.Slime", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = Configuration.getInt("minMobsToSpawnNormal", "Mobs.Slime", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = Configuration.getInt("maxMobsToSpawnNormal", "Mobs.Slime", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = Configuration.getInt("minMobsToSpawnHard", "Mobs.Slime", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = Configuration.getInt("maxMobsToSpawnHard", "Mobs.Slime", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = Configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Slime", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = Configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Slime", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = Configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Slime", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = Configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Slime", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = Configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Slime", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = Configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Slime", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = Configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Slime", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = Configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Slime", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = Configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Slime", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = Configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Slime", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = Configuration.getString("staffCreationPrimaryItem", "Mobs.Slime", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = Configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Slime", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = Configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Slime", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = Configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Slime", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = Configuration.getString("staffCreationSecondaryItem", "Mobs.Slime", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = Configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Slime", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = Configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Slime", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = Configuration.getBoolean("enableStaffFragmentItem", "Mobs.Slime", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = Configuration.getBoolean("mobDropsStaffFragment", "Mobs.Slime", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = Configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Slime", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = Configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Slime", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = Configuration.getInt("staffCooldown", "Mobs.Slime", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Slime", mobconfig);
		mobconfig = null;

		// Silverfish
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = Configuration.getInt("spawnXPLevel", "Mobs.Silverfish", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = Configuration.getInt("minMobsToSpawnEasy", "Mobs.Silverfish", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = Configuration.getInt("maxMobsToSpawnEasy", "Mobs.Silverfish", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = Configuration.getInt("minMobsToSpawnNormal", "Mobs.Silverfish", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = Configuration.getInt("maxMobsToSpawnNormal", "Mobs.Silverfish", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = Configuration.getInt("minMobsToSpawnHard", "Mobs.Silverfish", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = Configuration.getInt("maxMobsToSpawnHard", "Mobs.Silverfish", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = Configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Silverfish", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = Configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Silverfish", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = Configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Silverfish", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = Configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Silverfish", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = Configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Silverfish", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = Configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Silverfish", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = Configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Silverfish", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = Configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Silverfish", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = Configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Silverfish", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = Configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Silverfish", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = Configuration.getString("staffCreationPrimaryItem", "Mobs.Silverfish", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = Configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Silverfish", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = Configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Silverfish", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = Configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Silverfish", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = Configuration.getString("staffCreationSecondaryItem", "Mobs.Silverfish", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = Configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Silverfish", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = Configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Silverfish", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = Configuration.getBoolean("enableStaffFragmentItem", "Mobs.Silverfish", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = Configuration.getBoolean("mobDropsStaffFragment", "Mobs.Silverfish", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = Configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Silverfish", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = Configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Silverfish", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = Configuration.getInt("staffCooldown", "Mobs.Silverfish", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Silverfish", mobconfig);
		mobconfig = null;

		// Skeleton
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = Configuration.getInt("spawnXPLevel", "Mobs.Skeleton", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = Configuration.getInt("minMobsToSpawnEasy", "Mobs.Skeleton", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = Configuration.getInt("maxMobsToSpawnEasy", "Mobs.Skeleton", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = Configuration.getInt("minMobsToSpawnNormal", "Mobs.Skeleton", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = Configuration.getInt("maxMobsToSpawnNormal", "Mobs.Skeleton", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = Configuration.getInt("minMobsToSpawnHard", "Mobs.Skeleton", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = Configuration.getInt("maxMobsToSpawnHard", "Mobs.Skeleton", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = Configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Skeleton", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = Configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Skeleton", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = Configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Skeleton", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = Configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Skeleton", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = Configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Skeleton", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = Configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Skeleton", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = Configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Skeleton", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = Configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Skeleton", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = Configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Skeleton", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = Configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Skeleton", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = Configuration.getString("staffCreationPrimaryItem", "Mobs.Skeleton", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = Configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Skeleton", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = Configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Skeleton", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = Configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Skeleton", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = Configuration.getString("staffCreationSecondaryItem", "Mobs.Skeleton", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = Configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Skeleton", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = Configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Skeleton", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = Configuration.getBoolean("enableStaffFragmentItem", "Mobs.Skeleton", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = Configuration.getBoolean("mobDropsStaffFragment", "Mobs.Skeleton", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = Configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Skeleton", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = Configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Skeleton", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = Configuration.getInt("staffCooldown", "Mobs.Skeleton", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Skeleton", mobconfig);
		mobconfig = null;

		// Witch
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = Configuration.getInt("spawnXPLevel", "Mobs.Witch", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = Configuration.getInt("minMobsToSpawnEasy", "Mobs.Witch", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = Configuration.getInt("maxMobsToSpawnEasy", "Mobs.Witch", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = Configuration.getInt("minMobsToSpawnNormal", "Mobs.Witch", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = Configuration.getInt("maxMobsToSpawnNormal", "Mobs.Witch", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = Configuration.getInt("minMobsToSpawnHard", "Mobs.Witch", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = Configuration.getInt("maxMobsToSpawnHard", "Mobs.Witch", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = Configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Witch", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = Configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Witch", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = Configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Witch", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = Configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Witch", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = Configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Witch", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = Configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Witch", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = Configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Witch", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = Configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Witch", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = Configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Witch", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = Configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Witch", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = Configuration.getString("staffCreationPrimaryItem", "Mobs.Witch", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = Configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Witch", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = Configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Witch", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = Configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Witch", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = Configuration.getString("staffCreationSecondaryItem", "Mobs.Witch", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = Configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Witch", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = Configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Witch", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = Configuration.getBoolean("enableStaffFragmentItem", "Mobs.Witch", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = Configuration.getBoolean("mobDropsStaffFragment", "Mobs.Witch", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = Configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Witch", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = Configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Witch", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = Configuration.getInt("staffCooldown", "Mobs.Witch", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Witch", mobconfig);
		mobconfig = null;

		// PigZombie
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = Configuration.getInt("spawnXPLevel", "Mobs.PigZombie", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = Configuration.getInt("minMobsToSpawnEasy", "Mobs.PigZombie", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = Configuration.getInt("maxMobsToSpawnEasy", "Mobs.PigZombie", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = Configuration.getInt("minMobsToSpawnNormal", "Mobs.PigZombie", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = Configuration.getInt("maxMobsToSpawnNormal", "Mobs.PigZombie", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = Configuration.getInt("minMobsToSpawnHard", "Mobs.PigZombie", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = Configuration.getInt("maxMobsToSpawnHard", "Mobs.PigZombie", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = Configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.PigZombie", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = Configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.PigZombie", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = Configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.PigZombie", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = Configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.PigZombie", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = Configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.PigZombie", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = Configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.PigZombie", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = Configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.PigZombie", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = Configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.PigZombie", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = Configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.PigZombie", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = Configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.PigZombie", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = Configuration.getString("staffCreationPrimaryItem", "Mobs.PigZombie", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = Configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.PigZombie", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = Configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.PigZombie", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = Configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.PigZombie", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = Configuration.getString("staffCreationSecondaryItem", "Mobs.PigZombie", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = Configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.PigZombie", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = Configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.PigZombie", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = Configuration.getBoolean("enableStaffFragmentItem", "Mobs.PigZombie", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = Configuration.getBoolean("mobDropsStaffFragment", "Mobs.PigZombie", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = Configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.PigZombie", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = Configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.PigZombie", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = Configuration.getInt("staffCooldown", "Mobs.PigZombie", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("PigZombie", mobconfig);
		mobconfig = null;

		// Ghast
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = Configuration.getInt("spawnXPLevel", "Mobs.Ghast", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = Configuration.getInt("minMobsToSpawnEasy", "Mobs.Ghast", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = Configuration.getInt("maxMobsToSpawnEasy", "Mobs.Ghast", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = Configuration.getInt("minMobsToSpawnNormal", "Mobs.Ghast", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = Configuration.getInt("maxMobsToSpawnNormal", "Mobs.Ghast", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = Configuration.getInt("minMobsToSpawnHard", "Mobs.Ghast", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = Configuration.getInt("maxMobsToSpawnHard", "Mobs.Ghast", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = Configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Ghast", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = Configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Ghast", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = Configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Ghast", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = Configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Ghast", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = Configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Ghast", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = Configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Ghast", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = Configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Ghast", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = Configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Ghast", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = Configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Ghast", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = Configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Ghast", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = Configuration.getString("staffCreationPrimaryItem", "Mobs.Ghast", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = Configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Ghast", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = Configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Ghast", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = Configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Ghast", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = Configuration.getString("staffCreationSecondaryItem", "Mobs.Ghast", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = Configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Ghast", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = Configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Ghast", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = Configuration.getBoolean("enableStaffFragmentItem", "Mobs.Ghast", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = Configuration.getBoolean("mobDropsStaffFragment", "Mobs.Ghast", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = Configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Ghast", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = Configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Ghast", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = Configuration.getInt("staffCooldown", "Mobs.Ghast", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Ghast", mobconfig);
		mobconfig = null;

		// LavaSlime
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = Configuration.getInt("spawnXPLevel", "Mobs.LavaSlime", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = Configuration.getInt("minMobsToSpawnEasy", "Mobs.LavaSlime", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = Configuration.getInt("maxMobsToSpawnEasy", "Mobs.LavaSlime", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = Configuration.getInt("minMobsToSpawnNormal", "Mobs.LavaSlime", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = Configuration.getInt("maxMobsToSpawnNormal", "Mobs.LavaSlime", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = Configuration.getInt("minMobsToSpawnHard", "Mobs.LavaSlime", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = Configuration.getInt("maxMobsToSpawnHard", "Mobs.LavaSlime", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = Configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.LavaSlime", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = Configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.LavaSlime", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = Configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.LavaSlime", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = Configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.LavaSlime", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = Configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.LavaSlime", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = Configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.LavaSlime", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = Configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.LavaSlime", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = Configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.LavaSlime", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = Configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.LavaSlime", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = Configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.LavaSlime", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = Configuration.getString("staffCreationPrimaryItem", "Mobs.LavaSlime", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = Configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.LavaSlime", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = Configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.LavaSlime", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = Configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.LavaSlime", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = Configuration.getString("staffCreationSecondaryItem", "Mobs.LavaSlime", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = Configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.LavaSlime", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = Configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.LavaSlime", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = Configuration.getBoolean("enableStaffFragmentItem", "Mobs.LavaSlime", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = Configuration.getBoolean("mobDropsStaffFragment", "Mobs.LavaSlime", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = Configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.LavaSlime", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = Configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.LavaSlime", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = Configuration.getInt("staffCooldown", "Mobs.LavaSlime", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("LavaSlime", mobconfig);
		mobconfig = null;

		// WitherSkeleton
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = Configuration.getInt("spawnXPLevel", "Mobs.WitherSkeleton", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = Configuration.getInt("minMobsToSpawnEasy", "Mobs.WitherSkeleton", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = Configuration.getInt("maxMobsToSpawnEasy", "Mobs.WitherSkeleton", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = Configuration.getInt("minMobsToSpawnNormal", "Mobs.WitherSkeleton", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = Configuration.getInt("maxMobsToSpawnNormal", "Mobs.WitherSkeleton", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = Configuration.getInt("minMobsToSpawnHard", "Mobs.WitherSkeleton", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = Configuration.getInt("maxMobsToSpawnHard", "Mobs.WitherSkeleton", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = Configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.WitherSkeleton", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = Configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.WitherSkeleton", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = Configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.WitherSkeleton", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = Configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.WitherSkeleton", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = Configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.WitherSkeleton", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = Configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.WitherSkeleton", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = Configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.WitherSkeleton", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = Configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.WitherSkeleton", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = Configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.WitherSkeleton", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = Configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.WitherSkeleton", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = Configuration.getString("staffCreationPrimaryItem", "Mobs.WitherSkeleton", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = Configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.WitherSkeleton", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = Configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.WitherSkeleton", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = Configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.WitherSkeleton", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = Configuration.getString("staffCreationSecondaryItem", "Mobs.WitherSkeleton", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = Configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.WitherSkeleton", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = Configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.WitherSkeleton", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = Configuration.getBoolean("enableStaffFragmentItem", "Mobs.WitherSkeleton", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = Configuration.getBoolean("mobDropsStaffFragment", "Mobs.WitherSkeleton", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = Configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.WitherSkeleton", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = Configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.WitherSkeleton", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = Configuration.getInt("staffCooldown", "Mobs.WitherSkeleton", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("WitherSkeleton", mobconfig);
		mobconfig = null;

		// Enderman
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = Configuration.getInt("spawnXPLevel", "Mobs.Enderman", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = Configuration.getInt("minMobsToSpawnEasy", "Mobs.Enderman", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = Configuration.getInt("maxMobsToSpawnEasy", "Mobs.Enderman", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = Configuration.getInt("minMobsToSpawnNormal", "Mobs.Enderman", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = Configuration.getInt("maxMobsToSpawnNormal", "Mobs.Enderman", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = Configuration.getInt("minMobsToSpawnHard", "Mobs.Enderman", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = Configuration.getInt("maxMobsToSpawnHard", "Mobs.Enderman", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = Configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Enderman", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = Configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Enderman", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = Configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Enderman", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = Configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Enderman", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = Configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Enderman", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = Configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Enderman", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = Configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Enderman", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = Configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Enderman", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = Configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Enderman", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = Configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Enderman", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = Configuration.getString("staffCreationPrimaryItem", "Mobs.Enderman", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = Configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Enderman", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = Configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Enderman", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = Configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Enderman", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = Configuration.getString("staffCreationSecondaryItem", "Mobs.Enderman", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = Configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Enderman", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = Configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Enderman", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = Configuration.getBoolean("enableStaffFragmentItem", "Mobs.Enderman", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = Configuration.getBoolean("mobDropsStaffFragment", "Mobs.Enderman", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = Configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Enderman", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = Configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Enderman", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = Configuration.getInt("staffCooldown", "Mobs.Enderman", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Enderman", mobconfig);
		mobconfig = null;

		if (Configuration.hasChanged())
		{
			Configuration.save();
		}
	}
}
