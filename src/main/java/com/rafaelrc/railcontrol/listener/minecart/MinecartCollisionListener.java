package com.rafaelrc.railcontrol.listener.minecart;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;

public class MinecartCollisionListener implements Listener {

    @EventHandler
    public void onVehicleEntityCollision(VehicleEntityCollisionEvent event) {
        Vehicle vehicle = event.getVehicle();

        if (!(vehicle instanceof Minecart minecart)) {
            return;
        }

        if (!(event.getEntity() instanceof LivingEntity hitEntity)) {
            return;
        }

        if (vehicle.getVelocity().length() <= 2.0) {
            return;
        }

        double maxSpeed = minecart.getMaxSpeed();

        if (maxSpeed <= 0.5) {
            return;
        }

        hitEntity.damage(maxSpeed*6, minecart);

        event.setCancelled(true);
        event.setCollisionCancelled(true);
    }

    @EventHandler
    public void onVehicleBlockCollision(VehicleBlockCollisionEvent event) {
        Vehicle vehicle = event.getVehicle();

        if (!(vehicle instanceof Minecart minecart)) {
            return;
        }

        if (vehicle.getVelocity().length() <= 2.0) {
            return;
        }

        double maxSpeed = minecart.getMaxSpeed();

        if (maxSpeed <= 0.5) {
            return;
        }

        vehicle.getPassengers().stream()
                .filter(e -> e instanceof LivingEntity)
                .forEach(e -> ((LivingEntity)e).damage(maxSpeed*6, minecart));
    }
}
