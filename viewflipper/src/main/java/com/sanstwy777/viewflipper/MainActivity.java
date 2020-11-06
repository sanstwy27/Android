package com.sanstwy777.viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    ViewFlipper flipper;
    GestureDetector detector;

    // ViewFlipper Animations
    Animation[] animation = new Animation[4];
    // Minimum Gesture Diff Distance
    final int distance = 50;
    private int[] images = new int[]{
            R.drawable.img01, R.drawable.img02, R.drawable.img03,
            R.drawable.img04, R.drawable.img05, R.drawable.img06,
            R.drawable.img07, R.drawable.img08, R.drawable.img09,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detector = new GestureDetector(this, this);
        flipper = (ViewFlipper) findViewById(R.id.flipper);
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            flipper.addView(imageView);
        }
        // init animations
        animation[0] = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        animation[1] = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        animation[2] = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        animation[3] = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        // flip to left or right
        if (e1.getX() - e2.getX() > distance) {
            // set flipper animation
            flipper.setInAnimation(animation[2]);
            flipper.setOutAnimation(animation[1]);
            flipper.showPrevious();
            return true;
        } else if (e2.getX() - e1.getX() > distance) {
            // set flipper animation
            flipper.setInAnimation(animation[0]);
            flipper.setOutAnimation(animation[3]);
            flipper.showNext();
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // delegate to GestureDetector
        return detector.onTouchEvent(event);
    }
}