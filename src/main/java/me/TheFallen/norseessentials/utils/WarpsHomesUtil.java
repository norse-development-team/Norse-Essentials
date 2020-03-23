package me.TheFallen.norseessentials.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;

import java.util.ArrayList;
import java.util.List;

//I also used this class for a warps system as well, that's why it has more than homes in here.
public class WarpsHomesUtil {

    private final Resources r;

    public WarpsHomesUtil(final Resources r) {
        this.r = r;
    }

    /**
     * @param value the name of the home/warp
     * @param path the path, "warps." or "homes.<player's UUID here>"
     * @return all home/warp names and returns true if equal to prevent duplicate names
     */
    private String searchForEqual(final String value, final String path) {
        if (r.getWarps().get(path) != null) {
            for (final String key : r.getWarps().getConfigurationSection(path).getKeys(false)) {
                if (value.equalsIgnoreCase(key)) {
                    return key;
                }
            }
        }
        return null;
    }

    /**
     * @param path the path, "warps." or "homes.<player's UUID here>"
     * @return all of the player's homes OR all public warps.
     */
    public List<String> returnArray(final String path) {
        final List<String> keys = new ArrayList<>();
        for (final String key : r.getWarps().getConfigurationSection(path).getKeys(false)) {
            r.getWarps().getString(key);
            keys.add(key);
        }
        return keys;
    }

    /**
     * Sets the home/warp value to the config.
     * @param p the player
     * @param path the path, "warps." or "homes.<player's UUID here>"
     * @param value the name of the home/warp
     * @param homes true if using homes, false for warps
     */
    public void setValues(final Player p, final String path, final String value, final boolean homes) {
        final String locPath = path + value;
        final String msg = homes ? "home" : "warp";
        if (r.getWarps().get(locPath) == null) {
            if (searchForEqual(value, path) != null) {
                Common.tell(p, "&cThat " + msg + " already exists.");
                return;
            }
            r.getWarps().set(locPath + ".world", p.getWorld().getName());
            r.getWarps().set(locPath + ".x", p.getLocation().getX());
            r.getWarps().set(locPath + ".y", p.getLocation().getY());
            r.getWarps().set(locPath + ".z", p.getLocation().getZ());
            r.getWarps().set(locPath + ".yaw", p.getLocation().getYaw());
            r.getWarps().set(locPath + ".pitch", p.getLocation().getPitch());
            r.getWarps().save();
            Common.tell(p, "&aThe " + msg + " was successfully set. Teleport to it with /" + msg + ".");
            return;
        }
        Common.tell(p, "&cThat " + msg + " already exists.");
    }

    /**
     * Delete homes/warps from the config.
     * @param p the player
     * @param path the path, "warps." or "homes.<player's UUID here>"
     * @param value the name of the home/warp
     * @param homes true if using homes, false for warps
     */
    public void delValues(final Player p, final String path, final String value, final boolean homes) {
        String loc = value;
        final String msg = homes ? "home" : "warp";
        if (r.getWarps().get(path + value) == null) {
            if (searchForEqual(value, path) == null) {
                Common.tell(p, "&cThat " + msg + " does not exist.");
                return;
            }
            loc = searchForEqual(value, path);
        }
        final String locPath = path + loc;
        r.getWarps().set(locPath + ".world", null);
        r.getWarps().set(locPath + ".x", null);
        r.getWarps().set(locPath + ".y", null);
        r.getWarps().set(locPath + ".z", null);
        r.getWarps().set(locPath + ".yaw", null);
        r.getWarps().set(locPath + ".pitch", null);
        r.getWarps().set(locPath, null);
        r.getWarps().save();
        Common.tell(p, "&7The " + msg + "&a " + loc + "&7 has been deleted.");
    }

    /**
     * Teleport to an existing home or warp.
     * @param p the player
     * @param path the path, "warps." or "homes.<player's UUID here>"
     * @param value the name of the home/warp
     * @param homes true if using homes, false for warps
     */
    public void teleportToLoc(final Player p, final String path, final String value, final boolean homes) {
        String locPath = path + value;
        final String msg = homes ? "home" : "warp";
        if (r.getWarps().get(locPath) == null) {
            if (searchForEqual(value, path) == null) {
                Common.tell(p, "&cThat " + msg + " does not exist.");
                return;
            }
            locPath = path + searchForEqual(value, path);
        }
        Common.tell(p, "&7Teleporting...");
        final String world = (String) r.getWarps().get(locPath + ".world");
        if (world == null) {
            Common.tell(p, "&cThe world that this " + msg + " is located in does not exist.");
            return;
        }
        p.teleport(new Location(Bukkit.getWorld(world),
                r.getWarps().getDouble(locPath + ".x"),
                r.getWarps().getDouble(locPath + ".y"),
                r.getWarps().getDouble(locPath + ".z"),
                (float) r.getWarps().getDouble(locPath + ".yaw"),
                (float) r.getWarps().getDouble(locPath + ".pitch")));
    }
}
