package com.example.happybee;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class FereastraCreareCont extends AppCompatActivity {

    Typeface typeface1;
    TextView intrebarec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fereastra_creare_cont);
        intrebarec=(TextView)findViewById(R.id.txtintrebarecc);
        typeface1=Typeface.createFromAsset(getAssets(),"fa-solid-900.ttf");
        intrebarec.setTypeface(typeface1);
    }
}