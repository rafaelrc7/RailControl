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

    public void setDefault(double val) {
        config.set(basePath + "default", val);
    }

    public double getMaximum() {
        return config.getDouble(basePath + "maximum", 4.0);
    }

    public void setMaximum(double val) {
        config.set(basePath + "maximum", val);
    }

    public boolean isMaximumEnforced() {
        return config.getBoolean(basePath + "enforce-maximum", false);
    }

    public void setIsMaximumEnforced(boolean val) {
        config.set(basePath + "enforce-maximum", val);
    }

}
