package me.yourname.onepiece;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class DevilFruit {
    private String name;

    public DevilFruit(String name) {
        this.name = name;
    }

    public void applyPower(EntityPlayer player) {
        if (this.name.equalsIgnoreCase("Gomu Gomu")) {
            // Give Jump Boost II (index 8) for 1000 ticks
            player.addPotionEffect(new PotionEffect(Potion.jump.id, 1000, 1));
            System.out.println("You are now made of rubber!");
        }
    }
}
