package com.smashproject.smash;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //all variables
    public static TextView moneyTextView;
    public TextView killsTextView;
    ImageButton mTarget;
    TextView upgradesLabel;
    ImageView background;
    Target target;
    ProgressBar healthBar;
    MediaPlayer punchSoundMP;
    int deathIndex;
    int newIndex;
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);setContentView(R.layout.activity_main);

        //initialize variables
        deathIndex = 0;
        newIndex = deathIndex;
        moneyTextView = (TextView) findViewById(R.id.money);
        killsTextView = (TextView) findViewById(R.id.killsNumber);
        mTarget = (ImageButton) findViewById(R.id.target);
        background = (ImageView) findViewById(R.id.bg);
        healthBar = (ProgressBar) findViewById(R.id.healthBar);
        target = new Target(this, mTarget, background);
        upgradesLabel = (TextView) findViewById(R.id.upgrades);
        c = this;

        healthBar.setMax(target.getMaxHealth());
        healthBar.setProgress(target.getCurrentHealth());
        background.setScaleType(ImageView.ScaleType.FIT_XY);

        //causes target to bounce up and down when hit
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale);

        mTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                target.stopPlaying(punchSoundMP);
                punchSoundMP = MediaPlayer.create(MainActivity.this, R.raw.smack);
                punchSoundMP.start();
                mTarget.startAnimation(anim);
                target.fight();

                if (target.isDead()) {
                    deathIndex++;
                } else {
                    if (deathIndex != newIndex) {
                        target.changeCharacters(mTarget, c);
                        if(deathIndex % 3 == 0){
                            target.changeBackgrounds(background, c);
                        }
                        target.addMoney(1);
                        killsTextView.setText(deathIndex + "");
                        newIndex++;
                    }
                }

                healthBar.setMax(target.getMaxHealth());
                healthBar.setProgress(target.getCurrentHealth());

                changeMoneyLabel(target.getNumMoney() + "");

            }
        });

        upgradesLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                viewUpgrades();
            }
        });

    }

    private void viewUpgrades(){
        Intent intent = new Intent(this, UpgradesActivity.class);
        startActivity(intent);
    }

    public static void changeMoneyLabel(String s) {
        moneyTextView.setText(s);
    }
}