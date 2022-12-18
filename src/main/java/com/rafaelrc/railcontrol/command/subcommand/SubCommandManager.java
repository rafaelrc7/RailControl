package com.rafaelrc.railcontrol.command.subcommand;

import com.rafaelrc.railcontrol.command.util.ErrorMessages;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Hashtable;

public class SubCommandManager {
    private final Hashtable<String, SubCommandExecutor> subCommands = new Hashtable<>();

    public void registerSubCommand(String command, SubCommandExecutor subCommandExecutor) {
        subCommands.put(command, subCommandExecutor);
    }

    public boolean onSubCommand(CommandSender sender, String label, String[] args) {
        if (args == null || args.length == 0) {
            return false;
        }

        String subLabel = args[0];

        if (!subCommands.containsKey(subLabel)) {
            sender.sendMessage(ErrorMessages.invalidSubCommand(label, subLabel));
            return false;
        }

        SubCommandExecutor subCommandExecutor = subCommands.get(subLabel);

        String subCommandPermission = subCommandExecutor.getPermission();
        if (subCommandPermission != null && !sender.hasPermission(subCommandPermission)) {
            sender.sendMessage(ErrorMessages.missingPermissions(label, subLabel));
            return false;
        }

        return subCommandExecutor.onCommand(sender, label + " " + args[0], subLabel, Arrays.copyOfRange(args, 1, args.length));
    }
}
