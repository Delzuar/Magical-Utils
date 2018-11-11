package com.emiyas.tutorialmod.blocks;

import java.util.Random;

import com.emiyas.tutorialmod.blocks.custom.BlockCustom;
import com.emiyas.tutorialmod.init.ModItemsInit;
import com.emiyas.tutorialmod.items.ItemWandOfBinding;
import com.emiyas.tutorialmod.tileEntities.TileEntityTeleporter;
import com.emiyas.tutorialmod.util.MessageUtils;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTeleporter extends BlockCustom implements ITileEntityProvider
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public boolean isEnable = false;
	int count = 0;

	public BlockTeleporter(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 2);
	}

	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity)
	{

		if (isTeleporterEnable())
		{
			TileEntityTeleporter teleporterTE = getTeleporterTileEntity(world, pos);
			BlockPos linkedBlockPos = teleporterTE.getLinkedBlockPos();
			if (linkedBlockPos != null && entity instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) entity;
				if (player.attemptTeleport(linkedBlockPos.getX(), linkedBlockPos.getY() + 3, linkedBlockPos.getZ()))
				{
					MessageUtils.informationMessage("Teleportation..", player);
				} else
				{
					MessageUtils.errorMessage("Teleporter obstructed!", player);
				}
				setTeleporterEnable(false);
			}
		}
		super.onEntityWalk(world, pos, entity);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityTeleporter();
	}

	private TileEntityTeleporter getTeleporterTileEntity(World world, BlockPos pos)
	{
		return (TileEntityTeleporter) world.getTileEntity(pos);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			if (!player.isSneaking())
			{
				ItemStack itemUsed = player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
				if (itemUsed.areItemsEqual(itemUsed, new ItemStack(ModItemsInit.WAND_OF_BINDING)))
				{
					TileEntityTeleporter teleporterTE = getTeleporterTileEntity(world, pos);
					ItemWandOfBinding wand = (ItemWandOfBinding) itemUsed.getItem();

					teleporterTE.setLinkedBlockPos(wand.getTargetPos());
					MessageUtils.informationMessage("Link establish !", player);

				}
			}
		}
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		if (!world.isRemote)
		{
			TileEntityTeleporter teleporterTileEntity = getTeleporterTileEntity(world, pos);
		}
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		world.scheduleUpdate(pos, this, this.tickRate(world));
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		if (!world.isRemote)
		{
			setTeleporterEnable(world.isBlockPowered(pos));
		}
	}

	private void RenderTickEvent()
	{
		System.out.println(count++);
	}

	@Override
	public int tickRate(World world)
	{
		return 10;
	}

	public boolean isTeleporterEnable()
	{
		return isEnable;
	}

	private void setTeleporterEnable(boolean isEnable)
	{
		this.isEnable = isEnable;
	}

}