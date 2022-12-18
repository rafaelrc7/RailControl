package com.rafaelrc.railcontrol.listener.minecart;

import com.rafaelrc.railcontrol.RailControl;
import com.rafaelrc.railcontrol.config.MinecartCollisionConfig;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;

public class MinecartCollisionListener implements Listener {

    private final MinecartCollisionConfig config;


    public MinecartCollisionListener(RailControl plugin) {
        this.config = plugin.getPluginConfig().getMinecartCollision();
    }


    @EventHandler
    public void onVehicleEntityCollision(VehicleEntityCollisionEvent event) {
        if (!config.isModified()) {
            return;
        }

        Vehicle vehicle = event.getVehicle();

        if (!(vehicle instanceof Minecart minecart)) {
            return;
        }

        if (!(event.getEntity() instanceof LivingEntity collidedEntity)) {
            return;
        }

        if (vehicle.getVelocity().length() <= 2.0) {
            return;
        }

        double maxSpeed = minecart.getMaxSpeed();

        if (maxSpeed < config.getMinimumAffectedSpeed()) {
            return;
        }

        if (config.onEntity().shouldDamageCollidedEntity()) {
            collidedEntity.damage(maxSpeed * config.getCollidedEntityDamageMultiplier(), minecart);
        }

        if (config.onEntity().shouldDamagePassenger()) {
            vehicle.getPassengers().stream()
                    .filter(e -> e instanceof LivingEntity)
                    .forEach(e -> ((LivingEntity)e).damage(maxSpeed * config.getPassengerDamageMultiplier(), collidedEntity));
        }

        if (!config.onEntity().shouldHaltMinecart()) {
            event.setCancelled(true);
            event.setCollisionCancelled(true);
        }
    }

    @EventHandler
    public void onVehicleBlockCollision(VehicleBlockCollisionEvent event) {
        if (!config.isModified()) {
            return;
        }

        Vehicle vehicle = event.getVehicle();

        if (!(vehicle instanceof Minecart minecart)) {
            return;
        }

        if (vehicle.getVelocity().length() <= 2.0) {
            return;
        }

        double maxSpeed = minecart.getMaxSpeed();

        if (maxSpeed < config.getMinimumAffectedSpeed()) {
            return;
        }

        if (config.onBlock().shouldDamagePassenger()) {
            vehicle.getPassengers().stream()
                    .filter(e -> e instanceof LivingEntity)
                    .forEach(e -> ((LivingEntity)e).damage(maxSpeed * config.getPassengerDamageMultiplier()));
        }

        if (config.onBlock().shouldBreakMinecart()) {
            minecart.setDamage(minecart.getDamage() + maxSpeed * 3);
        }
    }
}
