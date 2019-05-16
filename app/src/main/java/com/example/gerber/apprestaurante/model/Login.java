package com.example.gerber.apprestaurante.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import com.example.gerber.apprestaurante.R;

public class Login extends AppCompatActivity {

    EditText etNombre; //recive Nombre
    EditText etTelefono; //Recive Telefono

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNombre = findViewById(R.id.editText);
        etTelefono = findViewById(R.id.editText2);
    }

    public void Guardar(View view) {
        SharedPreferences nombre = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences telefono = getSharedPreferences("datos", Context.MODE_PRIVATE);

        //Se crea un Editor para guardar y editar datos
        SharedPreferences.Editor edit1 = nombre.edit();
        SharedPreferences.Editor edit2 = telefono.edit();

        //Se asignan los datos de etNombre y etTelefono a su respectivo Editor
        edit1.putString("nombre", etNombre.getText().toString());
        edit2.putString("telefono", etTelefono.getText().toString());

        edit1.commit();
        edit2.commit();

        InsertarPersona p = new InsertarPersona();
        p.execute();

        Intent i =  new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    //Insertar Persona
    private class InsertarPersona extends AsyncTask<Void, Void, Boolean> {
        public Boolean doInBackground(Void... params) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://localhost/api_rest_crud_vdos/metodos_insertar/create_login.php/");
            httpPost.setHeader("Content-Type", "application/json");

            JSONObject jsonObject = new JSONObject();
            try {
                SharedPreferences nombre = getSharedPreferences("datos",Context.MODE_PRIVATE);
                SharedPreferences telefono = getSharedPreferences("datos",Context.MODE_PRIVATE);

                jsonObject.put("nombreUsuario", nombre.getString("nombre",""));
                jsonObject.put("telefonoUsuario", telefono.getString("telefono",""));
                StringEntity stringEntity = new StringEntity(jsonObject.toString());
                httpPost.setEntity(stringEntity);
                httpClient.execute(httpPost);
                return true;
            } catch (org.json.JSONException e) {
                return false;
            } catch (java.io.UnsupportedEncodingException e) {
                return false;
            } catch (org.apache.http.client.ClientProtocolException e) {
                return false;
            } catch (java.io.IOException e) {
                return false;
            }
        }
        public void onPostExecute(Boolean result){
            if(result){
                Toast.makeText(Login.this, "Usuario Creado", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(Login.this, "Problema al Crear Usuario", Toast.LENGTH_LONG).show();
        }
    }//Finaliza Insertar
}
