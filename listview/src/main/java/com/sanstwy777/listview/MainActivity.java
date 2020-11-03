package com.sanstwy777.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView) findViewById(R.id.listview);

        // Image Set
        int[] imageId = new int[]{
                R.mipmap.img01, R.mipmap.img02, R.mipmap.img03,
                R.mipmap.img04, R.mipmap.img05, R.mipmap.img06,
                R.mipmap.img07, R.mipmap.img08, R.mipmap.img09,
        };
        String[] title = new String[]{
                "Alice", "Bob", "Charlie",
                "David", "Eve", "Frank",
                "Grace", "Heidi", "Ivan"
        };
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageId.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", imageId[i]);
            map.put("name", title[i]);
            listItems.add(map);
        }

        // Adapter
        SimpleAdapter adapter = new SimpleAdapter(this, listItems,
                R.layout.main, new String[]{"name", "image"}, new int[]{R.id.title, R.id.image});
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, map.get("name").toString(), Toast.LENGTH_SHORT).show();


            }
        });
    }
}