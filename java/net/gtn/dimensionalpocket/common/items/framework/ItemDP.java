package net.gtn.dimensionalpocket.common.items.framework;

import net.gtn.dimensionalpocket.DimensionalPockets;
import net.gtn.dimensionalpocket.common.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class ItemDP extends Item {

    public ItemDP(int id, String name) {
    	super(id);
        setUnlocalizedName(name);
        setCreativeTab(DimensionalPockets.creativeTab);
        register(name);
    }

    public void register(String name) {
        GameRegistry.registerItem(this, name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Reference.MOD_IDENTIFIER + getUnlocalizedName().replace("item.", ""));
    }

}
