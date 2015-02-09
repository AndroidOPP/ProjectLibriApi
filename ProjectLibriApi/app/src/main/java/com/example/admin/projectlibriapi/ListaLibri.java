package com.example.admin.projectlibriapi;

import android.app.ActionBar;
import android.app.ListActivity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Admin on 1/19/2015.
 */
public class ListaLibri extends ListActivity {

    ListView lv;
    GetAllBooks gab = new GetAllBooks();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //String[] libri = gab.getBooks();
        String[] libri = {"primo libro","secondo libro"};

        /*

         */
        Log.i("string libri", "TEST LIBRI DI 0" + libri[0]);

        ArrayAdapter aa = new ArrayAdapter<String>(this, R.layout.list_libri,libri);

        setListAdapter(aa);

    }
}