package com.sanstwy777.colors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int[] tvid = {
            R.id.textView1, R.id.textView2, R.id.textView3,
            R.id.textView4, R.id.textView5, R.id.textView6,
            R.id.textView7, R.id.textView8, R.id.textView9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] color = getResources().getIntArray(R.array.bgcolor);
        String[] word = getResources().getStringArray(R.array.word);
        // set colors and texts
        for (int i = 0; i < 9; i++) {
            TextView tv = (TextView) findViewById(tvid[i]);
            tv.setBackgroundColor(color[i]);
            tv.setText(word[i]);
        }
    }
}