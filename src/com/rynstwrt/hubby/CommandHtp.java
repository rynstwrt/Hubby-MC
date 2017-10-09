package com.rynstwrt.hubby;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHtp implements CommandExecutor {

    private Hubby plugin;

    public CommandHtp(Hubby plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!command.getName().equalsIgnoreCase("htp")) {
            return false;
        }



        return true;
    }
}
