package com.example.proyectocuy.ModeloDatos;

import java.util.Date;

public class Cuy extends Poza{
    public String cuyId;
    public String categoria;
    public String genero;
    public Date fechaNaci;

    public String getCuyId() {
        return cuyId;
    }

    public void setCuyId(String cuyId) {
        this.cuyId = cuyId;
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

    public void setIdPoza(String idPoza)
    {
        super.idPoza=idPoza;
    }

    public void getIdPoza(String idPoza)
    {
        super.idPoza=idPoza;
    }
}

