package com.sanstwy777.paintbitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    private int view_width = 0;
    private int view_height = 0;
    private float preX;
    private float preY;
    private Path path;
    public Paint paint = null;
    Bitmap cacheBitmap = null;
    Canvas cacheCanvas = null;

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view_width = context.getResources().getDisplayMetrics().widthPixels;
        view_height = context.getResources().getDisplayMetrics().heightPixels;
        System.out.println("Screen: " + view_width + " * " + view_height);
        // bitmap
        cacheBitmap = Bitmap.createBitmap(view_width, view_height, Bitmap.Config.ARGB_8888);
        cacheCanvas = new Canvas();
        path = new Path();
        cacheCanvas.setBitmap(cacheBitmap);
        paint = new Paint();
        paint.setColor(Color.RED);
        // pen style
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(cacheBitmap, 0, 0, null);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // start point
                path.moveTo(x, y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                // new point
                float dx = Math.abs(x - preX);
                float dy = Math.abs(y - preY);
                if (dx >= 5 || dy >= 5) {
                    // add a quadratic bezier from the last point
                    path.quadTo(preX, preY, (x + preX) / 2, (y + preY) / 2);
                    preX = x;
                    preY = y;
                }
                break;
            case MotionEvent.ACTION_UP:
                // end point
                cacheCanvas.drawPath(path, paint);
                path.reset();
                break;
        }
        // refresh
        invalidate();
        // consume event
        return true;
    }


    public void clear() {
        if (cacheCanvas != null) {
            path.reset();
            cacheCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            invalidate();
        }
    }
}
