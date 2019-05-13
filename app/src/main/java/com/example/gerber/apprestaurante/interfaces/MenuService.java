package com.example.gerber.apprestaurante.interfaces;

import com.example.gerber.apprestaurante.requests.Menu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MenuService {

    String API_ROUTE = "/api_rest_crud_vdos/metodos_lectura/read_menus.php";

    @GET(API_ROUTE)
    Call< List<Menu> > getMenu();

}
