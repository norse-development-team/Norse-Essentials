package me.TheFallen.norseessentials.commands;

import org.bukkit.GameMode;
		import org.bukkit.entity.Player;
		import org.mineacademy.fo.command.SimpleCommand;

public class Adventure extends SimpleCommand {

	public Adventure() {
		super("adventure|a|gm3");
		setPermission("ne.gamemode.adventure");
	}

	@Override
	public void onCommand() {

		checkConsole();
		Player player = getPlayer();

		hasPerm("ne.gamemode.adventure");
		hasPerm("ne.gamemode.*");
		player.setGameMode(GameMode.ADVENTURE);
		tell("&eYou are now in Adventure Mode!");


	}
}