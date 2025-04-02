package com.example.newdemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Intent2ndview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2ndview);
        CharSequence name = getIntent().getCharSequenceExtra("name");
        int age = getIntent().getIntExtra("age",0);
        ((TextView)findViewById(R.id.tv_result)).setText(name+"/"+age);
        }
}