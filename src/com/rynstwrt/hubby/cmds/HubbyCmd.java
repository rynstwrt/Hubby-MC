package com.rynstwrt.hubby.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static com.rynstwrt.hubby.Hubby.instance;
import static com.rynstwrt.hubby.struct.Constants.CONFIG_RELOAD_MSG;
import static com.rynstwrt.hubby.struct.Constants.NO_PERM_MSG;

public class HubbyCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

	    if (!sender.hasPermission("hubby.reload")) {
	        sender.sendMessage(NO_PERM_MSG);
	        return true;
        }

		if (args.length != 1 || !args[0].equalsIgnoreCase("reload")) return false;

		instance().reloadConfig();
		sender.sendMessage(CONFIG_RELOAD_MSG);

		return false;
	}

}
