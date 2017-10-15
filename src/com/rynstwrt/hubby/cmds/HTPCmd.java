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

		if (args.length != 1 && args.length != 2) return false;


		if (!(sender instanceof Player) && args.length == 1) {
			sender.sendMessage(NOT_PLAYER_MSG);
			return true;
		}

		Player target = args.length == 1 ? (Player) sender : getPlayer(args[0]);
		if (target == null) return false;


		World world = args.length == 2 ? getWorld(args[0]) : target.getWorld();

		if (world == null) {
			target.sendMessage(WORLD_NOT_FOUND_MSG);
			return true;
		}


		if (!sender.hasPermission("hubby.tp.self") && sender == target) {
			sender.sendMessage(NO_PERM_MSG);
			return true;
		}

		if (!sender.hasPermission("hubby.tp.others") && sender != target) {
			sender.sendMessage(NO_PERM_MSG);
			return true;
		}

		target.teleport(world.getSpawnLocation());

		if (!config().sendTeleportMsg()) return false;

		if (sender != target) sender.sendMessage(config().prefix() + GREEN + "Successfully teleported player " + AQUA + target.getName() + GREEN + ".");

		target.sendMessage(config().prefix() + GREEN + "You have been teleported to the world " + AQUA + args[0] + GREEN + ".");

		return true;
	}

}
