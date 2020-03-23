package me.TheFallen.norseessentials.utils;


import me.TheFallen.norseessentials.NorseMain;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Resource extends YamlConfiguration {
    private final String name;
    private final File file;

    //make the file, if it doesnt exist
    public Resource(final NorseMain plugin, final String name) {
        this.name = name;
        this.file = new File(plugin.getDataFolder(), name);
        if (!this.file.getParentFile().exists()) {
            this.file.getParentFile().mkdirs();
        }
        if (!this.file.exists()) {
            plugin.saveResource(name, true);
        }
    }

    //load file
    public void load() {
        try {
            super.load(this.file);
        } catch (final IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    //save file
    public void save() {
        try {
            super.save(this.file);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    public File getFile() {
        return this.file;
    }
}

