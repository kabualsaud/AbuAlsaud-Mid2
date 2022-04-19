package com.example.abualsaud_mid2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Company.db";
    public static final String TABLE_NAME = "MyTable";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_FNAME = "FirstName";
    public static final String COLUMN_SNAME = "Surname";
    public static final String COLUMN_NAT_ID = "NationalID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL (
                "CREATE TABLE " + TABLE_NAME + "("
                        + COLUMN_ID + " INTEGER PRIMARY KEY,"
                        + COLUMN_FNAME + " TEXT NOT NULL,"
                        + COLUMN_SNAME + " INTEGER NOT NULL," +
                        COLUMN_NAT_ID + " INTEGER NOT NULL)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void Insert(String id, String fname, String sname, String natID){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, id);
        values.put(COLUMN_FNAME, fname);
        values.put(COLUMN_SNAME, sname);
        values.put(COLUMN_NAT_ID, natID);
        db.insert(TABLE_NAME, null, values);
    }

    public Cursor View() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor x = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return x;
    }

    public Integer Delete(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }
}
