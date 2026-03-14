package me.yourname.onepiece;

public class Commands {
    
    // This simulates a player typing a command in chat
    public void handleCommand(String command) {
        if (command.equalsIgnoreCase("/haki on")) {
            System.out.println("[Eagle-Piece] Your skin turns black... Armament Haki is active!");
        } 
        else if (command.equalsIgnoreCase("/fruit info")) {
            System.out.println("[Eagle-Piece] You possess the Gomu Gomu no Mi powers.");
        } 
        else {
            System.out.println("[Eagle-Piece] Unknown command! Try /haki on.");
        }
    }
}
