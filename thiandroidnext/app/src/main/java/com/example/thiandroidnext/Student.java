package com.example.thiandroidnext;

import androidx.annotation.NonNull;

public class Student {
    private int id ;
    private String name ,  email , address  , year;

    public Student(int id, String name, String email, String address, String year) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.year = year;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @NonNull
    @Override
    public String toString() {
        return id +" "+ name +" "+ email+" "+address+" "+year;
    }
}
