package com.if5b.bukusqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBuku;
    MyDatabaseHelper myDB;
    AdapterBuku adapterBuku;
    ArrayList<String> arrJudul, arrPenulis, arrTahun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBuku = findViewById(R.id.rv_buku);

        myDB = new MyDatabaseHelper(MainActivity.this);
        arrJudul = new ArrayList<>();
        arrPenulis = new ArrayList<>();
        arrTahun = new ArrayList<>();

        
    }

    public void bukaActivityTambah(View view) {
        startActivity(new Intent(MainActivity.this, TambahActivity.class));

    }
    private void tabelKeArrayList(){
        Cursor cursor = myDB.bacaSemuaData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Tidak ada data", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                arrJudul.add(cursor.getString(1));
                arrPenulis.add(cursor.getString(2));
                arrJudul.add(cursor.getString(3));
            }
        }

    }
}