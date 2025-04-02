package com.example.newdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GestureDemoActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{
    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_demo);
        gestureDetector = new GestureDetector(this, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        Log.d("GestureDemo_Log","onDown");
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        Log.d("GestureDemo_Log","onSingleTapUp");

        return false;
    }

    @Override
    public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
        Log.d("GestureDemo_Log","onScroll");

        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        Log.d("GestureDemo_Log","onFling");

        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
        Log.d("GestureDemo_Log", "onSingleTapConfirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent e) {
        Log.d("GestureDemo_Log","onDoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent e) {
        Log.d("GestureDemo_Log","onDoubleTapEvent");
        return false;
    }
}