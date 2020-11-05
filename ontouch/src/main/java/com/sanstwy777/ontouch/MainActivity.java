package com.sanstwy777.ontouch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        final HatView hat = new HatView(MainActivity.this);
        hat.setOnTouchListener((v, event) -> {
            hat.bitmapX = event.getX() - 80; // reposition x
            hat.bitmapY = event.getY() - 50; // reposition y
            hat.invalidate(); // redraw
            return true;
        });
        relativeLayout.addView(hat);
    }
}