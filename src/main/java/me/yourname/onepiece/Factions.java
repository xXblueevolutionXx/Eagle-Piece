package me.yourname.onepiece;

import net.minecraft.entity.player.EntityPlayer;

public class Factions {
    public enum Side { PIRATE, MARINE, NONE }
    
    private Side playerSide = Side.NONE;

    public void setSide(Side side, EntityPlayer player) {
        this.playerSide = side;
        System.out.println("You are now a " + side.name() + "!");
    }

    public Side getSide() {
        return this.playerSide;
    }

    public void applyFactionBuffs(EntityPlayer player) {
        if (playerSide == Side.MARINE) {
            // Marines get a speed boost (Soru)
            player.addPotionEffect(new net.minecraft.potion.PotionEffect(1, 200, 1));
        }
    }
}
