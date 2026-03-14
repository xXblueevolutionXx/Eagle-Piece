package me.yourname.onepiece;

import net.minecraft.entity.player.EntityPlayer;

public class Commands {
    
    public void handleCommand(String command, EntityPlayer player, Haki haki, Factions factions) {
        if (command.equalsIgnoreCase("/join marines")) {
            factions.setSide(Factions.Side.MARINE, player);
        } 
        else if (command.equalsIgnoreCase("/join pirates")) {
            factions.setSide(Factions.Side.PIRATE, player);
        }
        else if (command.equalsIgnoreCase("/haki on")) {
            haki.toggleArmament(player);
        }
    }
}
