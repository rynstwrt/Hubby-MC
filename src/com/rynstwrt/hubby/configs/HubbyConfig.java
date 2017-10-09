package com.rynstwrt.hubby.configs;

import org.bukkit.configuration.file.FileConfiguration;

import static com.rynstwrt.hubby.utils.ChatUtils.format;


public class HubbyConfig {

	private final boolean sendTeleportMsg;

	private final String prefix, hubWorldName, spawnTeleportMsg, hubTeleportMsg;


	public HubbyConfig(boolean sendTeleportMsg, String prefix, String hubWorldName, String spawnTeleportMsg, String hubTeleportMsg) {
		this.prefix = prefix;
		this.hubWorldName = hubWorldName;
		this.hubTeleportMsg = hubTeleportMsg;
		this.sendTeleportMsg = sendTeleportMsg;
		this.spawnTeleportMsg = spawnTeleportMsg;
	}


	public static HubbyConfig from(FileConfiguration config) {

		String chatPrefix = format(config.getString("prefix"));
		String hubWorldName = format(config.getString("hubWorldName"));
		String spawnTeleportMsg = format(config.getString("teleport.spawnTeleportMessage"));
		String hubTeleportMsg = format(config.getString("teleport.hubTeleportMessage"));

		boolean sendTeleportMsg = config.getBoolean("teleport.sendTeleportMessage");


		return new HubbyConfig(sendTeleportMsg, chatPrefix, hubWorldName, spawnTeleportMsg, hubTeleportMsg);
	}


	public String prefix() { return prefix; }

	public String hubWorldName() { return hubWorldName; }

	public String hubTeleportMsg() { return hubTeleportMsg; }

	public boolean sendTeleportMsg() { return sendTeleportMsg; }

	public String spawnTeleportMsg() { return spawnTeleportMsg; }

}
