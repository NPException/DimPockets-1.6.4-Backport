package net.gtn.dimensionalpocket.common;

import net.gtn.dimensionalpocket.common.block.BlockDimensionalPocket;
import net.gtn.dimensionalpocket.common.block.BlockDimensionalPocketFrame;
import net.gtn.dimensionalpocket.common.core.config.ConfigHandler;
import net.gtn.dimensionalpocket.common.lib.Reference;
import net.gtn.dimensionalpocket.common.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Configuration;

public class ModBlocks {

    public static Block dimensionalPocket;
    public static Block dimensionalPocketFrame;
    
    public static void preInit() {
    	Reference.BLOCK_ID_POCKET = ConfigHandler.config.get(Configuration.CATEGORY_BLOCK, Strings.BLOCK_POCKET, -1).getInt();
    	if (Reference.BLOCK_ID_POCKET != -1)
    		dimensionalPocket = new BlockDimensionalPocket(Reference.BLOCK_ID_POCKET, Material.anvil, Strings.BLOCK_POCKET);
    	
    	Reference.BLOCK_ID_FRAME = ConfigHandler.config.get(Configuration.CATEGORY_BLOCK, Strings.BLOCK_POCKET_FRAME, -1).getInt();
    	if (Reference.BLOCK_ID_FRAME != -1)
    		dimensionalPocketFrame = new BlockDimensionalPocketFrame(Reference.BLOCK_ID_FRAME, Material.anvil, Strings.BLOCK_POCKET_FRAME);
    }

    public static void init() {
    	if (dimensionalPocket == null) {
    		ConfigHandler.config.get(Configuration.CATEGORY_BLOCK, Strings.BLOCK_POCKET, -1).set(Reference.BLOCK_ID_POCKET_DEFAULT);
    		dimensionalPocket = new BlockDimensionalPocket(Reference.BLOCK_ID_POCKET_DEFAULT, Material.anvil, Strings.BLOCK_POCKET);
    	}
    	if (dimensionalPocketFrame == null) {
    		ConfigHandler.config.get(Configuration.CATEGORY_BLOCK, Strings.BLOCK_POCKET_FRAME, -1).set(Reference.BLOCK_ID_FRAME_DEFAULT);
    		dimensionalPocketFrame = new BlockDimensionalPocket(Reference.BLOCK_ID_FRAME_DEFAULT, Material.anvil, Strings.BLOCK_POCKET_FRAME);
    	}
    }
}
