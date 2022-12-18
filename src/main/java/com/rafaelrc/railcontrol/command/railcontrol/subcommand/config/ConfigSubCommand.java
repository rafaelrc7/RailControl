package com.rafaelrc.railcontrol.command.railcontrol.subcommand.config;

import com.rafaelrc.railcontrol.RailControl;
import com.rafaelrc.railcontrol.command.subcommand.SubCommandExecutor;
import com.rafaelrc.railcontrol.command.subcommand.SubCommandManager;
import org.bukkit.command.CommandSender;

public class ConfigSubCommand implements SubCommandExecutor {

    private static final String permission = "railcontrol.railcontrol.config";

    private final SubCommandManager subCommandManager = new SubCommandManager();
    private final RailControl plugin;


    public ConfigSubCommand(RailControl plugin) {
        this.plugin = plugin;

        subCommandManager.registerSubCommand("set", new ConfigSetSubCommand(plugin));
        subCommandManager.registerSubCommand("get", new ConfigGetSubCommand(plugin));
    }


    @Override
    public boolean onCommand(CommandSender sender, String label, String subLabel, String[] args) {
        return false;
    }

    @Override
    public String getPermission() {
        return permission;
    }

}
