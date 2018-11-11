package com.emiyas.tutorialmod.items;

import com.emiyas.tutorialmod.items.base.WandOfBindingBase;
import com.emiyas.tutorialmod.tileEntities.TeleporterTileEntity;
import com.emiyas.tutorialmod.util.MessageUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WandOfBinding extends WandOfBindingBase
{
	public WandOfBinding(String name)
	{
		super(name);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			if (player.isSneaking())
			{
				setTargetPos(pos);
				MessageUtils.informationMessage("Wand Binded!", player);
			} else
			{
				TeleporterTileEntity teleporterTE = getTeleporterTileEntity(world, pos);
				teleporterTE.setLinkedBlockPos(getTargetPos());
				MessageUtils.informationMessage("Link Establish!", player);
			}
		}
		return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
	}

	private TeleporterTileEntity getTeleporterTileEntity(World world, BlockPos pos)
	{
		return (TeleporterTileEntity) world.getTileEntity(pos);
	}
}
