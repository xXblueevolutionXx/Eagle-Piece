package me.yourname.onepiece;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "eaglepiece", name = "Eagle Piece", version = "1.0")
public class Main {
    
    // Create the "crew" (the other files)
    public DevilFruit myFruit = new DevilFruit("Gomu Gomu");
    public Haki myHaki = new Haki();
    public Commands myCommands = new Commands();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // This registers the mod so it can listen for you walking/swimming
        MinecraftForge.EVENT_BUS.register(this);
        System.out.println("Eagle-Piece: Grand Line is open!");
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        // Every second, the game checks these 3 things:
        
        // 1. Give jump powers
        myFruit.applyPower(event.player);
        
        // 2. Check if the player is drowning in water
        myFruit.checkWaterWeakness(event.player);

        // 3. (Optional) You could trigger commands here or via keybinds
    }
}
