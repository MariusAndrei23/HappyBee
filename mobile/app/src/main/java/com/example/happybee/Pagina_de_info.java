package com.example.happybee;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class Pagina_de_info extends AppCompatActivity {

    Typeface typeface,typeface1;
    TextView gunoi,meniu,stea,task,check,warning,alert,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_de_info);

        gunoi=(TextView)findViewById(R.id.txtGunoi);
        meniu=(TextView)findViewById(R.id.txtMeniu);
        stea=(TextView)findViewById(R.id.txtStea);
        task=(TextView)findViewById(R.id.txtTask);
        check=(TextView)findViewById(R.id.txtCheck);
        warning=(TextView)findViewById(R.id.txtWarning);
        alert=(TextView)findViewById(R.id.txtAlert);
        add=(TextView)findViewById(R.id.txtAdd);

        typeface=Typeface.createFromAsset(getAssets(),"fa-regular-400.ttf");
        typeface1=Typeface.createFromAsset(getAssets(),"fa-solid-900.ttf");
        gunoi.setTypeface(typeface);
        meniu.setTypeface(typeface1);//
        stea.setTypeface(typeface1);
        task.setTypeface(typeface);
        check.setTypeface(typeface1);
        warning.setTypeface(typeface1);//
        alert.setTypeface(typeface1);//
        add.setTypeface(typeface1);//


    }
}