package com.emiyas.tutorialmod.blocks;

import com.emiyas.tutorialmod.blocks.custom.BlockCustom;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockRedIngot extends BlockCustom
{
	public BlockRedIngot(String name, Material material) 
	{
		super(name, material);		
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 2);
	}
}
