package com.example.dishant.navdraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TimeResult extends AppCompatActivity {

    ArrayList<String> names;
    ArrayList<String> views;
    ListView listView;

    @Override
    protected void onStart() {
        super.onStart();

        names = getIntent().getStringArrayListExtra("names");
        views = getIntent().getStringArrayListExtra("views");
        listView = (ListView) findViewById(R.id.timeres);
        ListAdapter arrayAdapter = new CustomAdapter(getApplicationContext(), names, views);
        listView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_result);
    }
}
