package com.themuso.mobsonyourterms;

import com.themuso.mobsonyourterms.handler.AnvilHandler;
import com.themuso.mobsonyourterms.handler.ChunkWatchEventHandler;
import com.themuso.mobsonyourterms.handler.ConfigurationHandler;
import com.themuso.mobsonyourterms.handler.ItemRegistrationHandler;
import com.themuso.mobsonyourterms.handler.MobDropHandler;
import com.themuso.mobsonyourterms.handler.RuleHandler;
import com.themuso.mobsonyourterms.init.ModItems;
import com.themuso.mobsonyourterms.reference.Reference;
import com.themuso.mobsonyourterms.reference.VanillaMobSettings;
import com.themuso.mobsonyourterms.utility.LogHelper;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MobsOnYourTerms 
{
	@Mod.Instance(Reference.MOD_ID)
	public static MobsOnYourTerms instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		LogHelper.init(event.getModLog());
		VanillaMobSettings.initDefaults();
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());

		ModItems.init();

		MinecraftForge.EVENT_BUS.register(new ItemRegistrationHandler());
		MinecraftForge.EVENT_BUS.register(new ChunkWatchEventHandler());
		MinecraftForge.EVENT_BUS.register(new RuleHandler());
		MinecraftForge.EVENT_BUS.register(new AnvilHandler());
		MinecraftForge.EVENT_BUS.register(new MobDropHandler());

		LogHelper.info("Pre Init complete");
	}

	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		ConfigurationHandler.loadExtraMobConfig();

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
