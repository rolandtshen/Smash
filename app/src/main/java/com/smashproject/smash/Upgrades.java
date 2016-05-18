package com.smashproject.smash;
import java.util.ArrayList;

public class Upgrades {
    public String name;
    public String hometown;

    public Upgrades(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
    }

    public static ArrayList<Upgrades> getUsers() {
        ArrayList<Upgrades> upgrades = new ArrayList<Upgrades>();
        upgrades.add(new Upgrades("Harry", "San Diego"));
        upgrades.add(new Upgrades("Marla", "San Francisco"));
        upgrades.add(new Upgrades("Sarah", "San Marco"));
        return upgrades;
    }
}


