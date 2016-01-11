package com.themuso.mobsonyourterms.reference;

public class Settings
{
	public static class General
	{
		public static boolean spawnHostileMobs;
		public static boolean useIndividualMobSpawnSettings;
		public static int spawnXPLevelEasy;
		public static int spawnXPLevelNormal;
		public static int spawnXPLevelHard;
		public static int minMobsToSpawnEasy;
		public static int maxMobsToSpawnEasy;
		public static int minMobsToSpawnNormal;
		public static int maxMobsToSpawnNormal;
		public static int minMobsToSpawnHard;
		public static int maxMobsToSpawnHard;
		public static int spawnRangeFromPlayerMinEasy;
		public static int spawnRangeFromPlayerMaxEasy;
		public static int spawnRangeFromPlayerMinNormal;
		public static int spawnRangeFromPlayerMaxNormal;
		public static int spawnRangeFromPlayerMinHard;
		public static int spawnRangeFromPlayerMaxHard;
		public static boolean spawnMobsBehindPlayerEasy;
		public static boolean spawnMobsBehindPlayerNormal;
		public static boolean spawnMobsBehindPlayerHard;
		public static int staffCooldownEasy;
		public static int staffCooldownNormal;
		public static int staffCooldownHard;
		public static boolean mobOnlySpawnableAtNightEasy;
		public static boolean mobOnlySpawnableAtNightNormal;
		public static boolean mobOnlySpawnableAtNightHard;
		public static boolean enableStaffFragmentItem;
		public static boolean registerMobSpawnerRecipes;
		public static boolean staffHasOwner;
	}

	public static class Spawner
	{
		public static boolean changeMobSpawnerBehavior;
		public static int activatingRangeFromPlayer;
		public static int spawnRange;
	}

	public static MobSettings extraMobDefaultConfig;

	public static void setExtraMobDefaults()
	{
		extraMobDefaultConfig = new MobSettings();

		extraMobDefaultConfig.spawnXPLevelEasy = 5;
		extraMobDefaultConfig.spawnXPLevelNormal = 5;
		extraMobDefaultConfig.spawnXPLevelHard = 5;
		extraMobDefaultConfig.minMobsToSpawnEasy = 1;
		extraMobDefaultConfig.maxMobsToSpawnEasy = 1;
		extraMobDefaultConfig.minMobsToSpawnNormal = 1;
		extraMobDefaultConfig.maxMobsToSpawnNormal = 1;
		extraMobDefaultConfig.minMobsToSpawnHard = 1;
		extraMobDefaultConfig.maxMobsToSpawnHard = 1;
		extraMobDefaultConfig.spawnRangeFromPlayerMinEasy = 1;
		extraMobDefaultConfig.spawnRangeFromPlayerMaxEasy = 1;
		extraMobDefaultConfig.spawnRangeFromPlayerMinNormal = 1;
		extraMobDefaultConfig.spawnRangeFromPlayerMaxNormal = 1;
		extraMobDefaultConfig.spawnRangeFromPlayerMinHard = 1;
		extraMobDefaultConfig.spawnRangeFromPlayerMaxHard = 1;
		extraMobDefaultConfig.spawnMobsBehindPlayerEasy = false;
		extraMobDefaultConfig.spawnMobsBehindPlayerNormal = true;
		extraMobDefaultConfig.spawnMobsBehindPlayerHard = true;
		extraMobDefaultConfig.enableStaffCreationPrimaryItem = false;
		extraMobDefaultConfig.staffCreationPrimaryItem = "";
		extraMobDefaultConfig.staffCreationPrimaryItemAmount = 1;
		extraMobDefaultConfig.staffCreationPrimaryItemLevels = 1;
		extraMobDefaultConfig.staffCreationPrimaryItemUses = 0;
		extraMobDefaultConfig.enableStaffCreationSecondaryItem = false;
		extraMobDefaultConfig.staffCreationSecondaryItem = "";
		extraMobDefaultConfig.staffCreationSecondaryItemAmount = 1;
		extraMobDefaultConfig.staffCreationSecondaryItemLevels = 1;
		extraMobDefaultConfig.staffCreationSecondaryItemUses = 0;
		extraMobDefaultConfig.mobDropsStaffFragment = false;
		extraMobDefaultConfig.staffSpawnedMobDropsFragmentForEntity = "";
		extraMobDefaultConfig.minDroppedStaffFragmentsEasy = 1;
		extraMobDefaultConfig.maxDroppedStaffFragmentsEasy = 1;
		extraMobDefaultConfig.minDroppedStaffFragmentsNormal = 1;
		extraMobDefaultConfig.maxDroppedStaffFragmentsNormal = 1;
		extraMobDefaultConfig.minDroppedStaffFragmentsHard = 1;
		extraMobDefaultConfig.maxDroppedStaffFragmentsHard = 1;
		extraMobDefaultConfig.staffFragmentAnvilAmount = 1;
		extraMobDefaultConfig.staffFragmentAnvilLevels = 1;
		extraMobDefaultConfig.staffFragmentAnvilUses = 0;
		extraMobDefaultConfig.staffCooldownEasy = 5;
		extraMobDefaultConfig.staffCooldownNormal = 5;
		extraMobDefaultConfig.staffCooldownHard = 5;
		extraMobDefaultConfig.mobOnlySpawnableAtNightEasy = false;
		extraMobDefaultConfig.mobOnlySpawnableAtNightNormal = true;
		extraMobDefaultConfig.mobOnlySpawnableAtNightHard = true;
	}
}
