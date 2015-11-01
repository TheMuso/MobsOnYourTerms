package com.themuso.mobsonyourterms;

import net.minecraftforge.common.MinecraftForge;

import com.themuso.mobsonyourterms.entity.EntityWitherSkeleton;
import com.themuso.mobsonyourterms.handler.AnvilHandler;
import com.themuso.mobsonyourterms.handler.ChunkWatchEventHandler;
import com.themuso.mobsonyourterms.handler.ConfigurationHandler;
import com.themuso.mobsonyourterms.handler.MobDropHandler;
import com.themuso.mobsonyourterms.handler.RuleHandler;
import com.themuso.mobsonyourterms.init.ModItems;
import com.themuso.mobsonyourterms.init.Recipes;
import com.themuso.mobsonyourterms.reference.Reference;
import com.themuso.mobsonyourterms.reference.Settings;
import com.themuso.mobsonyourterms.reference.VanillaMobSettings;
import com.themuso.mobsonyourterms.utility.LogHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MobsOnYourTerms 
{
	@Mod.Instance(Reference.MOD_ID)
	public static MobsOnYourTerms instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		VanillaMobSettings.initDefaults();
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());

		if (Settings.General.registerWitherSkeletonEntity)
		{
			EntityRegistry.registerGlobalEntityID(EntityWitherSkeleton.class, "WitherSkeleton", EntityRegistry.findGlobalUniqueEntityId());
		}

		ChunkWatchEventHandler chunkEventHandler = new ChunkWatchEventHandler();
		RuleHandler ruleEventHandler = new RuleHandler();
		AnvilHandler anvilHandler = new AnvilHandler();
		MobDropHandler mobDropHandler = new MobDropHandler();

		MinecraftForge.EVENT_BUS.register(chunkEventHandler);
		MinecraftForge.EVENT_BUS.register(ruleEventHandler);
		MinecraftForge.EVENT_BUS.register(anvilHandler);
		MinecraftForge.EVENT_BUS.register(mobDropHandler);

		ModItems.init();

		LogHelper.info("Pre Init complete");
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		ConfigurationHandler.loadExtraMobConfig();
		Recipes.init();
		LogHelper.info("Init complete");
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		ConfigurationHandler.validate();
		LogHelper.info("Post Init complete");
	}

	@Mod.EventHandler
	public void loadComplete(FMLLoadCompleteEvent event)
	{
		LogHelper.info("Load complete");
	}
}
