package com.themuso.mobsonyourterms.handler;

import com.themuso.mobsonyourterms.init.ModItems;
import com.themuso.mobsonyourterms.reference.MobList;
import com.themuso.mobsonyourterms.reference.MobSettings;
import com.themuso.mobsonyourterms.reference.Names;
import com.themuso.mobsonyourterms.reference.Settings;
import com.themuso.mobsonyourterms.utility.EntityNBTHelper;
import com.themuso.mobsonyourterms.utility.ItemNBTHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDropHandler
{
	@SubscribeEvent
	public void onMobDrop(LivingDropsEvent event)
	{
		int lootLevel = 0;
		int minDrops = 0;
		int maxDrops = 0;
		int dropsRange = 0;
		int numDrops = 0;
		EnumDifficulty difficulty = event.getEntityLiving().world.getDifficulty();
		Entity mob;
		EntityDamageSource source;
		EntityPlayer player;
		EntityPlayerMP playerMP;
		MobSettings mobConfig;
		ItemStack fragment;
		EntityItem drop;

		if (difficulty == EnumDifficulty.PEACEFUL)
		{
			return;
		}

		if (!(event.getSource() instanceof EntityDamageSource))
		{
			return;
		}

		source = (EntityDamageSource)event.getSource();

		if (!(source.getTrueSource() instanceof EntityPlayer))
		{
			return;
		}

		mob = event.getEntityLiving();
		player = (EntityPlayer)source.getTrueSource();
		playerMP = (EntityPlayerMP)player;

		if (!EntityNBTHelper.getBoolean(mob, Names.NBTTags.MOB_SPAWNED_WITH_STAFF))
		{
			return;
		}

		mobConfig = MobList.mobList.get(EntityList.getKey(mob).toString());

		if (mobConfig == null)
		{
			player.sendMessage(new TextComponentString("Cannot retrieve the config for this staff spawned mob."));
			return;
		}

		if (!Settings.General.enableStaffFragmentItem || !mobConfig.mobDropsStaffFragment)
		{
			return;
		}

		if (event.getLootingLevel() == 0)
		{
			lootLevel = 1;
		}
		else
		{
			lootLevel = event.getLootingLevel();
		}

		if (difficulty == EnumDifficulty.EASY)
		{
			minDrops = mobConfig.minDroppedStaffFragmentsEasy;
			maxDrops = mobConfig.maxDroppedStaffFragmentsEasy;
		}
		else if (difficulty == EnumDifficulty.NORMAL)
		{
			minDrops = mobConfig.minDroppedStaffFragmentsNormal;
			maxDrops = mobConfig.maxDroppedStaffFragmentsNormal;
		}
		else if (difficulty == EnumDifficulty.HARD)
		{
			minDrops = mobConfig.minDroppedStaffFragmentsHard;
			maxDrops = mobConfig.maxDroppedStaffFragmentsHard;
		}

		dropsRange = maxDrops - minDrops;
		if (dropsRange <= 0)
		{
			dropsRange = 1;
		}

		numDrops = ((mob.world.rand.nextInt(dropsRange) + minDrops) * lootLevel);
		fragment = new ItemStack(ModItems.staffFragment, numDrops);
		ItemNBTHelper.setString(fragment, Names.NBTTags.FRAGMENT_IS_FOR_MOB, mobConfig.staffSpawnedMobDropsFragmentForEntity);
		drop = new EntityItem(mob.world, mob.posX, mob.posY, mob.posZ, fragment);
		event.getDrops().add(drop);
	}
}
