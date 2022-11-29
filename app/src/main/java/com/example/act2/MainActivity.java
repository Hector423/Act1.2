package com.example.act2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
public class MainActivity extends AppCompatActivity
{
    private Button crearIncidencia, llistarIncidencies, resoldreIncidencies;
    private TextView llistar;
    String nom = "nom3", cognom= "cognom", dni= "nom2", email= "nom3",  identificador= "nom4",  Descripcio= "nom5";
    int telContacte = 3123;

    /**
     * En la clase principal, tenim 3 botons que porten a les diferents pantalles de l'aplicació
     */
    @SuppressWarnings({"RedundantCast", "DanglingJavadoc"})
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
        crearIncidencia.setOnClickListener(v -> openCrearIncidencies());

        llistarIncidencies.setOnClickListener(v ->
        {

            openLlistarIncidencies();
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

    @SuppressWarnings("UnusedAssignment")
    private void obrirConexio()
    {
        GestorBBDD gestorBBDD = new GestorBBDD(this);
        ArrayList<Registro> arrayList;
        arrayList = gestorBBDD.llegirRegistres();

        llistar.setText("");
    }

    public void openResoldreIncidencies()
    {
        // Aqui aniría el codi per obrir l'activitat del tercer botó...
    }
}