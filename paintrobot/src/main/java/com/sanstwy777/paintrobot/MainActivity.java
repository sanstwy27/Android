package com.sanstwy777.paintrobot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(0xFFA4C739);
            // head
            RectF rectf_head = new RectF(10, 10, 100, 100);
            rectf_head.offset(90, 20);
            canvas.drawArc(rectf_head, -10, -160, false, paint);
            // eye
            paint.setColor(Color.WHITE);
            canvas.drawCircle(125, 53, 4, paint);
            canvas.drawCircle(165, 53, 4, paint);
            paint.setColor(0xFFA4C739);
            // antenna
            paint.setStrokeWidth(2);
            canvas.drawLine(110, 15, 125, 35, paint);
            canvas.drawLine(180, 15, 165, 35, paint);
            // body
            canvas.drawRect(100, 75, 190, 150, paint);
            RectF rectf_body = new RectF(100, 140, 190, 160);
            canvas.drawRoundRect(rectf_body, 10, 10, paint);
            // arm
            RectF rectf_arm = new RectF(75, 75, 95, 140);
            canvas.drawRoundRect(rectf_arm, 10, 10, paint);
            rectf_arm.offset(120, 0);
            canvas.drawRoundRect(rectf_arm, 10, 10, paint);
            // leg
            RectF rectf_leg = new RectF(115, 150, 135, 200);
            canvas.drawRoundRect(rectf_leg, 10, 10, paint);
            rectf_leg.offset(40, 0);
            canvas.drawRoundRect(rectf_leg, 10, 10, paint);
        }
    }
}