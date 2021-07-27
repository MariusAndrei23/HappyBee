package com.example.happybee;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomePage extends AppCompatActivity {

    int x=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);


        try {
            Thread.sleep(9000);
            startActivity(new Intent(WelcomePage.this, MainActivity.class));
            } catch (InterruptedException e) {
                e.printStackTrace();
            startActivity(new Intent(WelcomePage.this, MainActivity.class));
        }
    }

}
