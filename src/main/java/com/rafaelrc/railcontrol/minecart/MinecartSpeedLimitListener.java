package com.rafaelrc.railcontrol.minecart;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

import java.util.Arrays;

public class MinecartSpeedLimitListener implements Listener {

    private static final BlockFace[] possibleSpeedSignPositions = {BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST, BlockFace.UP};

    @EventHandler
    public void onMinecartMove(VehicleMoveEvent event){
        Vehicle vehicle = event.getVehicle();

        if (!(vehicle instanceof Minecart minecart)) {
            return;
        }

        Block vehicleBlock = vehicle.getLocation().getBlock();
        Sign speedSign = (Sign)Arrays.stream(possibleSpeedSignPositions)
                            .map(face -> vehicleBlock.getRelative(face).getState())
                            .filter(block -> block instanceof Sign s && s.getLine(0).strip().equalsIgnoreCase("[SPEED LIMIT]"))
                            .findFirst().orElse(null);

        if (speedSign == null) {
            return;
        }

        for (String line : speedSign.getLines()) {
            switch (line.strip().toLowerCase()) {
                case "normal", "default" -> {
                    minecart.setSlowWhenEmpty(true);
                    minecart.setMaxSpeed(0.4);
                }

                case "auto"              -> minecart.setSlowWhenEmpty(false);
                case "no auto", "noauto" -> minecart.setSlowWhenEmpty(true);

                case "limited speed", "limited", "slow down"    -> minecart.setMaxSpeed(0.4);
                case "no limit", "nolimit"                      -> minecart.setMaxSpeed(10);

                default -> {
                    try {
                        double maxSpeed = Double.parseDouble(line);
                        if (maxSpeed > 0) {
                            minecart.setMaxSpeed(maxSpeed);
                        }
                    } catch (NumberFormatException ignored) { }
                }
            }
        }

    }

}
