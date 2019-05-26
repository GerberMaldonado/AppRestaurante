package app.ejemplo.aplicacion.apprestaurante.Adaptadors;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gerber.apprestaurante.R;
import app.ejemplo.aplicacion.apprestaurante.requests.Domicilio;

import java.util.List;


public class DomicilioAdapter extends RecyclerView.Adapter<DomicilioAdapter.MenuViewHolder> {

    List<Domicilio> lista;

    public DomicilioAdapter(List<Domicilio> lista) {
        this.lista = lista;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cliente_row,parent,false);

        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.bindMenu(lista.get(position));
    }

    public void addMenu(Domicilio domicilio){
        lista.add(domicilio);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{

        TextView tvMenu;
        TextView tvPrecio;

        public MenuViewHolder(View itemView) {
            super(itemView);
            tvMenu = itemView.findViewById(R.id.tvMenu);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
        }

        public void bindMenu(Domicilio domicilio){
            String nombre = domicilio.getFechaPedido();
            tvMenu.setText(nombre);
            tvPrecio.setText(String.valueOf(domicilio.getIdPedidoADomicilio()));
        }

    }
}
