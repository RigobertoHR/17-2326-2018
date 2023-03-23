package com.example.parcialii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private EmpleadoAdapter empleadoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            ArrayList<empleados> empleados = new ArrayList<>();
            empleados.add(new empleados(R.drawable.img1, "Alexander Pierrot", "CEO", "Insures S.O"));
            empleados.add(new empleados(R.drawable.img2, "Carlos Lopez", "Asistente", "Hospital Blue"));
            empleados.add(new empleados(R.drawable.img3, "Sara Bonz", "Directora de Markting", "Electrical Parts"));
            empleados.add(new empleados(R.drawable.img4, "Liliana Clarence", "Diselladora de producto", "Creative APP"));
            empleados.add(new empleados(R.drawable.img5, "Benito Peralta", "Supervisor de Ventas", "Neumatico PRESS"));
            empleados.add(new empleados(R.drawable.img6, "Juan Jaramillo", "CEO", "Ban co Nqacional"));
            empleados.add(new empleados(R.drawable.img7, "Christian Steps", "CTO", "Cooperativa Verde"));
            empleados.add(new empleados(R.drawable.img8, "Alexa Giraldo", "Lead Programmer", "frutiSpfy"));
            empleados.add(new empleados(R.drawable.img9, "Linda Murillo", "Directora", "Seguros Boliver"));
            empleados.add(new empleados(R.drawable.img10, "Lizeth Astrada", "CEO", "Consesionaria Motolox"));


        EmpleadoAdapter empleadoAdapter = new EmpleadoAdapter(this, R.layout.activity_layoutempleado,empleados);

            listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(empleadoAdapter);

    }

}