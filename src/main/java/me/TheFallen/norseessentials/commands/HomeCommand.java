package me.TheFallen.norseessentials.commands;

import me.TheFallen.norseessentials.PlayerCache;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class HomeCommand extends SimpleCommand {

	public HomeCommand() {
		super("home");
		setPermission("ne.home");
		setMinArguments(1);
		setUsage("<name>" );
	}

	@Override
	protected void onCommand() {

		checkConsole();

		final Player player = getPlayer();
		final PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
		/* Set new home
		final Location newHomeLocation = player.getLocation();

		cache.setHomeLocation(newHomeLocation);
		tell("You have set the location to: " + Common.shortLocation(newHomeLocation));
		*/

		final Location homeLocation = cache.getHomeLocation();

		//Perms must be in the onCommand method
		hasPerm("ne.home");
		hasPerm("ne.default");


		if (homeLocation == null) {
			Common.tell(player, "&cYou must set a home first");

		}else {
			player.teleport(homeLocation);

		}
	}


}