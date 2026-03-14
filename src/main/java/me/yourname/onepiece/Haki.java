package me.yourname.onepiece;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import java.util.List;

public class Haki {
    private int level = 1;
    private boolean isArmamentActive = false;

    public void toggleArmament(EntityPlayer player) {
        this.isArmamentActive = !this.isArmamentActive;
        if (isArmamentActive) {
            player.addPotionEffect(new PotionEffect(Potion.resistance.id, 1000, 1));
            player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1000, 1));
        } else {
            player.removePotionEffect(Potion.resistance.id);
            player.removePotionEffect(Potion.damageBoost.id);
        }
    }

    // NEW: The Conqueror's Blast
    public void useConquerors(EntityPlayer player) {
        System.out.println("HAOSHOKU HAKI ACTIVATED!");
        
        // Create a box 10 blocks around the player
        double range = 10.0D;
        AxisAlignedBB area = player.getEntityBoundingBox().expand(range, 5.0D, range);
        
        // Find all living things in that box
        List<EntityLivingBase> targets = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, area);

        for (EntityLivingBase target : targets) {
            if (target != player) {
                // Blast them away!
                double varX = target.posX - player.posX;
                double varZ = target.posZ - player.posZ;
                target.knockBack(player, 5.0F, varX, varZ);
                
                // Give them Weakness (ID 18) because they are "fainting"
                target.addPotionEffect(new PotionEffect(Potion.weakness.id, 200, 2));
            }
        }
    }
}
