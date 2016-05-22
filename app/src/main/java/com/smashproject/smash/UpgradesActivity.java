package com.smashproject.smash;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class UpgradesActivity extends Activity {

    ArrayList<Upgrades> arrayOfUsers;
    ListView listView;
    static int damage = 1;
    MainActivity main = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        populateUsersList();

        Context context = getApplicationContext();
        CharSequence text = "You don't have enough money.";
        int duration = Toast.LENGTH_SHORT;

        final Toast noMoney = Toast.makeText(context, text, duration);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        if(Target.getNumMoney() >= 5) {
                            damage += 1;
                            Target.payMoney(5);
                        }
                        else
                            noMoney.show();
                        break;
                    case 1:
                        if(Target.getNumMoney() >= 10) {
                            damage += 2;
                            Target.payMoney(10);
                        }
                        else
                            noMoney.show();
                        break;

                    case 2:
                        if(Target.getNumMoney() >= 15) {
                            damage += 3;
                            Target.payMoney(15);
                        }
                        else
                            noMoney.show();
                        break;
                    case 3:
                        if(Target.getNumMoney() >= 20) {
                            damage += 4;
                            Target.payMoney(20);
                        }
                        else
                            noMoney.show();
                        break;
                    case 4:
                        if(Target.getNumMoney() >= 25) {
                            damage += 5;
                            Target.payMoney(25);
                        }
                        else
                            noMoney.show();
                        break;
                    case 5:
                        if(Target.getNumMoney() >= 30) {
                            damage += 6;
                            Target.payMoney(30);
                        }
                        else
                            noMoney.show();
                        break;
                    case 6:
                        if(Target.getNumMoney() >= 35) {
                            damage += 7;
                            Target.payMoney(35);
                        }
                        else
                            noMoney.show();
                        break;
                    case 7:
                        if(Target.getNumMoney() >= 40) {
                            damage += 8;
                            Target.payMoney(40);
                        }
                        else
                            noMoney.show();
                        break;
                    case 8:
                        if(Target.getNumMoney() >= 45) {
                            damage += 9;
                            Target.payMoney(45);
                        }
                        else
                            noMoney.show();
                        break;
                }
                //main.changeMoneyLabel(Target.getNumMoney() + "");
                //finish();
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
