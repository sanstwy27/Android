package com.sanstwy777.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView password = (TextView) findViewById(R.id.wang_mima);
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent
                Intent intent = new Intent(MainActivity.this, PasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}