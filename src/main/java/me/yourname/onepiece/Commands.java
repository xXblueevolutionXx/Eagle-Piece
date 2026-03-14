package me.yourname.onepiece;

import net.minecraft.entity.player.EntityPlayer;

public class Commands {
    
    public void handleCommand(String command, EntityPlayer player, Haki hakiSystem) {
        if (command.equalsIgnoreCase("/haki on")) {
            hakiSystem.toggleArmament(player);
        } 
        else if (command.equalsIgnoreCase("/haki conqueror")) {
            hakiSystem.useConquerors(player);
        }
        else if (command.equalsIgnoreCase("/fruit info")) {
            System.out.println("Fruit: Gomu Gomu no Mi");
        }
    }
}
