package com.example.act2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class LlistarIncidencies extends AppCompatActivity
{
    public ArrayList<Object> llistaDeRegistres;

    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llistar_incidencies);

        recycler = findViewById(R.id.recycler);
    }
}