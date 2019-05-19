package com.example.gerber.apprestaurante.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gerber.apprestaurante.R;
import com.example.gerber.apprestaurante.interfaces.MenuService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Menu extends AppCompatActivity {

    ListView list;
    ArrayList<String> titles = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,titles);
        list = findViewById(R.id.list);
        list.setAdapter(arrayAdapter);
        getPosts();
}

    private void getPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.106")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MenuService menuService = retrofit.create(MenuService.class);
        Call< List<com.example.gerber.apprestaurante.requests.Menu> > call = menuService.getMenu();

        call.enqueue(new Callback<List<com.example.gerber.apprestaurante.requests.Menu>>() {
            @Override
            public void onResponse(Call<List<com.example.gerber.apprestaurante.requests.Menu>> call, Response<List<com.example.gerber.apprestaurante.requests.Menu>> response) {
                for(com.example.gerber.apprestaurante.requests.Menu menu : response.body()) {
                    titles.add(menu.getNombreMenu());
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<com.example.gerber.apprestaurante.requests.Menu>> call, Throwable t) {
            }
        });
    }

}



