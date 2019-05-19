package com.example.gerber.apprestaurante.Adaptadors;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.gerber.apprestaurante.R;
import com.example.gerber.apprestaurante.requests.Login;
import java.util.List;

public class LoginAdapter extends RecyclerView.Adapter<LoginAdapter.LoginViewHolder> {

    List<Login> lista;

    public LoginAdapter(List<Login> lista) {
        this.lista = lista;
    }

    @Override
    public LoginViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.login_row,parent,false);

        return new LoginViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LoginViewHolder holder, int position) {
        holder.bindLogin(lista.get(position));
    }

    public void addLogin(Login login){
        lista.add(login);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class LoginViewHolder extends RecyclerView.ViewHolder{

        TextView tvNombre;
        TextView tvId;

        public LoginViewHolder(View itemView) {
            super(itemView);
            //tvNombre = itemView.findViewById(R.id.tvPaciente);
            tvId = itemView.findViewById(R.id.tvId);
        }

        public void bindLogin(Login login){
            String nombre = login.getNombreUsuario();
            tvNombre.setText(nombre);
            tvId.setText(String.valueOf(login.getTelefonoUsuario()));
        }

    }
}
