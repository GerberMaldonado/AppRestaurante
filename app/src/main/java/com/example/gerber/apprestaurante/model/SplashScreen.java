package com.example.gerber.apprestaurante.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences nombre = getSharedPreferences("datos", Context.MODE_PRIVATE);

        //tv1.setText(dato); //Muestra el usuario
        if(nombre.getString("nombre","").equals("")){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();

        }

    }


}
