package com.emiyas.tutorialmod.blocks;

import com.emiyas.tutorialmod.blocks.base.BlockBase;
import com.emiyas.tutorialmod.init.ModItems;
import com.emiyas.tutorialmod.tileEntities.TeleporterTileEntity;
import com.emiyas.tutorialmod.util.MessageUtils;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TeleporterBlock extends BlockBase implements ITileEntityProvider
{

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public TeleporterBlock(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 2);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TeleporterTileEntity();
	}

	private TeleporterTileEntity getTeleporterTileEntity(World world, BlockPos pos)
	{
		return (TeleporterTileEntity) world.getTileEntity(pos);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			// We only count on the server side.
			if (side == state.getValue(FACING))
			{
				// displayDebugMessage(world, pos, player, hand);
				TeleporterTileEntity teleporterTE = getTeleporterTileEntity(world, pos);
				BlockPos linkedBlockPos = teleporterTE.getLinkedBlockPos();
				if (linkedBlockPos != null)
				{
					player.attemptTeleport(linkedBlockPos.getX(), linkedBlockPos.getY(), linkedBlockPos.getZ());
				}
			}
		}
		return true;
	}

	private void teleportPlayer(World world, BlockPos pos, EntityPlayer player, EnumHand hand)
	{
		ItemStack itemUsed = player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
		if (itemUsed.areItemsEqual(itemUsed, new ItemStack(ModItems.WAND_OF_BINDING)))
		{
			player.attemptTeleport(pos.getX() + 5, pos.getY() + 5, pos.getZ() + 5);
		}
	}

	private void displayDebugMessage(World world, BlockPos pos, EntityPlayer player, EnumHand hand)
	{
		// Send message to current player with teleporter coords
		MessageUtils.informationMessage("Test Coord : " + getTeleporterTileEntity(world, pos).getCoord(), player);

		// Send message to current player with teleporter coords
		MessageUtils.informationMessage("Current teleporter coordinate : " + pos.toString(), player);
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
		if (!world.isRemote)
		{
			TeleporterTileEntity teleporterTileEntity = getTeleporterTileEntity(world, pos);
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return getDefaultState().withProperty(FACING, EnumFacing.getFront((meta & 3) + 2));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(FACING).getIndex() - 2;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, FACING);
	}
}