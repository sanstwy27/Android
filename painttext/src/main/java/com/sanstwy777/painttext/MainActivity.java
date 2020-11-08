package com.sanstwy777.painttext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
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
            Paint paintText = new Paint();
            paintText.setColor(Color.BLACK);
            paintText.setTextAlign(Paint.Align.LEFT);
            paintText.setTextSize(12);
            paintText.setAntiAlias(true);
            canvas.drawText("AAAAAAA!", 245, 35, paintText);
            canvas.drawText("BBBBBBBBBBB", 170, 140, paintText);
            canvas.drawText("BBBB?", 170, 155, paintText);
        }
    }
}