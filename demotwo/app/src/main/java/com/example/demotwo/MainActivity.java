package com.example.demotwo;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ggpixelimg);
        TextView tv = findViewById(R.id.tv_price);
        tv.setText(R.string.price);
        tv.setTextSize(24);
        tv.setTextColor(getColor(R.color.red));

        LinearLayout linearL = new LinearLayout(this);
        linearL.setOrientation(LinearLayout.VERTICAL);

        TextView myText =   findViewById(R.id.tvlabel);
        myText.setText("Display this Text!");
        linearL.addView(myText);
        setContentView(linearL);
    }
}