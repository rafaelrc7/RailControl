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

    public void setShouldDamageCollidedEntity(boolean val) {
        config.set(basePath + "damage-collided-entity", val);
    }

    public boolean shouldDamagePassenger() {
        return config.getBoolean(basePath + "damage-passenger", false);
    }

    public void setShouldDamagePassenger(boolean val) {
        config.set(basePath + "damage-passenger", val);
    }

    public boolean shouldHaltMinecart() {
        return config.getBoolean(basePath + "halt-minecart", false);
    }

    public void setShouldHaltMinecart(boolean val) {
        config.set(basePath + "halt-minecart", val);
    }

}
