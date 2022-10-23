package com.proto.function;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import java.util.ArrayList;
import java.util.Collection;

public class checks {


    public static int countEntities(Location x){
        Collection<Entity> listOfEntities = x.getWorld().getNearbyEntities(x,5,5,5);
        int amount = -1;
        for (Entity i : listOfEntities) {
            String Temp = i.toString();
            if (Temp.equals("CraftWarden")){
                amount += 1;
            }

        }
        return(amount);
    }

    public static Collection<Player> playerNames(Location x){
        Collection<Entity> listOfEntities = x.getWorld().getNearbyEntities(x,5,5,5);
        Collection<Player> players = new ArrayList<>();
        for (Entity i : listOfEntities) {
            String Temp = i.toString();
            if (Temp.contains("CraftPlayer")){
                Player name = (Player) i;
                players.add(name);
            }

        }
        return(players);
    }

    public static boolean inventoryCheck(PlayerInventory playerInv){
        boolean h1 = false;
        boolean h2 = false;
        boolean h3 = false;
        int h1i = 0;
        int h2i = 0;
        int h3i = 0;
        for (int i = 0; i < 46; ++i ) {
            ItemStack is = playerInv.getItem(i);
            try {
                Material item = is.getType();
                if (item == Material.PLAYER_HEAD) {
                    String itemName = is.getItemMeta().getDisplayName();
                    String itemLore = is.getItemMeta().getLore().get(0);
                    ///give @p player_head{SkullOwner:Cholo1280,display:{Name:'[{"text":"Mizaru","italic":false,"color":"light_purple","bold":true}]',Lore:['[{"text":"Sees no evil","italic":false,"color":"aqua"}]']}} 1
                    if (itemName.equals("§d§lMizaru") && itemLore.equals("§bSees no evil")) {
                        h1 = true;
                        h1i = i;
                    }
                    //head 2
                    ///give @p player_head{SkullOwner:Cholo1280,display:{Name:'[{"text":"Kikazaru","italic":false,"color":"light_purple","bold":true}]',Lore:['[{"text":"Hears no evil","italic":false,"color":"aqua"}]']}} 1
                    if (itemName.equals("§d§lKikazaru") && itemLore.equals("§bHears no evil")) {
                        h2 = true;
                        h2i = i;
                    }
                    //head 3
                    ///give @p player_head{SkullOwner:Cholo1280,display:{Name:'[{"text":"Iwazaru","italic":false,"color":"light_purple","bold":true}]',Lore:['[{"text":"Speaks no evil","italic":false,"color":"aqua"}]']}} 1
                    if (itemName.equals("§d§lIwazaru") && itemLore.equals("§bSpeaks no evil")) {
                        h3 = true;
                        h3i = i;
                    }
                }
                if (h1 && h2 && h3){
                    ItemStack i1 = playerInv.getItem(h1i);
                    i1.setAmount(i1.getAmount()-1);
                    ItemStack i2 = playerInv.getItem(h2i);
                    i2.setAmount(i2.getAmount()-1);
                    ItemStack i3 = playerInv.getItem(h3i);
                    i3.setAmount(i3.getAmount()-1);
                    return(true);
                    //remove items here
                }
            } catch (Exception e) {
                //no item in slot comes up as null
            }
        }
        return(false);
    }

}
