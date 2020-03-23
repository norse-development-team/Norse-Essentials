package me.TheFallen.norseessentials;

import com.Zrips.CMI.commands.list.back;
import com.Zrips.CMI.commands.list.dback;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.jetbrains.annotations.NotNull;
import org.mineacademy.fo.settings.YamlSectionConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Getter
public class PlayerCache extends YamlSectionConfig {


	private static Map<UUID, PlayerCache> cacheMap = new HashMap<>();

	//-----------Home Cache---------------//

	public Location homeLocation;


	public PlayerCache(final String uuid) {
		super(uuid);

		loadConfiguration(null, "data.db");
	}

	public void setHomeLocation(Location homeLocation) {
		this.homeLocation = homeLocation;

		save("Home", homeLocation);
	}

	public Location getHomeLocation() {
		return getLocation("Home");
	}


	@Override
	protected void onLoadFinish() {
		if (isSet("Home"))
			getLocation("Home");
	}


	//-----------Death Back---------------//
	@Getter
	public Location deathlocation;


	private static Map<UUID, PlayerCache> dlocation = new HashMap<>();

	public void setDeathlocation(Location dlocation) {
		this.deathlocation = dlocation;

		save("Death", dlocation);
	}

	public Location getDeathlocation() {
		return getLocation("Death");
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent event){
		Player player = event.getEntity();



	}



	public static PlayerCache getCache(final UUID player){
		PlayerCache cache = cacheMap.get(player);

		if (cache == null){
			cache = new PlayerCache(player.toString());

			cacheMap.put(player, cache);
		}

		return cache;
	}

}
