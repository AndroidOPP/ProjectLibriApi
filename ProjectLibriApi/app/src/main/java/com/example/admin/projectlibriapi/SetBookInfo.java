package com.example.admin.projectlibriapi;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class SetBookInfo extends ActionBarActivity {


    GestioneInformazioni gi;
    EditText nome;
    EditText autore;
    EditText descrizione;
    CheckBox stato;

    boolean sent = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_book_info);



        /*

        ** se si usa un'altra classe, scrivere (nomedellaclasse) this.getapplication();
         */
        gi = (GestioneInformazioni) this.getApplication();


    /*
    ** Se si crea un oggetto nella GUI, istanziarlo nella classe e usare
    * (Oggetto) findViewById(R.id.iddell'oggetto)
     */

        nome = (EditText) findViewById(R.id.editText);
        autore = (EditText) findViewById(R.id.editText2);
        descrizione = (EditText) findViewById(R.id.editText3);
        stato = (CheckBox) findViewById(R.id.checkBox);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set_book_info, menu);
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
    **
     */
    public void setBook(View view) {

        new sendJson().execute();
            /*
            ** FACCIAMO UN BEL TOAST, CHE AVVISA L'UTENTE DELLA RIUSCITA DELL'OPERAZIONE
            */


        if(sent) {
            Toast.makeText(
                    getApplicationContext(),
                    "Inviato Correttamente",
                    Toast.LENGTH_LONG
            ).show();
        }
        else {
            Toast.makeText(
                    getApplicationContext(),
                    "Impossibile Inviare",
                    Toast.LENGTH_LONG
            ).show();
        }



         /*
        CHIUDIAMO L'ACTIVITY SETBOOK PER RITORNARE AL MENU PRNCIPALE
         */


        // IL FATTO CHE E' UN THREAD DIVERSO, NON CI PERMETTE DI CONFRONTARE LA VARIABILE
        // sent
        this.finish();

    }

    /*
        questa è una subclass, che estende AyncTask perhcè multithread....

         */
    class sendJson extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            JsonClient client = new JsonClient();
            JSONObject object = null;
            try {
            object = new JSONObject();

                object.put("nome",nome.getText().toString());
                object.put("autore",autore.getText().toString());
                object.put("descrizione",descrizione.getText().toString());
                int letto;
                if (stato.isChecked()) {
                    letto = 1;
                }
                else {
                    letto = 0;
                }

                object.put("stato",letto);

            }
            catch (JSONException e) {

                e.printStackTrace();
            }

            String inviato = client.getJSON(NetConfig.ADD,object.toString(),"");
            Log.i("response", "inviato" + inviato);

            sent = inviato.equalsIgnoreCase("");

            return null;

        }
    }
}
