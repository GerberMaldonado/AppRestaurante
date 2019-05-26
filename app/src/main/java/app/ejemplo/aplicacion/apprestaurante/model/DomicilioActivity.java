package app.ejemplo.aplicacion.apprestaurante.model;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gerber.apprestaurante.R;
import app.ejemplo.aplicacion.apprestaurante.interfaces.DatosService;
import app.ejemplo.aplicacion.apprestaurante.requests.Domicilio;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DomicilioActivity extends AppCompatActivity{
    private final String baseUrl = "http://d5kp4ul.shekalug.org/";
    Button bfecha, bhora, btn_enviar;
    private  int dia,mes,ano,hora,minutos;
    DatosService domicilioService;
    String dir; //Se almacena la direccion
    String coor; //Se almacenan las coordenadas
    String fechaF = "1111/05/1";
    String horaF = "20:15";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domicilio);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
        } else {
            locationStart();
        }

        btn_enviar = findViewById(R.id.btn_enviar);

        final SharedPreferences nombreG = getSharedPreferences("datos", Context.MODE_PRIVATE);
        final SharedPreferences telefonoG = getSharedPreferences("datos", Context.MODE_PRIVATE);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        domicilioService = retrofit.create(DatosService.class);

        btn_enviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Domicilio domicilio = new Domicilio();
                domicilio.setClientesNombreCliente(nombreG.getString("nombre", ""));
                domicilio.setTelefonoCliente(telefonoG.getString("telefono", ""));
                domicilio.setFechaPedido(fechaF);
                domicilio.setHorarioSalida(horaF);
                domicilio.setUbicacionCliente(dir);
                domicilio.setCoordenadasCliente(coor);
                RegistrarUsuario(domicilio);
            }
        });
    }

    public void RegistrarUsuario(Domicilio domicilio){
        final ProgressDialog dialog = new ProgressDialog(DomicilioActivity.this);
        dialog.setMessage("Registrando");
        dialog.show();
        Call<Domicilio> r = domicilioService.saveDomicilio(domicilio);
        r.enqueue(new Callback<Domicilio>() {
            @Override
            public void onResponse(Call<Domicilio> call, Response<Domicilio> response) {
                if(response.isSuccessful()){
                    Domicilio domicilioResponse = response.body();
                    //adapter.addLogin(loginResponse);
                    Toast.makeText(getApplicationContext(),"Pedido Enviado",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(DomicilioActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
            }
            @Override
            public void onFailure(Call<Domicilio> call, Throwable t) {
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
                Toast.makeText(getApplicationContext(),"Error en el Registro",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void locationStart() {
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        DomicilioActivity.Localizacion Local = new DomicilioActivity.Localizacion();
        Local.setDomicilioActivity(this);
        final boolean gpsEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            return;
        }
        mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, (LocationListener) Local);
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) Local);
    }//Finaliza locationStart

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationStart();
                return;
            }
        }
    }//Finaliza onRequest

    public void setLocation(Location loc) {
        //Obtener la direccion de la calle a partir de la latitud y la longitud
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(
                        loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address DirCalle = list.get(0);
                    dir = (DirCalle.getAddressLine(0));
                    //    tv2.setText(dir);
                    //    nombre.setText(direccion);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//Finaliza setLocation

    /* Aqui empieza la Clase Localizacion */
    public class Localizacion implements LocationListener {
        DomicilioActivity domicilioActivity;

        public DomicilioActivity getDomicilioActivity() {
            return domicilioActivity;
        }
        public void setDomicilioActivity(DomicilioActivity domicilioActivity) {
            this.domicilioActivity = domicilioActivity;
        }

        @Override
        public void onLocationChanged(Location loc) {
            // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
            // debido a la deteccion de un cambio de ubicacion
            loc.getLatitude();
            loc.getLongitude();
            String Text = "" + loc.getLatitude() + "," + loc.getLongitude();
            //tv1.setText(Text);
            //String Text =loc.getLatitude()+ loc.getLongitude()+"";
            coor= Text;
            //tv1.setText(Text);
            this.domicilioActivity.setLocation(loc);
        }

        @Override
        public void onProviderDisabled(String provider) {
            //Este metodo se ejecuta cuando el GPS es desactivado
            //tv1.setText("GPS Desactivado");
        }

        @Override
        public void onProviderEnabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es activado
            // tv1.setText("GPS Activado");
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case LocationProvider.AVAILABLE:
                    Log.d("debug", "LocationProvider.AVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                    break;
            }
        }
    }
}
