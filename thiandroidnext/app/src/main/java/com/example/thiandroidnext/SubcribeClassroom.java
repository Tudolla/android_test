package com.example.thiandroidnext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SubcribeClassroom extends AppCompatActivity {
    EditText lop, sinhvien;
    Button dk, xem;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcribe_classroom);
        lop = findViewById(R.id.idlop);
        sinhvien = findViewById(R.id.idsv);
        dk= findViewById(R.id.dk);
        xem = findViewById(R.id.xem);
        lv = findViewById(R.id.lv);

        dk.setOnClickListener(new View.OnClickListener() {
            SinhvienLop sinhvienLop;
            @Override
            public void onClick(View view) {
                try{
                    sinhvienLop = new SinhvienLop(0, Integer.parseInt(lop.getText().toString()),
                            Integer.parseInt(sinhvien.getText().toString()));
                    Toast.makeText(SubcribeClassroom.this, "Added", Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(SubcribeClassroom.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DatabaseHelper db = new DatabaseHelper(SubcribeClassroom.this);
                boolean check = db.addSinhvienLop(sinhvienLop);
                Toast.makeText(SubcribeClassroom.this, "Result "+ check, Toast.LENGTH_SHORT).show();



            }
        });
        xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(SubcribeClassroom.this);
                ArrayAdapter adapter = new ArrayAdapter<SinhvienLop>(SubcribeClassroom.this, android.R.layout.simple_list_item_1,db.getSinhvienLop());
                lv.setAdapter(adapter);
            }
        });
    }
}