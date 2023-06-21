package com.example.thiandroidnext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class TimNam extends AppCompatActivity {
    Button tim;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_nam);
        tim = findViewById(R.id.tim);
        lv = findViewById(R.id.lv);

        tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(TimNam.this);
                ArrayAdapter adapter = new ArrayAdapter<Student>(TimNam.this, android.R.layout.simple_list_item_1,db.getNam());
                lv.setAdapter(adapter);
            }
        });
    }
}