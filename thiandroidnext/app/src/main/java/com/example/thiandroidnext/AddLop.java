package com.example.thiandroidnext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class AddLop extends AppCompatActivity {
    EditText tenlop , mota;
    Button them , xem;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lop);
        tenlop = findViewById(R.id.tenlop);
        mota = findViewById(R.id.mota);
        them = findViewById(R.id.themlop);
        xem = findViewById(R.id.xemlop);
        lv=findViewById(R.id.lv1);

        them.setOnClickListener(new View.OnClickListener() {
            Lop lop  ;

            @Override
            public void onClick(View view) {
                try{
                    lop = new Lop(0,tenlop.getText().toString(),mota.getText().toString());
                    Toast.makeText(AddLop.this, "Added Lop", Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(AddLop.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DatabaseHelper db = new DatabaseHelper(AddLop.this);
                boolean check = db.addLop(lop);
                Toast.makeText(AddLop.this, "Ok"+check, Toast.LENGTH_SHORT).show();


            }
        });

        xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter adapter;
                try (DatabaseHelper db = new DatabaseHelper(AddLop.this)) {

                    adapter = new ArrayAdapter<Lop>(AddLop.this, android.R.layout.simple_list_item_1, db.getLop());
                }
                lv.setAdapter(adapter);

            }
        });
    }
}