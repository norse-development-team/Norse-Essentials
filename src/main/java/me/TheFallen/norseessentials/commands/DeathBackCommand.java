package me.TheFallen.norseessentials.commands;

import com.Zrips.CMI.commands.list.dback;
import com.Zrips.CMI.commands.list.util;
import jdk.nashorn.internal.ir.IfNode;
import lombok.Getter;
import me.TheFallen.norseessentials.utils.DBackUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.HashMap;

@Getter
public class DeathBackCommand extends SimpleCommand {

	DBackUtil plugin;


	public DeathBackCommand() {
		super("dback");
		//setPermission("ne.dback");
	}



	@EventHandler
	public void onDeath(PlayerDeathEvent event){
		plugin.setDBackLoc();
	}


	@Override
	protected void onCommand() {

		checkConsole();

		//hasPerm("ne.dback");

		plugin.getDbackLoc();
		plugin.



	}

	If



}
