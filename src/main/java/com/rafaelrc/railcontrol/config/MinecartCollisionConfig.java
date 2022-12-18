package com.rafaelrc.railcontrol.config;

import org.bukkit.configuration.file.FileConfiguration;

public class MinecartCollisionConfig {

    private static final String basePath = "minecart-collision.";

    private final FileConfiguration config;

    private final MinecartBlockCollisionConfig minecartBlockCollisionConfig;
    private final MinecartEntityCollisionConfig minecartEntityCollisionConfig;


    public MinecartCollisionConfig(FileConfiguration config) {
        this.config = config;

        minecartBlockCollisionConfig = new MinecartBlockCollisionConfig(config);
        minecartEntityCollisionConfig = new MinecartEntityCollisionConfig(config);
    }


    public MinecartBlockCollisionConfig onBlock() {
        return minecartBlockCollisionConfig;
    }

    public MinecartEntityCollisionConfig onEntity() {
        return minecartEntityCollisionConfig;
    }

    public boolean isModified() {
        return config.getBoolean(basePath + "modify-collision", true);
    }

    public double getMinimumAffectedSpeed() {
        return config.getDouble(basePath + "minimum-affected-speed", 0.5);
    }

    public double getCollidedEntityDamageMultiplier() {
        return config.getDouble(basePath + "collided-entity-damage-multiplier", 6.0);
    }

    public double getPassengerDamageMultiplier() {
        return config.getDouble(basePath + "passenger-damage-multiplier", 6.0);
    }

}
