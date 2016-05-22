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
                        if(Target.getNumPoints() >= 5) {
                            damage = 2;
                            Target.payMoney(5);
                            break;
                        }
                        else
                        break;
                    case 2:
                        if(Target.getNumPoints() >= 15) {
                            damage = 5;
                            Target.payMoney(15);
                            break;
                        }
                        else
                        break;
                    case 3:
                        if(Target.getNumPoints() >= 40) {
                            damage = 8;
                            Target.payMoney(40);
                            break;
                        }
                        else
                        break;
                    case 4:
                        if(Target.getNumPoints() >= 90) {
                            damage = 12;
                            Target.payMoney(90);
                            break;
                        }
                        else
                        break;
                    case 5:
                        if(Target.getNumPoints() >= 150) {
                            damage = 18;
                            Target.payMoney(150);
                            break;
                        }
                        else
                        break;
                    case 6:
                        if(Target.getNumPoints() >= 200) {
                            damage = 24;
                            Target.payMoney(200);
                            break;
                        }
                        else
                        break;
                    case 7:
                        if(Target.getNumPoints() >= 260) {
                            damage = 32;
                            Target.payMoney(260);
                            break;
                        }
                        else
                        break;
                    case 8:
                        if(Target.getNumPoints() >= 400) {
                            damage = 40;
                            Target.payMoney(400);
                            break;
                        }
                        else
                        break;
                }
                finish();
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
