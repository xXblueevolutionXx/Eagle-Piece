package me.yourname.onepiece;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;

@Mod(modid = "eaglepiece", name = "Eagle Piece", version = "1.0")
public class Main {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // This creates your fruit object
        DevilFruit rubberFruit = new DevilFruit("Gomu Gomu");
        
        // This starts your Haki and Commands systems
        Haki playerHaki = new Haki();
        Commands gameCommands = new Commands();

        // This gives the player the jump power as soon as the mod loads
        if (Minecraft.getMinecraft().thePlayer != null) {
            rubberFruit.applyPower(Minecraft.getMinecraft().thePlayer);
        }

        System.out.println("Eagle-Piece: Systems Online!");
    }
}
