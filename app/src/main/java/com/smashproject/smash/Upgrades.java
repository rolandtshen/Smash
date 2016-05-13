package com.smashproject.smash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class Upgrades extends AppCompatActivity {
    private String[] upgrades = new String[] { "GLOVE OF BOOM", "HAPPY FEET 2"};

    ListAdapter gloveAdapter;
    ListAdapter helperAdapter;
    ListView gloveList;
    ListView helperList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrades);
        gloveList = (ListView) findViewById(R.id.gloveUpgrades);
        //helperList = (ListView) findViewById(R.id.helperUpgrades);
        gloveAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, upgrades);
        gloveList.setAdapter(gloveAdapter);
        helperList.setAdapter(gloveAdapter);
    }
}
