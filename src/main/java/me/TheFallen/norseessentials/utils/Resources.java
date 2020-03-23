package me.TheFallen.norseessentials.utils;

import me.TheFallen.norseessentials.NorseMain;

public class Resources
{
    private final Resource warps;

    public Resources(final NorseMain plugin) {

        this.warps = new Resource(plugin, "warps.yml"); //single file is bad. Will be changed.
    }

    public void load() {
        warps.load();
    }

    public void save() {
        warps.save();
    }

    public Resource getWarps() {
        return warps;
    }
}

