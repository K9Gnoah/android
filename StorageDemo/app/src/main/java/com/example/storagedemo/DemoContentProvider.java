package com.example.storagedemo;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.CommonDataKinds;

import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DemoContentProvider extends AppCompatActivity {
    ContentResolver resolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_content_provider);
        requestContactPermission(android.Manifest.permission.READ_CONTACTS, 10);
        requestContactPermission(Manifest.permission.READ_PHONE_NUMBERS, 11);

        resolver= getContentResolver();
    }

    public void onReadContact(View view) {
        Cursor c = resolver.query(Contacts.CONTENT_URI,
                new String[]{Contacts._ID, Contacts.DISPLAY_NAME},
                null, null, null);
        String result =" ";
        while (c.moveToNext()){
            int col = c.getColumnIndex(Contacts._ID);
            int id = c.getInt(col);
            col = c.getColumnIndex(Contacts.DISPLAY_NAME);
            String name = c.getString(col);
            Cursor c1 = resolver.query(CommonDataKinds.Phone.CONTENT_URI,
                    new String[]{CommonDataKinds.Phone.NUMBER},
                    CommonDataKinds.Phone.CONTACT_ID + "=?",
                    new String[]{String.valueOf(id)}, null);
            String phones = "";
            while (c1.moveToNext()){
                int index = c1.getColumnIndex(CommonDataKinds.Phone.NUMBER);
                String ph = c1.getString(index);

                phones += ph + ", ";
            }
            result += id + ": " + phones + "\n";
        }
        ((TextView)findViewById(R.id.textView)).setText(result);
    }

    public void requestContactPermission(String p, int code) {
        if(checkSelfPermission(p) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{p}, code);
        }
    }
}