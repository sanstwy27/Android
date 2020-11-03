package com.sanstwy777.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private int[] arrayPictures = new int[]{
            R.mipmap.img01, R.mipmap.img02, R.mipmap.img03,
            R.mipmap.img04, R.mipmap.img05, R.mipmap.img06,
            R.mipmap.img07, R.mipmap.img08, R.mipmap.img09,
    };
    private ImageSwitcher imageSwitcher;
    // display index
    private int pictureIndex;
    // x pos on touching down
    private float touchDownX;
    // x pos on touching up
    private float touchUpX;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FULLSCREEN
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageswitcher);
        // set ImageSwitcher Factory for making ImageView
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(arrayPictures[pictureIndex]);
                return imageView;
            }
        });

        imageSwitcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                     touchDownX = event.getX();
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    touchUpX = event.getX();
                    if (touchUpX - touchDownX > 100) {
                        // To left
                        pictureIndex = pictureIndex == 0 ? arrayPictures.length - 1 : pictureIndex - 1;
                        // animation
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_left));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_out_right));
                        // display
                        imageSwitcher.setImageResource(arrayPictures[pictureIndex]);
                    } else if (touchDownX - touchUpX > 100) {
                        // To right
                        pictureIndex = pictureIndex == arrayPictures.length - 1 ? 0 : pictureIndex + 1;
                        // animation
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_out_left));
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_right));
                        // display
                        imageSwitcher.setImageResource(arrayPictures[pictureIndex]);
                    }
                    return true;
                }
                return false;
            }
        });
    }

    public boolean performClick() {
        return true;
    }
}