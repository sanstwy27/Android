package com.sanstwy777.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TimePicker timepicker;
    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Time Component
        c = Calendar.getInstance();
        timepicker = (TimePicker) findViewById(R.id.timePicker1);
        timepicker.setIs24HourView(true);

        // Button
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                // AlarmManager
                AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                // Hour of clock
                c.set(Calendar.HOUR_OF_DAY, timepicker.getCurrentHour());
                // Minute of clock
                c.set(Calendar.MINUTE, timepicker.getCurrentMinute());
                // Second of clock
                c.set(Calendar.SECOND, 0);
                alarm.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
                Toast.makeText(MainActivity.this, "Clock is active", Toast.LENGTH_SHORT).show();
            }
        });
    }
}