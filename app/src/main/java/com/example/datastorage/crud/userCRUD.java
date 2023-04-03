package com.example.datastorage.crud;

import android.util.Log;

import com.example.datastorage.User.User;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class userCRUD {
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

                                         } catch (RealmPrimaryKeyConstraintException e) {
                                             Log.d("TAG", "Primary Key Sudah ada + " + e.getMessage().toString());
                                         }

                                     }
                                 }
        );
        realm.close();
    }

    public void updateDataUser(String Nama, String Tipe, String Panjang, String Status) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
                                     @Override
                                     public void execute(Realm realm) {
                                         try {
                                             User user1 = realm.where(User.class).equalTo("status", Status).findFirst();
                                             user1.setNama(Nama);
                                             user1.setTipe(Tipe);
                                             user1.setPanjang(Panjang);

                                         } catch (RealmPrimaryKeyConstraintException e) {
                                             Log.d("TAG", "Primary Key Sudah ada + " + e.getMessage().toString());
                                         }

                                     }
                                 }
        );
        realm.close();
    }

    public void deleteDataUser(String Status) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
                                     @Override
                                     public void execute(Realm realm) {
                                         try {
                                             User user1 = realm.where(User.class).equalTo("status", Status).findFirst();
                                             user1.deleteFromRealm();

                                         } catch (RealmPrimaryKeyConstraintException e) {
                                             Log.d("TAG", "Primary Key Sudah ada + " + e.getMessage().toString());
                                         }

                                     }
                                 }
        );
        realm.close();
    }
}
