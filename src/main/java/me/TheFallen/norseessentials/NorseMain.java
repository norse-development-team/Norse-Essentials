package me.TheFallen.norseessentials;

import me.TheFallen.norseessentials.commands.*;
import me.TheFallen.norseessentials.events.PlayerListener;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

public class NorseMain extends SimplePlugin {


	@Override
	protected void onPluginStart() {


		//Registering Commands
		//----------Homes---------//
		registerCommand( new SetHomeCommand());
		registerCommand( new HomeCommand());
		registerCommand( new DeleteCommand());

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
}
