package com.example.datastorage.User;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class User extends RealmObject {

    @Required
    private String nama;
    @Required
    private String tipe;
    @Required
    private String panjang;
    @PrimaryKey
    private String status;

    public User() {
    }

    public User(String nama, String tipe, String panjang, String status) {
        this.nama = nama;
        this.tipe = tipe;
        this.panjang = panjang;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTipe() {
        return tipe;
    }
    public void setTipe(String tipe) {
        this.tipe = tipe;
    }


    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    public String getPanjang() {
        return panjang;
    }
    public void setPanjang(String panjang) {
        this.panjang = panjang;
    }


}
