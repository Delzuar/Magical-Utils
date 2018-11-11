package com.emiyas.tutorialmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes 
{
	public static void init() 
	{
		GameRegistry.addSmelting(ModItems.RED_COMPOUND, new ItemStack(ModItems.RED_INGOT, 1), 1.5f);
	}
}
