package com.sanstwy777.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout fragment = (FrameLayout) findViewById(R.id.frameLayout);
        fragment.addView(new MyView(this));
    }

    private class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            Shader shader = new LinearGradient(
                    0, 0, 100, 100,
                    Color.RED, Color.GREEN, Shader.TileMode.MIRROR);
            paint.setShader(shader);
            canvas.drawRect(10, 10, 280, 150, paint);
            super.onDraw(canvas);
        }
    }
}