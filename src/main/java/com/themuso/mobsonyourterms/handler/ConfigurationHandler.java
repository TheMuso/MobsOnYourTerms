package com.themuso.mobsonyourterms.handler;

import java.io.File;
import java.util.Iterator;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import com.themuso.mobsonyourterms.reference.MobList;
import com.themuso.mobsonyourterms.reference.MobSettings;
import com.themuso.mobsonyourterms.reference.Settings;
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
		Settings.General.doMobSpawningGameRule = configuration.getBoolean("doMobSpawningGameRule", Configuration.CATEGORY_GENERAL, false, "Do you want the game rule for mob spawning turned on.");
		Settings.General.mobSpawnRuleEnableXPMultiply = configuration.getInt("mobSpawnRuleEnableXPMultiply", Configuration.CATEGORY_GENERAL, 4, 1, 10, "Multiplication of XP");
		Settings.General.useIndividualMobSpawnSettings = configuration.getBoolean("useIndividualMobSpawnSettings", Configuration.CATEGORY_GENERAL, false, "Use individual mob spawn settings.");
		Settings.General.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", Configuration.CATEGORY_GENERAL, 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		Settings.General.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", Configuration.CATEGORY_GENERAL, 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		Settings.General.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", Configuration.CATEGORY_GENERAL, 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
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
		Settings.General.staffCooldownEasy = configuration.getInt("staffCooldownEasy", Configuration.CATEGORY_GENERAL, 0, 0, 30, "THe amount of time the player must wait before the staff can be used to spawn another mob on easy difficulty.");
		Settings.General.staffCooldownNormal = configuration.getInt("staffCooldownNormal", Configuration.CATEGORY_GENERAL, 0, 0, 30, "THe amount of time the player must wait before the staff can be used to spawn another mob on normal difficulty.");
		Settings.General.staffCooldownHard = configuration.getInt("staffCooldownHard", Configuration.CATEGORY_GENERAL, 0, 0, 30, "THe amount of time the player must wait before the staff can be used to spawn another mob on hard difficulty.");
		Settings.General.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", Configuration.CATEGORY_GENERAL, false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		Settings.General.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", Configuration.CATEGORY_GENERAL, false, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		Settings.General.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", Configuration.CATEGORY_GENERAL, true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		Settings.General.enableStaffFragmentItem = configuration.getBoolean("enableStaffFragmentItem", Configuration.CATEGORY_GENERAL, true, "Enable the staff fragment item required for the mob spawning staff recipe. If disabled, the staff crafting recipe will be disabled.");
		Settings.General.registerMobSpawnerRecipes = configuration.getBoolean("registerMobSpawnerRecipes", Configuration.CATEGORY_GENERAL, true, "Should recipes to make mob spawners get registered.");
		Settings.General.staffHasOwner = configuration.getBoolean("staffHasOwner", Configuration.CATEGORY_GENERAL, true, "Determines whether a mob spawning staff has an owner after first use.");

		// Mob spawner settings
		Settings.Spawner.changeMobSpawnerBehavior = configuration.getBoolean("changeMobSpawnerBehavior", "Mob Spawner Settings", true, "Whether mob spawner characteristics are changed.");
		Settings.Spawner.activatingRangeFromPlayer = configuration.getInt("activatingRangeFromPlayer", "Mob Spawner Settings", 4, 2, 32, "The distance in blocks a player needs to bbe from the spawner to activate it.");
		Settings.Spawner.spawnRange = configuration.getInt("spawnRange", "Mob Spawner Settings", 8, 2, 32, "The range in blocks where mobs can be spawned.");

		// Mob settings
		MobSettings mobconfig;

		// Zombie
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", "Mobs.Zombie", 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		mobconfig.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", "Mobs.Zombie", 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		mobconfig.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", "Mobs.Zombie", 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
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
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Zombie", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Zombie", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.minDroppedStaffFragmentsEasy = configuration.getInt("minDroppedStaffFragmentsEasy", "Mobs.Zombie", 2, 1, 10, "The minimum number of staff fragments the mob will drop when killed on easy difficulty. A random value will be chosen between the minimum and maximum dropped staff fragments settings, and will then be multiplied by the fortune level. If there is no fortune on the weapon used to kill the mob, a fortune level of 1 is used.");
		mobconfig.maxDroppedStaffFragmentsEasy = configuration.getInt("maxDroppedStaffFragmentsEasy", "Mobs.Zombie", 4, 1, 10, "The maximum number of staff fragments the mob will drop when killed on easy difficulty. A random value will be chosen between the minimum and maximum dropped staff fragments settings, and will then be multiplied by the fortune level. If there is no fortune on the weapon used to kill the mob, a fortune level of 1 is used.");
		mobconfig.minDroppedStaffFragmentsNormal = configuration.getInt("minDroppedStaffFragmentsNormal", "Mobs.Zombie", 1, 1, 5, "The minimum number of staff fragments the mob will drop when killed on normal difficulty. A random value will be chosen between the minimum and maximum dropped staff fragments settings, and will then be multiplied by the fortune level. If there is no fortune on the weapon used to kill the mob, a fortune level of 1 is used.");
		mobconfig.maxDroppedStaffFragmentsNormal = configuration.getInt("maxDroppedStaffFragmentsNormal", "Mobs.Zombie", 3, 1, 5, "The maximum number of staff fragments the mob will drop when killed on normal difficulty. A value will be chosen between the minimum and maximum dropped staff fragments settings, and will then be multiplied by the fortune level. If there is no fortune on the weapon used to kill the mob, a fortune level of 1 is used.");
		mobconfig.minDroppedStaffFragmentsHard = configuration.getInt("minDroppedStaffFragmentsHard", "Mobs.Zombie", 1, 1, 3, "The minimum number of staff fragments the mob will drop when killed on hard difficulty. A random value will be chosen between the minimum and maximum dropped staff fragments settings, and will then be multiplied by the fortune level. If there is no fortune on the weapon used to kill the mob, a fortune level of 1 is used.");
		mobconfig.maxDroppedStaffFragmentsHard = configuration.getInt("maxDroppedStaffFragmentsHard", "Mobs.Zombie", 1, 1, 3, "The maximum number of staff fragments the mob will drop when killed on Hard difficulty. A value will be chosen between the minimum and maximum dropped staff fragments settings, and will then be multiplied by the fortune level. If there is no fortune on the weapon used to kill the mob, a fortune level of 1 is used.");
		mobconfig.staffFragmentAnvilCost = configuration.getInt("staffFragmentAnvilCost", "Mobs.Zombie", 1, 1, 10, "The number of staff fragments needed to embew a spawning staff in an Anvil.");
		mobconfig.staffCooldownEasy = configuration.getInt("staffCooldownEasy", "Mobs.Zombie", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on easy difficulty.");
		mobconfig.staffCooldownNormal = configuration.getInt("staffCooldownNormal", "Mobs.Zombie", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on normal difficulty.");
		mobconfig.staffCooldownHard = configuration.getInt("staffCooldownHard", "Mobs.Zombie", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on hard difficulty.");
		mobconfig.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", "Mobs.Zombie", false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		mobconfig.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", "Mobs.Zombie", false, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		mobconfig.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", "Mobs.Zombie", true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		MobList.mobList.put("Zombie", mobconfig);

		// Creeper
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", "Mobs.Creeper", 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		mobconfig.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", "Mobs.Creeper", 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		mobconfig.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", "Mobs.Creeper", 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
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
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Creeper", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Creeper", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffCooldownEasy = configuration.getInt("staffCooldownEasy", "Mobs.Creeper", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on easy difficulty.");
		mobconfig.staffCooldownNormal = configuration.getInt("staffCooldownNormal", "Mobs.Creeper", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on normal difficulty.");
		mobconfig.staffCooldownHard = configuration.getInt("staffCooldownHard", "Mobs.Creeper", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on hard difficulty.");
		mobconfig.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", "Mobs.Creeper", false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		mobconfig.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", "Mobs.Creeper", false, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		mobconfig.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", "Mobs.Creeper", true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		MobList.mobList.put("Creeper", mobconfig);

		// Spider
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", "Mobs.Spider", 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		mobconfig.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", "Mobs.Spider", 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		mobconfig.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", "Mobs.Spider", 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
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
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Spider", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Spider", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffCooldownEasy = configuration.getInt("staffCooldownEasy", "Mobs.Spider", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on easy difficulty.");
		mobconfig.staffCooldownNormal = configuration.getInt("staffCooldownNormal", "Mobs.Spider", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on normal difficulty.");
		mobconfig.staffCooldownHard = configuration.getInt("staffCooldownHard", "Mobs.Spider", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on hard difficulty.");
		mobconfig.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", "Mobs.Spider", false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		mobconfig.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", "Mobs.Spider", false, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		mobconfig.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", "Mobs.Spider", true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		MobList.mobList.put("Spider", mobconfig);

		// Slime
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", "Mobs.Slime", 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		mobconfig.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", "Mobs.Slime", 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		mobconfig.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", "Mobs.Slime", 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
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
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Slime", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Slime", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffCooldownEasy = configuration.getInt("staffCooldownEasy", "Mobs.Slime", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on easy difficulty.");
		mobconfig.staffCooldownNormal = configuration.getInt("staffCooldownNormal", "Mobs.Slime", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on normal difficulty.");
		mobconfig.staffCooldownHard = configuration.getInt("staffCooldownHard", "Mobs.Slime", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on hard difficulty.");
		mobconfig.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", "Mobs.Slime", false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		mobconfig.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", "Mobs.Slime", false, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		mobconfig.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", "Mobs.Slime", true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		MobList.mobList.put("Slime", mobconfig);

		// Silverfish
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", "Mobs.Silverfish", 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		mobconfig.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", "Mobs.Silverfish", 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		mobconfig.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", "Mobs.Silverfish", 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
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
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Silverfish", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Silverfish", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffCooldownEasy = configuration.getInt("staffCooldownEasy", "Mobs.Silverfish", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on easy difficulty.");
		mobconfig.staffCooldownNormal = configuration.getInt("staffCooldownNormal", "Mobs.Silverfish", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on normal difficulty.");
		mobconfig.staffCooldownHard = configuration.getInt("staffCooldownHard", "Mobs.Silverfish", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on hard difficulty.");
		mobconfig.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", "Mobs.Silverfish", false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		mobconfig.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", "Mobs.Silverfish", false, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		mobconfig.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", "Mobs.Silverfish", true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		MobList.mobList.put("Silverfish", mobconfig);

		// Skeleton
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", "Mobs.Skeleton", 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		mobconfig.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", "Mobs.Skeleton", 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		mobconfig.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", "Mobs.Skeleton", 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
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
		mobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.Skeleton", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Skeleton", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Skeleton", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Skeleton", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.Skeleton", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Skeleton", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Skeleton", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Skeleton", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Skeleton", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffCooldownEasy = configuration.getInt("staffCooldownEasy", "Mobs.Skeleton", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on easy difficulty.");
		mobconfig.staffCooldownNormal = configuration.getInt("staffCooldownNormal", "Mobs.Skeleton", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on normal difficulty.");
		mobconfig.staffCooldownHard = configuration.getInt("staffCooldownHard", "Mobs.Skeleton", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on hard difficulty.");
		mobconfig.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", "Mobs.Skeleton", false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		mobconfig.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", "Mobs.Skeleton", false, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		mobconfig.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", "Mobs.Skeleton", true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		MobList.mobList.put("Skeleton", mobconfig);

		// Witch
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", "Mobs.Witch", 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		mobconfig.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", "Mobs.Witch", 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		mobconfig.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", "Mobs.Witch", 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
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
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Witch", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Witch", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffCooldownEasy = configuration.getInt("staffCooldownEasy", "Mobs.Witch", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on easy difficulty.");
		mobconfig.staffCooldownNormal = configuration.getInt("staffCooldownNormal", "Mobs.Witch", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on normal difficulty.");
		mobconfig.staffCooldownHard = configuration.getInt("staffCooldownHard", "Mobs.Witch", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on hard difficulty.");
		mobconfig.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", "Mobs.Witch", false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		mobconfig.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", "Mobs.Witch", false, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		mobconfig.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", "Mobs.Witch", true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		MobList.mobList.put("Witch", mobconfig);

		// PigZombie
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", "Mobs.PigZombie", 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		mobconfig.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", "Mobs.PigZombie", 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		mobconfig.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", "Mobs.PigZombie", 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
		mobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.PigZombie", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.PigZombie", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.PigZombie", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.PigZombie", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.PigZombie", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.PigZombie", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.PigZombie", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.PigZombie", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.PigZombie", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.PigZombie", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.PigZombie", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.PigZombie", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.PigZombie", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.PigZombie", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.PigZombie", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.PigZombie", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.PigZombie", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.PigZombie", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.PigZombie", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.PigZombie", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.PigZombie", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.PigZombie", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.PigZombie", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.PigZombie", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.PigZombie", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffCooldownEasy = configuration.getInt("staffCooldownEasy", "Mobs.PigZombie", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on easy difficulty.");
		mobconfig.staffCooldownNormal = configuration.getInt("staffCooldownNormal", "Mobs.PigZombie", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on normal difficulty.");
		mobconfig.staffCooldownHard = configuration.getInt("staffCooldownHard", "Mobs.PigZombie", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on hard difficulty.");
		mobconfig.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", "Mobs.PigZombie", false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		mobconfig.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", "Mobs.PigZombie", false, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		mobconfig.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", "Mobs.PigZombie", true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		MobList.mobList.put("PigZombie", mobconfig);

		// Ghast
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", "Mobs.Ghast", 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		mobconfig.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", "Mobs.Ghast", 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		mobconfig.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", "Mobs.Ghast", 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
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
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Ghast", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Ghast", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffCooldownEasy = configuration.getInt("staffCooldownEasy", "Mobs.Ghast", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on easy difficulty.");
		mobconfig.staffCooldownNormal = configuration.getInt("staffCooldownNormal", "Mobs.Ghast", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on normal difficulty.");
		mobconfig.staffCooldownHard = configuration.getInt("staffCooldownHard", "Mobs.Ghast", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on hard difficulty.");
		mobconfig.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", "Mobs.Ghast", false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		mobconfig.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", "Mobs.Ghast", false, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		mobconfig.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", "Mobs.Ghast", true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		MobList.mobList.put("Ghast", mobconfig);

		// LavaSlime
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", "Mobs.LavaSlime", 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		mobconfig.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", "Mobs.LavaSlime", 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		mobconfig.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", "Mobs.LavaSlime", 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
		mobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.LavaSlime", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.LavaSlime", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.LavaSlime", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.LavaSlime", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.LavaSlime", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.LavaSlime", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.LavaSlime", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.LavaSlime", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.LavaSlime", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.LavaSlime", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.LavaSlime", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.LavaSlime", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.LavaSlime", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.LavaSlime", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.LavaSlime", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.LavaSlime", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.LavaSlime", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.LavaSlime", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.LavaSlime", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.LavaSlime", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.LavaSlime", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.LavaSlime", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.LavaSlime", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.LavaSlime", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.LavaSlime", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffCooldownEasy = configuration.getInt("staffCooldownEasy", "Mobs.LavaSlime", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on easy difficulty.");
		mobconfig.staffCooldownNormal = configuration.getInt("staffCooldownNormal", "Mobs.LavaSlime", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on normal difficulty.");
		mobconfig.staffCooldownHard = configuration.getInt("staffCooldownHard", "Mobs.LavaSlime", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on hard difficulty.");
		mobconfig.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", "Mobs.LavaSlime", false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		mobconfig.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", "Mobs.LavaSlime", false, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		mobconfig.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", "Mobs.LavaSlime", true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		MobList.mobList.put("LavaSlime", mobconfig);

		// Wither Skeleton
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", "Mobs.Wither Skeleton", 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		mobconfig.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", "Mobs.Wither Skeleton", 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		mobconfig.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", "Mobs.Wither Skeleton", 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
		mobconfig.minMobsToSpawnEasy = configuration.getInt("minMobsToSpawnEasy", "Mobs.Wither Skeleton", 1, 1, 3, "The minimum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.maxMobsToSpawnEasy = configuration.getInt("maxMobsToSpawnEasy", "Mobs.Wither Skeleton", 2, 1, 3, "The maximum number of mobs that can be spawned from the staff on easy difficulty.");
		mobconfig.minMobsToSpawnNormal = configuration.getInt("minMobsToSpawnNormal", "Mobs.Wither Skeleton", 1, 1, 4, "The minimum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.maxMobsToSpawnNormal = configuration.getInt("maxMobsToSpawnNormal", "Mobs.Wither Skeleton", 3, 1, 4, "The maximum number of mobs that can be spawned from the staff in normal difficulty.");
		mobconfig.minMobsToSpawnHard = configuration.getInt("minMobsToSpawnHard", "Mobs.Wither Skeleton", 1, 1, 5, "The minimum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.maxMobsToSpawnHard = configuration.getInt("maxMobsToSpawnHard", "Mobs.Wither Skeleton", 4, 1, 5, "The maximum number of mobs that can be spawned from the staff in hard difficulty.");
		mobconfig.spawnRangeFromPlayerMinEasy = configuration.getInt("spawnRangeFromPlayerMinEasy", "Mobs.Wither Skeleton", 3, 3, 10, "The minimum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMaxEasy = configuration.getInt("spawnRangeFromPlayerMaxEasy", "Mobs.Wither Skeleton", 5, 3, 10, "The maximum distance that a mob can be spawned from the player on easy difficulty.");
		mobconfig.spawnRangeFromPlayerMinNormal = configuration.getInt("spawnRangeFromPlayerMinNormal", "Mobs.Wither Skeleton", 2, 2, 7, "The minimum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMaxNormal = configuration.getInt("spawnRangeFromPlayerMaxNormal", "Mobs.Wither Skeleton", 4, 2, 7, "The maximum distance that a mob can be spawned from the player on normal difficulty.");
		mobconfig.spawnRangeFromPlayerMinHard = configuration.getInt("spawnRangeFromPlayerMinHard", "Mobs.Wither Skeleton", 1, 1, 4, "The minimum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnRangeFromPlayerMaxHard = configuration.getInt("spawnRangeFromPlayerMaxHard", "Mobs.Wither Skeleton", 3, 1, 4, "The maximum distance that a mob can be spawned from the player on hard difficulty.");
		mobconfig.spawnMobsBehindPlayerEasy = configuration.getBoolean("spawnMobsBehindPlayerEasy", "Mobs.Wither Skeleton", false, "Whether mobs can be spawned behind the player on easy difficulty.");
		mobconfig.spawnMobsBehindPlayerNormal = configuration.getBoolean("spawnMobsBehindPlayerNormal", "Mobs.Wither Skeleton", true, "Whether mobs can be spawned behind the player on normal difficulty.");
		mobconfig.spawnMobsBehindPlayerHard = configuration.getBoolean("spawnMobsBehindPlayerHard", "Mobs.Wither Skeleton", true, "Whether mobs can be spawned behind the player on hard difficulty.");
		mobconfig.enableStaffCreationPrimaryItem = configuration.getBoolean("enableStaffCreationPrimaryItem", "Mobs.Wither Skeleton", true, "Whether to enable the use of the primary item to create the staff.");
		mobconfig.staffCreationPrimaryItem = configuration.getString("staffCreationPrimaryItem", "Mobs.Wither Skeleton", "minecraft:rotten_flesh", "The primary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemAmount = configuration.getInt("staffCreationPrimaryItemAmount", "Mobs.Wither Skeleton", 1, 1, 100, "The amount of the primary item required to construct the mob spawning staff in an anvil.");
		mobconfig.staffCreationPrimaryItemLevels = configuration.getInt("staffCreationPrimaryItemLevels", "Mobs.Wither Skeleton", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the primary item on an anvil.");
		mobconfig.enableStaffCreationSecondaryItem = configuration.getBoolean("enableStaffCreationSecondaryItem", "Mobs.Wither Skeleton", true, "Whether to enable the use of a secondary item to create the staff.");
		mobconfig.staffCreationSecondaryItem = configuration.getString("staffCreationSecondaryItem", "Mobs.Wither Skeleton", "minecraft:beef", "The secondary item that can be used to construct a mob spawning staff in an anvil.");
		mobconfig.staffCreationSecondaryItemAmount = configuration.getInt("staffCreationSecondaryItemAmount", "Mobs.Wither Skeleton", 10, 1, 100, "The amount of the secondary item required to construct the mob spawning staff on an anvil.");
		mobconfig.staffCreationSecondaryItemLevels = configuration.getInt("staffCreationSecondaryItemLevels", "Mobs.Wither Skeleton", 3, 1, 20, "The required number of experience levels to create the mob spawning staff with the secondary item on an anvil.");
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Wither Skeleton", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Wither Skeleton", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffCooldownEasy = configuration.getInt("staffCooldownEasy", "Mobs.Wither Skeleton", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on easy difficulty.");
		mobconfig.staffCooldownNormal = configuration.getInt("staffCooldownNormal", "Mobs.Wither Skeleton", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on normal difficulty.");
		mobconfig.staffCooldownHard = configuration.getInt("staffCooldownHard", "Mobs.Wither Skeleton", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on hard difficulty.");
		mobconfig.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", "Mobs.Wither Skeleton", false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		mobconfig.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", "Mobs.Wither Skeleton", false, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		mobconfig.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", "Mobs.Wither Skeleton", true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		MobList.mobList.put("Wither Skeleton", mobconfig);

		// Enderman
		mobconfig = new MobSettings();
		mobconfig.spawnXPLevelEasy = configuration.getInt("spawnXPLevelEasy", "Mobs.Enderman", 5, 1, 100, "The required amount of levels to be able to spawn this mob on easy difficulty.");
		mobconfig.spawnXPLevelNormal = configuration.getInt("spawnXPLevelNormal", "Mobs.Enderman", 7, 1, 100, "The required amount of levels to be able to spawn this mob on normal difficulty.");
		mobconfig.spawnXPLevelHard = configuration.getInt("spawnXPLevelHard", "Mobs.Enderman", 9, 1, 100, "The required amount of levels to be able to spawn this mob on hard difficulty.");
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
		mobconfig.mobDropsStaffFragment = configuration.getBoolean("mobDropsStaffFragment", "Mobs.Enderman", true, "Whether the mob drops the staff fragment used in the mob spawning staff crafting recipe.");
		mobconfig.staffSpawnedMobDropsFragmentForEntity = configuration.getString("staffSpawnedMobDropsFragmentForEntity", "Mobs.Enderman", "Creeper", "The entity whos staff fragments should be dropped by killing this staff spawned mob.");
		mobconfig.staffCooldownEasy = configuration.getInt("staffCooldownEasy", "Mobs.Enderman", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on easy difficulty.");
		mobconfig.staffCooldownNormal = configuration.getInt("staffCooldownNormal", "Mobs.Enderman", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on normal difficulty.");
		mobconfig.staffCooldownHard = configuration.getInt("staffCooldownHard", "Mobs.Enderman", 5, 0, 20, "The amount of time in seconds you have to wait before you can spawn more mobs with the staff on hard difficulty.");
		mobconfig.mobOnlySpawnableAtNightEasy = configuration.getBoolean("mobOnlySpawnableAtNightEasy", "Mobs.Enderman", false, "SHould the mob only be spawnable with the staff at night on easy difficulty.");
		mobconfig.mobOnlySpawnableAtNightNormal = configuration.getBoolean("mobOnlySpawnableAtNightNormal", "Mobs.Enderman", false, "SHould the mob only be spawnable with the staff at night on normal difficulty.");
		mobconfig.mobOnlySpawnableAtNightHard = configuration.getBoolean("mobOnlySpawnableAtNightHard", "Mobs.Enderman", true, "SHould the mob only be spawnable with the staff at night on hard difficulty.");
		MobList.mobList.put("Enderman", mobconfig);

		if (configuration.hasChanged())
		{
			configuration.save();
		}
	}

	public static void validate()
	{
		if (MobList.mobList != null)
		{
			Iterator iterator = MobList.mobList.values().iterator();

			while (iterator.hasNext())
			{
				MobSettings config = (MobSettings)iterator.next();
				if (Item.itemRegistry.getObject(config.staffCreationPrimaryItem) == null)
				{
					String key = MobList.getKey(config);
					LogHelper.warn("Invalid item ID " + config.staffCreationPrimaryItem + "for staffCreationPrimaryItem for entity " + key + ", Disabling");
					config.staffCreationPrimaryItem = "";
					config.enableStaffCreationPrimaryItem = false;
					MobList.mobList.remove(key);
					MobList.mobList.put(key, config);
				}

				if (Item.itemRegistry.getObject(config.staffCreationSecondaryItem) == null)
				{
					String key = MobList.getKey(config);
					LogHelper.warn("Invalid item ID " + config.staffCreationSecondaryItem + "for staffCreationSecondaryItem for entity " + key + ", disabling");
					config.staffCreationSecondaryItem = "";
					config.enableStaffCreationSecondaryItem = false;
					MobList.mobList.remove(key);
					MobList.mobList.put(key, config);
				}

				// Duplicate primary/secondary item checking.
				Iterator subIterator = MobList.mobList.values().iterator();
				String key = MobList.getKey(config);

				while (subIterator.hasNext())
				{
					MobSettings subConfig = (MobSettings)subIterator.next();
					String subKey = MobList.getKey(subConfig);

					if (!key.equals(subKey))
					{
						if (config.staffCreationPrimaryItem.equals(subConfig.staffCreationPrimaryItem))
						{
							LogHelper.warn("The primary staff creation item for mob " + key + " is the same as the primary staff creation item for mob " + subKey);
						}
						else if (config.staffCreationSecondaryItem.equals(subConfig.staffCreationSecondaryItem))
						{
							LogHelper.warn("The secondary staff creation item for mob " + key + " is the same as the secondary staff creation item for mob " + subKey);
						}
						else if (config.staffCreationPrimaryItem.equals(subConfig.staffCreationSecondaryItem))
						{
							LogHelper.warn("The primary staff creation item for mob " + key + " is the same as the secondary staff creation item for mob " + subKey);
						}
						else if (config.staffCreationSecondaryItem.equals(subConfig.staffCreationPrimaryItem))
						{
							LogHelper.warn("The secondary staff creation item for mob " + key + " is the same as the primary staff creation item for mob " + subKey);
						}
					}
				}
			}
		}
	}
}
