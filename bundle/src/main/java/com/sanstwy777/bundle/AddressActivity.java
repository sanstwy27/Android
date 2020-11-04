package com.sanstwy777.bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        Intent intent = getIntent();
        // get bundle info.
        Bundle bundle = intent.getExtras();

        // display
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(bundle.getString("name"));
        TextView phone = (TextView) findViewById(R.id.phone);
        phone.setText(bundle.getString("phone"));
        TextView site = (TextView) findViewById(R.id.site);
        site.setText(bundle.getString("site1") + bundle.getString("site2") + bundle.get("site3"));
    }
}