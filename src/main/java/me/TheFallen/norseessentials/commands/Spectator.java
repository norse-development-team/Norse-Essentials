package me.TheFallen.norseessentials.commands;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class Spectator extends SimpleCommand {

	public Spectator() {
		super("spectator|sp|gm2");
		setPermission("ne.gamemode.spectator");

	}

	@Override
	public void onCommand() {

		checkConsole();
		Player player = getPlayer();

		hasPerm("ne.gamemode.spectator");
		hasPerm("ne.gamemode.*");
		player.setGameMode(GameMode.SPECTATOR);
		tell("&eYou are now in Spectator Mode!");


	}
}
