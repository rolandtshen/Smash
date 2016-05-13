package com.smashproject.smash;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //all variables
    TextView pointsTextView;
    ImageButton mTarget;
    TextView healthTextView;
    Button upgrades;
    RelativeLayout background;
    Upgrades mUpgrades = new Upgrades();
    Target target;
    ProgressBar healthBar;
    MediaPlayer punchSoundMP;
    int deathIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize variables
        deathIndex = 1;
        pointsTextView = (TextView) findViewById(R.id.points);
        mTarget = (ImageButton) findViewById(R.id.target);
        healthTextView = (TextView) findViewById(R.id.health);
        //upgrades = (Button) findViewById(R.id.viewUpgrades);
        background = (RelativeLayout) findViewById(R.id.background);
        healthBar = (ProgressBar) findViewById(R.id.healthBar);
        target = new Target(mTarget, background);


        healthBar.setMax(target.getMaxHealth());
        healthBar.setProgress(target.getCurrentHealth());

        //getActionBar().setHomeButtonEnabled(true);
        // getActionBar().setTitle("Money: ");
        //getActionBar().setIcon(R.mipmap.moneyicon);

        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale);

        mTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                target.stopPlaying(punchSoundMP);
                punchSoundMP = MediaPlayer.create(MainActivity.this, R.raw.smack);
                punchSoundMP.start();
                target.fight();
                mTarget.startAnimation(anim);
                if(target.isDead()) {
                    target.changeCharacters(mTarget);
                    deathIndex++;
                    if(deathIndex % 2 == 0) {
                        target.changeBackgrounds(background);
                    }
                }

                healthBar.setMax(target.getMaxHealth());
                healthBar.setProgress(target.getCurrentHealth());

                pointsTextView.setText(target.numPoints + "");
                healthTextView.setText(target.getCurrentHealth() + "");
            }
        });

        /*upgrades.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewUpgrades();
            }
        });*/
    }
    private void viewUpgrades() {
        Intent intent = new Intent(this, Upgrades.class);
        startActivity(intent);
    }
}