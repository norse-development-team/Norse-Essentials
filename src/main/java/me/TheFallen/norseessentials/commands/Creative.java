package me.TheFallen.norseessentials.commands;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class Creative extends SimpleCommand {

	public Creative() {
		super("creative|c|gm1");
		setPermission("ne.gamemode.creative");
	}

	@Override
	public void onCommand() {

		checkConsole();
		Player player = getPlayer();

		hasPerm("ne.gamemode.creative");
		hasPerm("ne.gamemode.*");
		player.setGameMode(GameMode.CREATIVE);
		tell("&eYou are now in Creative Mode!");

	}

}
