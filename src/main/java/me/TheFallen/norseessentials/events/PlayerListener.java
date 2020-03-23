package me.TheFallen.norseessentials.events;

import com.Zrips.CMI.commands.list.back;
import me.TheFallen.norseessentials.PlayerCache;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;


public class PlayerListener implements Listener {


	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event) {

		final Player player = event.getPlayer();
		final PlayerCache cache = PlayerCache.getCache(player.getUniqueId());


	}

		public static HashMap<Player, Location> dlocation = new HashMap<Player, Location>();


		@EventHandler
		public void onDeath(PlayerDeathEvent event){

			final Player player = event.getEntity().getPlayer();
			final PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
			final Location newdlocation = player.getLocation();
			dlocation.put(player, player.getLocation());


			cache.setDeathlocation(newdlocation);

		}







}
