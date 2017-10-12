package com.rynstwrt.hubby.struct;

import static org.bukkit.ChatColor.*;

public class Constants {

	public static final String HUBBY_HELP_MSG = AQUA + "" + BOLD + "[HUBBY] " + RED + "ERROR: Invalid syntax. Try /hubby reload.";

	public static final String HTP_HELP_MSG = AQUA + "" + BOLD + "[HUBBY] " + RED + "ERROR: Invalid syntax. Try /htp <player> <world> or /htp <world>.";

	public static final String NOT_PLAYER_MSG = AQUA + "" + BOLD + "[HUBBY] " + RED + "ERROR: This command must be run by an in-game player, or use /htp <playername> <worldname> syntax!";

	public static final String PLAYER_NOT_FOUND_MSG = AQUA + "" + BOLD + "[HUBBY] " + RED + "ERROR: Specified player does not exist.";

	public static final String WORLD_NOT_FOUND_MSG = AQUA + "" + BOLD + "[HUBBY] " + RED + "ERROR: Specified world does not exist.";

	public static final String NO_PERM_MSG = RED + "You don't have permission to perform this command.";

	public static final String CONFIG_RELOAD_MSG = AQUA + "" + BOLD + "[HUBBY] " + GREEN + "Reloaded config successfully!";

}
