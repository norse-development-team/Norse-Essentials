package me.TheFallen.norseessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.ArrayList;

public class Fly extends SimpleCommand {

	public Fly() {
		super("fly|f");
		setPermission("ne.fly");
		setUsage("<Target Player>");
	}

	private ArrayList<String> HasFly = new ArrayList<>();

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();


		hasPerm("ne.fly");
		hasPerm("ne.gamemode.all");
		if (!HasFly.contains(player.getName())) {

			player.setAllowFlight(true);
			player.setFlying(true);

			tell(ChatColor.GREEN + "Flying Enabled.");

			HasFly.add(player.getName());

		}
		else{
			player.setFlying(false);
			player.setAllowFlight(false);


			tell(ChatColor.RED + "Flying Disabled.");

			HasFly.remove(player.getName());
		}
		if (!hasPerm("ngmc.fly")){
			tell(ChatColor.RED + "You do not have permission.");
		}


	}
}
