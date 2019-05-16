package com.example.gerber.apprestaurante.requests;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Login {

    @SerializedName("idLogin")
    @Expose
    private String idLogin;
    @SerializedName("nombreUsuario")
    @Expose
    private String nombreUsuario;
    @SerializedName("telefonoUsuario")
    @Expose
    private String telefonoUsuario;

    public String getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public static ArrayList<Login> obtenerLogin(String json){
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Login>>(){}.getType();
        return gson.fromJson(json, type);
    }

}
