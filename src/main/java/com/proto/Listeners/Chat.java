package com.proto.Listeners;

import com.proto.Lulu;
import com.proto.data.dataaccess;
import com.proto.function.checks;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import java.util.Arrays;
import java.util.Collection;
import static com.proto.function.checks.inventoryCheck;

public class Chat implements Listener {
    @EventHandler
    public void ChatChecker(AsyncPlayerChatEvent event1){
        Player player = event1.getPlayer();
        Location location = player.getLocation();
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        if ((-12 <= x) && (-6 >= x)&&(57 <= y)&&(60 >= y)&&(-55 <= z)&& (-49 >= z)) {
            event1.setCancelled(true);
        }
    }
    //teleports
    @EventHandler
    public void didTheyTeleport(PlayerTeleportEvent event2){
        Player player = event2.getPlayer();
        Location location = player.getLocation();
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        if ((-12 <= x) && (-6 >= x)&&(57 <= y)&&(60 >= y)&&(-55 <= z)&& (-49 >= z)) {
            event2.setCancelled(true);
        }
    }
    //commands
    @EventHandler
    public void commandChecker(PlayerCommandPreprocessEvent event3){
        Player player = event3.getPlayer();
        Location location = player.getLocation();
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        if ((-12 <= x) && (-6 >= x)&&(57 <= y)&&(60 >= y)&&(-55 <= z)&& (-49 >= z)) {
            event3.setCancelled(true);
        }
    }

    //death
    @EventHandler
    public void deathChecker(PlayerDeathEvent event4){
        Player player = event4.getEntity();
        Location location = player.getLocation();
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        if ((-12 <= x) && (-6 >= x)&&(57 <= y)&&(60 >= y)&&(-55 <= z)&& (-49 >= z)) {
            HandlerList.unregisterAll(this);
        }
    }
    //logs
    @EventHandler
    public void logOff(PlayerQuitEvent event5){
        Player player = event5.getPlayer();
        Location location = player.getLocation();
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        if ((-12 <= x) && (-6 >= x)&&(57 <= y)&&(60 >= y)&&(-55 <= z)&& (-49 >= z)) {
            HandlerList.unregisterAll(this);
        }
    }
    @EventHandler
    public void WardensKilled(EntityDeathEvent event6){
        Entity whatsEntity = event6.getEntity();
        Location location = whatsEntity.getLocation();
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        Location centerOfRoom = new Location(location.getWorld(), -9,57,-52);
        if ((-12 <= x) && (-6 >= x)&&(57 <= y)&&(60 >= y)&&(-55 <= z)&& (-49 >= z)) {
            if (checks.countEntities(centerOfRoom) == 0){
                Collection<Player> players = checks.playerNames(centerOfRoom);
                for (Player player : players) {

                    PlayerInventory playerInv = player.getInventory();
                    if (inventoryCheck(playerInv)){
                        dataaccess.FPComplete(player);
                        ItemStack stick = new ItemStack(Material.STICK);
                        ItemMeta itemmeta = stick.getItemMeta();
                        itemmeta.setLore((Arrays.asList("§bMonkey Mischief")));
                        stick.setItemMeta(itemmeta);
                        stick.setAmount(1);
                        player.getInventory().addItem(stick);
                        player.sendMessage( ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "G" + ChatColor.WHITE + "] " + ChatColor.GOLD + "Legion " + ChatColor.YELLOW + "Please use my Stick to send other players to another dimension");
                    } else {
                        player.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "G" + ChatColor.WHITE + "] " + ChatColor.GOLD + "Legion " + ChatColor.YELLOW + "Bring me my monkeys");
                    }
                }
                HandlerList.unregisterAll(this);
            }

        }
    }
}
