package com.example.happybee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Setari_profil extends AppCompatActivity {

    TextView txtDeconect,iconDeconect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari_profil);
        txtDeconect = (TextView) findViewById(R.id.txtDeconectare);
        iconDeconect =(TextView) findViewById(R.id.iconLogout);

        iconDeconect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setari_profil.this, LoginPage.class);
                startActivity(intent);
            }
        });

        txtDeconect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setari_profil.this, LoginPage.class);
                startActivity(intent);
            }
        });

    }
}