package com.smashproject.smash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;
import java.util.zip.CheckedOutputStream;

public class Target {

    //init variables
    private int maxHealth = 5;
    private int currentHealth = maxHealth;
    public static int numPoints = 0;
    //public int damage = 1;

    public Target(Context c, ImageButton mTarget, ImageView background) {
        mTarget.setImageBitmap(decodeSampledBitmapFromResource(c.getResources(), R.mipmap.charboxer, 1100, 1100));
        //background.setImageBitmap(decodeSampledBitmapFromResource(c.getResources(), R.mipmap.bg10, 1000, 1000));
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

    public void changeCharacters(ImageButton current, Context c) {
        Random rand = new Random();
        int random = rand.nextInt(characters.length);
        current.setImageBitmap(decodeSampledBitmapFromResource(c.getResources(), characters[random], 1100, 1100));
    }

    public void changeBackgrounds(ImageView background, Context c) {
        Random rand = new Random();
        int random = rand.nextInt(backgrounds.length);
        //Bitmap bg = ((BitmapDrawable) background).getBitmap();
        //BitmapDrawable bg = new BitmapDrawable(c.getResources(),decodeSampledBitmapFromResource(c.getResources(), backgrounds[random], 1000, 1000));
        //background.setImageDrawable(bg);
        background.setBackgroundResource(backgrounds[random]);
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
            numPoints += 1;
            currentHealth = currentHealth - UpgradesActivity.getDamage();
        }
    }
    public void respawn() {
        maxHealth *= 1.8;
        currentHealth = maxHealth;
    }

    public static int getNumPoints(){
        return numPoints;
    }

    public static void payMoney(int money){
        numPoints -= money;
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
