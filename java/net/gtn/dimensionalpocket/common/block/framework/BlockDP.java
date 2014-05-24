package net.gtn.dimensionalpocket.common.block.framework;

import net.gtn.dimensionalpocket.DimensionalPockets;
import net.gtn.dimensionalpocket.common.core.utils.IBlockNotifier;
import net.gtn.dimensionalpocket.common.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BlockDP extends Block {

    public BlockDP(int id, Material material, String name) {
        super(id, material);
        setUnlocalizedName(name);
        setCreativeTab(DimensionalPockets.creativeTab);
        register(name);
    }

    public void register(String name) {
        GameRegistry.registerBlock(this, name);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (tileEntity instanceof IBlockNotifier)
            ((IBlockNotifier) tileEntity).onBlockPlaced(entityLiving, itemStack);
    }

    @Override
    public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {
        onBlockRemoval(world, x, y, z);
        super.onBlockExploded(world, x, y, z, explosion);
    }

    @Override
    public void onBlockHarvested(World world, int x, int y, int z, int dmg, EntityPlayer player) {
        onBlockRemoval(world, x, y, z);
        super.onBlockHarvested(world, x, y, z, dmg, player);
    }

    public void onBlockRemoval(World world, int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (tileEntity instanceof IBlockNotifier)
            ((IBlockNotifier) tileEntity).onBlockDestroyed();
    }
    
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_IDENTIFIER + getUnlocalizedName().replace("tile.", ""));
    }

    @Override
    public boolean renderAsNormalBlock() {
        return !renderWithModel();
    }

    @Override
    public boolean isOpaqueCube() {
        return !renderWithModel();
    }

    @Override
    public int getRenderType() {
        return renderWithModel() ? -1 : super.getRenderType();
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return getTileEntity(metadata);
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return getTileEntity(metadata) != null;
    }

    public abstract boolean renderWithModel();

    public abstract TileEntity getTileEntity(int metadata);
}
