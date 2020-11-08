package com.sanstwy777.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fullscreen
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

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

        // Video Player
        VideoView video = (VideoView) findViewById(R.id.video);
        // file
        File file = new File("/sdcard/Movies/sample.mp4");
        MediaController mc = new MediaController(MainActivity.this);
        // play
        if (file.exists()) {
            video.setVideoPath(file.getAbsolutePath());
            video.setMediaController(mc);
            video.requestFocus();
            try {
                video.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

            video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    Toast.makeText(MainActivity.this, "The video is done playing.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "Video doesn't exist.", Toast.LENGTH_SHORT).show();
        }
    }
}