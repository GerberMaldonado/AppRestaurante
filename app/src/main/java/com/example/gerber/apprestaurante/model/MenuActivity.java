package com.example.gerber.apprestaurante.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gerber.apprestaurante.Adaptadors.MenuAdapter;
import com.example.gerber.apprestaurante.R;
import com.example.gerber.apprestaurante.interfaces.DatosService;
import com.example.gerber.apprestaurante.requests.Menu;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.support.design.widget.FloatingActionButton;

public class MenuActivity extends AppCompatActivity{

    private final String baseUrl = "http://192.168.20.104/";
    RecyclerView rvLogin;
    FloatingActionButton fabAdd;
    List<Menu> listaMenu = new ArrayList<>();
    MenuAdapter adapter;
    DatosService datosService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        iniciarControles();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvLogin.setLayoutManager(llm);

        adapter = new MenuAdapter(listaMenu);
        rvLogin.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(rvLogin.getContext(),llm.getOrientation());
        rvLogin.addItemDecoration(itemDecoration);

        datosService = retrofit.create(DatosService.class);

        Call<List<Menu>> lista = datosService.getMenu();
        lista.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                if(response.isSuccessful()){
                    listaMenu = response.body();
                    adapter = new MenuAdapter(listaMenu);
                    rvLogin.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {

            }
        });

        /*fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogo();
            }
        });
        */
    }

    private void iniciarControles(){
        rvLogin = findViewById(R.id.rvMenu);
        fabAdd = findViewById(R.id.fabAdd);
    }
/*
    private void mostrarDialogo(){
        LoginDialog dialog = new LoginDialog();
        dialog.show(getSupportFragmentManager(),"dialog_fragment");
    }
*/

}



