package me.TheFallen.norseessentials.commands;

import me.TheFallen.norseessentials.PlayerCache;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class DeleteCommand extends SimpleCommand {

	public DeleteCommand() {
		super("delhome");
		setPermission("ne.delhome");
		setMinArguments(1);
		setUsage("<name>" );
	}

	@Override
	protected void onCommand() {

		checkConsole();

		final Player player = getPlayer();
		final PlayerCache cache = PlayerCache.getCache(player.getUniqueId());

		//Perms must be in the onCommand method
		hasPerm("ne.delhome");
		hasPerm("ne.default");

		cache.setHomeLocation(null);

		Common.tell(player,"&4Your home has been deleted!");

	}
}

