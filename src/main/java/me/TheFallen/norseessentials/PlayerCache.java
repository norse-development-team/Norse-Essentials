package me.TheFallen.norseessentials;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.mineacademy.fo.settings.YamlSectionConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Getter
public class PlayerCache extends YamlSectionConfig {
	private static Map<UUID, PlayerCache> cacheMap = new HashMap<>();

	private Location deathlocation;


	public PlayerCache(String uuid) {
		super(uuid);

		loadConfiguration(null, "data.db");
	}


	@Override
	protected void onLoadFinish() {
		if (isSet("DBackLocation"))
			deathlocation = getLocation("DBackLocation");
		//work with this
	}


	//-----------Death Back---------------//

	public void setDeathloc(Location dloc) {
		deathlocation = dloc;

		save("Death", dloc);
	}


	public static PlayerCache getCache(UUID player) {
		PlayerCache cache = cacheMap.get(player);

		if (cache == null){
			cache = new PlayerCache(player.toString());

			cacheMap.put(player, cache);
		}

		return cache;
	}

}
