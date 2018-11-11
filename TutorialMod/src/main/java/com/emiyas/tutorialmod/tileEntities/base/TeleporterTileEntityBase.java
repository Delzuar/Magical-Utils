package com.emiyas.tutorialmod.tileEntities.base;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class TeleporterTileEntityBase extends TileEntity
{
	private String coord;
	private BlockPos linkedBlockPos;

	public void setCoord(String coord)
	{
		this.coord = coord;
	}

	public String getCoord()
	{
		if (coord == null)
		{
			setCoord(this.getPos().toString());
		}
		return coord;
	}

	public void setLinkedBlockPos(BlockPos linkedBlockPos)
	{
		this.linkedBlockPos = linkedBlockPos;
	}

	public BlockPos getLinkedBlockPos()
	{
		return linkedBlockPos;
	}
}
