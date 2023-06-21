package com.example.thiandroidnext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class AddStudent extends AppCompatActivity {
    EditText name , email , address, year;
    Button add , view ;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        address=findViewById(R.id.address);
        year=findViewById(R.id.year);

        add = findViewById(R.id.add);
        view = findViewById(R.id.view);
        lv=findViewById(R.id.lv);

        add.setOnClickListener(new View.OnClickListener() {
            Student student;
            @Override
            public void onClick(View view) {

                try{
                       student = new Student(0,name.getText().toString(), email.getText().toString(),
                            address.getText().toString(), year.getText().toString());
                    Toast.makeText(AddStudent.this, "Added", Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(AddStudent.this, "Error", Toast.LENGTH_SHORT).show();

                }
                DatabaseHelper databaseHelper = new DatabaseHelper(AddStudent.this);
                boolean check = databaseHelper.addStudent(student);
                Toast.makeText(AddStudent.this, "Check"+check, Toast.LENGTH_SHORT).show();


            }


        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(AddStudent.this);

                ArrayAdapter adapter = new ArrayAdapter<Student>(AddStudent.this, android.R.layout.simple_list_item_1,db.getAll());
                lv.setAdapter(adapter);
            }
        });
    }
}