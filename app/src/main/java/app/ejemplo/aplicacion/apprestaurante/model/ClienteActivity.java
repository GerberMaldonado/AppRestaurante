package app.ejemplo.aplicacion.apprestaurante.model;

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
import app.ejemplo.aplicacion.apprestaurante.interfaces.DatosService;
import app.ejemplo.aplicacion.apprestaurante.requests.Cliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteActivity extends AppCompatActivity {

    private final String baseUrl = "http://d5kp4ul.shekalug.org/";

    //Variables para almacenar el nombre
    EditText GNombre; //Recive Nombre
    EditText GTelefono; //Recive Telefono

    Button submitBtn;
    EditText nombreE, telefonoE;

    DatosService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

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
                Cliente cliente = new Cliente();
                cliente.setNombreCliente(nombreE.getText().toString());
                cliente.setTelefonoCliente(telefonoE.getText().toString());
                RegistrarUsuario(cliente);
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

    public void RegistrarUsuario(Cliente cliente){

        String nombre = nombreE.getText().toString().trim();
        String telefono = telefonoE.getText().toString().trim();

        if (nombre.isEmpty()) {
            nombreE.setError("Ingresar Nombre");
            nombreE.requestFocus();
            return;
        }

        if (telefono.isEmpty()) {
            telefonoE.setError("Ingresar Teléfono");
            telefonoE.requestFocus();
            return;
        }

        final ProgressDialog dialog = new ProgressDialog(ClienteActivity.this);
        dialog.setMessage("Registrando");
        dialog.show();
        Call<Cliente> l = loginService.saveLogin(cliente);
        l.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if(response.isSuccessful()){
                    Cliente clienteResponse = response.body();
                    //adapter.addLogin(clienteResponse);
                    Toast.makeText(getApplicationContext(),"Usuario Registrado",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ClienteActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    Guardar();
                }
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
            }
            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
                Toast.makeText(getApplicationContext(),"Error en el Registro",Toast.LENGTH_LONG).show();
            }
        });

    }

}
