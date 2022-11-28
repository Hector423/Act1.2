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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class MainActivity extends AppCompatActivity
{
    private Button crearIncidencia, llistarIncidencies, resoldreIncidencies;
    private TextView llistar;
    String nom = "nom3", cognom= "cognom", dni= "nom2", email= "nom3",  identificador= "nom4",  Descripcio= "nom5";
    int telContacte = 3123;

    /**
     * En la clase principal, tenim 3 botons que porten a les diferents pantalles de l'aplicació
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        /**
         * Aquí assignem els botons
         */
        setContentView(R.layout.activity_main);
        crearIncidencia = (Button)findViewById(R.id.botoIncidencies);
        llistarIncidencies = findViewById(R.id.llistarIncidencia);
        resoldreIncidencies = findViewById(R.id.resoldreIncidencia);
        llistar = findViewById(R.id.llistatBBDD);

        /**
         * Aquí comencem a implementar quan es cliquin els botons, que ho portin a les diferents pantalles
         */
        crearIncidencia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openCrearIncidencies();
            }
        });

        llistarIncidencies.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                obrirConexio();
            }
        });

    }

    /**
     * Aquí tenim els diferents metodes per cridar les clases corresponents
     */
    public void openCrearIncidencies()
    {
        Intent intent = new Intent(this, CrearIncidencies.class);
        startActivity(intent);
    }

    public void openLlistarIncidencies()
    {
        Intent intent = new Intent(this, LlistarIncidencies.class);
        startActivity(intent);
    }


    private void obrirConexio() {
        GestorBBDD gestorBBDD = new GestorBBDD(this);
        ArrayList<Registro> arrayList;
        arrayList = gestorBBDD.llegirRegistres();

        llistar.setText("");

        llistar.append("Prova: " + arrayList.get(0).getId() + "\n");
        llistar.append("Prova: " + arrayList.get(0).getNom() + "\n");
        llistar.append("Prova: " + arrayList.get(0).getCognom() + "\n");
        llistar.append("Prova: " + arrayList.get(0).getDni() + "\n");
        llistar.append("Prova: " + arrayList.get(0).getTelContacte() + "\n");
        llistar.append("Prova: " + arrayList.get(0).getEmail() + "\n");
        llistar.append("Prova: " + arrayList.get(0).getIdentificador() + "\n");
        llistar.append("Prova: " + arrayList.get(0).getDescripcio() + "\n");
        llistar.append("-------------------------------------------");


    }
    public void openResoldreIncidencies()
    {
        // Posar aqui el codi per obrir l'activitat del tercer botó
    }
    }




