package com.example.newdemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView tv = findViewById(R.id.tv_price);
//        tv.setText(R.string.price);
//        tv.setTextSize(24);
//        tv.setTextColor(getColor(R.color.red));
//
//        LinearLayout linearL = new LinearLayout(this);
//        linearL.setOrientation(LinearLayout.VERTICAL);
//
//        TextView myText =   findViewById(R.id.tvlabel);
//        myText.setText("Display this Text!");
//        linearL.addView(myText);
//        setContentView(linearL);

        Log.d("MainActivity_LOG","go to onCreate");
        ((TextView)findViewById(R.id.tv_text)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity_LOG","go to onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity_LOG","go to onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity_LOG","go to onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity_LOG","go to onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity_LOG","go to onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity_LOG","go to onDestroy");
    }
}