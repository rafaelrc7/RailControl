package com.rafaelrc.railcontrol;

import com.rafaelrc.railcontrol.config.RailControlConfig;
import com.rafaelrc.railcontrol.listener.minecart.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class RailControl extends JavaPlugin {

    private final RailControlConfig config = new RailControlConfig(this);

    @Override
    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new MinecartCollisionListener(this), this);
        pluginManager.registerEvents(new MinecartSpeedLimitListener(this), this);
    }

    public RailControlConfig getPluginConfig() {
        return config;
    }

}
