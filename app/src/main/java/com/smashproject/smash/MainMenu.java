package com.smashproject.smash;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by michaelxue on 5/21/16.
 */
public class MainMenu extends AppCompatActivity {

    Button startGame;
    Button instructions;
    TextView textInstructions;
    Context c = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        startGame = (Button) findViewById(R.id.start);
        instructions = (Button) findViewById(R.id.instructions);
        textInstructions = (TextView) findViewById(R.id.textInstructions);
        instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(c)
                        .setMessage("Tap your opponents until they die. Obtain money and buy upgrades for more effective gloves as enemies get stronger.")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .show();
            }
        });
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginGame();
            }
        });
    }
    private void beginGame(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}