package com.lionzxy.debugore;

import com.lionzxy.debugore.blocks.DebugOreBlock;
import com.lionzxy.debugore.config.ConfigHandler;
import com.lionzxy.debugore.config.DebugOreConfig;
import com.lionzxy.debugore.tile.DebugOreTileEntity;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by nikit on 06.08.2015.
 */
@Mod(modid = "debugore", name = "Debug Ore Mod", version = "1.0", guiFactory = "com.lionzxy.debugore.config.ConfigGuiFactory")
public class DebugOreMod {
    public static final String modid = "debugore";
    public static Block debugoreblock;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        MinecraftForge.EVENT_BUS.register(new ConfigHandler());
        DebugOreConfig.Init();
        debugoreblock = new DebugOreBlock().setCreativeTab(CreativeTabs.tabBlock).setBlockName("debugblock").setBlockTextureName("debugore:debugore");
        GameRegistry.registerBlock(debugoreblock, "debugblock");
        GameRegistry.registerTileEntity(DebugOreTileEntity.class, "TileDebugBlock");
    }

}
