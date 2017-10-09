package com.rynstwrt.hubby.utils;

import org.bukkit.ChatColor;

import static org.bukkit.ChatColor.translateAlternateColorCodes;


public class ChatUtils {

	public static String format(String text) { return translateAlternateColorCodes('&', text); }

	public static String stripColor(String text) { return ChatColor.stripColor(text); }

}
