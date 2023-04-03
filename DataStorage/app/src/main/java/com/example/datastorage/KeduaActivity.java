package com.example.datastorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KeduaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        SharedPreferences sharedPreferences =
                PreferenceManager
                        .getDefaultSharedPreferences(getApplicationContext());
        String nama = sharedPreferences.getString("nama","");

        Bundle extras = getIntent().getExtras();
        TextView txvNama = (TextView) findViewById(R.id.txvNama);
        txvNama.setText(nama);
    }
}