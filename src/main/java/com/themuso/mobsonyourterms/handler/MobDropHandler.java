package com.themuso.mobsonyourterms.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.SkeletonType;
import net.minecraft.entity.player.EntityPlayer;
// import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import com.themuso.mobsonyourterms.init.ModItems;
import com.themuso.mobsonyourterms.reference.MobList;
import com.themuso.mobsonyourterms.reference.MobSettings;
import com.themuso.mobsonyourterms.reference.Names;
import com.themuso.mobsonyourterms.reference.Settings;
import com.themuso.mobsonyourterms.utility.EntityNBTHelper;
import com.themuso.mobsonyourterms.utility.ItemNBTHelper;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDropHandler
{
	@SubscribeEvent
	public void onMobDrop(LivingDropsEvent event)
	{
		String mobName;
		int lootLevel = 0;
		int minDrops = 0;
		int maxDrops = 0;
		int dropsRange = 0;
		int numDrops = 0;
		EnumDifficulty difficulty = event.getEntityLiving().worldObj.getDifficulty();
		Entity mob;
		EntityPlayer player;
		// EntityPlayerMP playerMP;
		MobSettings mobConfig;
		ItemStack fragment;
		EntityItem drop;

		if (difficulty == EnumDifficulty.PEACEFUL)
		{
			return;
		}

		if (!(event.getSource().getEntity() instanceof EntityPlayer))
		{
			return;
		}

		mob = event.getEntityLiving();
		player = (EntityPlayer)event.getSource().getEntity();
		// playerMP = (EntityPlayerMP)event.getSource().getEntity();

		if (!EntityNBTHelper.getBoolean(mob, Names.NBTTags.MOB_SPAWNED_WITH_STAFF))
		{
			return;
		}

		if ((mob instanceof EntitySkeleton) &&
		    (((EntitySkeleton)mob).getSkeletonType() == SkeletonType.WITHER))
		{
			mobName = "WitherSkeleton";
		}
		else
		{
			mobName = EntityList.getEntityString(mob);
		}

		mobConfig = MobList.mobList.get(mobName);

		if (mobConfig == null)
		{
			player.addChatMessage(new TextComponentString("Cannot retrieve the config for this staff spawned mob."));
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

		numDrops = ((mob.worldObj.rand.nextInt(dropsRange) + minDrops) * lootLevel);
		fragment = new ItemStack(ModItems.staffFragment, numDrops);
		ItemNBTHelper.setString(fragment, Names.NBTTags.FRAGMENT_IS_FOR_MOB, mobConfig.staffSpawnedMobDropsFragmentForEntity);
		drop = new EntityItem(mob.worldObj, mob.posX, mob.posY, mob.posZ, fragment);
		event.getDrops().add(drop);
	}
}
