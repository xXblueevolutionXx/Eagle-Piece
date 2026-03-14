package me.yourname.onepiece;

public class Haki {
    private int level;
    private boolean isConquerorsUnlocked;

    public Haki() {
        this.level = 1;
        this.isConquerorsUnlocked = false;
    }

    public void train() {
        this.level++;
        System.out.println("Your Haki is getting stronger! Current Level: " + level);
        
        if (level >= 50 && !isConquerorsUnlocked) {
            isConquerorsUnlocked = true;
            System.out.println("YOU HAVE AWAKENED CONQUEROR'S HAKI!");
        }
    }

    public void useArmament() {
        System.out.println("Armament Haki activated! Defense and Attack boosted.");
    }
}
