package com.emiyas.tutorialmod.init;

import java.util.ArrayList;
import java.util.List;

import com.emiyas.tutorialmod.blocks.RedIngotBlock;
import com.emiyas.tutorialmod.blocks.TeleporterBlock;
import com.emiyas.tutorialmod.blocks.base.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block RED_INGOT_BLOCK = new RedIngotBlock("red_ingot_block", Material.IRON);
	public static final Block TELEPORTER_BLOCK = new TeleporterBlock("teleporter_block", Material.IRON);
	
	
}
