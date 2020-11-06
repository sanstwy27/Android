package com.sanstwy777.gestureoverlayview;

import androidx.appcompat.app.AppCompatActivity;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {
    private GestureLibrary library;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        // Load gesture
        library = GestureLibraries.fromRawResource(MainActivity.this, R.raw.gestures);
        if (!library.load()) {
            finish();
        }
        GestureOverlayView gestureOverlayView = (GestureOverlayView) findViewById(R.id.gesture);
        gestureOverlayView.setGestureColor(Color.BLACK);
        gestureOverlayView.setFadeOffset(1000);
        gestureOverlayView.addOnGesturePerformedListener(this);
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        // Load gestures
        ArrayList<Prediction> gestures = library.recognize(gesture);
        int index = 0;
        double score = 0.0;
        // get best score of gestures
        for (int i = 0; i < gestures.size(); i++) {
            Prediction result = gestures.get(i);
            if (result.score > score) {
                index = i;
                score = result.score;
            }
        }
        // concat gesture text
        String text = editText.getText().toString();
        text += gestures.get(index).name;
        editText.setText(text);
    }
}