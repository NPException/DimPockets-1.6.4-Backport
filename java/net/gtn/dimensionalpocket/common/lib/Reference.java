package net.gtn.dimensionalpocket.common.lib;

public class Reference {

    public static final String MOD_ID = "dimensionalPockets";
    public static final String MOD_NAME = "Dimensional Pockets";
    public static final String VERSION = "bp_0.07";

    public static final String MOD_IDENTIFIER = MOD_ID + ":";

    public static final String CLIENT_PROXY_CLASS = "net.gtn.dimensionalpocket.client.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "net.gtn.dimensionalpocket.common.CommonProxy";

    public static final int DIMENSION_ID_DEFAULT = 33;
    public static int DIMENSION_ID;

    public static boolean SHOULD_SPAWN_WITH_BOOK;
    
    public static int BLOCK_ID_POCKET_DEFAULT = 3000;
    public static int BLOCK_ID_POCKET = -1;
    
    public static int BLOCK_ID_FRAME_DEFAULT = 3001;
    public static int BLOCK_ID_FRAME = -1;
    
    public static int ITEM_ID_MISC_ITEM_DEFAULT = 3010;
    public static int ITEM_ID_MISC_ITEM = -1;
}
