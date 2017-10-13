# Hubby-MC <img src="https://minecraft.gamepedia.com/media/minecraft.gamepedia.com/c/ca/Enchantment_Table.png" width=50>
Minecraft server hub plugin using already-existing world spawns (set in config, multiverse, or essentials).

# Commands:
* /spawn
  * Returns a player to **that world's** spawn.
* /hub
  * Returns a player to the **global** spawn.
* /hubby reload
  * Reloads config.
* /htp
  * Teleports a player to a specified world.
  
# Config:
```YAML
####################
#     Hubby-MC     #
####################

#What is said before the teleport messages.
prefix: "&bServer &7» "

#What world you want players to be teleported to when they type /hub.
hubWorldName: "world"


teleport:

  #if true, gives players a message when teleported.
  sendTeleportMessage: true

  #These messages are customizable.
  spawnTeleportMessage: "&aYou have been teleported back to spawn!"
  hubTeleportMessage: "&aYou have been teleported back to the lobby!"

```

# Permissions:
* `hubby.use` Allows the commands /spawn and /hub.
* `hubby.reload` Allows the command /hubby reload
* `hubby.bypass` Permitted players aren't teleported to hub on join.
* `hubby.tp.self` Allows players to teleport themselves to a specified world.
* `hubby.tp.others` Allows players to teleport other players to a specified world.
* `hubby.tp.*` Gives permission to both `hubby.tp.self` and `hubby.tp.others`.
* `hubby.*` All of the above.
