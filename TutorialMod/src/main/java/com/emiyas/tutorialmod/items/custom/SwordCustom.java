package com.emiyas.tutorialmod.items.custom;

import com.emiyas.tutorialmod.Main;
import com.emiyas.tutorialmod.init.ModItemsInit;
import com.emiyas.tutorialmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class SwordCustom extends ItemSword implements IHasModel
{
	public SwordCustom(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);

		ModItemsInit.ITEMS.add(this);
	}

	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
