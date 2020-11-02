package com.sanstwy777.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = findViewById(R.id.bt);
        rg = findViewById(R.id.rg);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < rg.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) rg.getChildAt(i);
                    if (radioButton.isChecked()) {
                        if (radioButton.getText().equals("D: NONE OF THESE")) {
                            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("Wrong.. roosters don't lay eggs.");
                            builder.setPositiveButton("OK", null).show();
                        }
                        break;
                    }
                }
            }
        });
    }
}