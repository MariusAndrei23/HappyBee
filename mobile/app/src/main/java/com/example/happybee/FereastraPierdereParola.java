package com.example.happybee;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class FereastraPierdereParola extends AppCompatActivity {

    Typeface typeface1;
    TextView intrebarePP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fereastra_pierdere_parola);
        intrebarePP=(TextView)findViewById(R.id.txtuitatParola);
        typeface1=Typeface.createFromAsset(getAssets(),"fa-solid-900.ttf");
        intrebarePP.setTypeface(typeface1);
    }
}