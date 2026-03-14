package me.yourname.onepiece;

public class DevilFruit {
    private String name;
    private String powerType;

    public DevilFruit(String name, String powerType) {
        this.name = name;
        this.powerType = powerType;
    }

    public void eat() {
        System.out.println("You ate the " + name + "!");
        System.out.println("Power Type: " + powerType);
        System.out.println("Warning: You can no longer swim!");
    }
}
