package com.example.happybee;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PUT {
    private String URLPut;
    private Object lock;
    public String REQUEST_METHOD;


    public PUT(Object lock, String URLPut, String REQUEST_METHOD) {
        this.lock = lock;
        this.URLPut = URLPut;
        this.REQUEST_METHOD = REQUEST_METHOD;
        HttpPutRequest request = new HttpPutRequest();
        request.execute();

    }

    public String responsePut;

    public class HttpPutRequest extends AsyncTask<Void, Void, String> {

        final int READ_TIMEOUT = 15000;
        final int CONNECTION_TIMEOUT = 15000;


            @Override
        protected String doInBackground(Void... params) {
            String result;
            String inputLine;

            try {
                // connect to the server
                URL myUrl = new URL(URLPut);
                HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                connection.connect();

                // get the string from the input stream
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                while ((inputLine = reader.readLine()) != null) {
                    stringBuilder.append(inputLine);
                }
                reader.close();
                streamReader.close();
                result = stringBuilder.toString();
                Log.i("State", result);
            } catch (IOException e) {
                e.printStackTrace();
                result = "error";
                //System.out.println(result);

            }

            return result;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            responsePut = result;
//            synchronized (lock) {
//                lock.notifyAll();
//            }
            Log.i("Rezultat",result);
        }
    }
}