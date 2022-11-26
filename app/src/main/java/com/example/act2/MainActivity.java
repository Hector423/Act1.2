package com.example.act2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button crearIncidencia, llistarIncidencies, resoldreIncidencies;
    private TextView llistar;
    String nom = "nom", cognom= "nom", dni= "nom", email= "nom",  identificador= "nom",  Descripcio= "nom";
    int telContacte = 3;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resoldreIncidencies = findViewById(R.id.resoldreIncidencia);
        llistar = findViewById(R.id.llistatBBDD);

        resoldreIncidencies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obrirConexio();
            }
        });
}

    private void obrirConexio() {
        GestorBBDD gestorBBDD = new GestorBBDD(this);
        gestorBBDD.guardarRegistre( nom, cognom,  dni,  telContacte, email,  identificador,  Descripcio);
        SQLiteDatabase db = gestorBBDD.getReadableDatabase();
        try{
            Cursor cursor = db.rawQuery("select * from registros", null);
            cursor.moveToFirst();
            llistar.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(this, "Error" + e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
    }