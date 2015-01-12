package com.example.admin.projectlibriapi;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /*
    ** Abbiamo creato un metodo che istanzia la seconda "schermata" chiamata Intent
    * questa schermata ha bisogno di 2 parametri, this, che indica il context, classe che
    * indica la classe da utilizzare
    * !!!! ATTENZIONE , E' IMPORTANTE SCRIVERE VIEW IN OGNI METODO, OGNI OGNI METODO
    * SCRIVERE VIEW VIEW, SE DA ERRORE, IMPOORTARLO MANUALMENTE CON android.view.View
    * Successivamente, per avviare la nuova finestra scrivere startActivity (nomeIntent)
     */
    public void showBookInfo(View view) {
        Intent setBook = new Intent(this,setBookInfo.class);

        startActivity(setBook);
    }
}
