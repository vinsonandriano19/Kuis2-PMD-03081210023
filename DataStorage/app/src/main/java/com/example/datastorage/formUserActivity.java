package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.datastorage.User.User;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class formUserActivity extends AppCompatActivity {

    EditText edtNama, edtTipe, edtPanjang;
    TextView edtStatus;
    Button btnSimpanUser;
    String Nama = "";
    String Tipe = "";
    String Panjang = "";
    String Status = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);

        edtNama = (EditText) findViewById(R.id.edtNama);
        edtTipe = (EditText) findViewById(R.id.edtTipe);
        edtPanjang = (EditText) findViewById(R.id.edtPanjang);
        edtStatus = (TextView) findViewById(R.id.edtStatus);
        btnSimpanUser = (Button) findViewById(R.id.btnSimpanUser);

        btnSimpanUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nama = (String) edtNama.getText().toString();
                Tipe = (String) edtTipe.getText().toString();
                Panjang = (String) edtPanjang.getText().toString();
                Status = (String) edtStatus.getText().toString();
                tambahDataUser(Nama, Tipe, Panjang, Status);
            }
        });

    }
    public void tambahDataUser(String Nama, String Tipe, String Panjang, String Status) {
        Realm realm = Realm.getDefaultInstance();
        //penyimpanan data
        realm.executeTransaction(new Realm.Transaction() {
                                     @Override
                                     public void execute(Realm realm) {
                                         try {
                                             User user1 = realm.createObject(User.class, Status);
                                             user1.setNama(Nama);
                                             user1.setTipe(Tipe);
                                             user1.setPanjang(Panjang);
                                             finish();

                                         } catch (RealmPrimaryKeyConstraintException e) {
                                             Log.d("TAG", "Primary Key Sudah ada + " + e.getMessage().toString());
                                         }

                                     }
                                 }
        );
        realm.close();
    }
}