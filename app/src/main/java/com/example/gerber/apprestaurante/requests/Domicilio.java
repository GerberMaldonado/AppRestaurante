package com.example.gerber.apprestaurante.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Domicilio {

    @SerializedName("idPedido_a_Domicilio")
    @Expose
    private String idPedidoADomicilio;
    @SerializedName("fechaPedido")
    @Expose
    private String fechaPedido;
    @SerializedName("horarioSalida")
    @Expose
    private String horarioSalida;
    @SerializedName("ubicacionCliente")
    @Expose
    private String ubicacionCliente;
    @SerializedName("Login_idLogin")
    @Expose
    private String loginIdLogin;

    public String getIdPedidoADomicilio() {
        return idPedidoADomicilio;
    }

    public void setIdPedidoADomicilio(String idPedidoADomicilio) {
        this.idPedidoADomicilio = idPedidoADomicilio;
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

    public String getLoginIdLogin() {
        return loginIdLogin;
    }

    public void setLoginIdLogin(String loginIdLogin) {
        this.loginIdLogin = loginIdLogin;
    }

}
