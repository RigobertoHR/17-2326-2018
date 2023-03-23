package com.example.parcialii;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EmpleadoAdapter extends ArrayAdapter<empleados> {
    private Context context;
    private int layoutResourceId;
    private ArrayList<empleados> data = null;

    public EmpleadoAdapter(Context context, int layoutResourceId, ArrayList<empleados> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        EmpleadoHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new EmpleadoHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.image_view);
            holder.nombre = (TextView) row.findViewById(R.id.nombre_text_view);
            holder.cargo = (TextView) row.findViewById(R.id.cargo_text_view);
            holder.compania = (TextView) row.findViewById(R.id.compania_text_view);

            row.setTag(holder);
        } else {
            holder = (EmpleadoHolder) row.getTag();
        }

        empleados empleado = data.get(position);

        holder.imagen.setImageResource(empleado.getImagen());
        holder.nombre.setText(empleado.getNombre());
        holder.cargo.setText(empleado.getCargo());
        holder.compania.setText(empleado.getCompania());

        return row;
    }

    static class EmpleadoHolder {
        ImageView imagen;
        TextView nombre;
        TextView cargo;
        TextView compania;
    }
}