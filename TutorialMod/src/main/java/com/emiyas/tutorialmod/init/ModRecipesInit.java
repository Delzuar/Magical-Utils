package com.emiyas.tutorialmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipesInit 
{
	public static void init() 
	{
		GameRegistry.addSmelting(ModItemsInit.RED_COMPOUND, new ItemStack(ModItemsInit.RED_INGOT, 1), 1.5f);
	}
}
