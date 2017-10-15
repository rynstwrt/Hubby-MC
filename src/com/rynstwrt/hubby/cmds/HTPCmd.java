package com.rynstwrt.hubby.cmds;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.rynstwrt.hubby.Hubby.config;
import static com.rynstwrt.hubby.struct.Constants.*;
import static org.bukkit.Bukkit.*;
import static org.bukkit.ChatColor.AQUA;
import static org.bukkit.ChatColor.GREEN;

public class HTPCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (args.length < 1 || args.length > 2) return false;

		if (!(sender instanceof Player) && args.length == 1) {
			sender.sendMessage(NOT_PLAYER_MSG);
			return false;
		}

		Player target = args.length == 1 ? (Player) sender : getPlayer(args[0]);
		if (target == null) return false;



		    if (!sender.hasPermission("hubby.tp.self")) {
		        sender.sendMessage(NO_PERM_MSG);
		        return true;
            }

			Player player = (Player) sender;
			World selectedWorld = getWorld(args[0]);

			if (selectedWorld == null) {
				player.sendMessage(WORLD_NOT_FOUND_MSG);
				return true;
			} else {
				player.teleport(selectedWorld.getSpawnLocation());
			}

			if (!config().sendTeleportMsg()) return false;

			player.sendMessage(config().prefix() + GREEN + "You have been teleported to the world " + AQUA + args[0] + GREEN + ".");



		if (!sender.hasPermission("hubby.tp.others")) {
			sender.sendMessage(NO_PERM_MSG);
			return true;
		}



		if (getWorld(args[1]) == null) {
			sender.sendMessage(WORLD_NOT_FOUND_MSG);
			return true;
		}

		getServer().getPlayer(args[0]).teleport(getServer().getWorld(args[1]).getSpawnLocation());

		if (!config().sendTeleportMsg()) return true;

		sender.sendMessage(config().prefix() + GREEN + "Successfully teleported player " + AQUA + plr.getName() + GREEN + ".");
		plr.sendMessage(config().prefix() + GREEN + "You have been teleported to the world " + AQUA + args[1] + GREEN + ".");

		return true;
	}

}
