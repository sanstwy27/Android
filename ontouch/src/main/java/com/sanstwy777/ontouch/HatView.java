package com.sanstwy777.ontouch;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class HatView extends View {
    public float bitmapX;
    public float bitmapY;

    public HatView(Context context) {
        super(context);
        bitmapX = 65;
        bitmapY = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        // redraw
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.hat);
        canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint);
        if (bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }
}