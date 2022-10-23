package com.proto.Listeners;

import com.proto.Lulu;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.concurrent.ThreadLocalRandom;

public class randomStick implements Listener {
    public randomStick(Lulu plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void Goodbye(EntityDamageByEntityEvent event){
        if (event.getDamager().getType() == EntityType.PLAYER) {
            if(event.getEntity().getType() == EntityType.PLAYER){
                Player damager = (Player) event.getDamager();
                Player damaged = (Player) event.getEntity();
                World world = damager.getWorld();
                Material stick = damager.getInventory().getItemInMainHand().getType();
                String lore = damager.getInventory().getItemInMainHand().getItemMeta().getLore().get(0);
                if(stick == Material.STICK && lore.equals("§bMonkey Mischief")){
                    //add max and min of map
                    int x = ThreadLocalRandom.current().nextInt(0,1+1);
                    int y = ThreadLocalRandom.current().nextInt(0,1+1);
                    int z = ThreadLocalRandom.current().nextInt(0,1+1);
                    Location randL = new Location(world,x,y,z);
                    damaged.teleport(randL);
                }

            }
        }
    }
}
