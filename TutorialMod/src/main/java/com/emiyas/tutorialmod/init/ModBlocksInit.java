package com.emiyas.tutorialmod.init;

import java.util.ArrayList;
import java.util.List;

import com.emiyas.tutorialmod.blocks.BlockRedIngot;
import com.emiyas.tutorialmod.blocks.BlockTeleporter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocksInit
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static final Block RED_INGOT_BLOCK = new BlockRedIngot("red_ingot_block", Material.IRON);
	public static final Block TELEPORTER_BLOCK = new BlockTeleporter("teleporter_block", Material.IRON);
}
