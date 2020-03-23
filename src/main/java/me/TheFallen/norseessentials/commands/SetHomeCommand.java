package me.TheFallen.norseessentials.commands;

import me.TheFallen.norseessentials.PlayerCache;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class SetHomeCommand extends SimpleCommand {


	public SetHomeCommand() {
		super("sethome");
		setPermission("ne.sethome");
		setMinArguments(1);
		setUsage("<name>");
	}

	@Override
	protected void onCommand() {

		checkConsole();

		final Player player = getPlayer();
		final PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
		final Location newHomeLocation = player.getLocation();

		//Perms must be in the onCommand method
		hasPerm("ne.sethome");
		hasPerm("ne.default");

		//Sets new home
		cache.setHomeLocation(newHomeLocation);
		tell("&6You have set your home.");


	}
}