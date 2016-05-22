package com.smashproject.smash;

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
                textInstructions.setVisibility(View.VISIBLE);
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
