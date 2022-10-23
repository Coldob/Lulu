package com.proto.Listeners;

import com.proto.Lulu;
import com.proto.data.dataaccess;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Candle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getServer;


public class Portals implements Listener {
    public Portals(Lulu plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    Plugin lulu = Lulu.lulu;
    @EventHandler
    public void portalCheck(BlockIgniteEvent event) {
        World world = event.getBlock().getWorld();
        String wName = world.getName();
        if (wName.equals("world")) {
            Block isCandle = event.getBlock();
            if (isCandle.getType() == Material.BLACK_CANDLE) {
                Candle pCandle = (Candle) world.getBlockAt(-6, 67, -52).getBlockData();
                Candle rCandle = (Candle) world.getBlockAt(-6, 66, -54).getBlockData();
                Candle lCandle = (Candle) world.getBlockAt(-6, 66, -50).getBlockData();
                Block bspCandle = world.getBlockAt(-6, 67, -52);
                Block bsrCandle = world.getBlockAt(-6, 66, -54);
                Block bslCandle = world.getBlockAt(-6, 66, -50);
                Block bsfCandle = world.getBlockAt(-5, 65, -52);
                Block bsbCandle = world.getBlockAt(-7, 65, -52);
                Boolean lit1 = (pCandle.isLit());
                Boolean lit2 = (rCandle.isLit());
                Boolean lit3 = (lCandle.isLit());
                if (lit1 && lit2 && lit3) {
                    pCandle.setLit(false);
                    bspCandle.setBlockData(pCandle);
                    bsrCandle.setBlockData(pCandle);
                    bslCandle.setBlockData(pCandle);
                    bsfCandle.setBlockData(pCandle);
                    bsbCandle.setBlockData(pCandle);
                    Player player = event.getPlayer();
                    String splayer = player.getName();
                    if (player.getInventory().getHelmet().getItemMeta().hasDisplayName()) {
                        String rHeadName = player.getInventory().getHelmet().getItemMeta().getDisplayName();
                        if(rHeadName.equalsIgnoreCase("§d§l弱い人")){
                            String sql = "SELECT portal1 FROM Portals WHERE players = '"+splayer+"';";
                            Location Goodbye = new Location(world, -8,57,-52);
                            if (dataaccess.SQLSearch(sql)==0){
                                player.setGameMode(GameMode.SURVIVAL);
                                player.teleport(Goodbye);
                                player.sendMessage( ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "G" + ChatColor.WHITE + "] " + ChatColor.GOLD + "Legion " + ChatColor.YELLOW + "The weak will die");
                                getServer().getPluginManager().registerEvents(new Chat(),lulu);
                                Location spawn1 = new Location(world, -8,57,-52);
                                Location spawn2 = new Location(world, -8,57,-52);
                                Location spawn3 = new Location(world, -8,57,-52);
                                world.spawnEntity(spawn1, EntityType.WARDEN);
                                world.spawnEntity(spawn2, EntityType.WARDEN);
                                world.spawnEntity(spawn3, EntityType.WARDEN);
                            } else {
                                player.teleport(Goodbye);
                            }
                        }
                    }
                }
            }
        }
    }
}