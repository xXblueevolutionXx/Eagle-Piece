package me.yourname.onepiece;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.block.material.Material;

public class DevilFruit {
    private String name;

    public DevilFruit(String name) {
        this.name = name;
    }

    // This is the power we added before
    public void applyPower(EntityPlayer player) {
        if (this.name.equalsIgnoreCase("Gomu Gomu")) {
            player.addPotionEffect(new net.minecraft.potion.PotionEffect(8, 1000, 1));
        }
    }

    // NEW: This is the weakness logic
    public void checkWaterWeakness(EntityPlayer player) {
        if (player.isInsideOfMaterial(Material.water)) {
            // Deals half a heart of damage and slows the player down
            player.attackEntityFrom(DamageSource.drown, 1.0F);
            player.motionX *= 0.5;
            player.motionZ *= 0.5;
            System.out.println("The sea drains your energy!");
        }
    }
}
