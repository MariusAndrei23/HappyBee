package com.example.happybee;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GET extends AppCompatActivity {
    public String URLPlus = Connection.SERVER + "?table=info&id=2";
    static TextView tvServerResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvServerResponse = findViewById(R.id.txt1);
        Button contactServerButton = findViewById(R.id.buttonADD);
        contactServerButton.setOnClickListener(onButtonClickListenerGET);
    }

    View.OnClickListener onButtonClickListenerGET = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HttpGetRequest request = new HttpGetRequest();
            request.execute();
        }

    };

    public class HttpGetRequest extends AsyncTask<Void, Void, String> {
        static final String REQUEST_METHOD = "GET";
        static final int READ_TIMEOUT = 15000;
        static final int CONNECTION_TIMEOUT = 15000;



        @Override
        protected String doInBackground(Void... params) {
            String result;
            String inputLine;


            try {
                // connect to the server
                URL myUrl = new URL(URLPlus);
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

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            tvServerResponse.setText(result);
        }
    }
}
