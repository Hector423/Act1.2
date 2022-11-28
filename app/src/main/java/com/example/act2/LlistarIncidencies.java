package com.example.act2;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LlistarIncidencies extends AppCompatActivity
{
    public ArrayList<Registro> databaseListEntries; // <- es necessari?
    public Registro[] databaserrayEntries;

    GestorBBDD gestorBBDD;

    public NotificationManager notificationManager;

    RecyclerView recyclerView;

    Button notificacionButton;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llistar_incidencies);

        //recyclerView = findViewById(R.id.recycler);

        notificacionButton = (Button)findViewById(R.id.leButton);
        textView = (TextView)findViewById(R.id.leText);

        notificacionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                result.setText("Hello "+name.getText());
                hola();
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

//        notificacionButton.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Notification.Builder notificationBuilder = null;
//
//                notificationBuilder = notificationManager.getNotificationNothing("No tens cap incidencia restant","Tens 0 incidencies per resoldre. Bona feina!");
//
//                notificationManager.notify(101, notificationBuilder);
//            }
//        });




        // aqui es on s'hauría d'omplir el databaseListEntries amb lo de la BD

        //databaseListEntries = (ArrayList<DatabaseListEntry>)getAllEntries();

        gestorBBDD = new GestorBBDD(this);
        databaseListEntries = gestorBBDD.llegirRegistres();
//        databaserrayEntries = gestorBBDD.llegirRegistres().toArray(new Registro[0]);
        databaserrayEntries = gestorBBDD.llegirRegistres().toArray(new Registro[gestorBBDD.llegirRegistres().toArray().length]);

        System.out.println("databaseListEntries.size() = " + databaseListEntries.size());

        String textForTextingTheTextView = "";

        for(int i=0; i<databaseListEntries.size(); i++)
        {
            textForTextingTheTextView = textForTextingTheTextView.concat(databaseListEntries.get(i).id+": "+databaseListEntries.get(i).identificador+"\n");
            textForTextingTheTextView = textForTextingTheTextView.concat(databaseListEntries.get(i).nom+" "+databaseListEntries.get(i).cognom+" ("+databaseListEntries.get(i).dni+")\n");
            textForTextingTheTextView = textForTextingTheTextView.concat(databaseListEntries.get(i).telContacte+"\n");
            textForTextingTheTextView = textForTextingTheTextView.concat(databaseListEntries.get(i).descripcio+"\n\n------------------------------\n");
        }

        textView.setText(textForTextingTheTextView);

        // mostrar el contingut de databaseListEntries dins de recyclerView
//        recyclerView
        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

//        String[] from = {/*"listview_image",*/ "listview_title", "listview_discription"};
//        int[] to = {/*R.id.listview_image,*/ R.id.listview_item_title, R.id.listview_item_short_description};

//        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

//        for(int i=0; i==databaseListEntries.size(); i++)
//        {
//            HashMap<String, String> hm = new HashMap<String, String>();
//            hm.put("listview_title", databaseListEntries.get(i).identificador);
//            hm.put("listview_discription", databaseListEntries.get(i).descripcio);
            //hm.put("listview_image", Integer.toString(listviewImage[i]));
//            hm.put("listview_image", "");
//            aList.add(hm);
//        }

//        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_activity, from, to);
//        ListView listView = (ListView)findViewById(R.id.list);
//        listView.setAdapter(simpleAdapter);
    }

    private void hola() {

//        Notification.Builder notificationBuilder = null;

//        postNotification(notification_one, getChannelOneText());

        Notification.Builder notificationBuilder;

        notificationBuilder = notificationManager.getNotificationNothing("No tens cap incidencia restant","Tens 0 incidencies per resoldre. Bona feina!");

        notificationManager.notify(101, notificationBuilder);
    }

    // things lol:
    // -> https://stackoverflow.com/questions/39248772/how-to-add-content-in-recyclerview-dynamically#39249026
    @SuppressWarnings("Convert2Diamond")
    public List<DatabaseListEntry> getAllEntries()
    {
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        databaseListEntries = new ArrayList<Registro>();
        String selectQuery = "SELECT * FROM llista"; //TODO canviar el nom de la taula
//        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

//        if(cursor.moveToFirst())
//        {

//        }
        return null;
    }

    public void buttonOnClick(View view)
    {

    }
}