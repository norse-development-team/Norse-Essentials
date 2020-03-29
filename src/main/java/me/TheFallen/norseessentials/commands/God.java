package me.TheFallen.norseessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.ArrayList;

public class God extends SimpleCommand implements Listener {




	private ArrayList<String> HasGod = new ArrayList<>();


	public God() {
		super("god");
		setPermission("ne.god");
		setUsage("<Target Player>");
	}

	@Override
	protected void onCommand() {

		checkConsole();
		Player player = getPlayer();
		hasPerm("ne.god");
		hasPerm("ne.gamemode.all");

		if (!HasGod.contains(player.getName())){
			player.setInvulnerable(true);

			tell(ChatColor.GREEN + "God Mode Enabled.");

			HasGod.add(player.getName());


		}
		else{
			player.setInvulnerable(false);
			tell(ChatColor.RED + "God Mode Disabled.");
			HasGod.remove(player.getName());
		}
		if (!hasPerm("ngmc.god")){
			tell(ChatColor.RED + "You do not have permission.");

		}


	}

}

