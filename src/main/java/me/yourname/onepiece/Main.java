package me.yourname.onepiece;

public class Main {
    public static void main(String[] args) {
        // 1. Give the player a fruit
        DevilFruit luffyFruit = new DevilFruit("Gomu Gomu no Mi", "Paramecia");
        luffyFruit.eat();

        // 2. Initialize Haki
        Haki playerHaki = new Haki();
        
        // 3. Simulate training
        playerHaki.useArmament();
        playerHaki.train();
    }
}
