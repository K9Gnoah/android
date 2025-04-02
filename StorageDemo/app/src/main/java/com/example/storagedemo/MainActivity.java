package com.example.storagedemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edt_usn, edt_pass;
    CheckBox cb;
    SharedPreferences share_pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        ((Button)findViewById(R.id.btn_login)).setOnClickListener(this);
        edt_usn = findViewById(R.id.edt_username);
        edt_pass = findViewById(R.id.edt_pass);
        cb = findViewById(R.id.cb_remember);
        share_pref = getSharedPreferences("account", MODE_PRIVATE);
        String u = share_pref.getString("username", "");
        String p = share_pref.getString("pass", "");
        boolean is_remember = share_pref.getBoolean("is_saved", false);

        if(is_remember){
            edt_usn.setText(u);
            edt_pass.setText(p);
            cb.setChecked(true);
        }
        else{
            editor = share_pref.edit();
            editor.clear();
            //editor.remove("username");....
            editor.commit();
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_login){
            if(cb.isChecked()){
                editor = share_pref.edit();
                editor.putString("username", edt_usn.getText().toString());
                editor.putString("pass", edt_pass.getText().toString());
                editor.putBoolean("is_saved", true);
                editor.commit();
            }
        }
    }
}