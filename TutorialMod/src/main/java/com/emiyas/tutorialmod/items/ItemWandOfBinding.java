package com.emiyas.tutorialmod.items;

import com.emiyas.tutorialmod.items.custom.ItemCustom;
import com.emiyas.tutorialmod.tileEntities.TileEntityTeleporter;
import com.emiyas.tutorialmod.util.MessageUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemWandOfBinding extends ItemCustom
{
	BlockPos targetPos;

	public ItemWandOfBinding(String name)
	{
		super(name);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			TileEntityTeleporter teleporterTE = getTeleporterTileEntity(world, pos);
			if (teleporterTE != null)
			{
				if (player.isSneaking())
				{
					setTargetPos(pos);
					MessageUtils.informationMessage("Wand linked to teleporter", player);
				}
			}
		}
		return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
	}

	private TileEntityTeleporter getTeleporterTileEntity(World world, BlockPos pos)
	{
		return (TileEntityTeleporter) world.getTileEntity(pos);
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
