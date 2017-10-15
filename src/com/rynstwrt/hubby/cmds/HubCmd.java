package com.rynstwrt.hubby.cmds;

import com.rynstwrt.hubby.struct.Constants;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.rynstwrt.hubby.Hubby.config;
import static org.bukkit.Bukkit.getConsoleSender;
import static org.bukkit.Bukkit.getWorld;


public class HubCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			getConsoleSender().sendMessage(Constants.NOT_PLAYER_MSG);
			return true;
		}

		if (!sender.hasPermission("hubby.use")) {
		    sender.sendMessage(Constants.NO_PERM_MSG);
		    return true;
        	}

		Player player = (Player) sender;
		player.teleport(getWorld(config().hubWorldName()).getSpawnLocation());

		if (!config().sendTeleportMsg()) return true;

		player.sendMessage(config().prefix() + config().hubTeleportMsg());

		return true;
	}

}
