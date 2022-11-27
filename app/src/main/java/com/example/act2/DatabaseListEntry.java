package com.example.act2;

public class DatabaseListEntry
{
    public int id;
    public String nom;
    public String cognom;
    public String dni;
    public int telef;
    public String email;
    public String identificador;
    public String descripcio;

    public DatabaseListEntry(int id, String nom, String cognom, String dni, int telef, String email, String identificador, String descripcio)
    {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.telef = telef;
        this.email = email;
        this.identificador = identificador;
        this.descripcio = descripcio;
    }

    public DatabaseListEntry(int id, String nom, String identificador, String descripcio)
    {
        this.id = id;
        this.nom = nom;
        this.identificador = identificador;
        this.descripcio = descripcio;
    }
}