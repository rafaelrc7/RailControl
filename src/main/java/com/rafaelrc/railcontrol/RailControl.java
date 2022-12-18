package com.rafaelrc.railcontrol;

import com.rafaelrc.railcontrol.listener.minecart.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class RailControl extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new MinecartCollisionListener(), this);
        pluginManager.registerEvents(new MinecartSpeedLimitListener(), this);
    }

}
