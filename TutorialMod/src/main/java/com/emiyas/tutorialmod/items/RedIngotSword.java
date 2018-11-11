package com.emiyas.tutorialmod.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RedIngotSword extends SwordBase
{

	public RedIngotSword(String name, ToolMaterial material) 
	{
		super(name, material);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		
	    target.setFire(10);
		return true;
	}
	

}
