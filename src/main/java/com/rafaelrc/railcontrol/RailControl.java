package com.rafaelrc.railcontrol;

import com.rafaelrc.railcontrol.command.railcontrol.RailControlCommand;
import com.rafaelrc.railcontrol.config.RailControlConfig;
import com.rafaelrc.railcontrol.listener.minecart.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class RailControl extends JavaPlugin {

    private final RailControlConfig config = new RailControlConfig(this);

    @Override
    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new MinecartCollisionListener(this), this);
        pluginManager.registerEvents(new MinecartSpeedLimitListener(this), this);

        Objects.requireNonNull(this.getCommand("railcontrol")).setExecutor(new RailControlCommand(this));
    }

    @Override
    public void onDisable() {
        config.save();
    }

    public RailControlConfig getPluginConfig() {
        return config;
    }

}
