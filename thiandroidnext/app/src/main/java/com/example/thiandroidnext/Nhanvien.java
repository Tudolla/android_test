package com.example.thiandroidnext;

public class Nhanvien {
    int id ;
    String ten , tuoi , vitri;

    public Nhanvien(int id, String ten, String tuoi, String vitri) {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
        this.vitri = vitri;
    }

    @Override
    public String toString() {
        return id +
                " " + ten +
                " " + tuoi +
                " " + vitri;
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

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }
}
