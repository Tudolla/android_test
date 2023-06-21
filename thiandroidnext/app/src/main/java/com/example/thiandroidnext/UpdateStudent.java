package com.example.thiandroidnext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class UpdateStudent extends AppCompatActivity {
    EditText id, name, email, address, year;
    Button capnhat, xem;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        id=findViewById(R.id.id);
        name = findViewById(R.id.name);
        email=findViewById(R.id.email);
        address = findViewById(R.id.address);
        year = findViewById(R.id.year);
        capnhat = findViewById(R.id.capnhat);
        xem = findViewById(R.id.xem);
        lv = findViewById(R.id.lv);

        capnhat.setOnClickListener(new View.OnClickListener() {
            Student student;
            @Override
            public void onClick(View view) {
                try {
                    student = new Student(Integer.parseInt(id.getText().toString()),name.getText().toString(),email.getText().toString(),
                            address.getText().toString(),year.getText().toString());
                    Toast.makeText(UpdateStudent.this, "Updated", Toast.LENGTH_SHORT).show();


                }catch (Exception e){
                    Toast.makeText(UpdateStudent.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DatabaseHelper db = new DatabaseHelper(UpdateStudent.this);
                boolean check = db.updateSinhvien(student);
                Toast.makeText(UpdateStudent.this, "Result " + check, Toast.LENGTH_SHORT).show();
            }
        });
        xem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DatabaseHelper db = new DatabaseHelper(UpdateStudent.this);
                ArrayAdapter adapter = new ArrayAdapter<Student>(UpdateStudent.this, android.R.layout.simple_list_item_1,db.getAll());
                lv.setAdapter(adapter);
            }
        });
    }
}