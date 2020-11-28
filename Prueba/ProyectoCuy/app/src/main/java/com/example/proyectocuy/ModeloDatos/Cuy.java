package com.example.proyectocuy.ModeloDatos;

import java.io.Serializable;
import java.util.Date;

public class Cuy extends Poza implements Serializable {
    public String cuyId;
    public String IdPoza;
    public String categoria;
    public String genero;
    public Date fechaNaci;

    public Cuy(String idPoza, float largo, float ancho, int capacidad, String clasificacion, String cuyId, String idPoza1, String categoria, String genero, Date fechaNaci) {
        super(idPoza, largo, ancho, capacidad, clasificacion);
        this.cuyId = cuyId;
        IdPoza = idPoza1;
        this.categoria = categoria;
        this.genero = genero;
        this.fechaNaci = fechaNaci;
    }
    public Cuy(){}
    public Cuy(String cuyId, String idPoza, String categoria, String genero, Date fechaNaci) {
        this.cuyId = cuyId;
        IdPoza = idPoza;
        this.categoria = categoria;
        this.genero = genero;
        this.fechaNaci = fechaNaci;
    }

    public String getCuyId() {
        return cuyId;
    }

    public void setCuyId(String cuyId) {
        this.cuyId = cuyId;
    }

    @Override
    public String getIdPoza() {
        return IdPoza;
    }

    @Override
    public void setIdPoza(String idPoza) {
        IdPoza = idPoza;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(Date fechaNaci) {
        this.fechaNaci = fechaNaci;
    }
}

