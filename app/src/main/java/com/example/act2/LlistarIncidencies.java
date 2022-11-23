package com.example.act2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LlistarIncidencies extends AppCompatActivity
{
    public ArrayList<DatabaseListEntry> databaseListEntries; // <- es necessari?

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llistar_incidencies);

        recyclerView = findViewById(R.id.recycler);

        // aqui es on s'hauría d'omplir el databaseListEntries amb lo de la BD
        databaseListEntries = (ArrayList<DatabaseListEntry>)getAllEntries();

        // mostrar el contingut de databaseListEntries dins de recyclerView
//        recyclerView
    }

    // things lol:
    // -> https://stackoverflow.com/questions/39248772/how-to-add-content-in-recyclerview-dynamically#39249026
    @SuppressWarnings("Convert2Diamond")
    public List<DatabaseListEntry> getAllEntries()
    {
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        databaseListEntries = new ArrayList<DatabaseListEntry>();
        String selectQuery = "SELECT * FROM llista"; //TODO canviar el nom de la taula
//        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

//        if(cursor.moveToFirst())
//        {

//        }
        return null;
    }
}