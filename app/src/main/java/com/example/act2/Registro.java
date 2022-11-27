package com.example.act2;

public class Registro {
    String nom, cognom, dni, descripcio, identificador, email;
    int telContacte, id;

    public Registro (int id, String nom_, String cognom_, String dni_, int telContacte_,String email, String identificador_, String descripcio_){
        nom = nom_;
        cognom = cognom_;
        dni = dni_;
        telContacte = telContacte_;
        identificador = identificador_;
        descripcio = descripcio_;
    }

    public Registro() {

    }

    public String getCognom() {
        return cognom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDni() {
        return dni;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getEmail() {
        return email;
    }

    public int getTelContacte() {
        return telContacte;
    }
}
