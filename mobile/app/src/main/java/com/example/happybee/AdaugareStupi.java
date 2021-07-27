package com.example.happybee;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class AdaugareStupi extends AppCompatActivity {

    Typeface typeface1;
    TextView intrebareads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_stupi);
        intrebareads=(TextView)findViewById(R.id.txtAdaugastup);
        typeface1=Typeface.createFromAsset(getAssets(),"fa-solid-900.ttf");
        intrebareads.setTypeface(typeface1);
    }
}