package me.TheFallen.norseessentials.commands;

import org.bukkit.GameMode;
		import org.bukkit.entity.Player;
		import org.mineacademy.fo.command.SimpleCommand;

public class Adventure extends SimpleCommand {

	public Adventure() {
		super("adventure|a|gm2");
		setPermission("norseessentials.gamemode.adventure");
		setUsage("<Target Player>");
	}

	@Override
	public void onCommand() {

		checkConsole();
		Player player = getPlayer();

		hasPerm("norseessentials.gamemode.adventure");
		hasPerm("norseessentials.gamemode.all");
		player.setGameMode(GameMode.ADVENTURE);
		tell("&eYou are now in Adventure Mode!");


	}
}