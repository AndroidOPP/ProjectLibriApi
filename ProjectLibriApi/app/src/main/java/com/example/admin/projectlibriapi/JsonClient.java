package com.example.admin.projectlibriapi;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
<<<<<<< HEAD
import  	org.apache.http.util.EntityUtils;
=======
>>>>>>> 68c6864c9fed5e258b35b1a751c379bafb8fcf1a

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class JsonClient {

    static InputStream is = null;
    static String json = "";

    // constructor
    public JsonClient() {

    }

    public String getJSON(String url, String getdata, String postdata) {
<<<<<<< HEAD

        String responseString = "";

=======
>>>>>>> 68c6864c9fed5e258b35b1a751c379bafb8fcf1a
        // Making HTTP request
        try {
            //build url
            url = NetConfig.SERVER+url;
            if(!getdata.isEmpty()){

                getdata = URLEncoder.encode(getdata, "utf-8");
                //url=url+"&data="+query;
                url=url+"&data="+getdata;
            }
            Log.e("Request: ", "> " + url);
<<<<<<< HEAD

            boolean result = false;

=======
>>>>>>> 68c6864c9fed5e258b35b1a751c379bafb8fcf1a
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> pairs = new ArrayList<NameValuePair>(1);
            pairs.add(new BasicNameValuePair("token", postdata));
            httpPost.setEntity(new UrlEncodedFormEntity(pairs));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
<<<<<<< HEAD

            responseString += httpResponse.toString();


=======
>>>>>>> 68c6864c9fed5e258b35b1a751c379bafb8fcf1a
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
            Log.e("Mess",json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
<<<<<<< HEAD
        Log.i("response", "RSP " + responseString);
        return responseString;
=======
        return json;
>>>>>>> 68c6864c9fed5e258b35b1a751c379bafb8fcf1a
    }

    public String getJSON(String url, String getdata, String postdata,String param) {
        // Making HTTP request
        try {
            //build url
            url = NetConfig.SERVER+url;
            if(!getdata.isEmpty()){

                getdata = URLEncoder.encode(getdata, "utf-8");
                //url=url+"&data="+query;
                url=url+"&data="+getdata;
            }
            Log.e("Request: ", "> " + url);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> pairs = new ArrayList<NameValuePair>(1);
            pairs.add(new BasicNameValuePair(param, postdata));
            httpPost.setEntity(new UrlEncodedFormEntity(pairs));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
            Log.e("Mess",json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
        return json;
    }
}

