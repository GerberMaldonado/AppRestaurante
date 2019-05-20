package com.example.gerber.apprestaurante.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reservacion {

    @SerializedName("idReservacion")
    @Expose
    private String idReservacion;
    @SerializedName("fechaReservacion")
    @Expose
    private String fechaReservacion;
    @SerializedName("Mesas_idMesa")
    @Expose
    private String mesasIdMesa;
    @SerializedName("Establecimientos_idEstablecimiento")
    @Expose
    private String establecimientosIdEstablecimiento;
    @SerializedName("Login_idLogin")
    @Expose
    private String loginIdLogin;

    public String getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(String idReservacion) {
        this.idReservacion = idReservacion;
    }

    public String getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(String fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getMesasIdMesa() {
        return mesasIdMesa;
    }

    public void setMesasIdMesa(String mesasIdMesa) {
        this.mesasIdMesa = mesasIdMesa;
    }

    public String getEstablecimientosIdEstablecimiento() {
        return establecimientosIdEstablecimiento;
    }

    public void setEstablecimientosIdEstablecimiento(String establecimientosIdEstablecimiento) {
        this.establecimientosIdEstablecimiento = establecimientosIdEstablecimiento;
    }

    public String getLoginIdLogin() {
        return loginIdLogin;
    }

    public void setLoginIdLogin(String loginIdLogin) {
        this.loginIdLogin = loginIdLogin;
    }

}
