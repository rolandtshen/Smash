package com.smashproject.smash;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class Target {

    //init variables
    private int maxHealth = 5;
    private int currentHealth = maxHealth;
    public int numPoints = 0;
    public int damage = 1;

    public Target(ImageButton mTarget, RelativeLayout background) {
        mTarget.setImageResource(R.mipmap.charboxer);
        background.setBackgroundResource(R.mipmap.bg10);
    }

    int[] characters = {
            R.mipmap.charbball,
            R.mipmap.charbear,
            R.mipmap.charboxer,
            R.mipmap.charcar,
            R.mipmap.charcat,
            R.mipmap.charfrog,
            R.mipmap.charninja,
            R.mipmap.charowl,
            R.mipmap.charpills,
            R.mipmap.charrobot1,
            R.mipmap.charrobot2,
    };

    int[] backgrounds = {
            R.mipmap.bg1,
            R.mipmap.bg2,
            R.mipmap.bg3,
            R.mipmap.bg4,
            R.mipmap.bg5,
            R.mipmap.bg6,
            R.mipmap.bg7,
            R.mipmap.bg8,
            R.mipmap.bg9,
            R.mipmap.bg10,
    };

    int[] gloves = {
    };

    public void changeCharacters(ImageButton current) {
        Random rand = new Random();
        int random = rand.nextInt(characters.length);
        current.setImageResource(characters[random]);
    }

    public void changeBackgrounds(RelativeLayout background) {
        Random rand = new Random();
        int random = rand.nextInt(backgrounds.length);
        background.setBackgroundResource(backgrounds[random]);
    }


    public void animate(ImageButton current){

    }

    public void stopPlaying(MediaPlayer punchSoundMP) {
        if (punchSoundMP != null) {
            punchSoundMP.stop();
            punchSoundMP.release();
            punchSoundMP = null;
        }
    }

    public boolean isDead() {
        if(currentHealth == 0) {
            return true;
        }
        return false;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void fight() {
        if(isDead()) {
            respawn();
        }
        else {
            numPoints++;
            currentHealth = currentHealth - damage;
        }
    }
    public void respawn() {
        maxHealth += 1;
        currentHealth = maxHealth;
    }

}
