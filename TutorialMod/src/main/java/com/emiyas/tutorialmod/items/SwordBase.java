package com.emiyas.tutorialmod.items;

import com.emiyas.tutorialmod.Main;
import com.emiyas.tutorialmod.init.ModItems;
import com.emiyas.tutorialmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class SwordBase extends ItemSword implements IHasModel
{
	public SwordBase(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);

		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
