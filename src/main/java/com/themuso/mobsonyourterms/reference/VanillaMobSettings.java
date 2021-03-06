package com.themuso.mobsonyourterms.reference;

import java.util.HashMap;

import com.themuso.mobsonyourterms.reference.MobSettings;

public class VanillaMobSettings
{
	public static HashMap<String, MobSettings> defaults = new HashMap<String, MobSettings>();

	public static void initDefaults()
	{
		MobSettings mobSet;

		// Zombie
		mobSet = new MobSettings();
		mobSet.spawnXPLevelEasy = 5;
		mobSet.spawnXPLevelNormal = 7;
		mobSet.spawnXPLevelHard = 10;
		mobSet.minMobsToSpawnEasy = 1;
		mobSet.maxMobsToSpawnEasy = 2;
		mobSet.minMobsToSpawnNormal = 1;
		mobSet.maxMobsToSpawnNormal = 2;
		mobSet.minMobsToSpawnHard = 1;
		mobSet.maxMobsToSpawnHard = 4;
		mobSet.spawnRangeFromPlayerMinEasy = 3;
		mobSet.spawnRangeFromPlayerMaxEasy = 6;
		mobSet.spawnRangeFromPlayerMinNormal = 2;
		mobSet.spawnRangeFromPlayerMaxNormal = 4;
		mobSet.spawnRangeFromPlayerMinHard = 1;
		mobSet.spawnRangeFromPlayerMaxHard = 3;
		mobSet.spawnMobsBehindPlayerEasy = false;
		mobSet.spawnMobsBehindPlayerNormal = true;
		mobSet.spawnMobsBehindPlayerHard = true;
		mobSet.enableStaffCreationPrimaryItem = true;
		mobSet.staffCreationPrimaryItem = "minecraft:rotten_flesh";
		mobSet.staffCreationPrimaryItemAmount = 1;
		mobSet.staffCreationPrimaryItemLevels = 3;
		mobSet.staffCreationPrimaryItemUses = 0;
		mobSet.enableStaffCreationSecondaryItem = true;
		mobSet.staffCreationSecondaryItem = "minecraft:beef";
		mobSet.staffCreationSecondaryItemAmount = 10;
		mobSet.staffCreationSecondaryItemLevels = 3;
		mobSet.staffCreationSecondaryItemUses = 0;
		mobSet.mobDropsStaffFragment = true;
		mobSet.staffSpawnedMobDropsFragmentForEntity = "minecraft:creeper";
		mobSet.minDroppedStaffFragmentsEasy = 2;
		mobSet.maxDroppedStaffFragmentsEasy = 4;
		mobSet.minDroppedStaffFragmentsNormal = 1;
		mobSet.maxDroppedStaffFragmentsNormal = 3;
		mobSet.minDroppedStaffFragmentsHard = 1;
		mobSet.maxDroppedStaffFragmentsHard = 1;
		mobSet.staffFragmentAnvilAmount = 1;
		mobSet.staffFragmentAnvilLevels = 5;
		mobSet.staffFragmentAnvilUses = 0;
		mobSet.staffCooldownEasy = 0;
		mobSet.staffCooldownNormal = 5;
		mobSet.staffCooldownHard = 10;
		mobSet.mobOnlySpawnableAtNightEasy = false;
		mobSet.mobOnlySpawnableAtNightNormal = true;
		mobSet.mobOnlySpawnableAtNightHard = true;
		defaults.put("minecraft:zombie", mobSet);

		// Creeper
		mobSet = new MobSettings();
		mobSet.spawnXPLevelEasy = 5;
		mobSet.spawnXPLevelNormal = 7;
		mobSet.spawnXPLevelHard = 10;
		mobSet.minMobsToSpawnEasy = 1;
		mobSet.maxMobsToSpawnEasy = 1;
		mobSet.minMobsToSpawnNormal = 1;
		mobSet.maxMobsToSpawnNormal = 2;
		mobSet.minMobsToSpawnHard = 1;
		mobSet.maxMobsToSpawnHard = 3;
		mobSet.spawnRangeFromPlayerMinEasy = 4;
		mobSet.spawnRangeFromPlayerMaxEasy = 6;
		mobSet.spawnRangeFromPlayerMinNormal = 3;
		mobSet.spawnRangeFromPlayerMaxNormal = 5;
		mobSet.spawnRangeFromPlayerMinHard = 2;
		mobSet.spawnRangeFromPlayerMaxHard = 4;
		mobSet.spawnMobsBehindPlayerEasy = false;
		mobSet.spawnMobsBehindPlayerNormal = false;
		mobSet.spawnMobsBehindPlayerHard = true;
		mobSet.enableStaffCreationPrimaryItem = true;
		mobSet.staffCreationPrimaryItem = "minecraft:gunpowder";
		mobSet.staffCreationPrimaryItemAmount = 1;
		mobSet.staffCreationPrimaryItemLevels = 3;
		mobSet.staffCreationPrimaryItemUses = 0;
		mobSet.enableStaffCreationSecondaryItem = false;
		mobSet.staffCreationSecondaryItem = "";
		mobSet.staffCreationSecondaryItemAmount = 1;
		mobSet.staffCreationSecondaryItemLevels = 1;
		mobSet.staffCreationSecondaryItemUses = 0;
		mobSet.mobDropsStaffFragment = true;
		mobSet.staffSpawnedMobDropsFragmentForEntity = "minecraft:spider";
		mobSet.minDroppedStaffFragmentsEasy = 1;
		mobSet.maxDroppedStaffFragmentsEasy = 3;
		mobSet.minDroppedStaffFragmentsNormal = 1;
		mobSet.maxDroppedStaffFragmentsNormal = 2;
		mobSet.minDroppedStaffFragmentsHard = 1;
		mobSet.maxDroppedStaffFragmentsHard = 1;
		mobSet.staffFragmentAnvilAmount = 2;
		mobSet.staffFragmentAnvilLevels = 3;
		mobSet.staffFragmentAnvilUses = 0;
		mobSet.staffCooldownEasy = 0;
		mobSet.staffCooldownNormal = 5;
		mobSet.staffCooldownHard = 10;
		mobSet.mobOnlySpawnableAtNightEasy = false;
		mobSet.mobOnlySpawnableAtNightNormal = false;
		mobSet.mobOnlySpawnableAtNightHard = true;
		defaults.put("minecraft:creeper", mobSet);

		// Spider
		mobSet = new MobSettings();
		mobSet.spawnXPLevelEasy = 7;
		mobSet.spawnXPLevelNormal = 9;
		mobSet.spawnXPLevelHard = 12;
		mobSet.minMobsToSpawnEasy = 1;
		mobSet.maxMobsToSpawnEasy = 2;
		mobSet.minMobsToSpawnNormal = 1;
		mobSet.maxMobsToSpawnNormal = 3;
		mobSet.minMobsToSpawnHard = 1;
		mobSet.maxMobsToSpawnHard = 4;
		mobSet.spawnRangeFromPlayerMinEasy = 3;
		mobSet.spawnRangeFromPlayerMaxEasy = 5;
		mobSet.spawnRangeFromPlayerMinNormal = 2;
		mobSet.spawnRangeFromPlayerMaxNormal = 4;
		mobSet.spawnRangeFromPlayerMinHard = 1;
		mobSet.spawnRangeFromPlayerMaxHard = 3;
		mobSet.spawnMobsBehindPlayerEasy = false;
		mobSet.spawnMobsBehindPlayerNormal = true;
		mobSet.spawnMobsBehindPlayerHard = true;
		mobSet.enableStaffCreationPrimaryItem = true;
		mobSet.staffCreationPrimaryItem = "minecraft:spider_eye";
		mobSet.staffCreationPrimaryItemAmount = 1;
		mobSet.staffCreationPrimaryItemLevels = 5;
		mobSet.staffCreationPrimaryItemUses = 20;
		mobSet.enableStaffCreationSecondaryItem = false;
		mobSet.staffCreationSecondaryItem = "";
		mobSet.staffCreationSecondaryItemAmount = 1;
		mobSet.staffCreationSecondaryItemLevels = 1;
		mobSet.staffCreationSecondaryItemUses = 0;
		mobSet.mobDropsStaffFragment = true;
		mobSet.staffSpawnedMobDropsFragmentForEntity = "minecraft:slime";
		mobSet.minDroppedStaffFragmentsEasy = 1;
		mobSet.maxDroppedStaffFragmentsEasy = 3;
		mobSet.minDroppedStaffFragmentsNormal = 1;
		mobSet.maxDroppedStaffFragmentsNormal = 2;
		mobSet.minDroppedStaffFragmentsHard = 1;
		mobSet.maxDroppedStaffFragmentsHard = 1;
		mobSet.staffFragmentAnvilAmount = 3;
		mobSet.staffFragmentAnvilLevels = 5;
		mobSet.staffFragmentAnvilUses = 0;
		mobSet.staffCooldownEasy = 5;
		mobSet.staffCooldownNormal = 7;
		mobSet.staffCooldownHard = 10;
		mobSet.mobOnlySpawnableAtNightEasy = true;
		mobSet.mobOnlySpawnableAtNightNormal = true;
		mobSet.mobOnlySpawnableAtNightHard = true;
		defaults.put("minecraft:spider", mobSet);

		// Slime
		mobSet = new MobSettings();
		mobSet.spawnXPLevelEasy = 7;
		mobSet.spawnXPLevelNormal = 9;
		mobSet.spawnXPLevelHard = 12;
		mobSet.minMobsToSpawnEasy = 1;
		mobSet.maxMobsToSpawnEasy = 2;
		mobSet.minMobsToSpawnNormal = 1;
		mobSet.maxMobsToSpawnNormal = 3;
		mobSet.minMobsToSpawnHard = 1;
		mobSet.maxMobsToSpawnHard = 4;
		mobSet.spawnRangeFromPlayerMinEasy = 3;
		mobSet.spawnRangeFromPlayerMaxEasy = 5;
		mobSet.spawnRangeFromPlayerMinNormal = 2;
		mobSet.spawnRangeFromPlayerMaxNormal = 4;
		mobSet.spawnRangeFromPlayerMinHard = 1;
		mobSet.spawnRangeFromPlayerMaxHard = 3;
		mobSet.spawnMobsBehindPlayerEasy = false;
		mobSet.spawnMobsBehindPlayerNormal = true;
		mobSet.spawnMobsBehindPlayerHard = true;
		mobSet.enableStaffCreationPrimaryItem = true;
		mobSet.staffCreationPrimaryItem = "minecraft:slime_ball";
		mobSet.staffCreationPrimaryItemAmount = 1;
		mobSet.staffCreationPrimaryItemLevels = 5;
		mobSet.staffCreationPrimaryItemUses = 20;
		mobSet.enableStaffCreationSecondaryItem = false;
		mobSet.staffCreationSecondaryItem = "";
		mobSet.staffCreationSecondaryItemAmount = 1;
		mobSet.staffCreationSecondaryItemLevels = 1;
		mobSet.staffCreationSecondaryItemUses = 0;
		mobSet.mobDropsStaffFragment = true;
		mobSet.staffSpawnedMobDropsFragmentForEntity = "minecraft:silverfish";
		mobSet.minDroppedStaffFragmentsEasy = 1;
		mobSet.maxDroppedStaffFragmentsEasy = 3;
		mobSet.minDroppedStaffFragmentsNormal = 1;
		mobSet.maxDroppedStaffFragmentsNormal = 2;
		mobSet.minDroppedStaffFragmentsHard = 1;
		mobSet.maxDroppedStaffFragmentsHard = 1;
		mobSet.staffFragmentAnvilAmount = 5;
		mobSet.staffFragmentAnvilLevels = 7;
		mobSet.staffFragmentAnvilUses = 50;
		mobSet.staffCooldownEasy = 5;
		mobSet.staffCooldownNormal = 7;
		mobSet.staffCooldownHard = 12;
		mobSet.mobOnlySpawnableAtNightEasy = false;
		mobSet.mobOnlySpawnableAtNightNormal = true;
		mobSet.mobOnlySpawnableAtNightHard = true;
		defaults.put("minecraft:slime", mobSet);

		// Silverfish
		mobSet = new MobSettings();
		mobSet.spawnXPLevelEasy = 10;
		mobSet.spawnXPLevelNormal = 2;
		mobSet.spawnXPLevelHard = 5;
		mobSet.minMobsToSpawnEasy = 1;
		mobSet.maxMobsToSpawnEasy = 1;
		mobSet.minMobsToSpawnNormal = 1;
		mobSet.maxMobsToSpawnNormal = 2;
		mobSet.minMobsToSpawnHard = 1;
		mobSet.maxMobsToSpawnHard = 3;
		mobSet.spawnRangeFromPlayerMinEasy = 4;
		mobSet.spawnRangeFromPlayerMaxEasy = 6;
		mobSet.spawnRangeFromPlayerMinNormal = 3;
		mobSet.spawnRangeFromPlayerMaxNormal = 5;
		mobSet.spawnRangeFromPlayerMinHard = 2;
		mobSet.spawnRangeFromPlayerMaxHard = 4;
		mobSet.spawnMobsBehindPlayerEasy = false;
		mobSet.spawnMobsBehindPlayerNormal = true;
		mobSet.spawnMobsBehindPlayerHard = true;
		mobSet.enableStaffCreationPrimaryItem = false;
		mobSet.staffCreationPrimaryItem = "";
		mobSet.staffCreationPrimaryItemAmount = 1;
		mobSet.staffCreationPrimaryItemLevels = 1;
		mobSet.staffCreationPrimaryItemUses = 0;
		mobSet.enableStaffCreationSecondaryItem = false;
		mobSet.staffCreationSecondaryItem = "";
		mobSet.staffCreationSecondaryItemAmount = 1;
		mobSet.staffCreationSecondaryItemLevels = 1;
		mobSet.staffCreationSecondaryItemUses = 0;
		mobSet.mobDropsStaffFragment = true;
		mobSet.staffSpawnedMobDropsFragmentForEntity = "minecraft:skeleton";
		mobSet.minDroppedStaffFragmentsEasy = 1;
		mobSet.maxDroppedStaffFragmentsEasy = 2;
		mobSet.minDroppedStaffFragmentsNormal = 1;
		mobSet.maxDroppedStaffFragmentsNormal = 1;
		mobSet.minDroppedStaffFragmentsHard = 1;
		mobSet.maxDroppedStaffFragmentsHard = 1;
		mobSet.staffFragmentAnvilAmount = 5;
		mobSet.staffFragmentAnvilLevels = 10;
		mobSet.staffFragmentAnvilUses = 50;
		mobSet.staffCooldownEasy = 5;
		mobSet.staffCooldownNormal = 10;
		mobSet.staffCooldownHard = 15;
		mobSet.mobOnlySpawnableAtNightEasy = false;
		mobSet.mobOnlySpawnableAtNightNormal = true;
		mobSet.mobOnlySpawnableAtNightHard = true;
		defaults.put("minecraft:silverfish", mobSet);

		// Skeleton
		mobSet = new MobSettings();
		mobSet.spawnXPLevelEasy = 7;
		mobSet.spawnXPLevelNormal = 9;
		mobSet.spawnXPLevelHard = 12;
		mobSet.minMobsToSpawnEasy = 1;
		mobSet.maxMobsToSpawnEasy = 1;
		mobSet.minMobsToSpawnNormal = 1;
		mobSet.maxMobsToSpawnNormal = 3;
		mobSet.minMobsToSpawnHard = 1;
		mobSet.maxMobsToSpawnHard = 3;
		mobSet.spawnRangeFromPlayerMinEasy = 3;
		mobSet.spawnRangeFromPlayerMaxEasy = 4;
		mobSet.spawnRangeFromPlayerMinNormal = 3;
		mobSet.spawnRangeFromPlayerMaxNormal = 5;
		mobSet.spawnRangeFromPlayerMinHard = 4;
		mobSet.spawnRangeFromPlayerMaxHard = 6;
		mobSet.spawnMobsBehindPlayerEasy = false;
		mobSet.spawnMobsBehindPlayerNormal = true;
		mobSet.spawnMobsBehindPlayerHard = true;
		mobSet.enableStaffCreationPrimaryItem = true;
		mobSet.staffCreationPrimaryItem = "minecraft:bone";
		mobSet.staffCreationPrimaryItemAmount = 1;
		mobSet.staffCreationPrimaryItemLevels = 10;
		mobSet.staffCreationPrimaryItemUses = 10;
		mobSet.enableStaffCreationSecondaryItem = false;
		mobSet.staffCreationSecondaryItem = "";
		mobSet.staffCreationSecondaryItemAmount = 1;
		mobSet.staffCreationSecondaryItemLevels = 1;
		mobSet.staffCreationSecondaryItemUses = 0;
		mobSet.mobDropsStaffFragment = true;
		mobSet.staffSpawnedMobDropsFragmentForEntity = "minecraft:witch";
		mobSet.minDroppedStaffFragmentsEasy = 1;
		mobSet.maxDroppedStaffFragmentsEasy = 2;
		mobSet.minDroppedStaffFragmentsNormal = 1;
		mobSet.maxDroppedStaffFragmentsNormal = 1;
		mobSet.minDroppedStaffFragmentsHard = 1;
		mobSet.maxDroppedStaffFragmentsHard = 1;
		mobSet.staffFragmentAnvilAmount = 7;
		mobSet.staffFragmentAnvilLevels = 10;
		mobSet.staffFragmentAnvilUses = 50;
		mobSet.staffCooldownEasy = 7;
		mobSet.staffCooldownNormal = 10;
		mobSet.staffCooldownHard = 15;
		mobSet.mobOnlySpawnableAtNightEasy = true;
		mobSet.mobOnlySpawnableAtNightNormal = true;
		mobSet.mobOnlySpawnableAtNightHard = true;
		defaults.put("minecraft:skeleton", mobSet);

		// Witch
		mobSet = new MobSettings();
		mobSet.spawnXPLevelEasy = 10;
		mobSet.spawnXPLevelNormal = 13;
		mobSet.spawnXPLevelHard = 15;
		mobSet.minMobsToSpawnEasy = 1;
		mobSet.maxMobsToSpawnEasy = 1;
		mobSet.minMobsToSpawnNormal = 1;
		mobSet.maxMobsToSpawnNormal = 2;
		mobSet.minMobsToSpawnHard = 1;
		mobSet.maxMobsToSpawnHard = 3;
		mobSet.spawnRangeFromPlayerMinEasy = 3;
		mobSet.spawnRangeFromPlayerMaxEasy = 4;
		mobSet.spawnRangeFromPlayerMinNormal = 1;
		mobSet.spawnRangeFromPlayerMaxNormal = 3;
		mobSet.spawnRangeFromPlayerMinHard = 1;
		mobSet.spawnRangeFromPlayerMaxHard = 2;
		mobSet.spawnMobsBehindPlayerEasy = false;
		mobSet.spawnMobsBehindPlayerNormal = false;
		mobSet.spawnMobsBehindPlayerHard = true;
		mobSet.enableStaffCreationPrimaryItem = false;
		mobSet.staffCreationPrimaryItem = "";
		mobSet.staffCreationPrimaryItemAmount = 1;
		mobSet.staffCreationPrimaryItemLevels = 1;
		mobSet.staffCreationPrimaryItemUses = 0;
		mobSet.enableStaffCreationSecondaryItem = false;
		mobSet.staffCreationSecondaryItem = "";
		mobSet.staffCreationSecondaryItemAmount = 1;
		mobSet.staffCreationSecondaryItemLevels = 1;
		mobSet.staffCreationSecondaryItemUses = 0;
		mobSet.mobDropsStaffFragment = true;
		mobSet.staffSpawnedMobDropsFragmentForEntity = "minecraft:zombie_pigman";
		mobSet.minDroppedStaffFragmentsEasy = 1;
		mobSet.maxDroppedStaffFragmentsEasy = 3;
		mobSet.minDroppedStaffFragmentsNormal = 1;
		mobSet.maxDroppedStaffFragmentsNormal = 2;
		mobSet.minDroppedStaffFragmentsHard = 1;
		mobSet.maxDroppedStaffFragmentsHard = 1;
		mobSet.staffFragmentAnvilAmount = 5;
		mobSet.staffFragmentAnvilLevels = 10;
		mobSet.staffFragmentAnvilUses = 60;
		mobSet.staffCooldownEasy = 10;
		mobSet.staffCooldownNormal = 13;
		mobSet.staffCooldownHard = 15;
		mobSet.mobOnlySpawnableAtNightEasy = false;
		mobSet.mobOnlySpawnableAtNightNormal = true;
		mobSet.mobOnlySpawnableAtNightHard = true;
		defaults.put("minecraft:witch", mobSet);

		// Zombie Pigman
		mobSet = new MobSettings();
		mobSet.spawnXPLevelEasy = 10;
		mobSet.spawnXPLevelNormal = 13;
		mobSet.spawnXPLevelHard = 15;
		mobSet.minMobsToSpawnEasy = 1;
		mobSet.maxMobsToSpawnEasy = 1;
		mobSet.minMobsToSpawnNormal = 1;
		mobSet.maxMobsToSpawnNormal = 2;
		mobSet.minMobsToSpawnHard = 1;
		mobSet.maxMobsToSpawnHard = 3;
		mobSet.spawnRangeFromPlayerMinEasy = 3;
		mobSet.spawnRangeFromPlayerMaxEasy = 5;
		mobSet.spawnRangeFromPlayerMinNormal = 2;
		mobSet.spawnRangeFromPlayerMaxNormal = 4;
		mobSet.spawnRangeFromPlayerMinHard = 1;
		mobSet.spawnRangeFromPlayerMaxHard = 3;
		mobSet.spawnMobsBehindPlayerEasy = true;
		mobSet.spawnMobsBehindPlayerNormal = true;
		mobSet.spawnMobsBehindPlayerHard = true;
		mobSet.enableStaffCreationPrimaryItem = false;
		mobSet.staffCreationPrimaryItem = "";
		mobSet.staffCreationPrimaryItemAmount = 1;
		mobSet.staffCreationPrimaryItemLevels = 1;
		mobSet.staffCreationPrimaryItemUses = 0;
		mobSet.enableStaffCreationSecondaryItem = false;
		mobSet.staffCreationSecondaryItem = "";
		mobSet.staffCreationSecondaryItemAmount = 1;
		mobSet.staffCreationSecondaryItemLevels = 3;
		mobSet.staffCreationSecondaryItemUses = 0;
		mobSet.mobDropsStaffFragment = true;
		mobSet.staffSpawnedMobDropsFragmentForEntity = "minecraft:ghast";
		mobSet.minDroppedStaffFragmentsEasy = 1;
		mobSet.maxDroppedStaffFragmentsEasy = 3;
		mobSet.minDroppedStaffFragmentsNormal = 1;
		mobSet.maxDroppedStaffFragmentsNormal = 2;
		mobSet.minDroppedStaffFragmentsHard = 1;
		mobSet.maxDroppedStaffFragmentsHard = 1;
		mobSet.staffFragmentAnvilAmount = 13;
		mobSet.staffFragmentAnvilLevels = 15;
		mobSet.staffFragmentAnvilUses = 20;
		mobSet.staffCooldownEasy = 10;
		mobSet.staffCooldownNormal = 5;
		mobSet.staffCooldownHard = 17;
		mobSet.mobOnlySpawnableAtNightEasy = false;
		mobSet.mobOnlySpawnableAtNightNormal = true;
		mobSet.mobOnlySpawnableAtNightHard = true;
		defaults.put("minecraft:zombie_pigman", mobSet);

		// Ghast
		mobSet = new MobSettings();
		mobSet.spawnXPLevelEasy = 15;
		mobSet.spawnXPLevelNormal = 17;
		mobSet.spawnXPLevelHard = 20;
		mobSet.minMobsToSpawnEasy = 1;
		mobSet.maxMobsToSpawnEasy = 1;
		mobSet.minMobsToSpawnNormal = 1;
		mobSet.maxMobsToSpawnNormal = 2;
		mobSet.minMobsToSpawnHard = 1;
		mobSet.maxMobsToSpawnHard = 3;
		mobSet.spawnRangeFromPlayerMinEasy = 3;
		mobSet.spawnRangeFromPlayerMaxEasy = 4;
		mobSet.spawnRangeFromPlayerMinNormal = 1;
		mobSet.spawnRangeFromPlayerMaxNormal = 3;
		mobSet.spawnRangeFromPlayerMinHard = 1;
		mobSet.spawnRangeFromPlayerMaxHard = 2;
		mobSet.spawnMobsBehindPlayerEasy = false;
		mobSet.spawnMobsBehindPlayerNormal = true;
		mobSet.spawnMobsBehindPlayerHard = true;
		mobSet.enableStaffCreationPrimaryItem = true;
		mobSet.staffCreationPrimaryItem = "minecraft:ghast_tear";
		mobSet.staffCreationPrimaryItemAmount = 1;
		mobSet.staffCreationPrimaryItemLevels = 15;
		mobSet.staffCreationPrimaryItemUses = 5;
		mobSet.enableStaffCreationSecondaryItem = false;
		mobSet.staffCreationSecondaryItem = "";
		mobSet.staffCreationSecondaryItemAmount = 1;
		mobSet.staffCreationSecondaryItemLevels = 1;
		mobSet.staffCreationSecondaryItemUses = 0;
		mobSet.mobDropsStaffFragment = true;
		mobSet.staffSpawnedMobDropsFragmentForEntity = "minecraft:magma_cube";
		mobSet.minDroppedStaffFragmentsEasy = 1;
		mobSet.maxDroppedStaffFragmentsEasy = 3;
		mobSet.minDroppedStaffFragmentsNormal = 1;
		mobSet.maxDroppedStaffFragmentsNormal = 2;
		mobSet.minDroppedStaffFragmentsHard = 1;
		mobSet.maxDroppedStaffFragmentsHard = 1;
		mobSet.staffFragmentAnvilAmount = 10;
		mobSet.staffFragmentAnvilLevels = 15;
		mobSet.staffFragmentAnvilUses = 30;
		mobSet.staffCooldownEasy = 10;
		mobSet.staffCooldownNormal = 15;
		mobSet.staffCooldownHard = 20;
		mobSet.mobOnlySpawnableAtNightEasy = false;
		mobSet.mobOnlySpawnableAtNightNormal = true;
		mobSet.mobOnlySpawnableAtNightHard = true;
		defaults.put("minecraft:ghast", mobSet);

		// Magma Cube
		mobSet = new MobSettings();
		mobSet.spawnXPLevelEasy = 15;
		mobSet.spawnXPLevelNormal = 17;
		mobSet.spawnXPLevelHard = 20;
		mobSet.minMobsToSpawnEasy = 1;
		mobSet.maxMobsToSpawnEasy = 2;
		mobSet.minMobsToSpawnNormal = 1;
		mobSet.maxMobsToSpawnNormal = 3;
		mobSet.minMobsToSpawnHard = 1;
		mobSet.maxMobsToSpawnHard = 4;
		mobSet.spawnRangeFromPlayerMinEasy = 3;
		mobSet.spawnRangeFromPlayerMaxEasy = 5;
		mobSet.spawnRangeFromPlayerMinNormal = 2;
		mobSet.spawnRangeFromPlayerMaxNormal = 4;
		mobSet.spawnRangeFromPlayerMinHard = 1;
		mobSet.spawnRangeFromPlayerMaxHard = 3;
		mobSet.spawnMobsBehindPlayerEasy = false;
		mobSet.spawnMobsBehindPlayerNormal = true;
		mobSet.spawnMobsBehindPlayerHard = true;
		mobSet.enableStaffCreationPrimaryItem = true;
		mobSet.staffCreationPrimaryItem = "minecraft:magma_cream";
		mobSet.staffCreationPrimaryItemAmount = 1;
		mobSet.staffCreationPrimaryItemLevels = 15;
		mobSet.staffCreationPrimaryItemUses = 25;
		mobSet.enableStaffCreationSecondaryItem = false;
		mobSet.staffCreationSecondaryItem = "";
		mobSet.staffCreationSecondaryItemAmount = 1;
		mobSet.staffCreationSecondaryItemLevels = 1;
		mobSet.staffCreationSecondaryItemUses = 0;
		mobSet.mobDropsStaffFragment = true;
		mobSet.staffSpawnedMobDropsFragmentForEntity = "minecraft:wither_skeleton";
		mobSet.minDroppedStaffFragmentsEasy = 1;
		mobSet.maxDroppedStaffFragmentsEasy = 3;
		mobSet.minDroppedStaffFragmentsNormal = 1;
		mobSet.maxDroppedStaffFragmentsNormal = 2;
		mobSet.minDroppedStaffFragmentsHard = 1;
		mobSet.maxDroppedStaffFragmentsHard = 1;
		mobSet.staffFragmentAnvilAmount = 17;
		mobSet.staffFragmentAnvilLevels = 15;
		mobSet.staffFragmentAnvilUses = 35;
		mobSet.staffCooldownEasy = 5;
		mobSet.staffCooldownNormal = 10;
		mobSet.staffCooldownHard = 20;
		mobSet.mobOnlySpawnableAtNightEasy = true;
		mobSet.mobOnlySpawnableAtNightNormal = true;
		mobSet.mobOnlySpawnableAtNightHard = true;
		defaults.put("minecraft:magma_cube", mobSet);

		// Wither Skeleton
		mobSet = new MobSettings();
		mobSet.spawnXPLevelEasy = 15;
		mobSet.spawnXPLevelNormal = 17;
		mobSet.spawnXPLevelHard = 20;
		mobSet.minMobsToSpawnEasy = 1;
		mobSet.maxMobsToSpawnEasy = 2;
		mobSet.minMobsToSpawnNormal = 1;
		mobSet.maxMobsToSpawnNormal = 3;
		mobSet.minMobsToSpawnHard = 1;
		mobSet.maxMobsToSpawnHard = 4;
		mobSet.spawnRangeFromPlayerMinEasy = 1;
		mobSet.spawnRangeFromPlayerMaxEasy = 3;
		mobSet.spawnRangeFromPlayerMinNormal = 2;
		mobSet.spawnRangeFromPlayerMaxNormal = 4;
		mobSet.spawnRangeFromPlayerMinHard = 3;
		mobSet.spawnRangeFromPlayerMaxHard = 5;
		mobSet.spawnMobsBehindPlayerEasy = false;
		mobSet.spawnMobsBehindPlayerNormal = true;
		mobSet.spawnMobsBehindPlayerHard = true;
		mobSet.enableStaffCreationPrimaryItem = false;
		mobSet.staffCreationPrimaryItem = "";
		mobSet.staffCreationPrimaryItemAmount = 1;
		mobSet.staffCreationPrimaryItemLevels = 1;
		mobSet.staffCreationPrimaryItemUses = 0;
		mobSet.enableStaffCreationSecondaryItem = false;
		mobSet.staffCreationSecondaryItem = "";
		mobSet.staffCreationSecondaryItemAmount = 1;
		mobSet.staffCreationSecondaryItemLevels = 1;
		mobSet.staffCreationSecondaryItemUses = 0;
		mobSet.mobDropsStaffFragment = true;
		mobSet.staffSpawnedMobDropsFragmentForEntity = "minecraft:enderman";
		mobSet.minDroppedStaffFragmentsEasy = 1;
		mobSet.maxDroppedStaffFragmentsEasy = 2;
		mobSet.minDroppedStaffFragmentsNormal = 1;
		mobSet.maxDroppedStaffFragmentsNormal = 1;
		mobSet.minDroppedStaffFragmentsHard = 1;
		mobSet.maxDroppedStaffFragmentsHard = 1;
		mobSet.staffFragmentAnvilAmount = 20;
		mobSet.staffFragmentAnvilLevels = 20;
		mobSet.staffFragmentAnvilUses = 20;
		mobSet.staffCooldownEasy = 10;
		mobSet.staffCooldownNormal = 15;
		mobSet.staffCooldownHard = 20;
		mobSet.mobOnlySpawnableAtNightEasy = true;
		mobSet.mobOnlySpawnableAtNightNormal = true;
		mobSet.mobOnlySpawnableAtNightHard = true;
		defaults.put("minecraft:wither_skeleton", mobSet);

		// Enderman
		mobSet = new MobSettings();
		mobSet.spawnXPLevelEasy = 20;
		mobSet.spawnXPLevelNormal = 23;
		mobSet.spawnXPLevelHard = 25;
		mobSet.minMobsToSpawnEasy = 1;
		mobSet.maxMobsToSpawnEasy = 1;
		mobSet.minMobsToSpawnNormal = 1;
		mobSet.maxMobsToSpawnNormal = 2;
		mobSet.minMobsToSpawnHard = 1;
		mobSet.maxMobsToSpawnHard = 3;
		mobSet.spawnRangeFromPlayerMinEasy = 3;
		mobSet.spawnRangeFromPlayerMaxEasy = 5;
		mobSet.spawnRangeFromPlayerMinNormal = 2;
		mobSet.spawnRangeFromPlayerMaxNormal = 4;
		mobSet.spawnRangeFromPlayerMinHard = 1;
		mobSet.spawnRangeFromPlayerMaxHard = 3;
		mobSet.spawnMobsBehindPlayerEasy = false;
		mobSet.spawnMobsBehindPlayerNormal = true;
		mobSet.spawnMobsBehindPlayerHard = true;
		mobSet.enableStaffCreationPrimaryItem = true;
		mobSet.staffCreationPrimaryItem = "minecraft:ender_pearl";
		mobSet.staffCreationPrimaryItemAmount = 1;
		mobSet.staffCreationPrimaryItemLevels = 20;
		mobSet.staffCreationPrimaryItemUses = 1;
		mobSet.enableStaffCreationSecondaryItem = false;
		mobSet.staffCreationSecondaryItem = "";
		mobSet.staffCreationSecondaryItemAmount = 1;
		mobSet.staffCreationSecondaryItemLevels = 1;
		mobSet.staffCreationSecondaryItemUses = 0;
		mobSet.mobDropsStaffFragment = false;
		mobSet.staffSpawnedMobDropsFragmentForEntity = "";
		mobSet.minDroppedStaffFragmentsEasy = 1;
		mobSet.maxDroppedStaffFragmentsEasy = 2;
		mobSet.minDroppedStaffFragmentsNormal = 0;
		mobSet.maxDroppedStaffFragmentsNormal = 1;
		mobSet.minDroppedStaffFragmentsHard = 0;
		mobSet.maxDroppedStaffFragmentsHard = 1;
		mobSet.staffFragmentAnvilAmount = 25;
		mobSet.staffFragmentAnvilLevels = 30;
		mobSet.staffFragmentAnvilUses = 60;
		mobSet.staffCooldownEasy = 20;
		mobSet.staffCooldownNormal = 25;
		mobSet.staffCooldownHard = 30;
		mobSet.mobOnlySpawnableAtNightEasy = true;
		mobSet.mobOnlySpawnableAtNightNormal = true;
		mobSet.mobOnlySpawnableAtNightHard = true;
		defaults.put("minecraft:enderman", mobSet);
	}
}
