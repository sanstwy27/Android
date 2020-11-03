package com.sanstwy777.ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RatingBar ratingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingbar = (RatingBar) findViewById(R.id.ratingBar1);
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = ratingbar.getProgress();
                float rating = ratingbar.getRating();
                float step = ratingbar.getStepSize();
                Log.i("Rating bar ", " step=" + step + " result=" + result + " rating=" + rating);
                Toast.makeText(MainActivity.this, "You got " + rating + " star", Toast.LENGTH_SHORT).show();
            }
        });
    }
}