package com.rynstwrt.hubby.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static com.rynstwrt.hubby.Hubby.instance;
import static org.bukkit.ChatColor.*;

public class HubbyCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (args.length != 1 || !args[0].equalsIgnoreCase("reload")) return false;

		instance().reloadConfig();
		sender.sendMessage(AQUA + "" + BOLD + "[HUBBY] " + WHITE + "Reloaded config successfully!");

		return true;
	}

}
