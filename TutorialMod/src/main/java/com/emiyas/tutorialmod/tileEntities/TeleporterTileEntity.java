package com.emiyas.tutorialmod.tileEntities;

import com.emiyas.tutorialmod.tileEntities.base.TeleporterTileEntityBase;

import net.minecraft.nbt.NBTTagCompound;

public class TeleporterTileEntity extends TeleporterTileEntityBase
{
	protected final static String COORD = "Coord";
	protected final static String LINKED_BLOCKPOS = "linkedBlockPos";

	// NBT METHOD
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
}