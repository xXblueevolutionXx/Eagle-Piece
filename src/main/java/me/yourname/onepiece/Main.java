package me.yourname.onepiece;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "eaglepiece", name = "Eagle Piece", version = "1.0")
public class Main {
    
    // This 'instance' allows other files to talk to Main easily
    public static Main instance;

    // Initialize all your systems
    public DevilFruit myFruit = new DevilFruit("Gomu Gomu");
    public Haki myHaki = new Haki();
    public Commands myCommands = new Commands();
    public Factions myFactions = new Factions();
    public MobManager myMobs = new MobManager();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        instance = this;

        // Register everything to the Event Bus so the code actually runs
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(myMobs); 
        
        System.out.println("Eagle-Piece: All systems connected!");
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        // 1. If you are a Pirate, you get Fruit powers but drown in water
        if (myFactions.getSide() == Factions.Side.PIRATE) {
            myFruit.applyPower(event.player);
            myFruit.checkWaterWeakness(event.player);
        } 
        
        // 2. If you are a Marine, you get Soru (Speed)
        else if (myFactions.getSide() == Factions.Side.MARINE) {
            myFactions.applyFactionBuffs(event.player);
        }
    }
}
