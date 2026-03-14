package me.yourname.onepiece;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.block.material.Material;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class DevilFruit {
    private String name;

    public DevilFruit(String name) {
        this.name = name;
    }

    // Gives the rubber powers
    public void applyPower(EntityPlayer player) {
        if (this.name.equalsIgnoreCase("Gomu Gomu")) {
            // Potion ID 8 is Jump Boost
            player.addPotionEffect(new PotionEffect(Potion.jump.id, 200, 1));
        }
    }

    // The "Curse of the Sea" logic
    public void checkWaterWeakness(EntityPlayer player) {
        if (player.isInsideOfMaterial(Material.water)) {
            // Deals 1 point (half heart) of damage
            player.attackEntityFrom(DamageSource.drown, 1.0F);
            
            // Slows the player down significantly
            player.motionX *= 0.1;
            player.motionZ *= 0.1;
        }
    }
}
