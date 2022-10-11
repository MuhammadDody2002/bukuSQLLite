package com.if5b.bukusqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context ctx;
    private static final String DATABASE_NAME = "db_buku";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "tbl_buku";
    private static final String Field_ID = "id";
    private static final String Field_JUDUL = "judul";
    private static final String Field_PENULIS = "penulis";
    private static final String Field_TAHUN = "tahun";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase  db) {
        String query = " CREATE TABLE " + TABLE_NAME + "(" +
                Field_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Field_JUDUL + " TEXT, " +
                Field_PENULIS + " TEXT, " +
                Field_TAHUN + " INTEGER ); ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long tambahBuku(String judul, String penulis, int tahun) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Field_JUDUL, judul);
        cv.put(Field_PENULIS, penulis);
        cv.put(Field_TAHUN, tahun);

        long eksekusi = db.insert(TABLE_NAME, null, cv);
        return eksekusi;
//        if (eksekusi == -1){
//            Toast.makeText(ctx, "Gagal Menambah Data Buku", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(ctx, "Buku Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
//        }
    }
}
