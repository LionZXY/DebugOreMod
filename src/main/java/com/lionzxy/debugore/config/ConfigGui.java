package com.lionzxy.debugore.config;

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

/**
 * Created by nikit on 07.08.2015.
 */
public class ConfigGui extends GuiConfig {
    public ConfigGui(GuiScreen parent) {
        super(parent,
                new ConfigElement(DebugOreConfig.config.getCategory("general")).getChildElements(),
                "Debug Ore Mod", false, false, GuiConfig.getAbridgedConfigPath(DebugOreConfig.config.toString()));
    }
}
