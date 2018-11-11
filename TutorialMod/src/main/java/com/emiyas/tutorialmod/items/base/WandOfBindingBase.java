package com.emiyas.tutorialmod.items.base;

import net.minecraft.util.math.BlockPos;

public abstract class WandOfBindingBase extends ItemCustom
{
	BlockPos targetPos;

	public WandOfBindingBase(String name)
	{
		super(name);
	}

	public void setTargetPos(BlockPos targetPos)
	{
		this.targetPos = targetPos;
	}

	public BlockPos getTargetPos()
	{
		return targetPos;
	}
}
