package com.example.gerber.apprestaurante.Prueba;

import java.lang.reflect.Type;
import java.util.ArrayList;


import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

public class Pelicula {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("telefono")
    @Expose
    private String telefono;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static ArrayList<Pelicula> obtenerPelicula(String json){
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Pelicula>>(){}.getType();
        return gson.fromJson(json, type);
    }

}