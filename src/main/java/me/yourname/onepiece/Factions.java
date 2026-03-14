package me.yourname.onepiece;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class Factions {

    public enum Side {
        NEUTRAL, PIRATE, MARINE
    }

    private Side currentSide = Side.NEUTRAL;
    private int berries = 0; // Your new currency/bounty

    public Side getSide() {
        return currentSide;
    }

    public int getBerries() {
        return berries;
    }

    // This updates your money
    public void addBerries(int amount) {
        this.berries += amount;
    }

    public void setSide(Side side, EntityPlayer player) {
        this.currentSide = side;
        player.addChatMessage(new ChatComponentText("You are now a " + side.toString() + "!"));
    }

    public void applyFactionBuffs(EntityPlayer player) {
        // Marines get Soru (Speed) automatically
        if (currentSide == Side.MARINE) {
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20, 1));
        }
    }
}
