package com.sanstwy777.tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.tab1, tabHost.getTabContentView());
        inflater.inflate(R.layout.tab2,tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("Popular")
                .setContent(R.id.linearlayout1));
        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("Post")
                .setContent(R.id.framelayout));
    }
}