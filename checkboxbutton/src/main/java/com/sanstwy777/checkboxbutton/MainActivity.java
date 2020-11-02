package com.sanstwy777.checkboxbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    CheckBox checkBox1, checkBox2, checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checked = "";
                if (checkBox1.isChecked()) {
                    checked += checkBox1.getText().toString() + " ";
                }
                if (checkBox2.isChecked()) {
                    checked += checkBox2.getText().toString() + " ";
                }
                if (checkBox3.isChecked()) {
                    checked += checkBox3.getText().toString() + " ";
                }
                Toast.makeText(MainActivity.this, checked, Toast.LENGTH_LONG).show();
            }
        });
    }
}