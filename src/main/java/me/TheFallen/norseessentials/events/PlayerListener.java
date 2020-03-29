package me.TheFallen.norseessentials.events;

import lombok.Getter;
import me.TheFallen.norseessentials.PlayerCache;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

@Getter
public class PlayerListener implements Listener {


	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event) {


	}

	Location location = getLocation();

	@EventHandler
	public void onDeath(PlayerDeathEvent event){
		Player player = event.getEntity();

		PlayerCache cache = PlayerCache.getCache(player);
		cache.setDloc(location);

	}



	}
