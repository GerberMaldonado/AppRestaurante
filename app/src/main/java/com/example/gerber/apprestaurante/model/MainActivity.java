package com.example.gerber.apprestaurante.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gerber.apprestaurante.R;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences nombre = getSharedPreferences("datos", Context.MODE_PRIVATE);
        Toast.makeText(this,"Bienvendio "+nombre.getString("nombre",""), Toast.LENGTH_SHORT).show();

    }

    public void menu (View view){
        Intent i = new Intent(this, MenuActivity.class); startActivity(i);
    }
    public void domicilio (View view){
        Intent i = new Intent(this, DomicilioActivity.class); startActivity(i);
    }
    public void reservacion (View view){
        Intent i = new Intent (this, ReservacionActivity.class); startActivity(i);
    }

}
