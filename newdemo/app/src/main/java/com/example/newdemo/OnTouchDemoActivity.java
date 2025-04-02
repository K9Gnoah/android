package com.example.newdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class OnTouchDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ontouch);
        LinearLayout ln = findViewById(R.id.ln_touch);
        ln.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                Log.d("OnTouchDemoActivity_Log",
                        "pointers count: " + motionEvent.getPointerCount());
                Log.d("OnTouchDemoActivity_Log", "X= " + motionEvent.getX(0));
                Log.d("OnTouchDemoActivity_Log", "Y= " + motionEvent.getY(0));
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("OnTouchDemoActivity_Log", "ACTION_DOWN");
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    Log.d("OnTouchDemoActivity_Log", "ACTION_UP");
                } else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    Log.d("OnTouchDemoActivity_Log", "ACTION_MOVE");
                }
                return true;// true thì show realtime, false thì show điểm cuối
            }
        });
    }
}