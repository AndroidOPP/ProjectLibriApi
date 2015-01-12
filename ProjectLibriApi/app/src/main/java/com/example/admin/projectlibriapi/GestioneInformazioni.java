package com.example.admin.projectlibriapi;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Admin on 1/12/2015.
 */
public class GestioneInformazioni extends Application {

    String nome;
    String autore;
    String descrizione;
    boolean stato;

    public void setBook(String nome, String autore, String descrizione, boolean stato) {
        this.nome = nome;
        this.autore = autore;
        this.descrizione = descrizione;
        this.stato = stato;
    }





}
