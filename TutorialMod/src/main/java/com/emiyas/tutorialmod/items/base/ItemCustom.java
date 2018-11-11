package com.emiyas.tutorialmod.items.base;

import com.emiyas.tutorialmod.Main;
import com.emiyas.tutorialmod.init.ModItems;
import com.emiyas.tutorialmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCustom extends Item implements IHasModel
{
	public ItemCustom(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);

		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
