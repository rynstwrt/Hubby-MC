package com.rynstwrt.hubby;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class Events implements Listener {

    Plugin plugin;

    Events(Hubby plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void plrJoined(PlayerJoinEvent e) {
        e.getPlayer().teleport(plugin.getServer().getWorld(plugin.getConfig().getString("hubworld")).getSpawnLocation());
    }


}
