/*package com.smashproject.smash;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class UpgradesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        populateUsersList();
    }

    private void populateUsersList() {
        // Construct the data source
        ArrayList<Upgrades> arrayOfUsers = Upgrades.getUsers();
        // Create the adapter to convert the array to views
        UpgradesAdapter adapter = new UpgradesAdapter(this, arrayOfUsers);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
*/