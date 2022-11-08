package com.example.act2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CrearIncidencies extends AppCompatActivity {

    private TextView nom, cognom, dni, email, descripcio, identificador, telContacte;
    private Button cancelar, enviar;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_crear_incidencies);
        spinner = findViewById(R.id.spinner);
        nom = findViewById(R.id.nomInformador);
        cognom = findViewById(R.id.cognomInformador);
        dni = findViewById(R.id.dni);
        email = findViewById(R.id.email);
        descripcio = findViewById(R.id.descripcioIncidencia);
        identificador = findViewById(R.id.identificador);
        telContacte = findViewById(R.id.telContacte);
        cancelar = findViewById(R.id.cancelar);
        enviar = findViewById(R.id.enviar);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTornarMain();
            }
        });
        /*
        Validar camps
         */


        String[] opcions = {"a", "b", "c", "d", "e"};

        ArrayAdapter<String> opcionsAdaptades = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, opcions);

        spinner.setAdapter(opcionsAdaptades);




        try{
            if(opcions.toString().isEmpty()){

            }


        } catch (Exception e){

        }
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
    public void openTornarMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

//    public void openEnviarDades(){
//        Intent intent = new Intent(this, ContentProviderBotoCrear.class);
//        startActivity(intent);
//    }



    }