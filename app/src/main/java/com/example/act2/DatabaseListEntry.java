package com.example.act2;

public class DatabaseListEntry
{
    public String tipusIncidencia;
    public String informadorNom;
    public String informadorCognom;
    public String DNI;
    public int telfContacte;
    public String email;
    public String id;
    public String descripcio;

    public DatabaseListEntry(String tipusIncidencia, String informadorNom, String informadorCognom,
                             String DNI, int telfContacte, String email, String id, String descripcio)
    {
        this.tipusIncidencia = tipusIncidencia;
        this.informadorNom = informadorNom;
        this.informadorCognom = informadorCognom;
        this.DNI = DNI;
        this.telfContacte = telfContacte;
        this.email = email;
        this.id = id;
        this.descripcio = descripcio;
    }

    public DatabaseListEntry(String informadorNom, String id, String descripcio)
    {
        this.informadorNom = informadorNom;
        this.id = id;
        this.descripcio = descripcio;
    }
}