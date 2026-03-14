package me.yourname.onepiece;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft; // Added to find the player

@Mod(modid = "eaglepiece", name = "Eagle Piece", version = "1.0")
public class Main {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        DevilFruit rubberFruit = new DevilFruit("Gomu Gomu");
        
        // This gets the person currently playing the game
        if (Minecraft.getMinecraft().thePlayer != null) {
            rubberFruit.applyPower(Minecraft.getMinecraft().thePlayer);
        }
        
        System.out.println("Eagle-Piece: Powers Loaded!");
    }
}
