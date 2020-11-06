package com.sanstwy777.actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button action_show, action_hide;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        action_show = (Button) findViewById(R.id.actionBar_show);
        action_hide = (Button) findViewById(R.id.actionBar_hide);
        action_show.setOnClickListener(l); // OnClickListener show
        action_hide.setOnClickListener(l); // OnClickListener hide
    }

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.actionBar_show:
                    actionBar.show();
                    break;
                case R.id.actionBar_hide:
                    actionBar.hide();
                    break;
            }
        }
    };
}