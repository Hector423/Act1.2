package com.example.act2;

/**
 * Aquesta clase es per guardar les dades quan les treiem de la taula i despres poder imprimir-les
 */
public class Registro
{
    String nom, cognom, dni, descripcio, identificador, email;
    int telContacte;
    int id;

    @SuppressWarnings("unused")
    public Registro(int id, String nom_, String cognom_, String dni_, int telContacte_,
                    String email_, String identificador_, String descripcio_)
    {
        nom = nom_;
        cognom = cognom_;
        dni = dni_;
        telContacte = telContacte_;
        email = email_;
        identificador = identificador_;
        descripcio = descripcio_;
    }

    @SuppressWarnings("unused")
    public Registro()
    {

    }

    @SuppressWarnings("unused")
    public String getCognom()
    {
        return cognom;
    }

    public int getId()
    {
        return id;
    }

    @SuppressWarnings("unused")
    public String getNom()
    {
        return nom;
    }

    @SuppressWarnings("unused")
    public String getDni()
    {
        return dni;
    }

    @SuppressWarnings("unused")
    public String getDescripcio()
    {
        return descripcio;
    }

    @SuppressWarnings("unused")
    public String getIdentificador()
    {
        return identificador;
    }

    @SuppressWarnings("unused")
    public String getEmail()
    {
        return email;
    }

    @SuppressWarnings("unused")
    public int getTelContacte()
    {
        return telContacte;
    }
}