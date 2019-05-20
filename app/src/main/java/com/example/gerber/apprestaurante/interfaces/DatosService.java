package com.example.gerber.apprestaurante.interfaces;

import com.example.gerber.apprestaurante.requests.*;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DatosService {

    @GET("api_rest_crud_vdos/metodos_lectura/read_menus.php")
    Call< List<Menu> > getMenu();

    @POST("api_rest_crud_vdos/metodos_insertar/create_login.php")
    Call<Login> saveLogin(@Body Login login);

    @POST("api_rest_crud_vdos/metodos_insertar/create_reservacion.php")
    Call<Reservacion> saveReservacion(@Body Reservacion reservacion);

    @POST("api_rest_crud_vdos/metodos_insertar/create_pedido_a_domicilio.php")
    Call<Domicilio> saveDomicilio(@Body Domicilio domicilio);
}
