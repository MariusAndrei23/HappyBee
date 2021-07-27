package com.example.happybee;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    Typeface typeface,typeface1;
    TextView meniu,stea,task,check,warning,alert,info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_menu);
        //meniu=(TextView)findViewById(R.id.txtMeniuHomePage);
        stea=(TextView)findViewById(R.id.txtSteaHomePage);
        task=(TextView)findViewById(R.id.textView27);
        check=(TextView)findViewById(R.id.textView32);
        warning=(TextView)findViewById(R.id.textView31);
        alert=(TextView)findViewById(R.id.textView30);
        info=(TextView)findViewById(R.id.iconInfoDeplasare);

        typeface=Typeface.createFromAsset(getAssets(),"fa-regular-400.ttf");
        typeface1=Typeface.createFromAsset(getAssets(),"fa-solid-900.ttf");

        //meniu.setTypeface(typeface1);//
        stea.setTypeface(typeface1);
        task.setTypeface(typeface);
        check.setTypeface(typeface1);
        warning.setTypeface(typeface1);//
        alert.setTypeface(typeface1);//
        info.setTypeface(typeface1);

    }
}