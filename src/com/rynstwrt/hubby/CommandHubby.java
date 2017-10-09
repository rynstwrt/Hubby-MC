package com.rynstwrt.hubby;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHubby implements CommandExecutor{

    private Hubby plugin;

    public CommandHubby(Hubby plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!command.getName().equalsIgnoreCase("hubby")) {
            return false;
        }

        if (strings.length != 1 || !strings[0].equalsIgnoreCase("reload")) {
            commandSender.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "[HUBBY] " + ChatColor.RED + "ERROR: Invalid arguments! Did you mean /hubby reload?");
            return true;
        }

        plugin.reloadConfig();
        commandSender.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "[HUBBY] " + ChatColor.WHITE + "Reloaded config successfully!");

        return true;
    }
}
