package com.emiyas.tutorialmod.tileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class TileEntityTeleporter extends TileEntity
{
	protected final static String COORD = "Coord";
	protected final static String LINKED_BLOCKPOS = "linkedBlockPos";

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);

		nbt.getString(COORD);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);

		nbt.setString(COORD, getCoord());

		return nbt;
	}

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