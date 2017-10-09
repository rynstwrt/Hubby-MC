package com.rynstwrt.hubby.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.rynstwrt.hubby.Hubby.config;


public class PlayerListener implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void onJoin(PlayerJoinEvent event) {

		Player player = event.getPlayer();
		Location location = Bukkit.getWorld(config().hubWorldName()).getSpawnLocation();

		if (!player.hasPermission("hubby.bypass")) player.teleport(location);
	}

}
