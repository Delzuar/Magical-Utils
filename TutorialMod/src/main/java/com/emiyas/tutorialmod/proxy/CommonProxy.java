package com.emiyas.tutorialmod.proxy;

import com.emiyas.tutorialmod.blocks.BlockTeleporter;
import com.emiyas.tutorialmod.init.ModBlocksInit;
import com.emiyas.tutorialmod.tileEntities.TileEntityTeleporter;
import com.emiyas.tutorialmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event)
    {
		System.out.println("CommonProxy PreInit"); 
    }
	 
	public void init(FMLInitializationEvent event) 
	{
		System.out.println("CommonProxy Init"); 	
	}
	
	public void postInit(FMLPostInitializationEvent event) 
	{
		System.out.println("CommonProxy PostInit"); 
	}

	public void registerItemRenderer(Item item, int meta, String id)
	{ 
	}
	

}
