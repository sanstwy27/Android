package com.sanstwy777.bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // locale
                String site1 = ((EditText) findViewById(R.id.et_site1)).getText().toString();
                // street
                String site2 = ((EditText) findViewById(R.id.et_site2)).getText().toString();
                // address
                String site3 = ((EditText) findViewById(R.id.et_site3)).getText().toString();
                // name
                String name = ((EditText) findViewById(R.id.et_name)).getText().toString();
                // phone
                String phone = ((EditText) findViewById(R.id.et_phone)).getText().toString();
                // email
                String email = ((EditText) findViewById(R.id.et_email)).getText().toString();
                if (!"".equals(site1) && !"".equals(site2) && !"".equals(site3) &&
                        !"".equals(name) && !"".equals(phone) && !"".equals(email)) {
                    // pass Bundle by Intent
                    Intent intent = new Intent(MainActivity.this, AddressActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("name", name);
                    bundle.putCharSequence("phone", phone);
                    bundle.putCharSequence("site1", site1);
                    bundle.putCharSequence("site2", site2);
                    bundle.putCharSequence("site3", site3);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "some info is missing", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}