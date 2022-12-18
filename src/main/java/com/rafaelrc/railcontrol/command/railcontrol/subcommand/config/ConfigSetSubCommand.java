package com.rafaelrc.railcontrol.command.railcontrol.subcommand.config;

import com.rafaelrc.railcontrol.RailControl;
import com.rafaelrc.railcontrol.command.subcommand.SubCommandExecutor;
import com.rafaelrc.railcontrol.command.util.ErrorMessages;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

class ConfigSetSubCommand implements SubCommandExecutor {

    private static final String permission = "railcontrol.railcontrol.config.set";
    private static final String usageArgs = "<key> <value>";

    private final RailControl plugin;


    public ConfigSetSubCommand(RailControl plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, String label, String subLabel, String[] args) {
        if (args.length != 2) {
            sender.sendMessage(ErrorMessages.usage(label, subLabel, usageArgs));
            return false;
        }

        String key = args[0];
        String value = args[1];

        if (plugin.getConfig().isSet(key)) {
            sender.sendMessage(ChatColor.RED + "Invalid config option");
            return false;
        }

        plugin.getConfig().set(key, value);

        return true;
    }

    @Override
    public String getPermission() {
        return permission;
    }

}
