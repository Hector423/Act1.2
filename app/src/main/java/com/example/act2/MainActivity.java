package com.example.act2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button crearIncidencia, llistarIncidencies, resoldreIncidencies;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        crearIncidencia = (Button)findViewById(R.id.botoIncidencies);
        llistarIncidencies = findViewById(R.id.llistarIncidencia);
        resoldreIncidencies = findViewById(R.id.resoldreIncidencia);

<<<<<<< HEAD
        crearIncidencia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                openNewActivity(crearIncidencia);
                openCrearIncidencies();
            }
        });

        llistarIncidencies.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                openNewActivity(llistarIncidencies);
                openLlistarIncidencies();
                obrirConexio();
            }
        });
=======
        crearIncidencia.setOnClickListener(v -> openCrearIncidencies());
        llistarIncidencies.setOnClickListener(v -> openLlistarIncidencies());
        resoldreIncidencies.setOnClickListener(v -> openResoldreIncidencies());
>>>>>>> 2e8b195b07be6f5d232fa24c37869d3e01d725c7
    }

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

<<<<<<< HEAD
    private void obrirConexio() {
        Intent intent = new Intent(this, ContentProviderBotoCrear.class);
        startActivity(intent);
    }
    }
=======
    public void openResoldreIncidencies()
    {
        // Posar aqui el codi per obrir l'activitat del tercer botó
    }
}
>>>>>>> 2e8b195b07be6f5d232fa24c37869d3e01d725c7
