package com.rynstwrt.hubby;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Hubby extends JavaPlugin {

    private static Logger log;
    private static PluginManager pm;
    private static FileConfiguration config;

    @Override
    public void onEnable() {
        new Events(this);
        log = Logger.getLogger("Minecraft");
        pm = this.getServer().getPluginManager();

        /*pm.addPermission(new Permission("hubby.use"));
        pm.addPermission(new Permission("hubby.reload"));
        pm.addPermission(new Permission("hubby.bypass");
        */

        if (!getConfig().contains("chatprefix")) {
            getConfig().addDefault("chatprefix", ChatColor.AQUA + "Server " + ChatColor.GRAY + "» ");
        }

        if (!getConfig().contains("hubworld")) {
            getConfig().addDefault("hubworld", this.getServer().getWorlds().get(0).getName());
        }

        if (!getConfig().contains("teleport.sendteleportmessage")) {
            getConfig().addDefault("teleport.sendteleportmessage", true);
        }

        if (!getConfig().contains("teleport.spawnteleportmessage")) {
            getConfig().addDefault("teleport.spawnteleportmessage", ChatColor.GREEN + "You have been teleported back to spawn!");
        }

        if (!getConfig().contains("teleport.hubteleportmessage")) {
            getConfig().addDefault("teleport.hubteleportmessage", ChatColor.GREEN + "You have been teleported back to the lobby!");
        }

        saveConfig();

        getCommand("hub").setExecutor(new CommandHub(this));
        getCommand("spawn").setExecutor(new CommandSpawn(this));
        getCommand("hubby").setExecutor(new CommandHubby(this));
        getCommand("htp").setExecutor(new CommandHubby(this));

    }

    @Override
    public void onDisable() {

    }


}
