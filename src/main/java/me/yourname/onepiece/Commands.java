package me.yourname.onepiece;

import net.minecraft.entity.player.EntityPlayer;

public class Commands {
    
    public void handleCommand(String command, EntityPlayer player, Haki hakiSystem) {
        if (command.equalsIgnoreCase("/haki on")) {
            hakiSystem.toggleArmament(player);
        } 
        else if (command.equalsIgnoreCase("/fruit info")) {
            System.out.println("You are a Rubber Human.");
        }
    }
}
