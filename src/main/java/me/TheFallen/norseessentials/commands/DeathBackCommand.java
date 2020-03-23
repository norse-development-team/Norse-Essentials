package me.TheFallen.norseessentials.commands;

import me.TheFallen.norseessentials.PlayerCache;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class DeathBackCommand extends SimpleCommand {


	public DeathBackCommand() {
		super("dback");
		//setPermission("ne.dback");
	}

	@Override
	protected void onCommand() {

		checkConsole();

		//hasPerm("ne.dback");
		//hasPerm("ne.default*");

		Player player = getPlayer();
		final PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
		final Location deathLocation = cache.getDeathlocation();


		if (deathLocation != null);
		player.teleport(deathLocation);

	}

}
