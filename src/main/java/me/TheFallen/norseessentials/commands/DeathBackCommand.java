package me.TheFallen.norseessentials.commands;

import lombok.Getter;
import me.TheFallen.norseessentials.PlayerCache;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

@Getter
public class DeathBackCommand extends SimpleCommand {


	public DeathBackCommand() {
		super("dback");
		//setPermission("ne.dback");
	}


	@Override
	protected void onCommand() {

		checkConsole();
		Player player = getPlayer();
		//hasPerm("ne.dback");

		PlayerCache cache = PlayerCache.getCache(player);
		cache.getDeathlocation();
	}



}
