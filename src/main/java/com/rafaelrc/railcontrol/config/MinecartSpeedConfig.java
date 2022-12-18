package com.rafaelrc.railcontrol.config;

import org.bukkit.configuration.file.FileConfiguration;

public class MinecartSpeedConfig {

    private static final String basePath = "minecart-speed.";

    private final FileConfiguration config;


    public MinecartSpeedConfig(FileConfiguration config) {
        this.config = config;
    }


    public double getDefault() {
        return config.getDouble(basePath + "default", 0.4);
    }

    public double getMaximum() {
        return config.getDouble(basePath + "maximum", 4.0);
    }

    public boolean isMaximumEnforced() {
        return config.getBoolean(basePath + "enforce-maximum", false);
    }

}
