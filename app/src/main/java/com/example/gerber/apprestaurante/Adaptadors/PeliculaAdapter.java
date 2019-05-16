package com.example.gerber.apprestaurante.Adaptadors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gerber.apprestaurante.Prueba.Pelicula;
import com.example.gerber.apprestaurante.R;

import java.util.ArrayList;

/**
 * Created by gerber on 29/03/2018.
 */

public class PeliculaAdapter extends BaseAdapter {
    Context context;
    ArrayList<Pelicula> peliculaArrayList;

    public PeliculaAdapter(Context context, ArrayList<Pelicula> peliculaArrayList) {
        this.context = context;
        this.peliculaArrayList = peliculaArrayList;
    }

    @Override
    public int getCount() {
        return this.peliculaArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.peliculaArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertViw, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_login, parent, false);

        TextView Nombre = (TextView) view.findViewById(R.id.editText);
        TextView Telefono = (TextView) view.findViewById(R.id.editText2);

        Pelicula pelicula = this.peliculaArrayList.get(position);

        if(pelicula != null){

            Nombre.setText(String.format("nombre: %s", pelicula.getNombre()));
            Telefono.setText(String.format("telefono: %s", pelicula.getTelefono()));

        }
        return view;
    }
}
