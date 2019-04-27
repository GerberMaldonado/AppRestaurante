package com.example.gerber.apprestaurante.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gerber.apprestaurante.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void menu (View view){
        Intent i = new Intent(this, Menu.class); startActivity(i);
    }
    public void domicilio (View view){
        Intent i = new Intent(this, a_domicilio.class); startActivity(i);
    }
    public void reservacion (View view){
        Intent i = new Intent (this, Reservacion.class); startActivity(i);
    }

}
