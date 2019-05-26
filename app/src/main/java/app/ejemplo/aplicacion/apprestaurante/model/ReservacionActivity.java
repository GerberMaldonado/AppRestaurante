package app.ejemplo.aplicacion.apprestaurante.model;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;
import com.example.gerber.apprestaurante.R;
import app.ejemplo.aplicacion.apprestaurante.interfaces.DatosService;
import app.ejemplo.aplicacion.apprestaurante.requests.Reservacion;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReservacionActivity extends AppCompatActivity implements View.OnClickListener {

    private final String baseUrl = "http://d5kp4ul.shekalug.org/";
    Button bfecha, bhora, btn_enviar;
    EditText efecha,ehora, emesa;
    private  int dia,mes,ano,hora,minutos;
    DatosService reservacionService;
    String establecimiento = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservacion);

        bfecha=(Button)findViewById(R.id.bfecha);
        bhora=(Button)findViewById(R.id.bhora);
        efecha=(EditText)findViewById(R.id.efecha);
        ehora=(EditText)findViewById(R.id.ehora);
        emesa=(EditText) findViewById(R.id.emesa);
        btn_enviar = findViewById(R.id.btn_enviar);

        bfecha.setOnClickListener(this);
        bhora.setOnClickListener(this);

        final SharedPreferences nombreGuardado = getSharedPreferences("datos", Context.MODE_PRIVATE);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        reservacionService = retrofit.create(DatosService.class);

        btn_enviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Reservacion reservacion = new Reservacion();
                reservacion.setClientesNombreCliente(nombreGuardado.getString("nombre", ""));
                reservacion.setFechaReservacion(efecha.getText().toString());
                reservacion.setHoraReservacion(ehora.getText().toString());
                reservacion.setMesasIdMesa(emesa.getText().toString());
                reservacion.setEstablecimientosIdEstablecimiento(establecimiento);
                RegistrarUsuario(reservacion);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v==bfecha){
            final Calendar c= Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    efecha.setText(year+"/"+(monthOfYear+1)+"/"+dayOfMonth);
                }
            }
                    ,dia,mes,ano);
            datePickerDialog.show();
        }
        if (v==bhora){
            final Calendar c= Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    ehora.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();
        }
    }

    public void RegistrarUsuario(Reservacion reservacion){
        final ProgressDialog dialog = new ProgressDialog(ReservacionActivity.this);
        dialog.setMessage("Registrando");
        dialog.show();
        Call<Reservacion> r = reservacionService.saveReservacion(reservacion);
        r.enqueue(new Callback<Reservacion>() {
            @Override
            public void onResponse(Call<Reservacion> call, Response<Reservacion> response) {
                if(response.isSuccessful()){
                    Reservacion loginResponse = response.body();
                    //adapter.addLogin(loginResponse);
                    Toast.makeText(getApplicationContext(),"Reservació Registrado",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ReservacionActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
            }
            @Override
            public void onFailure(Call<Reservacion> call, Throwable t) {
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
                Toast.makeText(getApplicationContext(),"Error en el Registro",Toast.LENGTH_LONG).show();
            }
        });
    }
}
