package com.sanstwy777.activityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HeadActivity.class);
                startActivityForResult(intent, 0x11);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // deal with or not
        if (requestCode == 0x11 && resultCode == 0x11) {
            // display avatar
            Bundle bundle = data.getExtras();
            int imageId = bundle.getInt("imageId");
            ImageView iv = (ImageView) findViewById(R.id.imageView);
            iv.setImageResource(imageId);
        }
    }
}