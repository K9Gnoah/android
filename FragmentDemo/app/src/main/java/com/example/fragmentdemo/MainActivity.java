package com.example.fragmentdemo;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    FragmentManager fManager;
    FragmentA fA;
    FragmentB fB;
    FragmentTransaction trans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.btn_add)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn_replace)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn_remove)).setOnClickListener(this);
        fManager = getSupportFragmentManager();
        fA = FragmentA.newInstance(null, null);
        fB = FragmentB.newInstance(null, null);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_add){
            trans = fManager.beginTransaction();
            trans.add(R.id.layout_container, fA, "");
            trans.commit();
        } else if (view.getId() == R.id.btn_replace){
            trans = fManager.beginTransaction();
            trans.replace(R.id.layout_container, fB, "");
            trans.addToBackStack("");
            trans.commit();
        } else if (view.getId() == R.id.btn_remove){
            trans = fManager.beginTransaction();
            trans.remove(fB);
            trans.commit();
        }
    }
}