package com.example.gerber.apprestaurante.interfaces;

import com.example.gerber.apprestaurante.requests.Platillo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlatilloService {

    String API_ROUTE = "/api_rest_crud/metodos_lectura/read_platillos.php";

    @GET(API_ROUTE)
    Call< List<Platillo> > getPlatillo();

}
