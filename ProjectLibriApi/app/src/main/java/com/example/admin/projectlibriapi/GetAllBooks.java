package com.example.admin.projectlibriapi;

import android.util.Log;

/**
 * Created by Admin on 2/9/2015.
 */
public class GetAllBooks {


    JsonClient client = new JsonClient();


   public String[] getBooks(){

       // NON FUNZIONA
      String[] test = new String[100];
      test[0] = client.getJSON(NetConfig.SERVER,NetConfig.GETLISTA,"");


       return test;

   }

}
