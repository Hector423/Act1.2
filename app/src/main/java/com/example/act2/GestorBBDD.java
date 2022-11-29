package com.example.act2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class GestorBBDD  extends SQLiteOpenHelper
{
    /**
     * La BBDD la em decidit fer al final amb SQLite ja que fent una BBDD amb MySQL ens donava un error de
     * connexió i no podiem avançar
     */
    public GestorBBDD(Context context)
    {
        super(context, "registres", null, 1);
    }

    /**
     *
     * Aquí es crea la taula per guardar els registres
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("CREATE TABLE registros ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nom TEXT,"
                + "cognom TEXT,"
                + "dni TEXT,"
                + "telContacte TEXT,"
                + "email TEXT,"
                + "identificador TEXT,"
                + "descripcio TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }

    /**
     * Aquest es el metode que utlitzem per recollir les dades
     */
    public void guardarRegistre(String nom, String cognom, String dni, int telContacte,
                                 String email, String identificador, String Descripcio)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        guardarRegistres(db, nom, cognom, dni, telContacte, email, identificador, Descripcio);
    }

    /**
     * Amb aquest metode fem l'insert a la taula amb les dades que ha introduit l'usuari
     */
    private void guardarRegistres(SQLiteDatabase db, String nom, String cognom, String dni, int telContacte,
                                  String email, String identificador, String Descripcio)
    {
        db.execSQL("insert into registros (nom, cognom, dni, telContacte, email, identificador, descripcio) " +
                    "values ('"+nom+"','"+cognom+"','"+dni+"','"+telContacte+"','"+email+"','"+identificador+"','"+Descripcio+"')");
        db.close();
    }

    /**
     * Amb aquest metode llegim el que hi ha a la taula, recollim les dades i les guardem a la clase Registro,
     *  per despres poder imprimir per pantalla.
     */
    public ArrayList<Registro> llegirRegistres()
    {
        SQLiteDatabase gestorBBDD = this.getReadableDatabase();

        Cursor cursor = gestorBBDD.rawQuery("SELECT * FROM registros", null);

        ArrayList<Registro> arrayRegistro = new ArrayList<>();

        if(cursor.moveToFirst())
        {
            do
            {
                arrayRegistro.add(new Registro
                (
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7)
                ));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return arrayRegistro;
    }
}