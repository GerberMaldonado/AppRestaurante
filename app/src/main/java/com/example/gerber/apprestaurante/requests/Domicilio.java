package com.example.gerber.apprestaurante.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Domicilio {

    @SerializedName("idPedido_a_Domicilio")
    @Expose
    private String idPedidoADomicilio;
    @SerializedName("Clientes_nombreCliente")
    @Expose
    private String clientesNombreCliente;
    @SerializedName("telefonoCliente")
    @Expose
    private String telefonoCliente;
    @SerializedName("fechaPedido")
    @Expose
    private String fechaPedido;
    @SerializedName("horarioSalida")
    @Expose
    private String horarioSalida;
    @SerializedName("ubicacionCliente")
    @Expose
    private String ubicacionCliente;
    @SerializedName("coordenadasCliente")
    @Expose
    private String coordenadasCliente;

    public String getIdPedidoADomicilio() {
        return idPedidoADomicilio;
    }

    public void setIdPedidoADomicilio(String idPedidoADomicilio) {
        this.idPedidoADomicilio = idPedidoADomicilio;
    }

    public String getClientesNombreCliente() {
        return clientesNombreCliente;
    }

    public void setClientesNombreCliente(String clientesNombreCliente) {
        this.clientesNombreCliente = clientesNombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(String horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public String getUbicacionCliente() {
        return ubicacionCliente;
    }

    public void setUbicacionCliente(String ubicacionCliente) {
        this.ubicacionCliente = ubicacionCliente;
    }

    public String getCoordenadasCliente() {
        return coordenadasCliente;
    }

    public void setCoordenadasCliente(String coordenadasCliente) {
        this.coordenadasCliente = coordenadasCliente;
    }

}
