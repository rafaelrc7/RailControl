package com.rafaelrc.railcontrol.command.railcontrol.subcommand.config;

import com.rafaelrc.railcontrol.RailControl;
import com.rafaelrc.railcontrol.command.subcommand.SubCommandExecutor;
import com.rafaelrc.railcontrol.command.util.ErrorMessages;
import org.bukkit.command.CommandSender;

class ConfigGetSubCommand implements SubCommandExecutor {

    private static final String permission = "railcontrol.railcontrol.config.get";
    private static final String usageArgs = "<key>";

    private final RailControl plugin;


    public ConfigGetSubCommand(RailControl plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, String label, String subLabel, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(ErrorMessages.usage(label, subLabel, usageArgs));
            return false;
        }

        sender.sendMessage(plugin.getConfig().get(args[0], "Unset option").toString());

        return true;
    }

    @Override
    public String getPermission() {
        return permission;
    }

}
