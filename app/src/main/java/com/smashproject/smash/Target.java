package com.smashproject.smash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class Target {

    //init variables
    private int maxHealth = 5;
    private int currentHealth = maxHealth;
    private static int numMoney = 0;

    public Target(Context c, ImageButton mTarget, ImageView background) {
        mTarget.setImageBitmap(decodeSampledBitmapFromResource(c.getResources(), R.mipmap.charboxer, 880, 880));
        background.setImageBitmap(decodeSampledBitmapFromResource(c.getResources(), R.mipmap.bg10, 1000, 1000));
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

    public void changeCharacters(ImageButton current, Context c) {
        Random rand = new Random();
        int random = rand.nextInt(characters.length);
        current.setImageBitmap(decodeSampledBitmapFromResource(c.getResources(), characters[random], 880, 880));
    }

    public void changeBackgrounds(ImageView background, Context c) {
        Random rand = new Random();
        int random = rand.nextInt(backgrounds.length);
        background.setImageBitmap(decodeSampledBitmapFromResource(c.getResources(), backgrounds[random], 1000, 1000));
    }

    public void stopPlaying(MediaPlayer punchSoundMP) {
        if (punchSoundMP != null) {
            punchSoundMP.stop();
            punchSoundMP.release();
            punchSoundMP = null;
        }
    }

    public boolean isDead() {
        if(currentHealth <= UpgradesActivity.getDamage()) {
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
            numMoney++;
            currentHealth = currentHealth - UpgradesActivity.getDamage();
        }
    }
    public void respawn() {
        maxHealth *= 1.5;
        currentHealth = maxHealth;
    }

    public static void payMoney(int money){
        numMoney -= money;
    }

    public static int getNumMoney() {
        return numMoney;
    }

    public void addMoney(int num) {
        numMoney += num;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}