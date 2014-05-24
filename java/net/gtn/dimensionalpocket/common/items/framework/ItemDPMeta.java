package net.gtn.dimensionalpocket.common.items.framework;

import java.util.List;

import net.gtn.dimensionalpocket.common.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class ItemDPMeta extends ItemDP {

    @SideOnly(Side.CLIENT)
    private Icon[] icons;

    public ItemDPMeta(int id, String name) {
        super(id, name);
        setHasSubtypes(true);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs tab, List list) {
        String[] names = getNames();
        int i = 0;
        for (String name : names)
            list.add(new ItemStack(this, 1, i++)); // FIXME: is this right?
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        String[] names = getNames();
        icons = new Icon[names.length];
        int i = 0;
        for (String name : names)
            icons[i++] = iconRegister.registerIcon(Reference.MOD_IDENTIFIER + name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int damage) {
        return icons[damage];
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        String[] names = getNames();
        return "item." + names[itemStack.getItemDamage()];
    }

    public abstract String[] getNames();

}
