package com.sanstwy777.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout outerLayout, innerLayout;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inner Layout
        innerLayout = new LinearLayout(MainActivity.this);
        innerLayout.setOrientation(LinearLayout.VERTICAL);
        ImageView imageView = new ImageView(MainActivity.this);
        imageView.setImageResource(R.mipmap.cidian);
        innerLayout.addView(imageView);
        TextView textView = new TextView(MainActivity.this);
        textView.setText(R.string.cidian);
        innerLayout.addView(textView);

        // Outer Layout
        scrollView = new ScrollView(MainActivity.this);
        scrollView.addView(innerLayout);
        outerLayout = (LinearLayout) findViewById(R.id.scrolllayout);
        outerLayout.addView(scrollView);
    }
}