package me.TheFallen.norseessentials.commands.homes;

import me.TheFallen.norseessentials.utils.Resources;
import me.TheFallen.norseessentials.utils.WarpsHomesUtil;
import org.mineacademy.fo.command.SimpleCommand;

public class sethome extends SimpleCommand {
    private final Resources r;
    private final WarpsHomesUtil util;

    public sethome(final Resources r) {
        super("sethome");
        this.r = r;
        util = new WarpsHomesUtil(r);
        setMinArguments(1);
        setUsage("<name>");
        setDescription("Create a Home.");
        setPermission("ne.sethome");
        setPermissionMessage("no perm");
    }

    @Override
    public void onCommand() {
        checkConsole();
        util.setValues(getPlayer(), "homes." + getPlayer().getUniqueId() + ".", args[0], true);
    }
}
