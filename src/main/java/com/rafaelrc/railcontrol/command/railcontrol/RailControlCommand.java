package com.rafaelrc.railcontrol.command.railcontrol;

import com.rafaelrc.railcontrol.RailControl;
import com.rafaelrc.railcontrol.command.railcontrol.subcommand.config.ConfigSubCommand;
import com.rafaelrc.railcontrol.command.subcommand.SubCommandExecutor;
import com.rafaelrc.railcontrol.command.subcommand.SubCommandManager;
import com.rafaelrc.railcontrol.command.util.ErrorMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class RailControlCommand implements CommandExecutor {

    private static final String permission = "railcontrol.railcontrol";

    private final RailControl plugin;
    private final SubCommandManager subCommandManager = new SubCommandManager();


    public RailControlCommand(RailControl plugin) {
        this.plugin = plugin;

        registerSubCommand("config", new ConfigSubCommand(plugin));
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission(permission)) {
            sender.sendMessage(ErrorMessages.missingPermissions(label, null));
            return false;
        }
        return subCommandManager.onSubCommand(sender, label, args);
    }

    public void registerSubCommand(String command, SubCommandExecutor subCommandExecutor) {
        subCommandManager.registerSubCommand(command, subCommandExecutor);
    }

}
