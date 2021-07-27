package com.example.happybee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;

public class WelcomePage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page1);

//        Handler handler = new Handler();
//        Runnable r=new Runnable() {
//            public void run() {
//                //what ever you do here will be done after 3 seconds delay. .
//                startActivity(new Intent(WelcomePage1.this, MainActivity.class));
//            }
//        };
//        handler.postDelayed(r, 3000);
    }
}