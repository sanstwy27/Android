package com.sanstwy777.mediaplayer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer player;
    private boolean isPause = false;
    private File file;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // PERMISSION_GRANTED
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
            for (String str : permissions) {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                    return;
                }
            }
        }

        // Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Player
        final ImageButton btn_play = (ImageButton) findViewById(R.id.btn_play);
        final ImageButton btn_stop = (ImageButton) findViewById(R.id.btn_stop);
        file = new File("/sdcard/Music/icarus.mp3");
        if (file.exists()) {
            // exist
            player = MediaPlayer.create(this, Uri.parse(file.getAbsolutePath()));
        } else {
            // not exist
            Toast.makeText(MainActivity.this, "File not exist!", Toast.LENGTH_SHORT).show();
            return;
        }

        // auto-replay
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                play();
            }
        });

        // play and pause
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.isPlaying() && !isPause) {
                    player.pause();
                    isPause = true;
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.play, null));
                } else {
                    // resume
                    player.start();
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.pause, null));
                    isPause = false;
                }
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                btn_play.setImageDrawable(getResources().getDrawable(R.drawable.play, null));
            }
        });
    }

    private void play() {
        try {
            player.reset();
            player.setDataSource(file.getAbsolutePath());
            player.prepare();
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        if (player.isPlaying()) {
            player.stop();
        }
        player.release();
        super.onDestroy();
    }
}