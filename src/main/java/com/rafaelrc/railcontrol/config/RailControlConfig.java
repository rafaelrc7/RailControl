package com.rafaelrc.railcontrol.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class RailControlConfig {

    private final JavaPlugin plugin;
    private final FileConfiguration config;

    private final MinecartSpeedConfig minecartSpeedConfig;
    private final MinecartCollisionConfig minecartCollisionConfig;


    public RailControlConfig(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        config = plugin.getConfig();

        minecartSpeedConfig = new MinecartSpeedConfig(config);
        minecartCollisionConfig = new MinecartCollisionConfig(config);
    }


    public void save() {
        plugin.saveConfig();
    }

    public MinecartSpeedConfig getMinecartSpeed() {
        return minecartSpeedConfig;
    }

    public MinecartCollisionConfig getMinecartCollision() {
        return minecartCollisionConfig;
    }

}
