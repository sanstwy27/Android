package com.sanstwy777.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    final String MY_MESSAGE = "com.sanstwy777";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Note: For Android 8.0 (API level 26) and higher, static receivers can't receive most implicit broadcasts.
         * (Implicit broadcasts are broadcasts that don't target your app specifically.)
         * Even if you register for these broadcasts in the manifest,
         * the Android system won't deliver them to your app.
         * However, you can still use a dynamic receiver to register for these broadcasts.
         */
        IntentFilter filter = new IntentFilter();
        filter.addAction(MY_MESSAGE);
        MyReceiver myReceiver = new MyReceiver();
        registerReceiver(myReceiver, filter);

        // Broadcast button
        Button button = (Button) findViewById(R.id.Broadcast);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(MY_MESSAGE);
                sendBroadcast(intent);
            }
        });
    }
}