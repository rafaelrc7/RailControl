package com.rafaelrc.railcontrol.listener.speedsign;

import com.rafaelrc.railcontrol.RailControl;
import com.rafaelrc.railcontrol.config.MinecartSpeedConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignPlacementListener implements Listener {

    private static final String placePermission = "railcontrol.speedsign";
    private static final String autoPermission = "railcontrol.speedsign.auto";

    private final MinecartSpeedConfig speedConfig;


    public SignPlacementListener(RailControl plugin) {
        this.speedConfig = plugin.getPluginConfig().getMinecartSpeed();
    }


    @EventHandler
    public void onSpeedSignPlacement(SignChangeEvent event) {
        Player player = event.getPlayer();
        String[] lines = event.getLines();

        // TODO: Make sign label configurable and set in on place
        if (lines.length == 0 || !lines[0].strip().equalsIgnoreCase("[SPEED LIMIT]")) {
            return;
        }

        if (!player.hasPermission(placePermission)) {
            event.setLine(0, "Not allowed!");
            return;
        }

        // TODO: Make strings configurable and set in one place
        for (int i = 1; i < lines.length; ++i) {
            String line = lines[i].strip().toLowerCase();
            switch (line) {
                case "auto", "no auto", "noauto" -> {
                    if (!player.hasPermission(autoPermission)) {
                        event.setLine(i, "Not allowed!");
                    }
                }

                case "normal", "default", "limited speed", "limited", "slow down", "no limit", "nolimit" -> {
                    if (!player.hasPermission(placePermission)) {
                        event.setLine(i, "Not allowed!");
                    }
                }

                default -> {
                    try {
                        double maxSpeed = Double.parseDouble(line);
                        if (!player.hasPermission(placePermission)) {
                            event.setLine(i, "Not allowed!");
                            continue;
                        }
                        if (!(maxSpeed > 0 && (!speedConfig.isMaximumEnforced() || maxSpeed <= speedConfig.getMaximum()))) {
                            event.setLine(i, "Invalid Speed!");
                        }
                    } catch (NumberFormatException ignored) { /* ignore line */ }
                }
            }
        }
    }

}
