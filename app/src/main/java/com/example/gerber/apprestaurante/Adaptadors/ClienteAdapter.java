package com.example.gerber.apprestaurante.Adaptadors;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.gerber.apprestaurante.R;
import com.example.gerber.apprestaurante.requests.Cliente;

import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder> {

    List<Cliente> lista;

    public ClienteAdapter(List<Cliente> lista) {
        this.lista = lista;
    }

    @Override
    public ClienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cliente_row,parent,false);

        return new ClienteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ClienteViewHolder holder, int position) {
        holder.bindCliente(lista.get(position));
    }

    public void addLogin(Cliente cliente){
        lista.add(cliente);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ClienteViewHolder extends RecyclerView.ViewHolder{

        TextView tvNombre;
        TextView tvId;

        public ClienteViewHolder(View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvPaciente);
            tvId = itemView.findViewById(R.id.tvId);
        }

        public void bindCliente(Cliente cliente){
            String nombre = cliente.getNombreCliente();
            tvNombre.setText(nombre);
            tvId.setText(String.valueOf(cliente.getTelefonoCliente()));
        }

    }
}
