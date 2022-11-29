package com.example.act2;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LlistarIncidencies extends AppCompatActivity
{
    public NotificationManager notificationManager;

    public ArrayList<Registro> databaseListEntries;

    public GestorBBDD gestorBBDD;

    public Button notificacionButton;

    public Button backButton;

    public TextView databaseText;

    @Override
    @SuppressLint("SetTextI18n")
    @SuppressWarnings("RedundantCast")
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llistar_incidencies);

        notificacionButton = (Button)findViewById(R.id.leButton);
        backButton = (Button)findViewById(R.id.leReturn);
        databaseText = (TextView)findViewById(R.id.leText);

        notificacionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showNotification();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openMain();
            }
        });

        /*
        Notification.Builder notificationBuilder = null;
        switch (id) {
            case notification_one:
                notificationBuilder = notificationHelper.getNotification1(title,
                        getString(R.string.channel_one_body));
                break;

            case notification_two:
                notificationBuilder = notificationHelper.getNotification2(title,
                        getString(R.string.channel_two_body));
                break;
        }

        if (notificationBuilder != null) {
            notificationHelper.notify(id, notificationBuilder);
        }
        *  */

        gestorBBDD = new GestorBBDD(this);
        databaseListEntries = gestorBBDD.llegirRegistres();

        System.out.println("databaseListEntries.size() = " + databaseListEntries.size());
        String textToShow = "";

        for(int i=0; i<databaseListEntries.size(); i++) textToShow = textToShow.concat
        (
            databaseListEntries.get(i).id + ": " + databaseListEntries.get(i).identificador + "\n"
                + databaseListEntries.get(i).nom + " " + databaseListEntries.get(i).cognom + " ("
                + databaseListEntries.get(i).dni + ")\n" + databaseListEntries.get(i).telContacte
                + "\n" + databaseListEntries.get(i).descripcio + "\n\n------------------------------\n"
        );
        databaseText.setText(textToShow +"\n\n\n\n\n");
        databaseText.setMovementMethod(new ScrollingMovementMethod());
    }

    private void showNotification() {

//        Notification.Builder notificationBuilder = null;

//        postNotification(notification_one, getChannelOneText());

        Notification.Builder notificationBuilder;

        notificationBuilder = notificationManager.getNotificationNothing("No tens cap incidencia restant","Tens 0 incidencies per resoldre. Bona feina!");

        notificationManager.notify(101, notificationBuilder);
    }

    public void openMain()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}