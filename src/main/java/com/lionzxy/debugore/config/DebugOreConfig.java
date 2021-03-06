package com.lionzxy.debugore.config;

import com.lionzxy.debugore.tile.DebugOreTileEntity;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by nikit on 07.08.2015.
 */
public class DebugOreConfig {
    public static Configuration config;

    public static boolean smartMod;
    public static int blockPerTick;
    public static boolean glassWall;
    public static Block wallBlock;
    public static int toNext;
    public static boolean allNow;


    public static void Init(){
        File configFile = new File(Loader.instance().getConfigDir(), "DebugOre.cfg");
        config = new Configuration(configFile,"1.0.3");
        config.load();
        readConfig();
    }

    public static void readConfig(){
        smartMod = config.getBoolean("Smart Mod", "general", true, "This mod use oreDictionary for check ore block. Ex. oreIron not break, but plank break");
        blockPerTick = config.getInt("Block per Tick", "general", 1000, 1, 99999999, "How many break block per Tick");
        glassWall = config.getBoolean("Glass Wall", "general", true, "Enable or disable glass wall");
        wallBlock = Block.getBlockFromName(config.getString("Wall Block", "general", "minecraft:glass", ""));
        toNext = config.getInt("This radius *","general", 2, 1, 1000,"On click : Radius * This value = Radius");
        allNow = config.getBoolean("All Delete","general",true,"");
        if(!smartMod)
            for(String i : config.getStringList("Only dig block","general",new String[]{"minecraft:dirt","minecraft:stone"},""))
                DebugOreTileEntity.onlyDigList.add(Block.getBlockFromName(i));
        if(config.hasChanged())
            config.save();}

}
