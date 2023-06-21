package com.example.thiandroidnext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button sinhvien, lop , nam , dklop, xoa, capnhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         sinhvien = findViewById(R.id.sinhvien);
         lop = findViewById(R.id.lop);
         nam = findViewById(R.id.nam);
         dklop = findViewById(R.id.dklop);
         xoa = findViewById(R.id.xoa);
         capnhat =findViewById(R.id.capnhat);

         sinhvien.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(MainActivity.this, AddStudent.class);
                 startActivity(i);
             }
         });
         lop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(MainActivity.this , AddLop.class);
                 startActivity(i);
             }
         });
         nam.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(MainActivity.this, TimNam.class);
                 startActivity(i);
             }
         });
         dklop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(MainActivity.this, SubcribeClassroom.class);
                 startActivity(i);
             }
         });
         xoa.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(MainActivity.this, DeleteStudent.class);
                 startActivity(i);
             }
         });
         capnhat.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(MainActivity.this, UpdateStudent.class);
                 startActivity(i);
             }
         });
    }
}