package me.TheFallen.norseessentials.commands;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class Survival extends SimpleCommand {

	public Survival() {
		super("survival|s|gm0");
		setPermission("ne.gamemode.survival");
		setUsage("<Target Player>");
	}

	@Override
	public void onCommand() {

		checkConsole();
		Player player = getPlayer();

		hasPerm("ne.gamemode.survival");
		hasPerm("ne.gamemode.all");
		player.setGameMode(GameMode.SURVIVAL);
		tell("&eYou are now in Survival Mode!");
	}
}
