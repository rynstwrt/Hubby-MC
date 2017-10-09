package com.rynstwrt.hubby;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHub implements CommandExecutor {

    private Hubby plugin;

    public CommandHub(Hubby plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!command.getName().equalsIgnoreCase("hub")) {
            return false;
        }

        if (!(commandSender instanceof Player)) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "[HUBBY] " + ChatColor.RED + "ERROR: This command must be run by an in-game player!");
            return true;
        }

        Player plr = (Player) commandSender;
        plr.teleport(plugin.getServer().getWorld(plugin.getConfig().getString("hubworld")).getSpawnLocation());
        if (plugin.getConfig().getBoolean("teleport.sendteleportmessage")) {
            plr.sendMessage(plugin.getConfig().getString("chatprefix") + plugin.getConfig().getString("teleport.hubteleportmessage"));
        }

        return true;
    }
}
