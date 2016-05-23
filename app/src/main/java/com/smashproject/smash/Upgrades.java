package com.smashproject.smash;

import java.util.ArrayList;

public class Upgrades {
    public String upgradeName;
    public String amount;
    public int icon;
    public int level;

    public Upgrades(String name, String num, int iconId, int level) {
        this.upgradeName = name;
        this.amount = num;
        this.icon = iconId;
        this.level = level;
    }

    public static ArrayList<Upgrades> getUsers() {
        ArrayList<Upgrades> upgrades = new ArrayList<>();
        upgrades.add(new Upgrades("Normal", "5", R.mipmap.glovenorm, 0));
        upgrades.add(new Upgrades("Air", "10", R.mipmap.gloveair, 0));
        upgrades.add(new Upgrades("Atom", "15", R.mipmap.gloveatom, 0));
        upgrades.add(new Upgrades("Fire", "20", R.mipmap.glovefire, 0));
        upgrades.add(new Upgrades("Ice", "25", R.mipmap.gloveice, 0));
        upgrades.add(new Upgrades("Magic", "30", R.mipmap.glovemagic, 0));
        upgrades.add(new Upgrades("Psy", "35", R.mipmap.glovepsy, 0));
        upgrades.add(new Upgrades("Steel", "40", R.mipmap.glovesteel, 0));
        upgrades.add(new Upgrades("Wave", "45", R.mipmap.glovewave, 0));
        return upgrades;
    }

}