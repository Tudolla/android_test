package com.example.thiandroidnext;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class DeleteStudent extends AppCompatActivity {
    EditText id ;
    Button xoa , xem;
    ListView lv;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);
        id = findViewById(R.id.idsv);
        xoa = findViewById(R.id.xoa);
        xem = findViewById(R.id.xem);
        lv=findViewById(R.id.lv);

        xoa.setOnClickListener(new View.OnClickListener() {
            Student student;
            @Override
            public void onClick(View view) {

                DatabaseHelper db = new DatabaseHelper(DeleteStudent.this);
                boolean check = db.deleteSinhvien(String.valueOf(id.getText()));
                Toast.makeText(DeleteStudent.this, "Result "+check, Toast.LENGTH_SHORT).show();
            }
        });
        xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(DeleteStudent.this);
                ArrayAdapter adapter = new ArrayAdapter<Student>(DeleteStudent.this, android.R.layout.simple_list_item_1,db.getAll());
                lv.setAdapter(adapter);
            }
        });
    }
}