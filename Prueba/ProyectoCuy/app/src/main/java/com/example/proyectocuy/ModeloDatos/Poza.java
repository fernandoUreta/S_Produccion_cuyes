package com.example.proyectocuy.ModeloDatos;

import java.io.Serializable;

public class Poza implements Serializable {
    public String idPoza;
    public float largo;
    public float ancho;
    public int capacidad;
    public String clasificacion;

    public Poza(String idPoza, float largo, float ancho, int capacidad, String clasificacion) {
        this.idPoza = idPoza;
        this.largo = largo;
        this.ancho = ancho;
        this.capacidad = capacidad;
        this.clasificacion = clasificacion;
    }
    public Poza(){}

    public String getIdPoza() {
        return idPoza;
    }

    public void setIdPoza(String idPoza) {
        this.idPoza = idPoza;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

}