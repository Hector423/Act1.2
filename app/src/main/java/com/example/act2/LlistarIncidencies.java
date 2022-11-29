package com.example.act2;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Classe per l'activity de Llistar Incidencies
 */
public class LlistarIncidencies extends AppCompatActivity
{
    /**
     * Instancia per interactuar amb la classe de notificacions
     */
    public NotificationManager notificationManager;

    /**
     * L'ArrayList on guardarem les dades rebudes de la consulta de la BD
     */
    public ArrayList<Registro> databaseListEntries;

    /**
     * Instancia per interactuar amb la BD
     */
    public GestorBBDD gestorBBDD;

    /**
     * Botó que mostrará una notificació en fer-hi click
     */
    public Button notificacionButton;

    /**
     * Botó que tornará a la pantalla principal
     */
    public Button backButton;

    /**
     * El TextView on hi mostrarem les dades de la base de dades
     */
    public TextView databaseText;

    /**
     * Metode que s'executa automaticament en obrir l'activitat
     *
     * @param savedInstanceState
     */
    @Override
    @SuppressLint("SetTextI18n")
    @SuppressWarnings({"RedundantCast", "JavaDoc"})
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llistar_incidencies);
        notificationManager = new NotificationManager(this);

        notificacionButton = (Button)findViewById(R.id.leButton);
        backButton = (Button)findViewById(R.id.leReturn);
        databaseText = (TextView)findViewById(R.id.leText);

        notificacionButton.setOnClickListener(v -> showNotification());
        backButton.setOnClickListener(v -> openMain());

//        Notification.Builder notificationBuilder = null;
//        switch (id) {
//            case notification_one:
//                notificationBuilder = notificationHelper.getNotification1(title,
//                        getString(R.string.channel_one_body));
//                break;
//
//            case notification_two:
//                notificationBuilder = notificationHelper.getNotification2(title,
//                        getString(R.string.channel_two_body));
//                break;
//        }
//
//        if (notificationBuilder != null) {
//            notificationHelper.notify(id, notificationBuilder);
//        }

        gestorBBDD = new GestorBBDD(this);
        databaseListEntries = gestorBBDD.llegirRegistres();

        System.out.println("databaseListEntries.size() = " + databaseListEntries.size());
        String textToShow = "";

        for(int i=0; i<databaseListEntries.size(); i++) textToShow = textToShow.concat
        (
            " " + /*databaseListEntries.get(i).id*/i + ": " + databaseListEntries.get(i).identificador
                + "\n " + databaseListEntries.get(i).nom + " " + databaseListEntries.get(i).cognom
                + " (" + databaseListEntries.get(i).dni + ")\n " + databaseListEntries.get(i).telContacte
                + "\n " + databaseListEntries.get(i).descripcio + "\n\n------------------------------\n"
        );
        databaseText.setText(textToShow +"\n\n\n\n\n");
        databaseText.setMovementMethod(new ScrollingMovementMethod());
    }

    /**
     * Funció per mostrar la notificació en premer el botó corresponent.
     */
    @SuppressWarnings("CommentedOutCode")
    public void showNotification()
    {

//        Notification.Builder notificationBuilder = null;

//        postNotification(notification_one, getChannelOneText());

        Notification.Builder notificationBuilder;

        notificationBuilder = notificationManager.getNotificationNothing("No tens cap incidencia restant","Tens 0 incidencies per resoldre. Bona feina!");

        notificationManager.notify(101, notificationBuilder);
    }

    /**
     * Funció per tornar a la MainActivity.
     */
    public void openMain()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}