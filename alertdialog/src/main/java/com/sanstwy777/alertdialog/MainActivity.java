package com.sanstwy777.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean[] checkedItems;
    private String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Alert
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setIcon(R.drawable.advise);
                alertDialog.setTitle("Someone:");
                alertDialog.setMessage("famous saying");
                // Yes
                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You choose 'Yes'", Toast.LENGTH_SHORT).show();
                    }
                });
                // No
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You choose 'No'", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{
                        "A",
                        "B",
                        "C",
                        "D"
                };
                // Alert
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.advise1);
                builder.setTitle("Select");
                // List
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                "You choose " + items[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[] {
                        "A",
                        "B",
                        "C",
                        "D",
                        "E"
                };
                // Alert
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.advise2);
                builder.setTitle("Select:");
                builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                "You choose " + items[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("OK", null);
                builder.create().show();
            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedItems = new boolean[] {
                        false,
                        true,
                        false,
                        true,
                        false
                };
                items = new String[] {
                        "A",
                        "B",
                        "C",
                        "D",
                        "E"
                };
                // Alert
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.advise2);
                builder.setTitle("Select:");
                builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;
                    }
                });
                // Button
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = "";
                        for (int i = 0; i < checkedItems.length; i++) {
                            if (checkedItems[i]) {
                                result += items[i] + ", ";
                            }
                        }
                        // Result
                        if (!"".equals(result)) {
                            // remove last ', '
                            result = result.substring(0, result.length() - 2);
                            Toast.makeText(MainActivity.this,
                                    "You choose [ " + result + " ]", Toast.LENGTH_LONG).show();
                        }

                    }
                });
                builder.create().show();
            }
        });
    }
}