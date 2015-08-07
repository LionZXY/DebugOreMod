package com.lionzxy.debugore;

import com.lionzxy.debugore.blocks.DebugOreBlock;
import com.lionzxy.debugore.tile.DebugOreTileEntity;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by nikit on 06.08.2015.
 */
@Mod(modid = "debugore", name = "Debug Ore Mod", version = "1.0")
public class DebugOreMod {
    public static Block debugoreblock;

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event){
        DebugOreConfig.Init();
        debugoreblock = new DebugOreBlock().setCreativeTab(CreativeTabs.tabBlock).setBlockName("debugblock").setBlockTextureName("debugore:debugore");
        GameRegistry.registerBlock(debugoreblock, "debugblock");
        GameRegistry.registerTileEntity(DebugOreTileEntity.class, "TileDebugBlock");
    }
}
