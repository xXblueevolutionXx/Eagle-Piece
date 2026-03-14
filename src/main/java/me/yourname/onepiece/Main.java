package me.yourname.onepiece;

public class Main {
    public static void main(String[] args) {
        // Initialize the systems
        Haki playerHaki = new Haki();
        Commands gameCommands = new Commands();

        // Simulate the player using a command
        gameCommands.handleCommand("/haki on");
        
        // Train the player
        playerHaki.train();
    }
}
