package app.ejemplo.aplicacion.apprestaurante.interfaces;

import app.ejemplo.aplicacion.apprestaurante.requests.*;

import java.util.List;

import app.ejemplo.aplicacion.apprestaurante.requests.Cliente;
import app.ejemplo.aplicacion.apprestaurante.requests.Domicilio;
import app.ejemplo.aplicacion.apprestaurante.requests.Menu;
import app.ejemplo.aplicacion.apprestaurante.requests.Reservacion;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DatosService {

    @GET("metodos_lectura/read_menus.php")
    Call< List<Menu> > getMenu();

    @POST("metodos_insertar/create_cliente.php")
    Call<Cliente> saveLogin(@Body Cliente cliente);

    @POST("metodos_insertar/create_reservacion.php")
    Call<Reservacion> saveReservacion(@Body Reservacion reservacion);

    @POST("metodos_insertar/create_pedido_a_domicilio.php")
    Call<Domicilio> saveDomicilio(@Body Domicilio domicilio);
}
