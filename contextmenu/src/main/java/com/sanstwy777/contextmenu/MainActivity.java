package com.sanstwy777.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView introduce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        introduce = (TextView) findViewById(R.id.introduce);
        registerForContextMenu(introduce);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.introduce_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_copy:
                Toast.makeText(MainActivity.this, "Copied", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_collect:
                Toast.makeText(MainActivity.this, "Collected", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}