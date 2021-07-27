package com.example.happybee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    Typeface typeface1;
    TextView intrebare;
    EditText txtUser,txtParola;
    Button logOn;
    String user,parola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        intrebare=(TextView)findViewById(R.id.txtIntrebare);
        typeface1=Typeface.createFromAsset(getAssets(),"fa-solid-900.ttf");
        intrebare.setTypeface(typeface1);
//////////////////////////////
        AlertDialog.Builder builder1 = null;
        builder1.setMessage("Write your message here.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Da",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "Nu",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
        //////////////////


        txtUser=(EditText)findViewById(R.id.fl_user);
        txtParola=(EditText)findViewById(R.id.fl_parola);
        logOn=(Button)findViewById(R.id.fl_btn_logare);
        logOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(logOn.isPressed())
                {
                    user= String.valueOf(txtUser);
                    parola=String.valueOf(txtParola);
                    user.replaceAll("[^?=&']","");
                    parola.replaceAll("[^?=&']","");
                    //builder1.setNegativeButton("Caracterele au fost eliminate");
                }
            }
        });
    }


}