package com.emiyas.tutorialmod;

import com.emiyas.tutorialmod.init.ModRecipesInit;
import com.emiyas.tutorialmod.proxy.CommonProxy;
import com.emiyas.tutorialmod.tileEntities.TileEntityTeleporter;
import com.emiyas.tutorialmod.util.Reference;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main
{
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		proxy.preInit(event);
		GameRegistry.registerTileEntity(TileEntityTeleporter.class, Reference.MOD_ID + "TeleporterTileEntity");
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		ModRecipesInit.init();
	}
	
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}
}
