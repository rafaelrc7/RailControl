package com.rafaelrc.railcontrol.command.util;

import org.bukkit.ChatColor;

public class ErrorMessages {
    public static String usage(String label, String subLabel, String usage) {
        return ChatColor.RED + "Usage: /" + label + " " + subLabel + " " + usage;
    }

    public static String missingPermissions(String label, String subLabel) {
        return ChatColor.RED + (subLabel == null ? "Missing permissions to invoke " + label : "Missing permissions to invoke subcommand " + subLabel);
    }

    public static String invalidSubCommand(String label, String subLabel) {
        return ChatColor.RED + "Command " + label + " has no subcommand " + subLabel;
    }
}
