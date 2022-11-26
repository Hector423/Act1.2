package com.example.act2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class GestorBBDD  extends SQLiteOpenHelper {


    public GestorBBDD(Context context) {
        super(context, "registres", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registros ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nom TEXT,"
                + "cognom TEXT,"
                + "dni TEXT,"
                + "telContacte INTEGER,"
                + "email TEXT,"
                + "identificador TEXT,"
                + "descripcio TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * Metodo para indicar el plato a dar de alta en la BD
     *
     * @author Laura Lopez
     */
    public void guardarRegistre(String nom, String cognom, String dni, int telContacte,
                                 String email, String identificador, String Descripcio) {
        SQLiteDatabase db = getWritableDatabase();
        guardarRegistres(db, nom, cognom, dni, telContacte, email, identificador, Descripcio);
    }

    /**
     * Metodo para introducir el plato en la BD
     *
     * @author Laura Lopez
     */
    private void guardarRegistres(SQLiteDatabase db, String nom, String cognom, String dni, int telContacte,
                                  String email, String identificador, String Descripcio) {
        ContentValues cv = new ContentValues();
        cv.put("nom", "nom");
        cv.put("cognom", cognom);
        cv.put("dni", dni);
        cv.put("telContacte", telContacte);
        cv.put("email", email);
        cv.put("identificador", identificador);
        cv.put("Descripcio", Descripcio);
        db.insert("registros", null, cv);
    }
}
