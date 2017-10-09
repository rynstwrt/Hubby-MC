# Hubby-MC <img src="https://minecraft.gamepedia.com/media/minecraft.gamepedia.com/c/ca/Enchantment_Table.png" width=50>
Minecraft server hub plugin using already-existing world spawns (set in config, multiverse, or essentials).

# Commands:
* /spawn
  * Returns a player to **that world's** spawn.
* /hub
  * Returns a player to the **global** spawn.
* /hubby reload
  * Reloads config.
* /hubby tp
  * Teleports a player to a specified world.
* /htp
  * Alternative to /hubby tp.
  
# Config:
```YAML
chatprefix: '§bServer §7» '
hubworld: world
teleport:
  sendteleportmessage: true
  spawnteleportmessage: §fYou have been teleported back to spawn!
  hubteleportmessage: §fYou have been teleported back to the lobby!
```

# Permissions:
* `hubby.use` Allows the commands /spawn and /hub.
* `hubby.reload` Allows the command /hubby reload
* `hubby.bypass` Permitted players aren't teleported to hub on join.
* `hubby.*` All of the above.
