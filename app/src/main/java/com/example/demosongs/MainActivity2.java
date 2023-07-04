package com.example.demosongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv = findViewById(R.id.lv);

        Intent intentReceived = getIntent();
        ArrayList<Song> songlist = new ArrayList<Song>();

        ArrayAdapter allsongs = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songlist);
        lv.setAdapter( allsongs);

        DBHelper db = new DBHelper(MainActivity2.this);
        songlist.clear();
        songlist.addAll(db.getSongs());
        allsongs.notifyDataSetChanged();
    }
}