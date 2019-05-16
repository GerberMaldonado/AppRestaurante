package com.example.gerber.apprestaurante.Adaptadors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gerber.apprestaurante.R;
import com.example.gerber.apprestaurante.requests.Login;

import java.util.ArrayList;

/**
 * Created by wer on 29/03/2018.
 */

public class LoginAdapter extends BaseAdapter {
    Context context;
    ArrayList<Login> loginArrayList;

    public LoginAdapter(Context context, ArrayList<Login> loginArrayList) {
        this.context = context;
        this.loginArrayList = loginArrayList;
    }

    @Override
    public int getCount() {
        return this.loginArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.loginArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertViw, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_login, parent, false);

        TextView Nombre = (TextView) view.findViewById(R.id.editText);
        TextView Telefono = (TextView) view.findViewById(R.id.editText2);

        Login login = this.loginArrayList.get(position);
        if(login != null){

            Nombre.setText(String.format("Nombre: %s", login.getNombreUsuario()));
            Telefono.setText(String.format("Telefono: %s", login.getTelefonoUsuario()));

        }
        return view;
    }
}
