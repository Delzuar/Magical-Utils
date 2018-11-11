package com.emiyas.tutorialmod.init;

import java.util.ArrayList;
import java.util.List;

import com.emiyas.tutorialmod.items.ItemRedIngotSword;
import com.emiyas.tutorialmod.items.ItemWandOfBinding;
import com.emiyas.tutorialmod.items.custom.ItemCustom;
import com.emiyas.tutorialmod.items.custom.SwordCustom;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItemsInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	//WOOD(0, 59, 2.0F, 0.0F, 15),
	//STONE(1, 131, 4.0F, 1.0F, 5),
	//IRON(2, 250, 6.0F, 2.0F, 14),
	//DIAMOND(3, 1561, 8.0F, 3.0F, 10),
	//GOLD(0, 32, 12.0F, 0.0F, 22);
	
	public static final ToolMaterial MATERIAL_RED_INGOT = EnumHelper.addToolMaterial("material_red_ingot", 3, 250, 12.0F, 4.0F, 50);
	
	//Basic Items
	public static final Item RED_INGOT = new ItemCustom("red_ingot");
	public static final Item RED_COMPOUND = new ItemCustom("red_compound");
	public static final Item WAND_OF_BINDING = new ItemWandOfBinding("wand_of_binding");
	
	//Swords
	public static final Item RED_INGOT_SWORD = new ItemRedIngotSword("red_ingot_sword", MATERIAL_RED_INGOT);
	
}