package com.rafaelrc.railcontrol.command.subcommand;

import org.bukkit.command.CommandSender;

public interface SubCommandExecutor {

    boolean onCommand(CommandSender sender, String label, String subLabel, String[] args);
    String getPermission();

}
