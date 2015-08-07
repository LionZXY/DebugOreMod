package com.lionzxy.debugore.config;

import com.lionzxy.debugore.DebugOreMod;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by nikit on 07.08.2015.
 */
public class ConfigHandler {

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        System.out.print(1);
        if(event.modID.equals(DebugOreMod.modid)){
            DebugOreConfig.readConfig();
        }
    }
}
