package com.rynstwrt.hubby.cmds;

import com.rynstwrt.hubby.struct.Constants;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.rynstwrt.hubby.Hubby.config;
import static org.bukkit.Bukkit.getOnlinePlayers;
import static org.bukkit.Bukkit.getServer;
import static org.bukkit.Bukkit.getWorld;
import static org.bukkit.ChatColor.AQUA;
import static org.bukkit.ChatColor.GREEN;

public class HTPCmd implements CommandExecutor {

	@SuppressWarnings( "deprecation" )

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (args.length < 1 || args.length > 2) {
			sender.sendMessage(Constants.HTP_HELP_MSG);
			return false;
		}

		if (!(sender instanceof Player) && args.length == 1) {
			sender.sendMessage(Constants.NOT_PLAYER_MSG);
			return false;
		}

		if (args.length == 1) {

		    if (!sender.hasPermission("hubby.tp.self")) {
		        sender.sendMessage(Constants.NO_PERM_MSG);
		        return false;
            }

			Player plr = (Player) sender;
			World selectedWorld = getWorld(args[0]);

			if (selectedWorld == null) {
				plr.sendMessage(Constants.WORLD_NOT_FOUND_MSG);
				return false;
			} else {
				plr.teleport(selectedWorld.getSpawnLocation());
			}

			if (!config().sendTeleportMsg()) return false;

			plr.sendMessage(config().prefix() + GREEN + "You have been teleported to the world " + AQUA + args[0] + GREEN + ".");

		} else {

            if (!sender.hasPermission("hubby.tp.others")) {
                sender.sendMessage(Constants.NO_PERM_MSG);
                return false;
            }

            boolean playerFound = false;
			Player plr = null;

			for (Object player : getOnlinePlayers().toArray()) {
				plr = (Player) player;

				if (plr.getName().equalsIgnoreCase(args[0])) {
					playerFound = true;
				}
			}

			if (!playerFound) {
				sender.sendMessage(Constants.PLAYER_NOT_FOUND_MSG);
				return false;
			}

			if (getWorld(args[1]) == null) {
				sender.sendMessage(Constants.WORLD_NOT_FOUND_MSG);
			}

			getServer().getPlayer(args[0]).teleport(getServer().getWorld(args[1]).getSpawnLocation());

			if (!config().sendTeleportMsg()) return false;

			sender.sendMessage(config().prefix() + GREEN + "Successfully teleported player " + AQUA + plr.getName() + GREEN + ".");
			plr.sendMessage(config().prefix() + GREEN + "You have been teleported to the world " + AQUA + args[1] + GREEN + ".");
		}

		return true;
	}

}
