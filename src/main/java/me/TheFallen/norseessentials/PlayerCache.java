package me.TheFallen.norseessentials;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mineacademy.fo.settings.YamlSectionConfig;

import java.util.HashMap;
import java.util.Map;


@Getter
public class PlayerCache extends YamlSectionConfig {
	private static Map<Player, PlayerCache> cacheMap = new HashMap<>();

	private Location deathlocation;


	public PlayerCache(String uuid) {
		super(uuid);

		loadConfiguration(null, "data.db");
	}


	@Override
	protected void onLoadFinish() {
		if (isSet("DBLoc"))
			deathlocation = getLocation("DBLoc");
		//work with this
	}


	//-----------Death Back---------------//

	public void setDloc(Location dloc) {
		deathlocation = dloc;

		save("Death", dloc);
	}


	public static PlayerCache getCache(Player player) {
		PlayerCache cache = cacheMap.get(player);

		if (cache == null){
			cache = new PlayerCache(player.toString());

			cacheMap.put(player, cache);
			cacheMap.remove(player, cache);
		}

		return cache;
	}

	public Location getDloc(Location dloc) {
		return this.deathlocation;

	}

}
