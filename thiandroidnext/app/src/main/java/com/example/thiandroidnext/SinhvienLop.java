package com.example.thiandroidnext;

import androidx.annotation.NonNull;

public class SinhvienLop {
    private int id ;
    private int sinhvien_id , lop_id;
    private String tensinhvien, tenlop;

    public SinhvienLop(int id, int sinhvien_id, int lop_id, String tensinhvien, String tenlop) {
        this.id = id;
        this.sinhvien_id = sinhvien_id;
        this.lop_id = lop_id;
        this.tensinhvien = tensinhvien;
        this.tenlop = tenlop;
    }
    public SinhvienLop(int id, int sinhvien_id, int lop_id){
        this.id=id;
        this.sinhvien_id=sinhvien_id;
        this.lop_id=lop_id;
    }

    @NonNull
    @Override
    public String toString() {
        return id +" "+ sinhvien_id+" "+lop_id+" "+tensinhvien+" "+tenlop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSinhvien_id() {
        return sinhvien_id;
    }

    public void setSinhvien_id(int sinhvien_id) {
        this.sinhvien_id = sinhvien_id;
    }

    public int getLop_id() {
        return lop_id;
    }

    public void setLop_id(int lop_id) {
        this.lop_id = lop_id;
    }

    public String getTensinhvien() {
        return tensinhvien;
    }

    public void setTensinhvien(String tensinhvien) {
        this.tensinhvien = tensinhvien;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }
}
