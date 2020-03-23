package me.TheFallen.norseessentials.commands.homes;

import me.TheFallen.norseessentials.utils.Resources;
import me.TheFallen.norseessentials.utils.WarpsHomesUtil;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.ArrayList;
import java.util.List;

public class home extends SimpleCommand {
    private final Resources r;
    private final WarpsHomesUtil util;

    public home(final Resources r) {
        super("home");
        this.r = r;
        util = new WarpsHomesUtil(r);
        setMinArguments(1);
        setUsage("<name>");
        setDescription("Teleport to the specified home.");
        setPermission("vrn.home");
        setPermissionMessage("no perm");
    }

    @Override
    public void onCommand() {
        checkConsole();
        util.teleportToLoc(getPlayer(), "homes." + getPlayer().getUniqueId() + ".", args[0], true);
    }

    /*
    tab complete, because who is going to remember
    each of those 100 homes they set?
    */
    @Override
    protected List<String> tabComplete() {
        if (args.length == 1) {
            if (this.r.getWarps().get("homes." + getPlayer().getUniqueId()) != null) {
                return completeLastWord(util.returnArray("homes." + getPlayer().getUniqueId()));
            } else {
                return completeLastWord("");
            }
        }
        return new ArrayList<>();
    }
}
