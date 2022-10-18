package com.example.act2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.act2CrearIncidencies.CrearIncidencies;

public class MainActivity extends AppCompatActivity {

    private Button crearIncidencia, llistarIncidencies, resoldreIncidencies;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        crearIncidencia = (Button) findViewById(R.id.botoIncidencies);
        llistarIncidencies = findViewById(R.id.llistarIncidencia);
        resoldreIncidencies = findViewById(R.id.resoldreIncidencia);

        crearIncidencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CrearIncidencies.class);
                startActivity(intent);
            }
        });
    }
}