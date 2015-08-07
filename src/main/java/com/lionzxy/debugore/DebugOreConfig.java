package com.lionzxy.debugore;

import cpw.mods.fml.common.Loader;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by nikit on 07.08.2015.
 */
public class DebugOreConfig {
    public static Configuration config;

    public static boolean smartMod;

    public static void Init(){
        File configFile = new File(Loader.instance().getConfigDir(), "DebugOre.cfg");
        config = new Configuration(configFile,"0.1");
        config.load();
        readConfig();
    }

    public static void readConfig(){
        config.load();
        smartMod = config.getBoolean("Smart Mod","general",true,"This mod use oreDictionary for check ore block. Ex. oreIron not break, but plank break");
    }
}
