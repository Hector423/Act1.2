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
        crearIncidencia = (Button) findViewById(R.id.botoIncidencies);
        llistarIncidencies = findViewById(R.id.llistarIncidencia);
        resoldreIncidencies = findViewById(R.id.resoldreIncidencia);

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
            }
        });
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

    @Deprecated
    public void openNewActivity(Button buttonPressed)
    {
        Intent intent;

        // RAONS PER EL CUAL C# ES INFINITAMENT MILLOR QUE JAVA;
        // JAVA NO ACCEPTA UN SWITCH EN SUBSTITUCIÓ D'AQUESTS IFS
        if(crearIncidencia.equals(buttonPressed))
        {
            intent = new Intent(this, CrearIncidencies.class);
            startActivity(intent);
        }
        else if(llistarIncidencies.equals(buttonPressed))
        {
            intent = new Intent(this, LlistarIncidencies.class);
            startActivity(intent);
        }
        else if(resoldreIncidencies.equals(buttonPressed))
        {
            intent = new Intent(this, CrearIncidencies.class);
            startActivity(intent);
        }
//        Intent intent = new Intent(this, CrearIncidencies.class);
//        startActivity(intent);
    }
}