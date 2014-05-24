package net.gtn.dimensionalpocket.common;

import net.gtn.dimensionalpocket.common.block.BlockDimensionalPocket;
import net.gtn.dimensionalpocket.common.core.config.ConfigHandler;
import net.gtn.dimensionalpocket.common.items.ItemMisc;
import net.gtn.dimensionalpocket.common.lib.Reference;
import net.gtn.dimensionalpocket.common.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.Configuration;

public class ModItems {

    public static final int ENDER_CRYSTAL_META = 0;
    public static final int NETHER_CRYSTAL_META = 1;
    public static final int INFO_BOOK_META = 2;

    public static Item miscItems;
    
    public static void preInit() {
		Reference.ITEM_ID_MISC_ITEM = ConfigHandler.config.get(Configuration.CATEGORY_ITEM, Strings.ITEM_MISC, -1).getInt();
    	if (Reference.ITEM_ID_MISC_ITEM != -1)
    		miscItems = new ItemMisc(Reference.ITEM_ID_MISC_ITEM, Strings.ITEM_MISC);
	}

    public static void init() {
    	if (miscItems == null) {
    		ConfigHandler.config.get(Configuration.CATEGORY_ITEM, Strings.ITEM_MISC, -1).set(Reference.ITEM_ID_MISC_ITEM_DEFAULT);
    		miscItems = new ItemMisc(Reference.ITEM_ID_MISC_ITEM_DEFAULT, Strings.ITEM_MISC);
    	}
    }

    public static void initRecipes() {
        CraftingManager crafting = CraftingManager.getInstance();

        //@formatter:off
        crafting.addRecipe(new ItemStack(ModBlocks.dimensionalPocket, 4), 
                new Object[] { "#N#",
                               "IDI",
                               "#E#",

                               Character.valueOf('#'),
                               new ItemStack(Block.stoneBrick, 1, 0),

                               Character.valueOf('I'),
                               Block.blockIron,

                               Character.valueOf('D'),
                               Block.blockDiamond,

                               Character.valueOf('N'),
                               new ItemStack(ModItems.miscItems, 1, NETHER_CRYSTAL_META),

                               Character.valueOf('E'),
                               new ItemStack(ModItems.miscItems, 1, ENDER_CRYSTAL_META)
        });

        crafting.addRecipe(new ItemStack(ModBlocks.dimensionalPocket, 4), 
                new Object[] { "#E#",
                               "IDI",
                               "#N#",
            
                               Character.valueOf('#'),
                               new ItemStack(Block.stoneBrick, 1, 0),
            
                               Character.valueOf('I'),
                               Block.blockIron,
            
                               Character.valueOf('D'),
                               Block.blockDiamond,
            
                               Character.valueOf('N'),
                               new ItemStack(ModItems.miscItems, 1, NETHER_CRYSTAL_META),
            
                               Character.valueOf('E'),
                               new ItemStack(ModItems.miscItems, 1, ENDER_CRYSTAL_META)
        });
        
        crafting.addRecipe(new ItemStack(ModItems.miscItems,1,NETHER_CRYSTAL_META),
                new Object[] { "TTT",
                               "TRT",
                               "TTT",

                               Character.valueOf('T'),
                               Item.ghastTear,

                               Character.valueOf('R'),
                               Block.blockRedstone
        });
        
        crafting.addRecipe(new ItemStack(ModItems.miscItems,1,ENDER_CRYSTAL_META),
                new Object[] { "EEE",
                               "EGE",
                               "EEE",

                               Character.valueOf('E'),
                               Item.eyeOfEnder,

                               Character.valueOf('G'),
                               Block.glass
        });
        
        crafting.addShapelessRecipe(new ItemStack(ModItems.miscItems,1,INFO_BOOK_META),
                new Object[]{ Item.book, Item.leather
        });
        //@formatter:on
    }
}
