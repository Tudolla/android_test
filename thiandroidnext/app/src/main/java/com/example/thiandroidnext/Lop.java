package com.example.thiandroidnext;

import androidx.annotation.NonNull;

public class Lop {
    private int id ;
    private String ten , mota ;

    public Lop(int id, String ten, String mota) {
        this.id = id;
        this.ten = ten;
        this.mota = mota;
    }
    public Lop(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @NonNull
    @Override
    public String toString() {
        return  id + " " + ten + " "  + mota ;
    }
}
