package com.themuso.mobsonyourterms.handler;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import com.themuso.mobsonyourterms.reference.MobSettings;
import com.themuso.mobsonyourterms.reference.Settings;
import com.themuso.mobsonyourterms.utility.LogHelper;

public class ConfigurationHandler
{
	public static Configuration configuration;
	public static HashMap<String, MobSettings> mobList = new HashMap<String, MobSettings>();

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
		Settings.General.doMobSpawningGameRule = configuration.getBoolean("doMobSpawningGameRule", Configuration.CATEGORY_GENERAL, false, "Do you want the game rule for mob spawning turned on.");
		Settings.General.mobSpawnRuleEnableXPMultiply = configuration.getInt("mobSpawnRuleEnableXPMultiply", Configuration.CATEGORY_GENERAL, 4, 1, 10, "Multiplication of XP");
		Settings.General.useIndividualMobSpawnSettings = configuration.getBoolean("useIndividualMobSpawnSettings", Configuration.CATEGORY_GENERAL, false, "Use individual mob spawn settings.");
		Settings.General.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", Configuration.CATEGORY_GENERAL, 1, 1,10, "minimum number of mobs to spawn on easy.");
		Settings.General.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Maximum number of mobs to spawn on easy.");
		Settings.General.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", Configuration.CATEGORY_GENERAL, 1, 1, 10, "minimum number of mobs to spawn on normal.");
		Settings.General.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Maximum number of mobs to spawn on normal.");
		Settings.General.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", Configuration.CATEGORY_GENERAL, 1, 1,10, "minimum number of mobs to spawn on hard.");
		Settings.General.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Maximum number of mobs to spawn on hard.");
		Settings.General.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Minimum range that a mob can spawn from the player on easy.");
		Settings.General.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Maximum range that a mob can spawn from the player in easy.");
		Settings.General.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Minimum range that a mob can spawn from the player in normal.");
		Settings.General.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Maximum range that a mob can spawn from a player in normal.");
		Settings.General.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Minimum range that a mob can spawn from a player in hard.");
		Settings.General.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", Configuration.CATEGORY_GENERAL, 1, 1, 10, "Maximum range that a mob can spawn from a player in hard.");
		Settings.General.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", Configuration.CATEGORY_GENERAL, false, "Whether mobs can be spawned behind the player on easy difficulty.");
		Settings.General.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", Configuration.CATEGORY_GENERAL, true, "Whether mobs can be spawned behind the player on normal difficulty.");
		Settings.General.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", Configuration.CATEGORY_GENERAL, true, "Whether mobs can be spawned behind the player on hard difficulty.");
		Settings.General.staffCooldown = configuration.getInt("staffCooldown", Configuration.CATEGORY_GENERAL, 0, 0, 30, "THe amount of time the player must wait before the staff can be used to spawn another mob.");
		Settings.General.mobsOnlySpawnableAtNight = configuration.getBoolean("mobsOnlySpawnableAtNight", Configuration.CATEGORY_GENERAL, true, "SHould mobs only be spawnable with the staff at night.");
		Settings.General.registerMobSpawnerRecipes = configuration.getBoolean("registerMobSpawnerRecipes", Configuration.CATEGORY_GENERAL, true, "Should recipes to make mob spawners get registered.");

		// Mob spawner settings
		Settings.Spawner.changeMobSpawnerBehavior = configuration.getBoolean("changeMobSpawnerBehavior", "Mob Spawner Settings", true, "Whether mob spawner characteristics are changed.");
		Settings.Spawner.activatingRangeFromPlayer = configuration.getInt("activatingRangeFromPlayer", "Mob Spawner Settings", 4, 2, 32, "The distance in blocks a player needs to bbe from the spawner to activate it.");
		Settings.Spawner.spawnRange = configuration.getInt("spawnRange", "Mob Spawner Settings", 8, 2, 32, "The range in blocks where mobs can be spawned.");

		// Mob settings
		MobSettings mobconfig;

		// Zombie
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = configuration.getInt("spawnXPLevel", "Mobs.Zombie", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.Zombie", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.Zombie", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.Zombie", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.Zombie", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.Zombie", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.Zombie", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Zombie", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Zombie", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Zombie", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Zombie", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Zombie", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Zombie", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Zombie", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Zombie", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Zombie", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Zombie", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.Zombie", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Zombie", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Zombie", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Zombie", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.Zombie", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Zombie", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Zombie", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", "Mobs.Zombie", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Zombie", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Zombie", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Zombie", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = configuration.getInt("staffCooldown", "Mobs.Zombie", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Zombie", mobconfig);

		// Creeper
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = configuration.getInt("spawnXPLevel", "Mobs.Creeper", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.Creeper", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.Creeper", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.Creeper", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.Creeper", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.Creeper", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.Creeper", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Creeper", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Creeper", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Creeper", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Creeper", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Creeper", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Creeper", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Creeper", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Creeper", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Creeper", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Creeper", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.Creeper", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Creeper", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Creeper", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Creeper", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.Creeper", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Creeper", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Creeper", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", "Mobs.Creeper", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Creeper", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Creeper", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Creeper", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = configuration.getInt("staffCooldown", "Mobs.Creeper", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Creeper", mobconfig);

		// Spider
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = configuration.getInt("spawnXPLevel", "Mobs.Spider", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.Spider", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.Spider", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.Spider", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.Spider", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.Spider", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.Spider", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Spider", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Spider", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Spider", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Spider", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Spider", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Spider", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Spider", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Spider", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Spider", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Spider", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.Spider", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Spider", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Spider", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Spider", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.Spider", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Spider", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Spider", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", "Mobs.Spider", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Spider", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Spider", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Spider", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = configuration.getInt("staffCooldown", "Mobs.Spider", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Spider", mobconfig);

		// Slime
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = configuration.getInt("spawnXPLevel", "Mobs.Slime", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.Slime", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.Slime", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.Slime", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.Slime", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.Slime", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.Slime", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Slime", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Slime", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Slime", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Slime", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Slime", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Slime", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Slime", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Slime", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Slime", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Slime", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.Slime", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Slime", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Slime", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Slime", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.Slime", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Slime", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Slime", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", "Mobs.Slime", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Slime", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Slime", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Slime", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = configuration.getInt("staffCooldown", "Mobs.Slime", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Slime", mobconfig);

		// Silverfish
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = configuration.getInt("spawnXPLevel", "Mobs.Silverfish", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.Silverfish", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.Silverfish", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.Silverfish", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.Silverfish", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.Silverfish", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.Silverfish", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Silverfish", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Silverfish", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Silverfish", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Silverfish", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Silverfish", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Silverfish", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Silverfish", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Silverfish", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Silverfish", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Silverfish", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.Silverfish", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Silverfish", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Silverfish", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Silverfish", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.Silverfish", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Silverfish", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Silverfish", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", "Mobs.Silverfish", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Silverfish", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Silverfish", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Silverfish", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = configuration.getInt("staffCooldown", "Mobs.Silverfish", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Silverfish", mobconfig);

		// Skeleton
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = configuration.getInt("spawnXPLevel", "Mobs.Skeleton", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.Skeleton", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.Skeleton", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.Skeleton", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.Skeleton", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.Skeleton", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.Skeleton", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Skeleton", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Skeleton", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Skeleton", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Skeleton", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Skeleton", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Skeleton", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Skeleton", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Skeleton", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Skeleton", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Skeleton", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.Skeleton", "minecraft:bone", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Skeleton", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Skeleton", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Skeleton", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.Skeleton", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Skeleton", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Skeleton", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", "Mobs.Skeleton", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Skeleton", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Skeleton", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Skeleton", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = configuration.getInt("staffCooldown", "Mobs.Skeleton", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Skeleton", mobconfig);

		// Witch
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = configuration.getInt("spawnXPLevel", "Mobs.Witch", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.Witch", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.Witch", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.Witch", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.Witch", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.Witch", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.Witch", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Witch", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Witch", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Witch", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Witch", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Witch", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Witch", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Witch", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Witch", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Witch", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Witch", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.Witch", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Witch", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Witch", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Witch", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.Witch", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Witch", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Witch", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", "Mobs.Witch", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Witch", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Witch", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Witch", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = configuration.getInt("staffCooldown", "Mobs.Witch", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Witch", mobconfig);

		// PigZombie
		mobconfig = new MobSettings();
		MobSettings Pigmobconfig = new MobSettings();
		Pigmobconfig.spawnXPLevel = configuration.getInt("spawnXPLevel", "Mobs.PigZombie", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		Pigmobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.PigZombie", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		Pigmobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.PigZombie", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		Pigmobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.PigZombie", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		Pigmobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.PigZombie", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		Pigmobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.PigZombie", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		Pigmobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.PigZombie", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		Pigmobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.PigZombie", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		Pigmobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.PigZombie", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		Pigmobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.PigZombie", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		Pigmobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.PigZombie", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		Pigmobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.PigZombie", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		Pigmobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.PigZombie", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		Pigmobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.PigZombie", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		Pigmobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.PigZombie", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		Pigmobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.PigZombie", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		Pigmobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.PigZombie", true, "Whether to enable the use of the primary item to create the staff.");
		Pigmobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.PigZombie", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		Pigmobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.PigZombie", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		Pigmobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.PigZombie", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		Pigmobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.PigZombie", true, "Whether to enable the use of a secondary item to create the staff.");
		Pigmobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.PigZombie", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		Pigmobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.PigZombie", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		Pigmobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.PigZombie", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		Pigmobconfig.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", "Mobs.PigZombie", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		Pigmobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.PigZombie", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		Pigmobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.PigZombie", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		Pigmobconfig.staffSpawnedMobDropsFragmentFortune = configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.PigZombie", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		Pigmobconfig.staffCooldown = configuration.getInt("staffCooldown", "Mobs.PigZombie", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("PigZombie", Pigmobconfig);

		// Ghast
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = configuration.getInt("spawnXPLevel", "Mobs.Ghast", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.Ghast", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.Ghast", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.Ghast", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.Ghast", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.Ghast", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.Ghast", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Ghast", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Ghast", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Ghast", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Ghast", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Ghast", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Ghast", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Ghast", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Ghast", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Ghast", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Ghast", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.Ghast", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Ghast", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Ghast", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Ghast", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.Ghast", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Ghast", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Ghast", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", "Mobs.Ghast", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Ghast", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Ghast", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Ghast", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = configuration.getInt("staffCooldown", "Mobs.Ghast", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Ghast", mobconfig);

		// LavaSlime
		mobconfig = new MobSettings();
		MobSettings Lavamobconfig = new MobSettings();
		Lavamobconfig.spawnXPLevel = configuration.getInt("spawnXPLevel", "Mobs.LavaSlime", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		Lavamobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.LavaSlime", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		Lavamobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.LavaSlime", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		Lavamobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.LavaSlime", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		Lavamobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.LavaSlime", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		Lavamobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.LavaSlime", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		Lavamobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.LavaSlime", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		Lavamobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.LavaSlime", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		Lavamobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.LavaSlime", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		Lavamobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.LavaSlime", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		Lavamobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.LavaSlime", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		Lavamobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.LavaSlime", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		Lavamobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.LavaSlime", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		Lavamobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.LavaSlime", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		Lavamobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.LavaSlime", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		Lavamobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.LavaSlime", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		Lavamobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.LavaSlime", true, "Whether to enable the use of the primary item to create the staff.");
		Lavamobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.LavaSlime", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		Lavamobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.LavaSlime", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		Lavamobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.LavaSlime", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		Lavamobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.LavaSlime", true, "Whether to enable the use of a secondary item to create the staff.");
		Lavamobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.LavaSlime", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		Lavamobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.LavaSlime", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		Lavamobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.LavaSlime", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		Lavamobconfig.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", "Mobs.LavaSlime", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		Lavamobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.LavaSlime", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		Lavamobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.LavaSlime", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		Lavamobconfig.staffSpawnedMobDropsFragmentFortune = configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.LavaSlime", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		Lavamobconfig.staffCooldown = configuration.getInt("staffCooldown", "Mobs.LavaSlime", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("LavaSlime", Lavamobconfig);

		// WitherSkeleton
		mobconfig = new MobSettings();
		MobSettings Withermobconfig = new MobSettings();
		Withermobconfig.spawnXPLevel = configuration.getInt("spawnXPLevel", "Mobs.WitherSkeleton", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		Withermobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.WitherSkeleton", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		Withermobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.WitherSkeleton", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		Withermobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.WitherSkeleton", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		Withermobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.WitherSkeleton", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		Withermobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.WitherSkeleton", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		Withermobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.WitherSkeleton", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		Withermobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.WitherSkeleton", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		Withermobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.WitherSkeleton", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		Withermobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.WitherSkeleton", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		Withermobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.WitherSkeleton", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		Withermobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.WitherSkeleton", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		Withermobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.WitherSkeleton", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		Withermobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.WitherSkeleton", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		Withermobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.WitherSkeleton", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		Withermobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.WitherSkeleton", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		Withermobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.WitherSkeleton", true, "Whether to enable the use of the primary item to create the staff.");
		Withermobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.WitherSkeleton", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		Withermobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.WitherSkeleton", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		Withermobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.WitherSkeleton", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		Withermobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.WitherSkeleton", true, "Whether to enable the use of a secondary item to create the staff.");
		Withermobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.WitherSkeleton", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		Withermobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.WitherSkeleton", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		Withermobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.WitherSkeleton", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		Withermobconfig.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", "Mobs.WitherSkeleton", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		Withermobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.WitherSkeleton", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		Withermobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.WitherSkeleton", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		Withermobconfig.staffSpawnedMobDropsFragmentFortune = configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.WitherSkeleton", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		Withermobconfig.staffCooldown = configuration.getInt("staffCooldown", "Mobs.WitherSkeleton", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("WitherSkeleton", Withermobconfig);

		// Enderman
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevel = configuration.getInt("spawnXPLevel", "Mobs.Enderman", 5, 1, 100, "The required amount of levels to be able to spawn this mob.");
		mobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.Enderman", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.Enderman", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.Enderman", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.Enderman", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.Enderman", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.Enderman", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Enderman", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Enderman", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Enderman", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Enderman", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Enderman", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Enderman", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Enderman", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Enderman", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Enderman", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Enderman", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.Enderman", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Enderman", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Enderman", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Enderman", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.Enderman", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Enderman", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Enderman", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", "Mobs.Enderman", true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Enderman", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Enderman", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffSpawnedMobDropsFragmentFortune = configuration.getInt("staffSpawnedMobDropsFragmentFortune", "Mobs.Enderman", 0, 0, 3, "The fortune level required on a tool to get a better chance of getting the mob fragment.");
		mobconfig.staffCooldown = configuration.getInt("staffCooldown", "Mobs.Enderman", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff.");
		mobList.put("Enderman", mobconfig);

		if (configuration.hasChanged())
		{
			configuration.save();
		}
	}

	public static void validate()
	{
		if (mobList != null)
		{
			Iterator iterator = mobList.values().iterator();

			while (iterator.hasNext())
			{
				MobSettings config = (MobSettings)iterator.next();
				if (Item.itemRegistry.getObject(config.staffCreationPrimaryItem) == null)
				{
					String key = getKey(config);
					LogHelper.warn("Invalid item ID " + config.staffCreationPrimaryItem + "for staffCreationPrimaryItem for entity " + key + ", Disabling");
					config.staffCreationPrimaryItem = "";
					config.enableStaffCreationPrimaryItem = false;
					mobList.remove(key);
					mobList.put(key, config);
				}

				if (Item.itemRegistry.getObject(config.staffCreationSecondaryItem) == null)
				{
					String key = getKey(config);
					LogHelper.warn("Invalid item ID " + config.staffCreationSecondaryItem + "for staffCreationSecondaryItem for entity " + key + ", disabling");
					config.staffCreationSecondaryItem = "";
					config.enableStaffCreationSecondaryItem = false;
					mobList.remove(key);
					mobList.put(key, config);
				}
			}
		}
	}

	private static String getKey(MobSettings value)
	{
		for (String key : mobList.keySet())
		{
			if (mobList.get(key).equals(value))
			{
				return key;
			}
		}

		return "";
	}
}
