package net.gtn.dimensionalpocket.client.utils;

import net.gtn.dimensionalpocket.common.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RecipeHelper {

    //@formatter:off
    private static ItemStack[] enderArray = new ItemStack[] {
        new ItemStack(Item.eyeOfEnder),
        new ItemStack(Item.eyeOfEnder),
        new ItemStack(Item.eyeOfEnder),
        new ItemStack(Item.eyeOfEnder),
        new ItemStack(Block.glass),
        new ItemStack(Item.eyeOfEnder),
        new ItemStack(Item.eyeOfEnder),
        new ItemStack(Item.eyeOfEnder),
        new ItemStack(Item.eyeOfEnder)
    };

    private static ItemStack[] netherArray = new ItemStack[] {
        new ItemStack(Item.ghastTear),
        new ItemStack(Item.ghastTear),
        new ItemStack(Item.ghastTear),
        new ItemStack(Item.ghastTear),
        new ItemStack(Block.blockRedstone),
        new ItemStack(Item.ghastTear),
        new ItemStack(Item.ghastTear),
        new ItemStack(Item.ghastTear),
        new ItemStack(Item.ghastTear)
    };

    private static ItemStack[] blockArray = new ItemStack[] {
        new ItemStack(Block.stoneBrick),
        new ItemStack(ModItems.miscItems,1,1),
        new ItemStack(Block.stoneBrick),
        new ItemStack(Block.blockIron),
        new ItemStack(Block.blockDiamond),
        new ItemStack(Block.blockIron),
        new ItemStack(Block.stoneBrick),
        new ItemStack(ModItems.miscItems,1,0),
        new ItemStack(Block.stoneBrick)
    };

    //@formatter:on

    public static ItemStack[] getEnderRecipe() {
        return enderArray;
    }

    public static ItemStack[] getNetherRecipe() {
        return netherArray;
    }

    public static ItemStack[] getBlockRecipe() {
        return blockArray;
    }

}
