package com.example.gerber.apprestaurante.Adaptadors;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.gerber.apprestaurante.R;
import com.example.gerber.apprestaurante.requests.Menu;
import java.util.List;


public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    List<Menu> lista;

    public MenuAdapter(List<Menu> lista) {
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

    public void addMenu(Menu Menu){
        lista.add(Menu);
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

        public void bindMenu(Menu menu){
            String nombre = menu.getNombreMenu();
            tvMenu.setText(nombre);
            tvPrecio.setText(String.valueOf(menu.getPrecioMenu()));
        }

    }
}
