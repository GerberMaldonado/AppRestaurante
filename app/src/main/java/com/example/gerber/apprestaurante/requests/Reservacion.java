package com.example.gerber.apprestaurante.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reservacion {

    @SerializedName("idReservacion")
    @Expose
    private String idReservacion;
    @SerializedName("Clientes_nombreCliente")
    @Expose
    private String clientesNombreCliente;
    @SerializedName("fechaReservacion")
    @Expose
    private String fechaReservacion;
    @SerializedName("horaReservacion")
    @Expose
    private String horaReservacion;
    @SerializedName("Mesas_idMesa")
    @Expose
    private String mesasIdMesa;
    @SerializedName("Establecimientos_idEstablecimiento")
    @Expose
    private String establecimientosIdEstablecimiento;

    public String getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(String idReservacion) {
        this.idReservacion = idReservacion;
    }

    public String getClientesNombreCliente() {
        return clientesNombreCliente;
    }

    public void setClientesNombreCliente(String clientesNombreCliente) {
        this.clientesNombreCliente = clientesNombreCliente;
    }

    public String getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(String fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getHoraReservacion() {
        return horaReservacion;
    }

    public void setHoraReservacion(String horaReservacion) {
        this.horaReservacion = horaReservacion;
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

}

