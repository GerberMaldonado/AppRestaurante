package com.example.gerber.apprestaurante.model;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gerber.apprestaurante.R;
import com.example.gerber.apprestaurante.interfaces.DatosService;
import com.example.gerber.apprestaurante.requests.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private final String baseUrl = "http://192.168.20.104/";

    //Variables para almacenar el nombre
    EditText GNombre; //Recive Nombre
    EditText GTelefono; //Recive Telefono

    Button submitBtn;
    EditText nombreE, telefonoE;

    DatosService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        submitBtn = findViewById(R.id.btnRegistrar);
        nombreE = findViewById(R.id.ENombre);
        telefonoE = findViewById(R.id.ETelefono);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        loginService = retrofit.create(DatosService.class);

        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Login login = new Login();
                login.setNombreUsuario(nombreE.getText().toString());
                login.setTelefonoUsuario(telefonoE.getText().toString());
                RegistrarUsuario(login);
            }
        });

    }

    public void Guardar() {
        SharedPreferences nombre = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences telefono = getSharedPreferences("datos", Context.MODE_PRIVATE);

        //Se crea un Editor para guardar y editar datos
        SharedPreferences.Editor edit1 = nombre.edit();
        SharedPreferences.Editor edit2 = telefono.edit();

        //Se asignan los datos de etNombre y etTelefono a su respectivo Editor
        edit1.putString("nombre", nombreE.getText().toString());
        edit2.putString("telefono", telefonoE.getText().toString());

        edit1.commit();
        edit2.commit();
    }

    public void RegistrarUsuario(Login login){

        final ProgressDialog dialog = new ProgressDialog(LoginActivity.this);
        dialog.setMessage("Registrando");
        dialog.show();
        Call<Login> l = loginService.saveLogin(login);
        l.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.isSuccessful()){
                    //Login loginResponse = response.body();
                    //adapter.addLogin(loginResponse);
                    Toast.makeText(getApplicationContext(),"Usuario Registrado",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    Guardar();
                }
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
            }
            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
                Toast.makeText(getApplicationContext(),"Error en el Registro",Toast.LENGTH_LONG).show();
            }
        });

    }

}
