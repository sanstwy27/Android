package com.sanstwy777.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton_phone);
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton_sms);
        imageButton.setOnClickListener(l);
        imageButton1.setOnClickListener(l);
    }

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            // startActivity by ImageButton Id
            switch (v.getId()) {
                case R.id.imageButton_phone:
                    intent.setAction(intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:0123456789"));
                    startActivity(intent);
                    break;
                case R.id.imageButton_sms:
                    intent.setAction(intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:9876543210"));
                    intent.putExtra("sms_body", "Welcome to Android!");
                    startActivity(intent);
            }
        }
    };
}