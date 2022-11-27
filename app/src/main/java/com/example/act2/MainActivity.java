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

public class MainActivity extends AppCompatActivity {

    private Button crearIncidencia, llistarIncidencies, resoldreIncidencies;
    private TextView llistar;
    String nom = "nom3", cognom= "cognom", dni= "nom2", email= "nom3",  identificador= "nom4",  Descripcio= "nom5";
    int telContacte = 3123;


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
        ArrayList<Registro> arrayList = new ArrayList<>();
        Registro registro = new Registro();
        arrayList = gestorBBDD.llegirRegistres();



        llistar.setText("");

            llistar.append("Prova: " + arrayList.get(0).getId() + "\n");
            llistar.append("Prova: " + arrayList.get(1).getNom() + "\n");
        llistar.append("Prova: " + arrayList.get(2).getCognom() + "\n");



//        SQLiteDatabase db = gestorBBDD.getReadableDatabase();
//        HashMap<String, String> resultat = new HashMap<String,String>();
//        try{
//            Cursor cursor = db.rawQuery("select cognom from registros", null);
//            cursor.moveToFirst();
//
//            llistar.setText(resultat.get("nom"));
////            String nom_ = cursor.getString(0);
////            cursor.moveToPosition(2);
////            String cognom_ = cursor.getString(2);
////            String dni_ = cursor.getString(0);
////            llistar.setText(cursor.getString(2));
////            llistar.setText(cognom_);
//            cursor.close();
//        }catch (Exception e){
//            Toast.makeText(this, "Error" + e.getMessage(), Toast.LENGTH_LONG).show();
//        }

    }
    }