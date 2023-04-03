package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.datastorage.Adapter.UserAdapter;
import com.example.datastorage.User.User;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class UserInquiryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_inquiry2);

        //tarik data dari database
        Realm realm = Realm.getDefaultInstance();
        //penarikan data.
        RealmResults<User> users = realm.where(User.class).findAll();
        //data sudah taruk dan sdh di realm result.
        //menampilkan data.
        ArrayList<User> arrayofuser = new ArrayList<User>();
        arrayofuser.addAll(realm.copyFromRealm(users));
        realm.close();

        UserAdapter userAdapter = new UserAdapter(this, arrayofuser);
        ListView listView = (ListView) findViewById(R.id.listviewuser);
        listView.setAdapter(userAdapter);
    }
}