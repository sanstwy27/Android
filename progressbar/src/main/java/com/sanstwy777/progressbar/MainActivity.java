package com.sanstwy777.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ProgressBar horizonP;
    private int mProgressStatus = 0;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FULLSCREEN
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // ProgressBar
        horizonP = (ProgressBar) findViewById(R.id.progressBar1);
        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x111) {
                    // update progress
                    horizonP.setProgress(mProgressStatus);
                } else {
                    // done
                    Toast.makeText(MainActivity.this, "process done", Toast.LENGTH_SHORT).show();
                    horizonP.setVisibility(View.GONE);
                }
            }
        };
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    // get current status
                    mProgressStatus = doWork();
                    // message
                    Message m = new Message();
                    if (mProgressStatus < 100) {
                        m.what = 0x111;
                        mHandler.sendMessage(m);
                    } else {
                        m.what = 0x110;
                        mHandler.sendMessage(m);
                        break;
                    }
                }

            }

            // simulate some work
            private int doWork() {
                // progress time
                mProgressStatus += Math.random() * 10;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // done
                return mProgressStatus;
            }
        }).start();
    }
}