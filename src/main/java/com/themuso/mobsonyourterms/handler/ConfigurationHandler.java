package com.themuso.mobsonyourterms.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.themuso.mobsonyourterms.reference.Settings;

public class ConfigurationHandler {
	Public static Configuration Configuration;

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
		// General settings
		Settings.General.doMobSpawningGameRule = Configuration.getBoolean("doMobSpawningGameRule", Configuration.CATEGORY_GENERAL, false, "Do you want the game rule for mob spawning turned on.");
		Settings.General.mobSpawnRuleEnableXPMultiply = Configuration.getInt("mobSpawnRuleEnableXPMultiply", Configuration.CATEGORY_GENERAL, 4, 1, 10, "Multiplication of XP");
		Settings.General.useIndividualMobSpawnSettings = Configuratino.getBoolean("useIndividualMobSpawnSettings", Configuration.CATEGORY_GENERAL, false, "Use individual mob spawn settings.");
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
		Settings.General.spawnMobsBehindPlayer = Configuration.GetBoolean("spawnMobsBehindPlayer", Configuration.CATEGORY_GENERAL, false, "Whether mobs can be spawned behind the player.");
		Settings.General.staffCooldown = Configuration.getInt("staffCooldown", Configuration.CATEGORY_GENERAL, 0, 0, 30, "THe amount of time the player must wait before the staff can be used to spawn another mob.");
		Settings.General.mobsOnlySpawnableAtNight = Configuration.getBoolean("mobsOnlySpawnableAtNight", Configuration.CATEGORY_GENERAL, true, "SHould mobs only be spawnable with the staff at night.");
		Settings.General.registerMobSpawnerRecipes = Configuration.getBoolean("registerMobSpawnerRecipes", Configuration.CATEGORY_GENERAL, true, "Should recipes to make mob spawners get registered.");
	}
}
