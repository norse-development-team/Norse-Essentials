package me.TheFallen.norseessentials.commands.homes;

import me.TheFallen.norseessentials.utils.Resources;
import me.TheFallen.norseessentials.utils.WarpsHomesUtil;
import org.bukkit.configuration.file.FileConfiguration;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.List;

public class homes extends SimpleCommand {
    private final Resources r;
    private final WarpsHomesUtil util;

    public homes(Resources r) {
        super("homes");
        this.r = r;
        util = new WarpsHomesUtil(r);
        setDescription("List all available homes.");
        setPermission("vrn.homes");
        setPermissionMessage("no perm");
    }

    //comma separated list of homes
    @Override
    public void onCommand() {
        checkConsole();
        FileConfiguration config = r.getWarps();
        if (config.get("homes." + getPlayer().getUniqueId()) != null) {
            List<String> homes = util.returnArray("homes." + getPlayer().getUniqueId());
            if (homes.size() != 0) {
                String homeslist = String.join("&7,&a ", homes);
                Common.tell(getPlayer(), "&7Currently showing a list of &a" + homes.size() + "&7 home(s): &a" + homeslist + "&7.");
            } else {
                Common.tell(getPlayer(), "&cYou do not have any homes available.");
            }
        }
    }
}

