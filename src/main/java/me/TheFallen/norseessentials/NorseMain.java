package me.TheFallen.norseessentials;

import me.TheFallen.norseessentials.commands.*;
import me.TheFallen.norseessentials.commands.homes.delhome;
import me.TheFallen.norseessentials.commands.homes.home;
import me.TheFallen.norseessentials.commands.homes.homes;
import me.TheFallen.norseessentials.commands.homes.sethome;
import me.TheFallen.norseessentials.events.PlayerListener;
import me.TheFallen.norseessentials.utils.Resources;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

public class NorseMain extends SimplePlugin {

	private Resources resources;

	public NorseMain() {
		resources = new Resources(this);
	}

	@Override
	protected void onPluginStart() {
		//Load Resources
		resources.load();

		//Registering Commands
		//----------Homes---------//
		registerCommand(new home(resources));
		registerCommand(new homes(resources));
		registerCommand(new sethome(resources));
		registerCommand(new delhome(resources));

		//----------GMC---------//
		registerCommand(new Creative());
		registerCommand(new Survival());
		registerCommand(new Adventure());
		registerCommand(new Spectator());

		//----------dback---------//
		registerCommand(new DeathBackCommand());

		//Registering Events
		//----------Homes---------//
		registerEvents(new PlayerListener());

		//----------GMC---------//


		Common.log("&2Norse Essentials is initializing!");
		Common.log("&2*********           Norse Essentials has Loaded          *********");
		Common.log("&2*******                Author: The Fallen                  *******");
		Common.log("&2*****                Norse Development Team                  *****");

	}

	@Override
	protected void onPluginStop() {
		//save resources
		resources.save();
	}
}
