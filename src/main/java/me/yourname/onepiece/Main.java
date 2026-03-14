package com.yourname.onepiece;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "onepiecemod", name = "Grand Line Evolved", version = "1.0")
public class Main {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // This is where you will eventually register your Devil Fruits and Haki!
        System.out.println("Set sail! One Piece Mod is loading...");
    }
}
