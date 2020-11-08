package com.sanstwy777.bitmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        frameLayout.addView(new MyView(this));
    }

    private class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            String path = Environment.getExternalStorageDirectory() + "/Pictures/ic_launcher.png";
            Bitmap bm = BitmapFactory.decodeFile(path);
            canvas.drawBitmap(bm, 0, 30, paint);
            Rect src = new Rect(105, 70, 220, 170);
            Rect dst = new Rect(350, 90, 465, 190);
            canvas.drawBitmap(bm, src, dst, paint);
        }
    }
}