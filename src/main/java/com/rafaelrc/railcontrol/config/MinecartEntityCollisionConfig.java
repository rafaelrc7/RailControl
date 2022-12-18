package com.rafaelrc.railcontrol.config;

import org.bukkit.configuration.file.FileConfiguration;

public class MinecartEntityCollisionConfig {

    private static final String basePath = "minecart-collision.entity-collision.";

    private final FileConfiguration config;


    public MinecartEntityCollisionConfig(FileConfiguration config) {
        this.config = config;
    }


    public boolean shouldDamageCollidedEntity() {
        return config.getBoolean(basePath + "damage-collided-entity", true);
    }

    public boolean shouldDamagePassenger() {
        return config.getBoolean(basePath + "damage-passenger", false);
    }

    public boolean shouldHaltMinecart() {
        return config.getBoolean(basePath + "halt-minecart", false);
    }

}
