package com.example.datastorage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datastorage.User.User;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //config Realm
        Realm.init(this);
        RealmConfiguration config =
                new RealmConfiguration.Builder()
                        .allowWritesOnUiThread(true)
                        .deleteRealmIfMigrationNeeded()
                        .build();
        Realm.setDefaultConfiguration(config);

        SharedPreferences sharedPreferences =
                PreferenceManager
                        .getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nama", "Budi");
        editor.apply();

        Button btnAct1 = (Button) findViewById(R.id.btnAct1);
        btnAct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(MainActivity.this,
                                KeduaActivity.class);
                intent.putExtra("nama", "Budi");
                startActivity(intent);
            }
        });

        Button btnAct2 = (Button) findViewById(R.id.btnAct2);
        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(MainActivity.this,
                                KetigaActivity.class);
                startActivity(intent);
            }
        });
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahDataUser();
            }
        });
        Button bntCetak = (Button) findViewById(R.id.bntCetak);
        bntCetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cetakDataUser();
            }
        });

        Button btnInq = (Button) findViewById(R.id.btnInq);
        btnInq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserInquiryActivity.class);
                startActivity(intent);
            }
        });

        Button btnTambahUser = (Button) findViewById(R.id.btnTambahUser);
        btnTambahUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, formUserActivity.class);
                startActivity(intent);
            }
        });
    }

    public void tambahDataUser() {
        Realm realm = Realm.getDefaultInstance();
        //penyimpanan data
        realm.executeTransaction(new Realm.Transaction() {
                                     @Override
                                     public void execute(Realm realm) {
                                         try {
                                             realm.deleteAll();
                                             User user1 = realm.createObject(User.class, "Primary Key");
                                             user1.setNama("id_buku");
                                             user1.setTipe("Interger");
                                             user1.setPanjang("11");
                                             User user01 = new User();
                                             user01.setNama("Budi");
                                             user01.setStatus("Primary Key" + " ");

                                             User user = realm.createObject(User.class, user01.getStatus());
                                             user.setNama("Budi");
                                         } catch (RealmPrimaryKeyConstraintException e) {
                                             Log.d("TAG", "Primary Key Sudah ada + " + e.getMessage().toString());
                                         }

                                     }
                                 }
        );
        realm.close();
    }

    public void cetakDataUser() {
        Realm realm = Realm.getDefaultInstance();
        //penarikan data
        RealmResults<User> users =
                realm.where(User.class).findAll();
        //menapilkan data
        for (User user : users) {
            Log.d("TAG","Nama :"+user.getNama()  + ",Tipe Data:  " + user.getTipe()
                    + ", Panjang: " + user.getPanjang()  + ", Status: " + user.getStatus() );
        }
        realm.close();
    }
}