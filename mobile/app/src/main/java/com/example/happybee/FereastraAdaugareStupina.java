package com.example.happybee;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class FereastraAdaugareStupina extends AppCompatActivity {

    Typeface typeface1;
    TextView intrebaread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fereastra_adaugare_stupina);
        intrebaread=(TextView)findViewById(R.id.txtintrebareAS);
        typeface1=Typeface.createFromAsset(getAssets(),"fa-solid-900.ttf");
        intrebaread.setTypeface(typeface1);
    }
}