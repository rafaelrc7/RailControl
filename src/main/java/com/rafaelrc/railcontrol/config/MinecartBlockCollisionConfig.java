package com.rafaelrc.railcontrol.config;

import org.bukkit.configuration.file.FileConfiguration;

public class MinecartBlockCollisionConfig {

    private static final String basePath = "minecart-collision.block-collision.";

    private final FileConfiguration config;


    public MinecartBlockCollisionConfig(FileConfiguration config) {
       this.config = config;
    }


    public boolean shouldDamagePassenger() {
        return config.getBoolean(basePath + "damage-passenger", true);
    }

    public void setShouldDamagePassenger(boolean val) {
        config.set(basePath + "damage-passenger", val);
    }

    public boolean shouldBreakMinecart() {
        return config.getBoolean(basePath + "break-minecart", false);
    }

    public void setShouldBreakMinecart(boolean val) {
        config.set(basePath + "break-minecart", val);
    }

}
