package com.example.thiandroidnext;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelpernext extends SQLiteOpenHelper {
    public DatabaseHelpernext(@Nullable Context context ) {

        super(context, "employee.db", null, 10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table boiban(id integer primary key autoincrement, ten text , tuoi text, vitri text)";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists boiban");
        onCreate(db);


    }
    public boolean addNhanvien(Nhanvien nv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ten" , nv.getTen());
        cv.put("tuoi" , nv.getTuoi());
        cv.put("vitri" , nv.getVitri());
        long insert = db.insert("boiban",null,cv);
        if(insert == -1){
            return false;
        }else{
            return true;
        }
    }

    public List<Nhanvien> getAll(){
        List<Nhanvien> list = new ArrayList<>();
        String sql = "select * from boiban";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String ten = cursor.getString(1);
                String tuoi = cursor.getString(2);
                String vitri = cursor.getString(3);
            }while (cursor.moveToNext());
        }else{
            // do nothing
        }
        cursor.close();
        db.close();
        return  list;

    }
}
