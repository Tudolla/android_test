package com.example.thiandroidnext;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {

        super(context, "student.db", null, 888);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table sinhvien(sinhvien_id integer primary key autoincrement, name text , email text," +
                "address text, year text)";
        String mysql = "create table lop(lop_id integer primary key autoincrement, tenlop text , mota text)";
        String sql3 = "create table sinhvienlop(id integer primary key autoincrement,sinhvien_id text, lop_id text," +
                "foreign key (sinhvien_id) references sinhvien(sinhvien_id)," +
                "foreign key (lop_id) references lop(lop_id))";
        db.execSQL(sql);
        db.execSQL(mysql);
        db.execSQL(sql3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists sinhvien");
        db.execSQL("drop table if exists lop");
        db.execSQL("drop table if exists sinhvienlop");
        onCreate(db);

    }

    public boolean addSinhvienLop(SinhvienLop svlop){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("lop_id",svlop.getLop_id());
        cv.put("sinhvien_id",svlop.getSinhvien_id());
        long res = db.insert("sinhvienlop",null,cv);
        if(res == -1){
            return false;
        }else{
            return true;
        }

    }
    public boolean deleteSinhvien(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        int check = db.delete("sinhvien","name = ?",new String[]{name});
        if(check == 0){
            return  false;
        }else{
            return true;
        }

    }

public boolean updateSinhvien(Student student){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();
    cv.put("name",student.getName());
    cv.put("email",student.getEmail());
    cv.put("address",student.getAddress());
    cv.put("year",student.getYear());
    int check = db.update("sinhvien", cv, "sinhvien_id = ?", new String[]{String.valueOf(student.getId())});
    if(check == 0){
        return false;
    }else{
        return true;
    }
}


    public boolean addLop(Lop lop){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("tenlop", lop.getTen());
        cv.put("mota",lop.getMota());
        long insert = db.insert("lop", null , cv);
        if(insert == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",student.getName());
        cv.put("email",student.getEmail());
        cv.put("address",student.getAddress());
        cv.put("year",student.getYear());

        long insert = db.insert("sinhvien",null, cv);
        if(insert == -1){
            return false;
        }else{
            return true;
        }

    }
    public List<SinhvienLop> getSinhvienLop(){
        List<SinhvienLop> list = new ArrayList<>();
        String sql = "select * from sinhvienlop";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                int idsinhvien = cursor.getInt(1);
                int idlop = cursor.getInt(2);

                SinhvienLop sinhvienLop = new SinhvienLop(id, idsinhvien, idlop);
                list.add(sinhvienLop);
            }while (cursor.moveToNext());
        }else{
            //nothing
        }
        cursor.close();
        db.close();
        return list;
    }

    public List<Lop> getLop(){
        List<Lop> reList = new ArrayList<>();
        String mysql = "select * from lop";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(mysql,null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String ten = cursor.getString(1);
                String mota = cursor.getString(2);
                Lop lop = new Lop(id,ten,mota);
                reList.add(lop);
            }while (cursor.moveToNext());
        }else{
            //do nothing
        }
        cursor.close();
        db.close();
        return reList;
    }
    public List<Student> getNam(){
        List<Student> res = new ArrayList<>();
        String sql = "select * from sinhvien where name = 'Nam' and year='2' ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String address = cursor.getString(3);
                String year = cursor.getString(4);
                Student nam = new Student(id,name,email,address,year);
                res.add(nam);

            }while (cursor.moveToNext());
        }else{
            // do nothing
        }
        cursor.close();
        db.close();
        return  res;
    }
    public List<Student> getAll(){
        List<Student> returnList = new ArrayList<>();
        String sql = "select * from sinhvien";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String address = cursor.getString(3);
                String year = cursor.getString(4);

                Student student = new Student(id, name, email, address, year);
                returnList.add(student);
            }while (cursor.moveToNext());
        }else{
            //nothing
        }
        cursor.close();
        db.close();
        return returnList;

    }
}
