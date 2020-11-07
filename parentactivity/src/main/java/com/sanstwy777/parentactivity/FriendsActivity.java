package com.sanstwy777.parentactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;

public class FriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        if (NavUtils.getParentActivityName(FriendsActivity.this) != null) {
            // display backward sign
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}