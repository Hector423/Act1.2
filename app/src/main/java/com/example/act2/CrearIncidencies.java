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


/**
 * En aquesta clase agafem les dades de l'inicidencia, i cridem els metodes necessaris dins de la clase GestorBBDD
 * per guardar les dades
 */
public class CrearIncidencies extends AppCompatActivity {

    private TextView nom, cognom, dni, email, descripcio, identificador, telContacte;
    private Button cancelar, enviar;

    String nomV = "", cognomV= "", dniV= "", emailV= "",  identificadorV= "",  descripcioV= "";
    int telContacteV = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        /**
         * Aquí assignem les variables amb els camps de entrada del cuestionari
         */
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


        /**
         * Aquí els hi posem als botons els diferents metodes perque pugin funcionar
         */
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

    /**
     * I aquí al final tenim els metodes que s'utilitzen en aquesta clase
     */
    public void openTornarMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

private void insertarDades() {

        nomV = nom.getText().toString();
        cognomV = cognom.getText().toString();
        dniV = dni.getText().toString();
        String telContacteString = telContacte.getText().toString();
        telContacteV = Integer.parseInt(telContacteString);
        emailV = email.getText().toString();
        identificadorV = identificador.getText().toString();
        descripcioV = descripcio.getText().toString();

    /**
     * Aquí es comprova que que els camps no estiguin buits, si hi ha algun mostrara el missatge per pantalla
     */
    if(!nomV.isEmpty() && !cognomV.isEmpty() && !dniV.isEmpty() && !emailV.isEmpty() && !identificadorV.isEmpty() && !descripcioV.isEmpty()){
            GestorBBDD gestorBBDD = new GestorBBDD(this);
            gestorBBDD.guardarRegistre( nomV, cognomV,  dniV,  telContacteV, emailV,  identificadorV,  descripcioV);
        }else{
            Toast.makeText(this, "Sisplau omple tots els camps", Toast.LENGTH_LONG).show();
        }



    }


    }