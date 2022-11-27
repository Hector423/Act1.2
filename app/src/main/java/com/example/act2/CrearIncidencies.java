package com.example.act2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CrearIncidencies extends AppCompatActivity {

    private TextView nom, cognom, dni, email, descripcio, identificador, telContacte;
    private Button cancelar, enviar;

    String nomV = "", cognomV= "", dniV= "", emailV= "",  identificadorV= "",  descripcioV= "";
    String telContacteV = "";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_crear_incidencies);
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
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    insertarDades();
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
private void insertarDades() {

        nomV = nom.getText().toString();
        cognomV = cognom.getText().toString();
        dniV = dni.getText().toString();
        telContacteV = telContacte.getText().toString();
        emailV = email.getText().toString();
        identificadorV = identificador.getText().toString();
        descripcioV = descripcio.getText().toString();

        if(!nomV.isEmpty() && !cognomV.isEmpty() && !dniV.isEmpty() && !telContacteV.isEmpty() && !emailV.isEmpty() && !identificadorV.isEmpty() && !descripcioV.isEmpty()){
            GestorBBDD gestorBBDD = new GestorBBDD(this);
            gestorBBDD.guardarRegistre( nomV, cognomV,  dniV,  telContacteV, emailV,  identificadorV,  descripcioV);
        }
    Toast.makeText(this, "Sisplau omple tots els camps", Toast.LENGTH_LONG).show();



    }


    }