package com.themuso.mobsonyourterms;

import java.util.HashMap;

import net.minecraftforge.common.MinecraftForge;

import com.themuso.mobsonyourterms.handler.ChunkLoaderEventHandler;
import com.themuso.mobsonyourterms.handler.ConfigurationHandler;
import com.themuso.mobsonyourterms.reference.MobSettings;
import com.themuso.mobsonyourterms.reference.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MobsOnYourTerms 
{
	@Mod.Instance(Reference.MOD_ID)
	public static MobsOnYourTerms instance;

	public HashMap<String, MobSettings> mobList;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigurationHandler.init(event.suggestedConfigurationFile));

		 ChunkLoaderEventHandler chunkHandler = new  ChunkLoaderEventHandler();
		 MinecraftForge.EVENT_BUS.register(chunkHandler);
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
