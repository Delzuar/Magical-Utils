package com.emiyas.tutorialmod.blocks;

import com.emiyas.tutorialmod.blocks.base.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RedIngotBlock extends BlockBase
{
	public RedIngotBlock(String name, Material material) 
	{
		super(name, material);		
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 2);
	}
}
