package com.example.gerber.apprestaurante.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu {

    @SerializedName("idMenu")
    @Expose
    private String idMenu;

    @SerializedName("nombreMenu")
    @Expose
    private String nombreMenu;

    @SerializedName("precioMenu")
    @Expose
    private String precioMenu;

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public String getPrecioMenu() {
        return precioMenu;
    }

    public void setPrecioMenu(String precioMenu) {
        this.precioMenu = precioMenu;
    }

}
