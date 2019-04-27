package com.example.gerber.apprestaurante.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Platillo {

    @SerializedName("idPlatillo")
    @Expose
    private String idPlatillo;
    @SerializedName("nombrePlatillo")
    @Expose
    private String nombrePlatillo;
    @SerializedName("precioPlatillo")
    @Expose
    private String precioPlatillo;

    public String getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(String idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public String getNombrePlatillo() {
        return nombrePlatillo;
    }

    public void setNombrePlatillo(String nombrePlatillo) {
        this.nombrePlatillo = nombrePlatillo;
    }

    public String getPrecioPlatillo() {
        return precioPlatillo;
    }

    public void setPrecioPlatillo(String precioPlatillo) {
        this.precioPlatillo = precioPlatillo;
    }

}
