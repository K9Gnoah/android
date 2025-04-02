package com.example.newdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DemoIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_intent);
    }

//    public void onNext(View view) {
//        //explicit intent (tường minh) : mở activity, service, trong nội bộ app, send broadcast, gửi kèm dữ liệu)
//        Intent i = new Intent(this, Intent2ndview.class);
//        CharSequence name = ((EditText)findViewById(R.id.editTextText)).getText();
//        CharSequence age_str = ((EditText)findViewById(R.id.editTextNumber)).getText().toString();
//        int age = Integer.parseInt(age_str.toString());
//        i.putExtra("name", name);
//        i.putExtra("age", age);
//        startActivity(i);
//    }

    public void onNext(View v){
        //implicit intent: mở activity của app khác thông qua bộ lọc
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0967841565"));
        startActivity(i);
    }
}

//home work : create app with one activity(include 1 button, 1 imageview), click button to open camera
//take photo and bring the photo to the original activity and display on ImageView