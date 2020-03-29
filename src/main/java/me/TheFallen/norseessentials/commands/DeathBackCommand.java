package me.TheFallen.norseessentials.commands;

import lombok.Getter;
import org.mineacademy.fo.command.SimpleCommand;

@Getter
public class DeathBackCommand extends SimpleCommand {


	public DeathBackCommand() {
		super("dback");
		//setPermission("ne.dback");
	}


	@Override
	protected void onCommand() {

		checkConsole();

		//hasPerm("ne.dback");




	}



}
