package me.TheFallen.norseessentials.commands;

import lombok.Getter;
import me.TheFallen.norseessentials.NorseMain;
import org.bukkit.ChatColor;
import org.mineacademy.fo.command.SimpleCommand;

@Getter
public class VersionCommand extends SimpleCommand {

	public VersionCommand() {
		super("nev");


		setPermission("ne.version");
	}


	@Override
	protected void onCommand() {


		checkConsole();
		hasPerm("ne.version");


		NorseMain.getVersion();
		tell((ChatColor.GREEN + "-----------------------------------" +
				" " +
				ChatColor.GREEN + "Norse GameMode Changer " + NorseMain.getVersion() + " is now enabled." +
				" " +
				ChatColor.GREEN + "-----------------------------------"));


	}
}
