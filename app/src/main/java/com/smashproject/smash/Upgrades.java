package com.smashproject.smash;

import java.util.ArrayList;

public class Upgrades {
    public String upgradeName;
    public String amount;
    public int icon;

    public Upgrades(String name, String num, int iconId) {
        this.upgradeName = name;
        this.amount = num;
        this.icon = iconId;
    }

    public static ArrayList<Upgrades> getUsers() {
        ArrayList<Upgrades> upgrades = new ArrayList<Upgrades>();
        upgrades.add(new Upgrades("Normal", "0", R.mipmap.glovenorm));
        upgrades.add(new Upgrades("Air", "5", R.mipmap.gloveair));
        upgrades.add(new Upgrades("Atom", "15", R.mipmap.gloveatom));
        upgrades.add(new Upgrades("Fire", "40", R.mipmap.glovefire));
        upgrades.add(new Upgrades("Ice", "90", R.mipmap.gloveice));
        upgrades.add(new Upgrades("Magic", "150", R.mipmap.glovemagic));
        upgrades.add(new Upgrades("Psy", "200", R.mipmap.glovepsy));
        upgrades.add(new Upgrades("Steel", "260", R.mipmap.glovesteel));
        upgrades.add(new Upgrades("Wave", "400", R.mipmap.glovewave));
        return upgrades;
    }

}


