package com.emiyas.tutorialmod.items;

import com.emiyas.tutorialmod.items.custom.SwordCustom;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ItemRedIngotSword extends SwordCustom
{

	public ItemRedIngotSword(String name, ToolMaterial material) 
	{
		super(name, material);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		
	    target.setFire(10);
		return true;
	}
	

}
