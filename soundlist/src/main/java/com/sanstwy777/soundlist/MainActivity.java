package com.sanstwy777.soundlist;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Sound
         */
        // sound attr.
        AudioAttributes attr = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
        final SoundPool soundpool = new SoundPool.Builder()
                .setAudioAttributes(attr)
                .setMaxStreams(10)
                .build();

        // Sound HashMap
        final HashMap<Integer, Integer> soundmap = new HashMap<Integer, Integer>();
        soundmap.put(0, soundpool.load(this, R.raw.cuckoo, 1));
        soundmap.put(1, soundpool.load(this, R.raw.chimes, 1));
        soundmap.put(2, soundpool.load(this, R.raw.notify, 1));
        soundmap.put(3, soundpool.load(this, R.raw.ringout, 1));
        soundmap.put(4, soundpool.load(this, R.raw.bird, 1));
        soundmap.put(5, soundpool.load(this, R.raw.water, 1));
        soundmap.put(6, soundpool.load(this, R.raw.cock, 1));

        /**
         * ListView
         */
        ListView listview = (ListView) findViewById(R.id.listView);

        // Text List
        String[] title = new String[]{
                "Cuckoo sound", "Wind chimes sound", "Doorbell sound", "Tel sound",
                "Bird sound", "Water sound", "Cock sound"};
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < title.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", title[i]);
            listItems.add(map);
        }

        // SimpleAdapter associate with ListView
        SimpleAdapter adapter = new SimpleAdapter(this, listItems,
                R.layout.main, new String[]{"name",}, new int[]{
                R.id.title});
        listview.setAdapter(adapter);

        // ListView OnItemClickListener
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
                soundpool.play(soundmap.get(position), 1, 1, 0, 0, 1);
            }
        });
    }
}