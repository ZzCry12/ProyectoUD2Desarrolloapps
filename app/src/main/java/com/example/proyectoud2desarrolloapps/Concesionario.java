package com.example.proyectoud2desarrolloapps;

public class Concesionario {
    private String nombre;
    private double latitud;
    private double longitud;
    private String imagen;

    public Concesionario(String nombre, double latitud, double longitud, String imagen) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getImagen() {
        return imagen;
    }
}
