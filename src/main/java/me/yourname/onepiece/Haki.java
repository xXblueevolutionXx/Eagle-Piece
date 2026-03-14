package me.yourname.onepiece;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class Haki {
    private int level;
    private boolean isArmamentActive;

    public Haki() {
        this.level = 1;
        this.isArmamentActive = false;
    }

    // This activates the physical "Armor" effect
    public void toggleArmament(EntityPlayer player) {
        this.isArmamentActive = !this.isArmamentActive;
        
        if (isArmamentActive) {
            // Resistance II (ID 11) and Strength II (ID 5)
            player.addPotionEffect(new PotionEffect(Potion.resistance.id, 1000, 1));
            player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1000, 1));
            System.out.println("Busoshoku Haki: Hardened!");
        } else {
            player.removePotionEffect(Potion.resistance.id);
            player.removePotionEffect(Potion.damageBoost.id);
        }
    }

    public void train() {
        this.level++;
        System.out.println("Haki Level Up! Current Level: " + this.level);
    }
}
