package com.smashproject.smash;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class UpgradesActivity extends Activity {

    ArrayList<Upgrades> arrayOfUsers;
    ListView listView;
    TextView pointsTextView;
    static int damage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        pointsTextView = (TextView) findViewById(R.id.money);
        populateUsersList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        damage = 1;
                        Target.payMoney(0);
                        break;
                    case 1:
                        if(Target.numPoints >= 5) {
                            damage = 2;
                            Target.payMoney(5);
                            break;
                        }
                    case 2:
                        if(Target.numPoints >= 10) {
                            damage = 3;
                            Target.payMoney(10);
                            break;
                        }
                    case 3:
                        if(Target.numPoints >= 15) {
                            damage = 4;
                            Target.payMoney(15);
                            break;
                        }
                    case 4:
                        if(Target.numPoints >= 20) {
                            damage = 5;
                            Target.payMoney(20);
                            break;
                        }
                    case 5:
                        if(Target.numPoints >= 25) {
                            damage = 6;
                            Target.payMoney(25);
                            break;
                        }
                    case 6:
                        if(Target.numPoints >= 30) {
                            damage = 7;
                            Target.payMoney(30);
                            break;
                        }
                    case 7:
                        if(Target.numPoints >= 35) {
                            damage = 8;
                            Target.payMoney(35);
                            break;
                        }
                    case 8:
                        if(Target.numPoints >= 10) {
                            damage = 9;
                            Target.payMoney(40);
                            break;
                        }
                }
                finish();
                //pointsTextView.setText(Target.numPoints);
            }
        });
    }

    private void populateUsersList() {
        // Construct the data source
        arrayOfUsers = Upgrades.getUsers();
        // Create the adapter to convert the array to views
        UpgradesAdapter adapter = new UpgradesAdapter(this, arrayOfUsers);
        // Attach the adapter to a ListView
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    public static int getDamage(){
        return damage;
    }
}
