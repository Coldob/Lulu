package com.proto;

import com.proto.Listeners.Chat;
import com.proto.Listeners.randomStick;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import com.proto.Listeners.Portals;
import com.proto.data.dataaccess;
import static org.bukkit.Bukkit.getServer;

public final class Lulu extends JavaPlugin {
    public static Plugin lulu;

    @Override
    public void onEnable() {
        this.lulu = this;
        // Plugin startup logic
        Bukkit.getLogger().info("|\\**/|    _           _        ");
        Bukkit.getLogger().info("\\ == /   | |         | |");
        Bukkit.getLogger().info(" |  |    | |    _   _| |_   _");
        Bukkit.getLogger().info(" |  |    | |   | | | | | | | |");
        Bukkit.getLogger().info(" \\  /    | |___| |_| | | |_| |");
        Bukkit.getLogger().info("  \\/     |______\\__,_|_|\\__,_|");
//        |\**/|    _           _
//        \ == /   | |         | |
//         |  |    | |    _   _| |_   _
//         |  |    | |   | | | | | | | |
//         \  /    | |___| |_| | | |_| |
//          \/     |______\__,_|_|\__,_|
        dataaccess.makeDatabase();
        dataaccess.createTheTable();
        new Portals(this);
        new randomStick(this);

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("     _.-^^---....,,--  ");
        Bukkit.getLogger().info(" _--                  --_  ");
        Bukkit.getLogger().info("<                        >)");
        Bukkit.getLogger().info("|                         | ");
        Bukkit.getLogger().info(" \\._                   _./  ");
        Bukkit.getLogger().info("    ```--. . , ; .--'''       ");
        Bukkit.getLogger().info("          | |   |         ");
        Bukkit.getLogger().info("       .-=||  | |=-.   ");
        Bukkit.getLogger().info("       `-=#$%&%$#=-'   ");
        Bukkit.getLogger().info("          | ;  :|     ");
        Bukkit.getLogger().info(" _____.,-#%&$@%#&#~,._____");

    }
}
