package com.themuso.mobsonyourterms;

import net.minecraftforge.common.MinecraftForge;

import com.themuso.mobsonyourterms.handler.ChunkLoadEventHandler;
import com.themuso.mobsonyourterms.handler.ConfigurationHandler;
import com.themuso.mobsonyourterms.handler.RuleHandler;
import com.themuso.mobsonyourterms.reference.Reference;
import com.themuso.mobsonyourterms.utility.LogHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MobsOnYourTerms 
{
	@Mod.Instance(Reference.MOD_ID)
	public static MobsOnYourTerms instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());

		ChunkLoadEventHandler chunkEventHandler = new ChunkLoadEventHandler();
		RuleHandler ruleEventHandler = new RuleHandler();

		MinecraftForge.EVENT_BUS.register(chunkEventHandler);
		MinecraftForge.EVENT_BUS.register(ruleEventHandler);

		LogHelper.info("Pre Init complete");
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		LogHelper.info("Init complete");
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		LogHelper.info("Post Init complete");
	}

	@Mod.EventHandler
	public void loadComplete(FMLLoadCompleteEvent event)
	{
		ConfigurationHandler.validate();
		LogHelper.info("Load complete");
	}
}
