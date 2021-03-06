package com.example.happybee;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DELETE {
    public static String URLDelete;

    public static class HttpDeleteRequest extends AsyncTask<Void, Void, String> {
        public static String responseDelete;
        static final String REQUEST_METHOD = "DELETE";
        static final int READ_TIMEOUT = 15000;
        static final int CONNECTION_TIMEOUT = 15000;

        @Override
        protected String doInBackground(Void... params) {
            String result;
            String inputLine;

            try {
                // connect to the server
                URL myUrl = new URL(URLDelete);
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

            } catch (IOException e) {
                e.printStackTrace();
                result = "error";
            }

            return result;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            responseDelete=result;
        }
    }
}
