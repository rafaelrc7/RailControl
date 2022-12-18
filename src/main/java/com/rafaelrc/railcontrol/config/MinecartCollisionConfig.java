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

    public void setIsModified(boolean val) {
        config.set(basePath + "modify-collision", val);
    }

    public double getMinimumAffectedSpeed() {
        return config.getDouble(basePath + "minimum-affected-speed", 0.5);
    }

    public void setMinimumAffectedSpeed(double val) {
        config.set(basePath + "minimum-affected-speed", val);
    }

    public double getCollidedEntityDamageMultiplier() {
        return config.getDouble(basePath + "collided-entity-damage-multiplier", 6.0);
    }

    public void setCollidedEntityDamageMultiplier(double val) {
        config.set(basePath + "collided-entity-damage-multiplier", val);
    }

    public double getPassengerDamageMultiplier() {
        return config.getDouble(basePath + "passenger-damage-multiplier", 6.0);
    }

    public void setPassengerDamageMultiplier(double val) {
        config.set(basePath + "passenger-damage-multiplier", val);
    }

}
