package com.rynstwrt.hubby;

import com.rynstwrt.hubby.cmds.HTPCmd;
import com.rynstwrt.hubby.cmds.HubCmd;
import com.rynstwrt.hubby.cmds.HubbyCmd;
import com.rynstwrt.hubby.cmds.SpawnCmd;
import com.rynstwrt.hubby.configs.HubbyConfig;
import com.rynstwrt.hubby.listeners.PlayerListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Hubby extends JavaPlugin {

    private static Hubby instance;

    private static HubbyConfig config;

    @Override
    public void onLoad() { instance = this; }

    @Override
    public void onEnable() {

        saveDefaultConfig();
        config = HubbyConfig.from(getConfig());

        registerEvents(new PlayerListener());

        getCommand("hub").setExecutor(new HubCmd());
        getCommand("spawn").setExecutor(new SpawnCmd());
        getCommand("hubby").setExecutor(new HubbyCmd());
        getCommand("htp").setExecutor(new HTPCmd());

    }

    public static Hubby instance() { return instance; }

    public static HubbyConfig config() { return config; }

    private void registerEvents(Listener... listeners) {
        PluginManager pm = getServer().getPluginManager();
        Arrays.stream(listeners).forEach(it -> pm.registerEvents(it, instance));
    }

}