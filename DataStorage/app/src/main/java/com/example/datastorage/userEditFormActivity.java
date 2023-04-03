package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.datastorage.crud.userCRUD;

public class userEditFormActivity extends AppCompatActivity {

    EditText edtNamaE;
    EditText edtTipeE;
    EditText edtPanjangE;
    TextView edtStatusE;
    Button btnSimpanUserE;
    String Nama = "";
    String Tipe = "";
    String Panjang = "";
    String Status = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit_form);

        edtNamaE = (EditText) findViewById(R.id.edtNamaE);
        edtTipeE = (EditText) findViewById(R.id.edtTipeE);
        edtPanjangE = (EditText) findViewById(R.id.edtPanjangE);
        edtStatusE = (TextView) findViewById(R.id.edtStatusE);
        btnSimpanUserE = (Button) findViewById(R.id.btnSimpanUserE);

        edtNamaE.setText(getIntent().getStringExtra("nama"));
        edtTipeE.setText(getIntent().getStringExtra("tipe"));
        edtPanjangE.setText(getIntent().getStringExtra("panjang"));
        edtStatusE.setText(getIntent().getStringExtra("status"));

        btnSimpanUserE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nama = edtNamaE.getText().toString();
                Tipe = edtTipeE.getText().toString();
                Panjang = edtPanjangE.getText().toString();
                Status = edtStatusE.getText().toString();
                userCRUD usercrud = new userCRUD();
                usercrud.updateDataUser(Nama, Tipe, Panjang, Status);
                finish();
            }
        });

    }
}