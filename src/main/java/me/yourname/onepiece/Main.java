package me.yourname.onepiece;

// These lines tell the game where to find Minecraft's tools
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

// This @Mod line is CRITICAL. It registers your mod in the game.
@Mod(modid = "eaglepiece", name = "Eagle Piece", version = "1.0")
public class Main {

    // This is the "Init" method. It replaces the "main" method for mods.
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Now we link your other files
        Haki playerHaki = new Haki();
        Commands gameCommands = new Commands();
        DevilFruit rubberFruit = new DevilFruit("Gomu Gomu", "Paramecia");

        // These messages will now show up in the Game Console/Log
        System.out.println("Eagle-Piece: Mod Loaded!");
        
        rubberFruit.eat();
        playerHaki.train();
        gameCommands.handleCommand("/haki on");
    }
}
