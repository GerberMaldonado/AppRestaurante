package com.example.gerber.apprestaurante.Adaptadors;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gerber.apprestaurante.R;

import com.example.gerber.apprestaurante.requests.Reservacion;

import java.util.List;


public class ReservacionAdapter extends RecyclerView.Adapter<ReservacionAdapter.MenuViewHolder> {

    List<Reservacion> lista;

    public ReservacionAdapter(List<Reservacion> lista) {
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

    public void addMenu(Reservacion reservacion){
        lista.add(reservacion);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{

        TextView tvReservacion;
        TextView tvId;

        public MenuViewHolder(View itemView) {
            super(itemView);
            tvReservacion = itemView.findViewById(R.id.tvMenu);
            tvId = itemView.findViewById(R.id.tvPrecio);
        }

        public void bindMenu(Reservacion reservacion){
            String nombre = reservacion.getFechaReservacion();
            tvReservacion.setText(nombre);
            tvId.setText(String.valueOf(reservacion.getIdReservacion()));
        }

    }
}
