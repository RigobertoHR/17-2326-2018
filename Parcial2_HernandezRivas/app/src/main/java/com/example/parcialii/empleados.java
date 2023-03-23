package com.example.parcialii;

public class empleados {
    private int imagen;
    private String nombres;
    private String cargo;
    private String compania;

    public empleados(int imagen, String nombre, String cargo, String compania) {
        this.imagen = imagen;
        this.nombres = nombre;
        this.cargo = cargo;
        this.compania = compania;
    }

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombres;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCompania() {
        return compania;
    }
}