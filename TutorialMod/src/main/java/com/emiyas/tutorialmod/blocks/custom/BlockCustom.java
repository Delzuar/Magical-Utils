package com.emiyas.tutorialmod.blocks.custom;

import com.emiyas.tutorialmod.Main;
import com.emiyas.tutorialmod.init.ModBlocksInit;
import com.emiyas.tutorialmod.init.ModItemsInit;
import com.emiyas.tutorialmod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockCustom extends Block implements IHasModel
{
	public BlockCustom(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		ModBlocksInit.BLOCKS.add(this);
		ModItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
